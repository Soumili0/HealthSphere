package com.miliproject.springboot.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "video_calls")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Videocall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;

    private Long doctorId;

    private LocalDateTime scheduledAt;

    private String callLink; // Zoom / Jitsi / custom link

    private String status; // Scheduled, Completed, Cancelled
}
