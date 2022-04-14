package com.enigma.learnspringboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity    ///this class merupakan sebuah modeling / class yang akan di mapping oleh xml.configure hibernate
@Table(name = "mst_customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    //modeling
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name ="system-uuid" ,strategy = "uuid")
    @Column(name = "customer_id")
    private String id;
    private String firstname;
    private String lastname;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private String status;
    private String userName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    //mappedBy customer berasal dari nama class yang diubah menjadi camel case
//    @OneToMany(mappedBy = "customer",cascade = CascadeType.PERSIST)//akan menambahkan transaksi ke purchase
//    private List<Purchase> purchases = new ArrayList<>();//bisa lihat transaksinya ada apa aja




}
