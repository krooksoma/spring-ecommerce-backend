package com.angularspringbootecommerce.dto;

import lombok.Data;

@Data
public class PurchaseResponse {
    //@NonNull annotation can be used instead of giving the final access modifier

    private final String orderTrackingNumber;
}
