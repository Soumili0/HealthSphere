package com.miliproject.springboot.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "video_calls")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Videocall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many video calls can belong to one patient
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    // Many video calls can belong to one doctor
    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    private LocalDateTime scheduledAt;

    private String callLink; // Zoom / Jitsi / custom link

    private String status; // Scheduled, Completed, Cancelled
}
