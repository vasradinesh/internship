package com.springboot.BloodManagementSystem.Service;

import com.springboot.BloodManagementSystem.Proxy.BloodRequestProxy;
import com.springboot.BloodManagementSystem.Proxy.BloodStockProxy;
import com.springboot.BloodManagementSystem.Proxy.DonationProxy;
import com.springboot.BloodManagementSystem.Proxy.UsersProxy;

import java.util.List;

public interface AdminService {

    List<UsersProxy> getAllUsers();

    UsersProxy getUsersByEmail(String email);

    String donorApprover(Long id);

    String bloodStockAddOrUpdate(BloodStockProxy bloodStockProxy);

    String bloodRequestapprover(Long id);

    String updateUserByEmail(String email,UsersProxy usersProxy);

    String deleteuserbyemail(String email);

    List<DonationProxy> getAllDonation();

    List<BloodRequestProxy> getAllBloodRequest();
}
