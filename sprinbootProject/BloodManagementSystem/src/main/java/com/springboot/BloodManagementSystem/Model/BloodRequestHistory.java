package com.springboot.BloodManagementSystem.Model;


import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodRequestHistory {

    private Long id;
    private String bloodGroup;
    private Double quantity;
    private LocalDateTime requestDate;
    private String status;

}
