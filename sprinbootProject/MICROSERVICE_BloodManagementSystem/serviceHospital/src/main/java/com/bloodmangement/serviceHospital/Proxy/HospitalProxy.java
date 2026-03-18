package com.bloodmangement.serviceHospital.Proxy;

import com.bloodmangement.serviceHospital.CustomAnnotation.MobileNo;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalProxy {

    private Long id;

    @NotBlank
    private String hospitalName;

    @NotBlank
    private String address;

    @MobileNo
    private String contactNumber;

    @NotBlank
    private String licenseNumber;

    private Long userid;
}
