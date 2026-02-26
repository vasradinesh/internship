package com.springboot.project19_springseuritycore.service;


import com.springboot.project19_springseuritycore.Domain.Student;
import com.springboot.project19_springseuritycore.proxy.Studentproxy;

public interface Studentservice {

    String saveStudent(Studentproxy studentproxy);
}
