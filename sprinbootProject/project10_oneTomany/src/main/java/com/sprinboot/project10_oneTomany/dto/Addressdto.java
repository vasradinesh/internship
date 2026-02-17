package com.sprinboot.project10_oneTomany.dto;

import com.sprinboot.project10_oneTomany.domain.Student;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class Addressdto {
    private Long id;
    private String city;
    private String pincode;
    private Studentdto student;
}
