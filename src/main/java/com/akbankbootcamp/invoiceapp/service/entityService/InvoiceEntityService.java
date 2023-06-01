package com.akbankbootcamp.invoiceapp.service.entityService;

import com.akbankbootcamp.invoiceapp.dao.CustomerRepository;
import com.akbankbootcamp.invoiceapp.dao.InvoiceRepository;
import com.akbankbootcamp.invoiceapp.entity.Customer;
import com.akbankbootcamp.invoiceapp.entity.Invoice;
import com.akbankbootcamp.invoiceapp.general.BaseEntityService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class InvoiceEntityService extends BaseEntityService<Invoice> implements InvoiceRepository {
    public InvoiceEntityService(List<Invoice> items) {
        super(items);
    }

    @Override
    public Double sumInvoiceSumByJune() {
        List<Invoice> invoices = new ArrayList<>();

        invoices.add(new Invoice(LocalDate.now(), 1L,120.5, 1L,"İrem Gıda"));
        invoices.add(new Invoice(LocalDate.now(), 1L,1500.5, 1L,"Deniz Giyim"));
        invoices.add(new Invoice(LocalDate.now(), 1L,300.5, 1L,"Cam"));
        invoices.add(new Invoice(LocalDate.now(), 1L,1700.0, 1L,"Cem Eşya"));
        List<Customer> filteredCustomer = new ArrayList<>();
        Double juneTotal = invoices.stream()
                .filter(invoice -> invoice.getDate().getMonth() == LocalDate.of(2023, 6, 1).getMonth())
                .mapToDouble(Invoice::getAmount)
                .sum();
        return juneTotal;
    }

    @Override
    public List<Invoice> findAllInvoiceByAmount() {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice(LocalDate.now(), 1L,120.5, 1L,"İrem Gıda"));
        invoices.add(new Invoice(LocalDate.now(), 1L,1500.5, 1L,"Deniz Giyim"));
        invoices.add(new Invoice(LocalDate.now(), 1L,300.5, 1L,"Cam"));
        invoices.add(new Invoice(LocalDate.now(), 1L,1700.0, 1L,"Cem Eşya"));
        List<Invoice> filteredInvoice = new ArrayList<>();
        invoices.stream()
                .filter(invoice -> invoice.getAmount() > 1500)
                .forEach(invoice -> filteredInvoice.add(invoice));
        return filteredInvoice;

    }

    @Override
    public Double findAverageInvoiceSumByAmount() {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice(LocalDate.now(), 1L,120.5, 1L,"İrem Gıda"));
        invoices.add(new Invoice(LocalDate.now(), 1L,1500.5, 1L,"Deniz Giyim"));
        invoices.add(new Invoice(LocalDate.now(), 1L,300.5, 1L,"Cam"));
        invoices.add(new Invoice(LocalDate.now(), 1L,1700.0, 1L,"Cem Eşya"));
        List<Customer> filteredCustomer = new ArrayList<>();
        double average = invoices.stream()
                .filter(invoice -> invoice.getAmount() > 1500)
                .mapToDouble(Invoice::getAmount)
                .average()
                .orElse(0);
        return average;
    }

    @Override
    public List<String> findCustomerNameByAmount() {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice(LocalDate.now(), 1L,120.5, 1L,"İrem Gıda"));
        invoices.add(new Invoice(LocalDate.now(), 1L,1500.5, 1L,"Deniz Giyim"));
        invoices.add(new Invoice(LocalDate.now(), 1L,300.5, 1L,"Cam"));
        invoices.add(new Invoice(LocalDate.now(), 1L,1700.0, 1L,"Cem Eşya"));

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("İrem Gıda", "iremsmr@gmail.com","05432345678","Gıda"));
        customers.add(new Customer("Deniz Giyim","denizgöl@gmail.com","05487345678","Giyim"));
        customers.add(new Customer("Cam" ,"ceydatrl@gmail.com","05487345678","Elektronik"));
        customers.add(new Customer("Cem Eşya", "cembayar@gmail.com","05487345678","Beyaz Eşya"));
        List<String> filteredInvoice = new ArrayList<>();
        invoices.stream()
                .filter(invoice -> invoice.getAmount() < 500)
                .map(invoice -> customers.stream()
                        .filter(customer -> customer.getName().equals(invoice.getName()))
                        .findFirst()
                        .orElse(null))
                .filter(Objects::nonNull)
                .forEach(customer -> filteredInvoice.add(customer.getName()));
        return filteredInvoice;

    }

    @Override
    public List<String> findCustomerSectorByAmount() {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice(LocalDate.now(), 1L,120.5, 1L,"İrem Gıda"));
        invoices.add(new Invoice(LocalDate.now(), 1L,1500.5, 1L,"Deniz Giyim"));
        invoices.add(new Invoice(LocalDate.now(), 1L,300.5, 1L,"Cam"));
        invoices.add(new Invoice(LocalDate.now(), 1L,1700.0, 1L,"Cem Eşya"));

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("İrem Gıda", "iremsmr@gmail.com","05432345678","Gıda"));
        customers.add(new Customer("Deniz Giyim","denizgöl@gmail.com","05487345678","Giyim"));
        customers.add(new Customer("Cam" ,"ceydatrl@gmail.com","05487345678","Elektronik"));
        customers.add(new Customer("Cem Eşya", "cembayar@gmail.com","05487345678","Beyaz Eşya"));
        List<String> filteredInvoice = new ArrayList<>();
        customers.stream()
                .filter(customer -> invoices.stream()
                        .filter(invoice -> invoice.getDate().getMonth() == LocalDate.of(2023, 6, 1).getMonth())
                        .mapToDouble(Invoice::getAmount)
                        .average()
                        .orElse(0) < 750)
                .distinct()
                .forEach(customer -> filteredInvoice.add(customer.getName()));
        return filteredInvoice;
    }
}
