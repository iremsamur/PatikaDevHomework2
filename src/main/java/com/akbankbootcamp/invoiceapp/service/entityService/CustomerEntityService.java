package com.akbankbootcamp.invoiceapp.service.entityService;

import com.akbankbootcamp.invoiceapp.dao.CustomerRepository;
import com.akbankbootcamp.invoiceapp.entity.Customer;
import com.akbankbootcamp.invoiceapp.general.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerEntityService extends BaseEntityService<Customer> implements CustomerRepository{

    public CustomerEntityService(List<Customer> items) {
        super(items);
    }
}
