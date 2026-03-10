package com.springboot.BloodManagementSystem.Proxy;

import com.springboot.BloodManagementSystem.Domain.Hospital;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloodRequestProxy {

    private Long id;

    private String bloodGroup;
    private Double quantity;
    private LocalDateTime requestDate;
    private String status;
    private HospitalProxy hospital;
}
