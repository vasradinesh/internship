package com.springboot.project17_fileHandling.Repository;

import com.springboot.project17_fileHandling.Domain.Filestorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Filestoragerepo extends JpaRepository<Filestorage,Long> {

    Optional<Filestorage> findByDockId(String dockid);
}
