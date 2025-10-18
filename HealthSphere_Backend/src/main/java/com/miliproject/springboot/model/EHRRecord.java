package com.miliproject.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "ehr_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EHRRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // কোন রোগীর রেকর্ড এটা
    @Column(nullable = false)
    private Long patientId;

    // কোন ডাক্তারের রেকর্ড তৈরি করা
    @Column(nullable = false)
    private Long doctorId;

    // ডায়াগনোসিস সম্পর্কিত তথ্য
    @Column(nullable = false)
    private String diagnosis;

    // চিকিৎসা বা প্রেসক্রিপশন সম্পর্কিত বিস্তারিত
    private String treatmentDetails;

    // মেডিকেল টেস্টের ফলাফল
    private String testResults;

    // অতিরিক্ত নোট
    private String notes;

    // তারিখ
    private LocalDate recordDate = LocalDate.now();
}
