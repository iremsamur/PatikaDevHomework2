package com.akbankbootcamp.invoiceapp.mapper;

import com.akbankbootcamp.invoiceapp.dto.Customer.CustomerDTO;
import com.akbankbootcamp.invoiceapp.dto.Customer.CustomerSaveRequestDTO;
import com.akbankbootcamp.invoiceapp.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer convertToCustomer(CustomerSaveRequestDTO customerSaveRequestDTO);

    Customer convertToCustomer(CustomerDTO customerDTO);
    CustomerDTO convertToCustomer(Customer customer);

    List<CustomerDTO> convertToCustomerList(List<Customer> customerList);

}
