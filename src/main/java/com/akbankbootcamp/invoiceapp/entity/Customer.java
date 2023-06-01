package com.akbankbootcamp.invoiceapp.entity;

import com.akbankbootcamp.invoiceapp.general.BaseEntity;

public class Customer extends BaseEntity {

    private String name;
    private String sectorTitle;
    private String email;
    private String phoneNumber;

    public Customer(String name, String email, String phoneNumber,String sectorTitle) {
        super();
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.sectorTitle = sectorTitle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSectorTitle() {
        return sectorTitle;
    }

    public void setSectorTitle(String sectorTitle) {
        this.sectorTitle = sectorTitle;
    }
}

