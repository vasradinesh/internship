package com.springboot.project14_derivedQueryMethod.repository;

import com.springboot.project14_derivedQueryMethod.domain.Student;
import com.springboot.project14_derivedQueryMethod.dto.Studentdto;
import com.springboot.project14_derivedQueryMethod.projection.StudentfirstnameAge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface Studentrepo extends JpaRepository<Student,Long> {
    List<Student> findByEmailAndLastName(String email, String lastname);
    List<Student> findByAgeGreaterThan(Integer age);
    List<Student> findByFirstNameContaining(String firstName);
    List<Student> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);
    List<Student> findByAgeBetween(Integer startAge, Integer endAge);
    List<Student> findByFirstNameLike(String firstName);
    List<Student> findByEmailContainingIgnoreCase(String email);
    List<Student> findByAgeLessThan(Integer age);
    List<Student> findByMobileNoStartingWith(String mobileNo);
    List<Student> findByMobileNoContaining(String mobileNo);

//    native query's

    @Query(nativeQuery = true,value = "select * from student where email =:email OR last_name =:lastName")
    List<Student> findByEmailOrLastName(@Param("email") String email,@Param("lastName") String lastname);

    @Query(nativeQuery = true,value = "select * from student")
    List<Student> getAllStudent();

    @Query(nativeQuery = true,value = "select * from student where age =:age ")
    List<Student> getByAge(@Param("age") Integer age);

//    crud



    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "delete from student where email=:email")
    void deleteByEmail(@Param("email") String email);


    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update student set email=:email,last_name=:last_name,age=:age,first_name=:first_name where id = :id")
    void updateStudentByid(@Param("id") Long id, @Param("email") String email,@Param("last_name") String last_name,@Param("age") Integer age,@Param("first_name") String first_name);



    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "insert into student(first_name, last_name, age, email, mobile_no) " +
            "value (:firstname, :lastname, :age, :email, :mobile)")
    void saveStudent(@Param("firstname") String firstname,@Param("lastname") String lastname,
                     @Param("age") Integer age,@Param("email") String email,@Param("mobile") String mobile);


    @Query(nativeQuery = true,value = "select * from student where ")
    Studentdto getStudentById(@Param("id") Long id);



    //get specific feild

    @Query(nativeQuery = true,value = "select first_name,mobile_no from student")
    Object[] getFirstnameAndMobile();


    //projection

    @Query(nativeQuery = true,value = "select first_name,age from student")
    List<StudentfirstnameAge> getStudentandAge();




}
