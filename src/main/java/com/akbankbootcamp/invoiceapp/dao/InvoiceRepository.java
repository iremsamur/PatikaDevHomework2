package com.akbankbootcamp.invoiceapp.dao;

import com.akbankbootcamp.invoiceapp.entity.Customer;
import com.akbankbootcamp.invoiceapp.entity.Invoice;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Repository
public interface InvoiceRepository {
    Double sumInvoiceSumByJune();
    List<Invoice> findAllInvoiceByAmount();
    Double findAverageInvoiceSumByAmount();
    List<String> findCustomerNameByAmount();
    List<String> findCustomerSectorByAmount();

}
