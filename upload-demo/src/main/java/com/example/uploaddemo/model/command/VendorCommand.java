package com.example.uploaddemo.model.command;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "vendor_sherwin")
public class VendorCommand {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String vendorName;

    @Column
    private String country;

    @Column
    private Long productId;

    public VendorCommand() {

    }

    public VendorCommand(String vendorName, String country, Long productId) {
        this.vendorName = vendorName;
        this.country = country;
        this.productId = productId;
    }
}
