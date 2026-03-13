package com.springboot.BloodManagementSystem.Service.Serviceimpl;

import com.springboot.BloodManagementSystem.CustomException.NoBloodFoundException;
import com.springboot.BloodManagementSystem.CustomException.NoUserFoundException;
import com.springboot.BloodManagementSystem.Domain.BloodRequest;
import com.springboot.BloodManagementSystem.Domain.BloodStock;
import com.springboot.BloodManagementSystem.Domain.Hospital;
import com.springboot.BloodManagementSystem.Domain.Users;
import com.springboot.BloodManagementSystem.Model.BloodRequestHistory;
import com.springboot.BloodManagementSystem.Model.DonoationDetailsHistory;
import com.springboot.BloodManagementSystem.Proxy.BloodRequestProxy;
import com.springboot.BloodManagementSystem.Proxy.HospitalProxy;
import com.springboot.BloodManagementSystem.Proxy.UsersProxy;
import com.springboot.BloodManagementSystem.Repository.BloodRequestrepo;
import com.springboot.BloodManagementSystem.Repository.BloodStockrepo;
import com.springboot.BloodManagementSystem.Repository.Hospitalrepo;
import com.springboot.BloodManagementSystem.Repository.Userrepo;
import com.springboot.BloodManagementSystem.Service.HospitalService;
import com.springboot.BloodManagementSystem.Utility.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class HospitalServiceImpl implements HospitalService {
    
    @Autowired
    private Hospitalrepo hospitalrepo;
    
    @Autowired
    private Userrepo userrepo;

    @Autowired
    private Mapper mapper;

    @Autowired
    private BloodRequestrepo bloodRequestrepo;

    @Autowired
    private BloodStockrepo bloodStockrepo;
    
    
    @Override
    public String saveHospital(HospitalProxy hospitalProxy) {

        Long id = hospitalProxy.getUsers().getId();
        Optional<Users> user = userrepo.findById(id);
        if (user.isPresent()){
            Users users = user.get();

            if (!users.getRole().equals("ROLE_HOSPITAL")){
                throw new RuntimeException("given user role is not HOSPITAL so you can't save hospital");
            }

            UsersProxy mapper1 = mapper.mapper(users, UsersProxy.class);
            hospitalProxy.setUsers(mapper1);
            hospitalrepo.save(mapper.mapper(hospitalProxy, Hospital.class));

            return hospitalProxy.toString();
        }
        throw new NoUserFoundException("no user of given id : " + id, HttpStatus.NOT_FOUND.toString());
    }

    @Override
    public String bloodRequest(BloodRequestProxy bloodRequestProxy) {
        Long hospitalid = bloodRequestProxy.getHospital().getId();
        Optional<Hospital> byId = hospitalrepo.findById(hospitalid);

        String reqBloodGroup = bloodRequestProxy.getBloodGroup();
        Double reqQuantity = bloodRequestProxy.getQuantity();

        Optional<BloodStock> bloodStockbyBloodGroup = bloodStockrepo.findByBloodGroup(reqBloodGroup);

        if(bloodStockbyBloodGroup.isPresent()){
            BloodStock bloodStock = bloodStockbyBloodGroup.get();
            if(!(bloodStock.getUnitsAvailable()>=reqQuantity)){
                throw new NoBloodFoundException("your requested bloodgroup units is less than bloodstock unit available",HttpStatus.NOT_ACCEPTABLE.toString());
            }
        }else {
            throw new NoBloodFoundException("your requested blood group is not in blood stock",HttpStatus.NOT_ACCEPTABLE.toString());
        }

        if(byId.isPresent()){
            Hospital hospital = byId.get();
            BloodRequest mapper1 = mapper.mapper(bloodRequestProxy, BloodRequest.class);
            mapper1.setHospital(hospital);

            bloodRequestrepo.save(mapper1);
            return "created";
        }
        throw new NoUserFoundException("there is no hosptal of given id : " + hospitalid,HttpStatus.NOT_FOUND.toString());
    }

    @Override
    public List<BloodRequestHistory> getBloodRequestHistory() {
        List<BloodRequestProxy> list = bloodRequestrepo.findAll().stream()
                .map(m -> mapper.mapper(m, BloodRequestProxy.class)).toList();

        List<BloodRequestHistory> bloodRequestHistories = new ArrayList<>();

        for (BloodRequestProxy b : list){
            bloodRequestHistories
                    .add(new BloodRequestHistory(b.getId(),b.getBloodGroup(),b.getQuantity(),b.getRequestDate(),b.getStatus()));
        }
        return bloodRequestHistories;
    }
}
