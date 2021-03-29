package com.ProjectEureka.backend.controllers;
import com.ProjectEureka.backend.services.VideoCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class VideoCommunicationController {

    @Autowired
    private VideoCallService videoCallService;

    @GetMapping("call/{id}")
    public Map<String, String> getTokenCall(@PathVariable("id") String id) throws Exception {
        return Collections.singletonMap("token", videoCallService.getAgoraTokenCall(id));
    }

    @GetMapping("answer/{id}")
    public Map<String, String> getTokenAnswer(@PathVariable("id") String id) throws Exception {
        return Collections.singletonMap("token", videoCallService.getAgoraTokenAnswer(id));
    }

    @DeleteMapping("hungup/{id}")
    public Map<String, String> hungUpCall(@PathVariable("id") String id) throws Exception {
        return Collections.singletonMap("token", videoCallService.hungUpCall(id));
    }
}
