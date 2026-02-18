package com.springboot.project11_manyToMany.repository;

import com.springboot.project11_manyToMany.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Courserepo extends JpaRepository<Course,Long> {
}
