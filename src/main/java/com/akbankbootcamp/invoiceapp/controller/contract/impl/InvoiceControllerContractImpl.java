package com.akbankbootcamp.invoiceapp.controller.contract.impl;

import com.akbankbootcamp.invoiceapp.controller.contract.CustomerControllerContract;
import com.akbankbootcamp.invoiceapp.controller.contract.InvoiceControllerContract;
import com.akbankbootcamp.invoiceapp.dto.Customer.CustomerDTO;
import com.akbankbootcamp.invoiceapp.dto.Customer.CustomerSaveRequestDTO;
import com.akbankbootcamp.invoiceapp.dto.Invoice.InvoiceDTO;
import com.akbankbootcamp.invoiceapp.dto.Invoice.InvoiceSaveRequestDTO;
import com.akbankbootcamp.invoiceapp.entity.Customer;
import com.akbankbootcamp.invoiceapp.entity.Invoice;
import com.akbankbootcamp.invoiceapp.mapper.CustomerMapper;
import com.akbankbootcamp.invoiceapp.mapper.InvoiceMapper;
import com.akbankbootcamp.invoiceapp.service.entityService.InvoiceEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceControllerContractImpl implements InvoiceControllerContract {
    private final InvoiceEntityService invoiceEntityService;


    public InvoiceControllerContractImpl(InvoiceEntityService invoiceEntityService) {
        this.invoiceEntityService = invoiceEntityService;
    }


    @Override
    public void add(InvoiceSaveRequestDTO request) {
        Invoice invoice = InvoiceMapper.INSTANCE.convertToInvoice(request);
        invoiceEntityService.add(invoice);

    }

    @Override
    public List<InvoiceDTO> findAll() {
        List<InvoiceDTO> invoiceList = InvoiceMapper.INSTANCE.convertToInvoiceList(invoiceEntityService.getAll());
        return invoiceList;
    }

    @Override
    public void delete(InvoiceDTO invoiceDTO) {
        Invoice invoice = InvoiceMapper.INSTANCE.convertToInvoice(invoiceDTO);
        invoiceEntityService.remove(invoice);
    }

    @Override
    public Double sumInvoiceSumByJune() {
        Double invoiceSumByJune = invoiceEntityService.sumInvoiceSumByJune();
        return invoiceSumByJune;
    }

    @Override
    public List<InvoiceDTO> findAllInvoiceByAmount() {
        List<InvoiceDTO> invoiceList = InvoiceMapper.INSTANCE.convertToInvoiceList(invoiceEntityService.findAllInvoiceByAmount());
        return invoiceList;

    }

    @Override
    public Double findAverageInvoiceSumByAmount() {
        Double invoiceAverageByAmount = invoiceEntityService.findAverageInvoiceSumByAmount();
        return invoiceAverageByAmount;
    }

    @Override
    public List<String> findCustomerNameByAmount() {
        List<String> invoiceList = invoiceEntityService.findCustomerNameByAmount();
        return invoiceList;
    }

    @Override
    public List<String> findCustomerSectorByAmount() {
        List<String> invoiceList = invoiceEntityService.findCustomerSectorByAmount();
        return invoiceList;
    }
}
