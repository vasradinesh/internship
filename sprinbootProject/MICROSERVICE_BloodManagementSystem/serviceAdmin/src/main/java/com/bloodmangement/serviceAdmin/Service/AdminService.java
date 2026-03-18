package com.bloodmangement.serviceAdmin.Service;

import com.bloodmangement.serviceAdmin.Proxy.BloodStockProxy;
import com.bloodmangement.serviceAdmin.Proxy.UsersProxy;

import java.util.List;

public interface AdminService {

    List<UsersProxy> getAllUsers();
//
//    UsersProxy getUsersByEmail(String email);
//
    String donorApprover(Long id,String token);

    String bloodStockAddOrUpdate(BloodStockProxy bloodStockProxy,String token);

    BloodStockProxy getBloodStock(String bloodgroup);
//
    String bloodRequestapprover(Long id,String token);

//    String updateUserByEmail(String email,UsersProxy usersProxy);

}
