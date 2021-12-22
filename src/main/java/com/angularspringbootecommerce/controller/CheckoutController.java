package com.angularspringbootecommerce.controller;

import com.angularspringbootecommerce.dto.Purchase;
import com.angularspringbootecommerce.dto.PurchaseResponse;
import com.angularspringbootecommerce.service.CheckoutService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/checkout")
public class CheckoutController {
    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){

       return checkoutService.placeOrder(purchase);
    }
}
