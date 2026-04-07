package com.springboot.BloodManagementSystem.Service.Serviceimpl;

import com.springboot.BloodManagementSystem.CustomException.NoBloodFoundException;
import com.springboot.BloodManagementSystem.CustomException.NoUserFoundException;
import com.springboot.BloodManagementSystem.Domain.BloodRequest;
import com.springboot.BloodManagementSystem.Domain.BloodStock;
import com.springboot.BloodManagementSystem.Domain.Donation;
import com.springboot.BloodManagementSystem.Domain.Users;
import com.springboot.BloodManagementSystem.Proxy.BloodRequestProxy;
import com.springboot.BloodManagementSystem.Proxy.BloodStockProxy;
import com.springboot.BloodManagementSystem.Proxy.DonationProxy;
import com.springboot.BloodManagementSystem.Proxy.UsersProxy;
import com.springboot.BloodManagementSystem.Repository.BloodRequestrepo;
import com.springboot.BloodManagementSystem.Repository.BloodStockrepo;
import com.springboot.BloodManagementSystem.Repository.Donationrepo;
import com.springboot.BloodManagementSystem.Repository.Userrepo;
import com.springboot.BloodManagementSystem.Service.AdminService;
import com.springboot.BloodManagementSystem.Utility.Mapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
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

    @Autowired
    private BloodRequestrepo bloodRequestrepo;


    @Override
    public List<UsersProxy> getAllUsers() {

        List<Users> usersList = userrepo.findAll();
        if (!usersList.isEmpty()){
            return usersList.stream().map(m->mapper.mapper(m,UsersProxy.class)).toList();
        }else {
            throw new NoUserFoundException("there is no users ",HttpStatus.NOT_FOUND.toString());
        }

    }

    @Override
    public UsersProxy getUsersByEmail(String email) {
        Optional<Users> user = userrepo.findByEmail(email);
        if (user.isPresent()){
            return mapper.mapper(user.get(),UsersProxy.class);
        }else {
            throw new NoUserFoundException("there is no user of given email", HttpStatus.NOT_FOUND.toString());
        }
    }

    @Override
    public String donorApprover(Long id) {
        Optional<Donation> byId = donationrepo.findById(id);
        if (byId.isPresent()){
            Donation donation = byId.get();

            if(Objects.equals(donation.getRemarks(), "approved")){
                throw new RuntimeException("donation is already approved");
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
        throw new NoUserFoundException("there is no donor of such id "+ id,HttpStatus.NOT_FOUND.toString());
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

    @Override
    public String bloodRequestapprover(Long id) {
        Optional<BloodRequest> bloodRequest = bloodRequestrepo.findById(id);
        if (bloodRequest.isPresent()){

            BloodRequest bloodRequest1 = bloodRequest.get();

            if(bloodRequest1.getStatus().equals("approved")){
                throw new RuntimeException("request is already approved");
            }

            String requestBloodGroup = bloodRequest1.getBloodGroup();
            Double bloodReqQuantity = bloodRequest1.getQuantity();


            Optional<BloodStock> stockOptional = bloodStockrepo.findByBloodGroup(requestBloodGroup);

            if(stockOptional.isPresent()){
                BloodStock bloodStock = stockOptional.get();
                Double unitsAvailable = bloodStock.getUnitsAvailable();

                if(unitsAvailable >= bloodReqQuantity){
                    Double newUnitsAvailable = unitsAvailable - bloodReqQuantity;

                    bloodStock.setLastUpdated(LocalDateTime.now());
                    bloodStock.setUnitsAvailable(newUnitsAvailable);
                    bloodStock.setBloodGroup(requestBloodGroup);
                    bloodStock.setId(bloodStock.getId());
                    bloodStockrepo.save(bloodStock);

                    bloodRequest1.setStatus("approved");
                    bloodRequestrepo.save(bloodRequest1);
                    return "request approved";
                }else {
                    throw new NoBloodFoundException("blood stock have less quantity than your request quantity",HttpStatus.BAD_REQUEST.toString());
                }
            }else {
                throw new NoBloodFoundException("there is no stock for your blood group",HttpStatus.NOT_FOUND.toString());
            }
        }else {
            throw new RuntimeException("there is no request exist for your given id");
        }
    }

    @Override
    public String updateUserByEmail(String email,UsersProxy usersProxy) {
        Optional<Users> user = userrepo.findByEmail(email);
        if(user.isPresent()){
            Users users = user.get();
            usersProxy.setId(users.getId());
            usersProxy.setPassword(users.getPassword());
            userrepo.save(mapper.mapper(usersProxy,Users.class));
            return "user updated";
        }else {
            throw new NoUserFoundException("there is no user of given email : " + email, HttpStatus.NOT_FOUND.toString());
        }
    }

    @Modifying
    @Transactional
    @Override
    public String deleteuserbyemail(String email) {

        Optional<Users> byEmail = userrepo.findByEmail(email);
        System.out.println(byEmail);

        if (byEmail.isPresent()){
            Long id = byEmail.get().getId();
            System.out.println("before"+id);
            userrepo.deleteById(id);
            System.out.println("delete id:"+id);
            return "deleted";
        }else {
            throw new NoUserFoundException("there is no user of given email : " + email, HttpStatus.NOT_FOUND.toString());
        }
    }

    @Override
    public List<DonationProxy> getAllDonation() {
        List<Donation> usersList = donationrepo.findAll();
        if (!usersList.isEmpty()){
            return usersList.stream().map(m->mapper.mapper(m,DonationProxy.class)).toList();
        }else {
            throw new NoUserFoundException("there is no users ",HttpStatus.NOT_FOUND.toString());
        }

    }

    @Override
    public List<BloodRequestProxy> getAllBloodRequest() {
        List<BloodRequest> bloodRequestList = bloodRequestrepo.findAll();
        System.out.println(bloodRequestList);
        if (!bloodRequestList.isEmpty()){
            return bloodRequestList.stream().map(m->mapper.mapper(m,BloodRequestProxy.class)).toList();
        }else {
            throw new NoUserFoundException("there is no users ",HttpStatus.NOT_FOUND.toString());
        }
    }
}
