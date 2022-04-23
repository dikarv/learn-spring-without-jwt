package com.enigma.learnspringboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mst_product")
@Getter@Setter
@NoArgsConstructor//getter setter menggunakan lombok
//@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name ="system-uuid" ,strategy = "uuid")
    @Column(name = "product_id")
    private String id;
    private String name;
    @Column(name = "product_price")
    private Integer productPrice;
    private Integer stock;
    @Column(name = "product_picture")
    private String productPicture;


    public Product(String id, String name, Integer productPrice, Integer stock) {
        this.id = id;
        this.name = name;
        this.productPrice = productPrice;
        this.stock = stock;
    }

    public Product(String id, String name, Integer productPrice, Integer stock, String productPicture) {
        this.id = id;
        this.name = name;
        this.productPrice = productPrice;
        this.stock = stock;
        this.productPicture = productPicture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(productPrice, product.productPrice) && Objects.equals(stock, product.stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, productPrice, stock);
    }
}
