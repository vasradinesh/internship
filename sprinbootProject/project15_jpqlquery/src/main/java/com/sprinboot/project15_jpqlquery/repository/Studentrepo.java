package com.sprinboot.project15_jpqlquery.repository;

import com.sprinboot.project15_jpqlquery.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface Studentrepo extends JpaRepository<Student,Long> {




    @Modifying
    @Transactional
    @Query("DELETE FROM Student s WHERE s.email = :email")
    void deleteByEmail(@Param("email") String email);


    @Modifying
    @Transactional
    @Query("UPDATE Student s SET s.age = :age,s.firstName=:firstname,s.lastName=:lastname,s.email=:email,s.mobileNo=:mobile WHERE s.id = :id")
    void updateAgeById(@Param("id") Long id,
                          @Param("age") Integer age,@Param("firstname") String firstname,@Param("lastname") String lastname,@Param("email")String email,@Param("mobile") String mobile);



}
