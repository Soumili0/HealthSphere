package com.miliproject.springboot.model;
import jakarta.persistence.*;

@Entity
@Table(name = "doctors")

public class Doctor {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String specialization;
    private String email;
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

}
