package com.sprinboot.project08_oneToonebidirectional.dto;

import com.sprinboot.project08_oneToonebidirectional.domain.Student;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class Addressdto {

    private Long id;
    private String state;
    private String pincode;
    private Studentdto student;
}
