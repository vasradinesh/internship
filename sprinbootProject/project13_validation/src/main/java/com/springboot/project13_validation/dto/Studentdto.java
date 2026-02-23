package com.springboot.project13_validation.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class Studentdto {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(regexp = "^[A-Za-z0-9._%+-]+@gmail\\.com$",message = "enter coorect email")
    private String email;

    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Mobile number must be exactly 10 digits"
    )
    private String mono;

    @Valid
    private List<Addressdto> addressList;


}
