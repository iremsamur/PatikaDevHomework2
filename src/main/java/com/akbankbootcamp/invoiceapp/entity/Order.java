package com.akbankbootcamp.invoiceapp.entity;

import com.akbankbootcamp.invoiceapp.general.BaseEntity;

public class Order extends BaseEntity {
    private Long productId;
    private Long customerId;

    public Order(Long id, Long productId) {

        this.productId = productId;
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
