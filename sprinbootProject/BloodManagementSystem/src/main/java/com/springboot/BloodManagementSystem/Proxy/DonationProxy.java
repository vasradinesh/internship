package com.springboot.BloodManagementSystem.Proxy;

import com.springboot.BloodManagementSystem.Domain.DonorDetails;
import jakarta.validation.constraints.Min;
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
    @Min(value = 1, message = "quantity must greater than 0")
    private Double quantity;
    private String remarks;

    private DonorDetails donorDetails;
}
