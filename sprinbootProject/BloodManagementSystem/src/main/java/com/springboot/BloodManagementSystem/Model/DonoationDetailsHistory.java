package com.springboot.BloodManagementSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonoationDetailsHistory {

    private Long id;

    private LocalDateTime donationDate;
    private Double quantity;
    private String remarks;

}
