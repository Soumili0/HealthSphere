package com.miliproject.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.miliproject.springboot.dto.EHRDTO;
import com.miliproject.springboot.service.EHRService;

import java.util.List;

@RestController
@RequestMapping("/api/ehr")
public class EHRController {

    @Autowired
    private EHRService ehrService;

    /**
     * Fetch all EHR records for a patient
     * Example: GET /api/ehr/patient/1
     */
    @GetMapping("/patient/{patientId}")
    public List<EHRDTO> getPatientEHR(@PathVariable Long patientId) {
        return ehrService.getPatientEHR(patientId);
    }
}
