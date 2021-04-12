package com.ProjectEureka.backend.services;

import com.ProjectEureka.backend.services.agora.media.RtcTokenBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class VideoCallService {

    @Value("${appId}")
    private String appId;

    @Value("${appCertificate}")
    private String appCertificate;

    static int uid = 0;
    // limit call duration
    static int expirationTimeInSeconds = 3600; // 3600 s = 1 h

    // hashmap is used to temporarily store token associated with the two users' ids (call id)
    HashMap<String, String> tokenAnswer = new HashMap<String, String>();

    public String getAppId(){
        return this.appId;
    }
    public String getAppCertificate(){
        return this.appCertificate;
    }
    public String getAgoraTokenCall(String call_id) {
        RtcTokenBuilder token = new RtcTokenBuilder();
        // token will expire
        int timestamp = (int)(System.currentTimeMillis() / 1000 + expirationTimeInSeconds);
        // token generating
        String result = token.buildTokenWithUid(getAppId(), getAppCertificate(), call_id, uid, RtcTokenBuilder.Role.Role_Publisher, timestamp);
        // append token associating it with the users' ids
        tokenAnswer.put(call_id, result);

        System.out.println("User calls. Token: " + tokenAnswer.get(call_id));
        System.out.println("CURRENT CALLS: " + tokenAnswer);
        return result;
    }

    public String getAgoraTokenAnswer(String call_id) {
        // return error string if the call appear to not be active any more
        if (tokenAnswer.get(call_id) == null) {
            System.out.println("Call is inactive");
            return "error";
        }
        // otherwise return the token
        else {
            System.out.println("User answers call. Token: " + tokenAnswer.get(call_id));
            System.out.println("CURRENT CALLS: " + tokenAnswer);
            return tokenAnswer.get(call_id);
        }
    }

    public String hungUpCall(String call_id) {
        // if the caller hung up it will remove the token associated with the call id from hashmap
        tokenAnswer.remove(call_id);
        System.out.println(call_id + " - call ended");
        return "Call ended";
    }
}