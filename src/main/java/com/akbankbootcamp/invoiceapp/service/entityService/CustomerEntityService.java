package com.akbankbootcamp.invoiceapp.service.entityService;

import com.akbankbootcamp.invoiceapp.dao.CustomerRepository;
import com.akbankbootcamp.invoiceapp.entity.Customer;
import com.akbankbootcamp.invoiceapp.general.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerEntityService extends BaseEntityService<Customer> implements CustomerRepository{

    public CustomerEntityService(List<Customer> items) {
        super(items);
    }

    @Override
    public List<Customer> findAllCustomersByNameStartswithC() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("İrem Gıda", "iremsmr@gmail.com","05432345678","Gıda"));
        customers.add(new Customer("Deniz Giyim","denizgöl@gmail.com","05487345678","Giyim"));
        customers.add(new Customer("Cam" ,"ceydatrl@gmail.com","05487345678","Elektronik"));
        customers.add(new Customer("Cem Eşya", "cembayar@gmail.com","05487345678","Beyaz Eşya"));
        List<Customer> filteredCustomer = new ArrayList<>();
        customers.stream()
                .filter(customer -> customer.getName().contains("C"))
                .forEach(customer -> filteredCustomer.add(customer));
        return filteredCustomer;
    }
}
