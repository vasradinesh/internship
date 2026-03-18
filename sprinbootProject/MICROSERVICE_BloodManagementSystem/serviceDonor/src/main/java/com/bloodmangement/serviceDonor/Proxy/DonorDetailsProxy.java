package com.bloodmangement.serviceDonor.Proxy;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonorDetailsProxy {

    private Long id;

    @Pattern(regexp = "^(A|B|AB|O)[+-]$", message = "Invalid blood group format. Use format like 'A+' or 'O-'.")
    private String bloodGroup;

    @Min(value = 18, message = "Minimum age must be 18")
    @Max(value = 50, message = "Maximum age must be 50")
    private Integer age;

    @NotBlank
    private String gender;

    @NotBlank
    private String city;
    private LocalDateTime lastDonationDate;
    private String available;

    private Long userid;

}