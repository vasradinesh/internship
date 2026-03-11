package com.springboot.BloodManagementSystem.Proxy;

import com.springboot.BloodManagementSystem.Domain.DonorDetails;
import jakarta.validation.constraints.Positive;
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

    @Positive(message = "enter positive quentity")
    private Double quantity;
    private String remarks;

    private DonorDetails donorDetails;
}
