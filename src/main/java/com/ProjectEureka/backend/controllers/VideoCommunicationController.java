package com.ProjectEureka.backend.controllers;

import com.ProjectEureka.backend.services.VideoCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class VideoCommunicationController {

    @Autowired
    private VideoCallService videoCallService;

    @GetMapping("agora/call/{call_id}")
    public Map<String, String> getTokenCall(@PathVariable("call_id") String call_id) throws Exception {
        return Collections.singletonMap("token", videoCallService.getAgoraTokenCall(call_id));
    }

    @GetMapping("agora/answer/{call_id}")
    public Map<String, String> getTokenAnswer(@PathVariable("call_id") String call_id) throws Exception {
        return Collections.singletonMap("token", videoCallService.getAgoraTokenAnswer(call_id));
    }

    @DeleteMapping("agora/hungup/{call_id}")
    public String hungUpCall(@PathVariable("call_id") String call_id) throws Exception {
        return videoCallService.hungUpCall(call_id);
    }
}
