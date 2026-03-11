package com.springboot.BloodManagementSystem.Proxy;

import com.springboot.BloodManagementSystem.Domain.Hospital;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloodRequestProxy {

    private Long id;

    @Pattern(regexp = "^(A|B|AB|O)[+-]$", message = "Invalid blood group format. Use format like 'A+' or 'O-'.")
    private String bloodGroup;

    @Positive(message = "enter positive quantity")
    private Double quantity;
    private LocalDateTime requestDate;
    private String status;
    private HospitalProxy hospital;
}
