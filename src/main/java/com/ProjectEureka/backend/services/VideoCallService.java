package com.ProjectEureka.backend.services;

import com.ProjectEureka.backend.services.agora.media.RtcTokenBuilder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class VideoCallService {
    static String appId = "";
    static String appCertificate = "";
    //static String channelName = "test";
    static int uid = 0;
    static int expirationTimeInSeconds = 3600; // 3600 s = 1 h

    HashMap<String, String> tokenAnswer = new HashMap<String, String>();

    public String getAgoraTokenCall(String userId) {
        RtcTokenBuilder token = new RtcTokenBuilder();
        int timestamp = (int)(System.currentTimeMillis() / 1000 + expirationTimeInSeconds);

        String result = token.buildTokenWithUid(appId, appCertificate, userId, uid, RtcTokenBuilder.Role.Role_Publisher, timestamp);

        tokenAnswer.put(userId, result);

        System.out.println("User calls. Token: " + tokenAnswer.get(userId));
        System.out.println("CURRENT CALLS: " + tokenAnswer);
        //System.out.println("TOKEN: " + result);
        return result;
    }

    public String getAgoraTokenAnswer(String userId) {

        System.out.println("User answers call. Token: " + tokenAnswer.get(userId));
        System.out.println("CURRENT CALLS: " + tokenAnswer);
        return tokenAnswer.get(userId);
    }

    public String hungUpCall(String userId) {
        tokenAnswer.remove(userId);
        return tokenAnswer.get(userId);
    }

}