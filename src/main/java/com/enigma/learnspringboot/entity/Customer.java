package com.enigma.learnspringboot.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity    ///this class merupakan sebuah modeling / class yang akan di mapping oleh xml.configure hibernate
@Table(name = "mst_customer")
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    //modeling
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_generator")//generator untuk sequence
    @SequenceGenerator(name = "customer_generator", sequenceName = "customer_id_seq", allocationSize = 1)//increment +1
    private Integer id;
    private String name;
    private String address;
    private Integer phone;
    @Column(name = "birthdate")
    private Date birthDate;
    private String status;
    private String email;
    private String password;

    public Customer(Integer id, String name, String address, Integer phone, Date birthDate, String status, String email, String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.birthDate = birthDate;
        this.status = status;
        this.email = email;
        this.password = password;
    }

}
