package com.bloodmangement.serviceAdmin.Service.Serviceimpl;

import com.bloodmangement.serviceAdmin.Domain.BloodStock;
import com.bloodmangement.serviceAdmin.Helper.ExcelHelper;
import com.bloodmangement.serviceAdmin.Proxy.BloodRequestProxy;
import com.bloodmangement.serviceAdmin.Proxy.UsersProxy;
import com.bloodmangement.serviceAdmin.Repository.BloodStockrepo;
import com.bloodmangement.serviceAdmin.Service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    private BloodStockrepo bloodStockrepo;

    @Autowired
    private ExcelHelper excelHelper;

//    @Autowired
//    private BloodRequestrepo bloodRequestrepo;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public byte[] downloadExcelFile() {
        List<BloodStock> all = bloodStockrepo.findAll();
        return excelHelper.getExcelFromListOfBloodStock(all);
    }

    @Override
    public byte[] getBloodRequestExcel() {



        List<BloodRequestProxy> all = restTemplate.exchange(
                "http://localhost:9090/gateway/hospital/bloodrequest/history",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<BloodRequestProxy>>() {
                }
        ).getBody();

        System.out.println(all);

        return excelHelper.getExcelFromListBloodRequest(all);
    }

}
