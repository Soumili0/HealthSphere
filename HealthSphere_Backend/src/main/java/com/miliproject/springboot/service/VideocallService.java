package com.miliproject.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miliproject.springboot.model.Patient;
import com.miliproject.springboot.model.Videocall;
import com.miliproject.springboot.repository.VideocallRepository;
import com.miliproject.springboot.repository.VideocallRepository.VideoCallRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VideocallService {

    private VideoCallRepository videoCallRepository = null;

    @Autowired
    public VideocallService(VideoCallRepository videoCallRepository) {
        this.videoCallRepository = videoCallRepository;
    }

    public List<Videocall> getAllCalls() {
        return (List<Videocall>) videoCallRepository.findAll();
    }

    public Optional<Videocall> getCallById(Long id) {
        return (Optional<Videocall>) videoCallRepository.findById(id);
    }

    public Videocall scheduleCall(Videocall call) {
        return videoCallRepository.save(call);
    }

    public Videocall updateCall(Long id, VideocallService updatedCall) {
        return videoCallRepository.findById(id).map(call -> {
            call.setDoctor(updatedCall.getDoctor());
            call.setPatient(updatedCall.getPatient());
            call.setStartTime(updatedCall.getStartTime());
            call.setEndTime(updatedCall.getEndTime());
            call.setStatus(updatedCall.getStatus());
            return videoCallRepository.save(call);
        }).orElseThrow(() -> new RuntimeException("Video call not found with id: " + id));
    }

    private String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	private LocalDateTime getEndTime() {
		// TODO Auto-generated method stub
		return null;
	}

	private LocalDateTime getStartTime() {
		// TODO Auto-generated method stub
		return null;
	}

	private Patient getPatient() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object getDoctor() {
		// TODO Auto-generated method stub
		return null;
	}

	public void cancelCall(Long id) {
        if (!videoCallRepository.existsById(id)) {
            throw new RuntimeException("Video call not found with id: " + id);
        }
        videoCallRepository.deleteById(id);
    }
}
