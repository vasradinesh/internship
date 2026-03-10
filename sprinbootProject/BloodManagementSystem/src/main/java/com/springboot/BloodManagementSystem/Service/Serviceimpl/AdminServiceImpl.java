package com.springboot.BloodManagementSystem.Service.Serviceimpl;

import com.springboot.BloodManagementSystem.Domain.BloodStock;
import com.springboot.BloodManagementSystem.Domain.Donation;
import com.springboot.BloodManagementSystem.Domain.Users;
import com.springboot.BloodManagementSystem.Proxy.BloodStockProxy;
import com.springboot.BloodManagementSystem.Proxy.UsersProxy;
import com.springboot.BloodManagementSystem.Repository.BloodStockrepo;
import com.springboot.BloodManagementSystem.Repository.Donationrepo;
import com.springboot.BloodManagementSystem.Repository.Userrepo;
import com.springboot.BloodManagementSystem.Service.AdminService;
import com.springboot.BloodManagementSystem.Utility.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private Userrepo userrepo;

    @Autowired
    private Mapper mapper;

    @Autowired
    private BloodStockrepo bloodStockrepo;

    @Autowired
    private Donationrepo donationrepo;


    @Override
    public List<UsersProxy> getAllUsers() {

        List<Users> all = userrepo.findAll();
        if (!all.isEmpty()){
            return all.stream().map(m->mapper.mapper(m,UsersProxy.class)).toList();
        }else {
            throw new RuntimeException("no users");
        }
    }

    @Override
    public UsersProxy getUsersByEmail(String email) {
        Optional<Users> user = userrepo.findByEmail(email);
        if (user.isPresent()){
            return mapper.mapper(user.get(),UsersProxy.class);
        }else {
            throw new RuntimeException("no user");
        }
    }

    @Override
    public String donorApprover(Long id) {
        Optional<Donation> byId = donationrepo.findById(id);
        if (byId.isPresent()){
            Donation donation = byId.get();

            if(Objects.equals(donation.getRemarks(), "approved")){
                return "already approved";
            }

            donation.setRemarks("approved");
            donation.setId(donation.getId());

            donationrepo.save(donation);

            String bloodGroup = donation.getDonorDetails().getBloodGroup();

            Optional<BloodStock> byBloodGroup = bloodStockrepo.findByBloodGroup(bloodGroup);

            if (byBloodGroup.isPresent()){
                BloodStock bloodStock = byBloodGroup.get();
                bloodStock.setLastUpdated(LocalDateTime.now());
                bloodStock.setUnitsAvailable(bloodStock.getUnitsAvailable() + donation.getQuantity());
                bloodStockrepo.save(bloodStock);
                return "blood group is already there so change in quantity";
            }else {
                BloodStock bloodStockProxy = new BloodStock();
                bloodStockProxy.setLastUpdated(LocalDateTime.now());
                bloodStockProxy.setBloodGroup(donation.getDonorDetails().getBloodGroup());
                bloodStockProxy.setUnitsAvailable(donation.getQuantity());
                bloodStockrepo.save(bloodStockProxy);
                return "new blood donation is added";
            }
        }
        return "there is no donor of such id ";
    }


    @Override
    public String bloodStockAddOrUpdate(BloodStockProxy bloodStockProxy) {
        Optional<BloodStock> byBloodGroup =
                bloodStockrepo.findByBloodGroup(bloodStockProxy.getBloodGroup());

        if (byBloodGroup.isPresent()){
            BloodStock bloodStock = byBloodGroup.get();
            bloodStock.setLastUpdated(LocalDateTime.now());
            bloodStock.setUnitsAvailable(bloodStockProxy.getUnitsAvailable() + bloodStock.getUnitsAvailable());
            bloodStockrepo.save(bloodStock);
            return "Blood group is already there so updated";
        }else {
            bloodStockProxy.setLastUpdated(LocalDateTime.now());
            bloodStockrepo.save(mapper.mapper(bloodStockProxy,BloodStock.class));
            return "new blood group entry is created";
        }
    }
}
