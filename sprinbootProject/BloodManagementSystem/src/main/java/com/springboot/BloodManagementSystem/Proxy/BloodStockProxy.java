package com.springboot.BloodManagementSystem.Proxy;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodStockProxy {

    private Long id;
    private String bloodGroup;
    private Double unitsAvailable;
    private LocalDateTime lastUpdated;

}
