package com.angularspringbootecommerce.dto;

import com.angularspringbootecommerce.entities.Address;
import com.angularspringbootecommerce.entities.Customer;
import com.angularspringbootecommerce.entities.Order;
import com.angularspringbootecommerce.entities.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
//    orderItems is just a Collection
    private Set<OrderItem> orderItems;

}
