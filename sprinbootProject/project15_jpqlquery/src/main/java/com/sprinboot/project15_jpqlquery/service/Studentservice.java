package com.sprinboot.project15_jpqlquery.service;

public interface Studentservice {
    void insertFakeData();
    void updateAgeByIdJPQL(Long id,Integer age,String lastname,String firstname,String mobileno,String email);
    void deleteByEmail(String email);

}
