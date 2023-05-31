package com.akbankbootcamp.invoiceapp.controller.contract;

import com.akbankbootcamp.invoiceapp.dto.CustomerDTO;
import com.akbankbootcamp.invoiceapp.dto.CustomerSaveRequestDTO;

import java.util.List;

public interface CustomerControllerContract {
    void add(CustomerSaveRequestDTO request);
    List<CustomerDTO> findAll();

    void delete(CustomerDTO customerDTO);

}
