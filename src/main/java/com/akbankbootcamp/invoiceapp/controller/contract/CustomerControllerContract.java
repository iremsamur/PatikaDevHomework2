package com.akbankbootcamp.invoiceapp.controller.contract;

import com.akbankbootcamp.invoiceapp.dto.Customer.CustomerDTO;
import com.akbankbootcamp.invoiceapp.dto.Customer.CustomerSaveRequestDTO;
import com.akbankbootcamp.invoiceapp.entity.Customer;

import java.util.List;

public interface CustomerControllerContract {
    void add(CustomerSaveRequestDTO request);
    List<CustomerDTO> findAll();

    void delete(CustomerDTO customerDTO);
    List<CustomerDTO> findAllCustomersByNameStartswithC();

}
