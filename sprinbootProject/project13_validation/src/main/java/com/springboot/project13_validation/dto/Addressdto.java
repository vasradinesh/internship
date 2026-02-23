package com.springboot.project13_validation.dto;

import com.springboot.project13_validation.customannotation.Pincode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class Addressdto {

    private Long id;

    @NotBlank
    @NotNull
    private String state;

    @NotNull
    @NotBlank
    private String city;

//    @Pattern(regexp = "^[1-9][0-9]{5}$",message = "enter correct pin code")
    @NotNull
    @Pincode
    private String pincode;

    @Valid
    private Studentdto student;
}
