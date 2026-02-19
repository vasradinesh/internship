package com.springboot.project12_globalException.dto;

import com.springboot.project12_globalException.domain.Address;
import lombok.Data;

import java.util.List;

@Data
public class Studentdto {

    private Long id;
    private String name;
    private String std;
    private String email;
    private String password;
    private List<Addressdto> addressList;
}
