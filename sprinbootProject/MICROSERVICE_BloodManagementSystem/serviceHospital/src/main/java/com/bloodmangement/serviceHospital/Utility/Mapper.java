package com.bloodmangement.serviceHospital.Utility;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class Mapper {


    @Autowired
    private ObjectMapper objectMapper;


    public <T> T mapper(Object source, Class<T> targetClass) {
        return objectMapper.convertValue(source, targetClass);
    }

}
