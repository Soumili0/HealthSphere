package com.miliproject.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.miliproject.springboot.model.Videocall;
import com.miliproject.springboot.service.VideocallService;

import java.util.List;

@RestController
@RequestMapping("/api/videocalls")
public class VideoCallController {

    private final VideocallService videoCallService;

    @Autowired
    public VideoCallController(VideocallService videoCallService) {
        this.videoCallService = videoCallService;
    }

    // Get all video calls
    @GetMapping
    public List<Videocall> getAllVideoCalls() {
        return videoCallService.getAllCalls();
    }

    // Get video call by ID
    @GetMapping("/{id}")
    public ResponseEntity<Videocall> getVideoCallById(@PathVariable Long id) {
        return videoCallService.getCallById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Schedule a new video call
    @PostMapping
    public VideoCall scheduleVideoCall(@RequestBody VideoCall videoCall) {
        return videoCallService.scheduleCall(videoCall);
    }

    // Update an existing video call
    @PutMapping("/{id}")
    public ResponseEntity<VideoCall> updateVideoCall(@PathVariable Long id,
                                                     @RequestBody VideoCall updatedCall) {
        try {
            VideoCall call = videoCallService.updateCall(id, updatedCall);
            return ResponseEntity.ok(call);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Cancel a video call
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelVideoCall(@PathVariable Long id) {
        try {
            videoCallService.cancelCall(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
