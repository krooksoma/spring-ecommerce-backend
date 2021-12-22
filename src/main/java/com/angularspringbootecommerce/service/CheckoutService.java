package com.angularspringbootecommerce.service;

import com.angularspringbootecommerce.dto.Purchase;
import com.angularspringbootecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
