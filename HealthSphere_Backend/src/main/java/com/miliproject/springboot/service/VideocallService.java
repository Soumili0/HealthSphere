package com.miliproject.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miliproject.springboot.model.Videocall;
import com.miliproject.springboot.repository.VideocallRepository;
import com.miliproject.springboot.repository.VideocallRepository.VideoCallRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VideocallService {

    private VideoCallRepository videoCallRepository = null;

    @Autowired
    public VideocallService(VideoCallRepository videoCallRepository) {
        this.videoCallRepository = videoCallRepository;
    }

    public List<VideocallRepository> getAllCalls() {
        return videoCallRepository.findAll();
    }

    public Optional<VideocallRepository> getCallById(Long id) {
        return videoCallRepository.findById(id);
    }

    public Videocall scheduleCall(Videocall call) {
        return videoCallRepository.save(call);
    }

    public VideocallRepository updateCall(Long id, Videocall updatedCall) {
        return videoCallRepository.findById(id).map(call -> {
            call.setDoctor(updatedCall.getDoctor());
            call.setPatient(updatedCall.getPatient());
            call.setStartTime(updatedCall.getStartTime());
            call.setEndTime(updatedCall.getEndTime());
            call.setStatus(updatedCall.getStatus());
            return videoCallRepository.save(call);
        }).orElseThrow(() -> new RuntimeException("Video call not found with id: " + id));
    }

    public void cancelCall(Long id) {
        if (!videoCallRepository.existsById(id)) {
            throw new RuntimeException("Video call not found with id: " + id);
        }
        videoCallRepository.deleteById(id);
    }
}
