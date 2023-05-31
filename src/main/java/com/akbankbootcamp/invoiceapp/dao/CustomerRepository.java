package com.akbankbootcamp.invoiceapp.dao;

import com.akbankbootcamp.invoiceapp.entity.Customer;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Repository
public interface CustomerRepository {
    List<Customer> findAllCustomersByNameStartswithC();

}
