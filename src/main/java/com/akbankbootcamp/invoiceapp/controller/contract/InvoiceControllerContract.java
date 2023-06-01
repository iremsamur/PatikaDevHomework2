package com.akbankbootcamp.invoiceapp.controller.contract;

import com.akbankbootcamp.invoiceapp.dto.Customer.CustomerDTO;
import com.akbankbootcamp.invoiceapp.dto.Customer.CustomerSaveRequestDTO;
import com.akbankbootcamp.invoiceapp.dto.Invoice.InvoiceDTO;
import com.akbankbootcamp.invoiceapp.dto.Invoice.InvoiceSaveRequestDTO;
import com.akbankbootcamp.invoiceapp.entity.Invoice;

import java.util.List;

public interface InvoiceControllerContract {
    void add(InvoiceSaveRequestDTO request);
    List<InvoiceDTO> findAll();

    void delete(InvoiceDTO invoiceDTO);
    Double sumInvoiceSumByJune();
    List<InvoiceDTO> findAllInvoiceByAmount();

    Double findAverageInvoiceSumByAmount();

    List<String> findCustomerNameByAmount();
    List<String> findCustomerSectorByAmount();
}
