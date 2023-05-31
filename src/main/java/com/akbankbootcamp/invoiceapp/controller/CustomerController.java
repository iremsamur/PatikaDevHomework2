package com.akbankbootcamp.invoiceapp.controller;

import com.akbankbootcamp.invoiceapp.controller.contract.CustomerControllerContract;
import com.akbankbootcamp.invoiceapp.dto.CustomerDTO;
import com.akbankbootcamp.invoiceapp.dto.CustomerSaveRequestDTO;
import com.akbankbootcamp.invoiceapp.general.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerControllerContract customerControllerContract;

    @Autowired
    public CustomerController(CustomerControllerContract customerControllerContract) {
        this.customerControllerContract = customerControllerContract;
    }

    @PostMapping
    public ResponseEntity<RestResponse<Object>> add(@RequestBody CustomerSaveRequestDTO customerSaveRequest) {
        try {
           customerControllerContract.add(customerSaveRequest);
            return ResponseEntity.ok(RestResponse.emptySuccess("Kullanıcı başarıyla eklendi."));
        } catch (Exception ex) {
            return ResponseEntity.ok(RestResponse.emptyError(ex.getMessage()));
        }

    }


    @GetMapping
    public ResponseEntity<RestResponse<List<CustomerDTO>>> findAll() {
        var customerDTOList = customerControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(customerDTOList));
    }

    @DeleteMapping
    public ResponseEntity<RestResponse<Object>> delete(@RequestBody CustomerDTO customerDTO) {
        try {
            customerControllerContract.delete(customerDTO);
            return ResponseEntity.ok(RestResponse.emptySuccess("Kullanıcı başarıyla silindi"));
        } catch (Exception ex) {
            return ResponseEntity.ok(RestResponse.emptyError(ex.getMessage()));
        }

    }

}
