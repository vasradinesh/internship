package com.springboot.project11_manyToMany.utility;

import com.springboot.project11_manyToMany.domain.Course;
import com.springboot.project11_manyToMany.domain.Student;
import com.springboot.project11_manyToMany.dto.Coursedto;
import com.springboot.project11_manyToMany.dto.Studentdto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Modelutility {

    @Autowired
    private ModelMapper modelMapper;

    public Studentdto studentEntityToDto(Student student){
        student.getCourseList().forEach(s->s.setStudentList(null));
        return modelMapper.map(student,Studentdto.class);
    }

    public Student studentDtoToEntity(Studentdto studentdto){
        return modelMapper.map(studentdto,Student.class);
    }

    public List<Student> listStudentDtoToEntity(List<Studentdto> studentdtoList){
        return studentdtoList.stream().map(s->studentDtoToEntity(s)).toList();
    }

    public List<Studentdto> listStudentEntityToDto(List<Student> studentList){
        return studentList.stream().map(s->studentEntityToDto(s)).toList();
    }

    public Course courseDtoToEntity(Coursedto coursedto){
        return modelMapper.map(coursedto,Course.class);
    }

    public Coursedto courseEntityToDto(Course course){
        course.getStudentList().forEach(s->s.setCourseList(null));
        return modelMapper.map(course, Coursedto.class);
    }

    public List<Course> listCourseDtoToEntity(List<Coursedto> coursedtoList){
        return coursedtoList.stream().map(s->courseDtoToEntity(s)).toList();
    }

    public List<Coursedto> listCourseEntityTODto(List<Course> courseList){
        return courseList.stream().map(s->courseEntityToDto(s)).toList();
    }

}
