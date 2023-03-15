package com.example.uploaddemo.repository;

import com.example.uploaddemo.model.command.VendorCommand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<VendorCommand, Long> {

}
