package com.bloodmangement.serviceAdmin.Service.Serviceimpl;

import com.bloodmangement.serviceAdmin.CustomException.NoBloodFoundException;
import com.bloodmangement.serviceAdmin.CustomException.NoUserFoundException;
import com.bloodmangement.serviceAdmin.Domain.BloodStock;
import com.bloodmangement.serviceAdmin.Proxy.BloodRequestProxy;
import com.bloodmangement.serviceAdmin.Proxy.BloodStockProxy;
import com.bloodmangement.serviceAdmin.Proxy.DonationProxy;
import com.bloodmangement.serviceAdmin.Proxy.UsersProxy;
import com.bloodmangement.serviceAdmin.Repository.BloodStockrepo;
import com.bloodmangement.serviceAdmin.Service.AdminService;
import com.bloodmangement.serviceAdmin.Utility.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

//    @Autowired
//    private Userrepo userrepo;

    @Autowired
    private Mapper mapper;

    @Autowired
    private BloodStockrepo bloodStockrepo;

//
    @Autowired
    private RestTemplate restTemplate;



    @Override
    public List<UsersProxy> getAllUsers() {

        List<UsersProxy> usersList = restTemplate.exchange(
                "http://localhost:9090/gateway/auth/get-all-users",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UsersProxy>>() {
                }
        ).getBody();


        if (!usersList.isEmpty()){
            return usersList.stream().map(m->mapper.mapper(m,UsersProxy.class)).toList();
        }else {
            throw new NoUserFoundException("there is no users ", HttpStatus.NOT_FOUND.toString());
        }

    }
//
//    @Override
//    public UsersProxy getUsersByEmail(String email) {
//        Optional<Users> user = userrepo.findByEmail(email);
//        if (user.isPresent()){
//            return mapper.mapper(user.get(),UsersProxy.class);
//        }else {
//            throw new NoUserFoundException("there is no user of given email", HttpStatus.NOT_FOUND.toString());
//        }
//    }

    @Override
    public String donorApprover(Long id,String token) {

        if(!restTemplate.postForObject("http://localhost:9090/gateway/auth/verify-token",token,Boolean.class)){
            throw new RuntimeException("token is not valid");
        }


        DonationProxy donation = restTemplate.getForObject("http://localhost:9090/gateway/donor/get-donation/" + id, DonationProxy.class);

        if (donation!=null){
            if(Objects.equals(donation.getRemarks(), "approved")){
                throw new RuntimeException("donation is already approved");
            }

            donation.setRemarks("approved");
            donation.setId(donation.getId());

            String s = restTemplate.postForObject("http://localhost:9090/gateway/donor/save-donation", donation, String.class);

            System.out.println(s);

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
    public String bloodStockAddOrUpdate(BloodStockProxy bloodStockProxy,String token) {

        if(!restTemplate.postForObject("http://localhost:9090/gateway/auth/verify-token",token,Boolean.class)){
            throw new RuntimeException("token is not valid");
        }

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
    public BloodStockProxy getBloodStock(String bloodgroup) {


        Optional<BloodStock> byBloodGroup = bloodStockrepo.findByBloodGroup(bloodgroup);
        if (byBloodGroup.isPresent()){
            return mapper.mapper(byBloodGroup.get(), BloodStockProxy.class);
        }
        throw new NoBloodFoundException("there is no bloodstock for given bloodgroup",HttpStatus.BAD_REQUEST.toString());
    }

    @Override
    public String bloodRequestapprover(Long id,String token) {

        if(!restTemplate.postForObject("http://localhost:9090/gateway/auth/verify-token",token,Boolean.class)){
            throw new RuntimeException("token is not valid");
        }

        BloodRequestProxy bloodRequest1 = restTemplate.getForObject("http://localhost:9090/gateway/hospital/get-bloodrequest/" + id, BloodRequestProxy.class);

        if (bloodRequest1!=null){

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

                    String s = restTemplate.postForObject("http://localhost:9090/gateway/hospital/set-approved", bloodRequest1, String.class);
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

//    @Override
//    public String updateUserByEmail(String email,UsersProxy usersProxy) {
//        Optional<Users> user = userrepo.findByEmail(email);
//        if(user.isPresent()){
//            Users users = user.get();
//            usersProxy.setId(users.getId());
//            usersProxy.setPassword(users.getPassword());
//            userrepo.save(mapper.mapper(usersProxy,Users.class));
//            return "user updated";
//        }else {
//            throw new NoUserFoundException("there is no user of given email : " + email, HttpStatus.NOT_FOUND.toString());
//        }
//    }
}
