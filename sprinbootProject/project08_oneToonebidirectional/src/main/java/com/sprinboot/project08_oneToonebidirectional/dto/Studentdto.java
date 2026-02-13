package com.sprinboot.project08_oneToonebidirectional.dto;

import com.sprinboot.project08_oneToonebidirectional.domain.Address;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.List;

@Data
public class Studentdto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Addressdto address;
}
