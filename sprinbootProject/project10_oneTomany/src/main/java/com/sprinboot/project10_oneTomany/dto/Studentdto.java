package com.sprinboot.project10_oneTomany.dto;

import com.sprinboot.project10_oneTomany.domain.Address;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class Studentdto {
    private Long id;
    private String name;
    private String email;
    private String mono;
    private List<Addressdto> address;
}
