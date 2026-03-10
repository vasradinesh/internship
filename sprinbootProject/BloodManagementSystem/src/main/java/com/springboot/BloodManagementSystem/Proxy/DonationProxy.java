package com.springboot.BloodManagementSystem.Proxy;

import com.springboot.BloodManagementSystem.Domain.DonorDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonationProxy {

    private Long id;
    private LocalDateTime donationDate;
    private Double quantity;
    private String remarks;

    private DonorDetails donorDetails;
}
