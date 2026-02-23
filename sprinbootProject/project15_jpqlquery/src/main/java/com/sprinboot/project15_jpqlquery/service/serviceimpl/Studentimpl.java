package com.sprinboot.project15_jpqlquery.service.serviceimpl;

import com.github.javafaker.Faker;
import com.sprinboot.project15_jpqlquery.dto.Studentdto;
import com.sprinboot.project15_jpqlquery.helper.Modelmapper;
import com.sprinboot.project15_jpqlquery.repository.Studentrepo;
import com.sprinboot.project15_jpqlquery.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Studentimpl implements Studentservice {

    @Autowired
    private Faker faker;


    @Autowired
    private Studentrepo studentrepo;

    @Autowired
    private Modelmapper modelmapper;


    @Override
    public void insertFakeData() {
        for (int i = 1;i<=100;i++){
            Studentdto student = new Studentdto();
            student.setFirstName(faker.name().firstName());
            student.setAge(faker.number().numberBetween(1,35));
            student.setLastName(faker.name().lastName());
            student.setEmail(faker.internet().safeEmailAddress());
            student.setMobileNo(faker.phoneNumber().phoneNumber());

            studentrepo.save(modelmapper.dtoToEntity(student));
        }
    }

    @Override
    public void updateAgeByIdJPQL(Long id, Integer age, String firstname, String lastname, String email, String mobileno) {
        studentrepo.updateAgeById(id,age,firstname,lastname,email,mobileno);
    }


    @Override
    public void deleteByEmail(String email) {
        studentrepo.deleteByEmail(email);
    }


}
