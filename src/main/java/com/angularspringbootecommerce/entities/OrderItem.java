package com.angularspringbootecommerce.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="order_item")
@Setter
@Getter
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="quantity")
    private int quantity;

    @Column(name="unit_price")
    private BigDecimal unitPrice;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

}
