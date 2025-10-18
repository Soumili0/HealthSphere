package com.miliproject.springboot.repository;
//
import org.springframework.data.jpa.repository.JpaRepository;
import com.miliproject.springboot.model.Videocall;
import java.util.List;

public class VideocallRepository {

    public interface VideoCallRepository extends JpaRepository<Videocall, Long> {
        List<Videocall> findByPatientId(Long patientId);
        List<Videocall> findByDoctorId(Long doctorId);
        Videocall save(Videocall call);
    }

    private Videocall videocall;

    public VideocallRepository() {
        this.videocall = new Videocall();
    }

    public void setDoctor(Object doctor) {
        videocall.setDoctor((com.miliproject.springboot.model.Doctor) doctor);
    }

    public void setPatient(Object patient) {
        videocall.setPatient((com.miliproject.springboot.model.Patient) patient);
    }

    public void setStartTime(Object startTime) {
        videocall.setStartTime((java.time.LocalDateTime) startTime);
    }

    public void setEndTime(Object endTime) {
        videocall.setEndTime((java.time.LocalDateTime) endTime);
    }

    public void setStatus(Object status) {
        videocall.setStatus((String) status);
    }

    public Videocall getVideocall() {
        return videocall;
    }
}
