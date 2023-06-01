package com.akbankbootcamp.invoiceapp.mapper;

import com.akbankbootcamp.invoiceapp.dto.Customer.CustomerDTO;
import com.akbankbootcamp.invoiceapp.dto.Customer.CustomerSaveRequestDTO;
import com.akbankbootcamp.invoiceapp.dto.Invoice.InvoiceDTO;
import com.akbankbootcamp.invoiceapp.dto.Invoice.InvoiceSaveRequestDTO;
import com.akbankbootcamp.invoiceapp.entity.Customer;
import com.akbankbootcamp.invoiceapp.entity.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InvoiceMapper {
    InvoiceMapper INSTANCE = Mappers.getMapper(InvoiceMapper.class);

    Invoice convertToInvoice(InvoiceSaveRequestDTO invoiceSaveRequestDTO);

    Invoice convertToInvoice(InvoiceDTO invoiceDTO);
    InvoiceDTO convertToInvoice(Invoice invoice);

    List<InvoiceDTO> convertToInvoiceList(List<Invoice> invoiceList);
}
