package com.akbankbootcamp.invoiceapp.controller.contract.impl;

import com.akbankbootcamp.invoiceapp.controller.contract.CustomerControllerContract;
import com.akbankbootcamp.invoiceapp.dao.CustomerRepository;
import com.akbankbootcamp.invoiceapp.dto.Customer.CustomerDTO;
import com.akbankbootcamp.invoiceapp.dto.Customer.CustomerSaveRequestDTO;
import com.akbankbootcamp.invoiceapp.entity.Customer;
import com.akbankbootcamp.invoiceapp.mapper.CustomerMapper;
import com.akbankbootcamp.invoiceapp.service.entityService.CustomerEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerControllerContractImpl implements CustomerControllerContract {
    private final CustomerEntityService customerEntityService;

    @Autowired
    public CustomerControllerContractImpl(CustomerEntityService customerEntityService, CustomerRepository customerRepository) {
        this.customerEntityService = customerEntityService;
    }

    @Override
    public void add(CustomerSaveRequestDTO request) {
        Customer customer = CustomerMapper.INSTANCE.convertToCustomer(request);
        customerEntityService.add(customer);
    }

    @Override
    public List<CustomerDTO> findAll() {
        List<CustomerDTO> customerList = CustomerMapper.INSTANCE.convertToCustomerList(customerEntityService.getAll());
        return customerList;
    }


    @Override
    public void delete(CustomerDTO customerDTO) {

        Customer customer = CustomerMapper.INSTANCE.convertToCustomer(customerDTO);
        customerEntityService.remove(customer);
    }

    @Override
    public List<CustomerDTO> findAllCustomersByNameStartswithC() {
        List<CustomerDTO> customerList = CustomerMapper.INSTANCE.convertToCustomerList(customerEntityService.findAllCustomersByNameStartswithC());

        return customerList;
    }
}
