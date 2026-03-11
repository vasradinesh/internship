package com.springboot.BloodManagementSystem.Proxy;


import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodStockProxy {

    private Long id;
    @Pattern(regexp = "^(A|B|AB|O)[+-]$", message = "Invalid blood group format. Use format like 'A+' or 'O-'.")
    private String bloodGroup;

    @Positive()
    private Double unitsAvailable;
    private LocalDateTime lastUpdated;

}
