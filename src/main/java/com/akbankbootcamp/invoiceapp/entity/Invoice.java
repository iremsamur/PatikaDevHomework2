package com.akbankbootcamp.invoiceapp.entity;

import com.akbankbootcamp.invoiceapp.general.BaseEntity;

import java.time.LocalDate;

public class Invoice extends BaseEntity {
    private LocalDate date;
    private Long customerId;
    private Double amount;
    private Long orderId;
    private String name;

    public Invoice(LocalDate date, Long customerId, Double amount, Long orderId,String name) {
        this.date = date;
        this.customerId = customerId;
        this.amount = amount;
        this.orderId = orderId;
        this.name = name;
    }


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
