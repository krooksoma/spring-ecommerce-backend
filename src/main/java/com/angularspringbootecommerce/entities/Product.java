package com.angularspringbootecommerce.entities;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

//Data annotation from project Lombok automatically generates setters and getters
//behind the scenes
@Entity
@Table(name = "product")
//@Setter
//@Getter
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;

    @Column(name = "sku")
    private String sku;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "active")
    private boolean active;

    @Column(name = "units_in_stock")
    private int unitInStock;

//    Creation/UpdateTimeStamp annotation from hibernate will automatically manage the timestamp
    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastupdated;

    // ManyToOne because one product can belong to many categories.
    // It will join column on the category id.


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", category=" + category +
                ", sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", imageUrl='" + imageUrl + '\'' +
                ", active=" + active +
                ", unitInStock=" + unitInStock +
                ", dateCreated=" + dateCreated +
                ", lastupdated=" + lastupdated +
                '}';
    }
}
