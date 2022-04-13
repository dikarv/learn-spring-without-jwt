package com.enigma.learnspringboot.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "mst_product")
@Getter@Setter
@NoArgsConstructor//getter setter menggunakan lombok
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
    @SequenceGenerator(name = "product_generator", sequenceName = "product_id_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "name")
    private String productName;
    @Column(name = "product_price")
    private Integer productPrice;
    private Integer stock;



}
