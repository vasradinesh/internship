package com.springboot.BloodManagementSystem.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime donationDate;
    private Double quantity;
    private String remarks;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "donor_id")
    private DonorDetails donorDetails;


}
