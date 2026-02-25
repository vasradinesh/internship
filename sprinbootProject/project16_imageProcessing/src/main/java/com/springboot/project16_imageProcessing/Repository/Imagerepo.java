package com.springboot.project16_imageProcessing.Repository;

import com.springboot.project16_imageProcessing.domain.Imagedata;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Imagerepo extends JpaRepository<Imagedata,Long> {
    Optional<Imagedata> findByDockId(String dockid);

}
