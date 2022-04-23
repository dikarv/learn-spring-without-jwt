package com.enigma.learnspringboot.service.impl;

import com.enigma.learnspringboot.entity.Customer;
import com.enigma.learnspringboot.entity.Product;
import com.enigma.learnspringboot.exception.DataNotFoundException;
import com.enigma.learnspringboot.repository.CustomerRepository;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



@ExtendWith({MockitoExtension.class, SpringExtension.class})
class CustomerServicelmplTest {

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerServicelmpl customerServicelmpl;

    private Customer customer;

    @BeforeEach
    void setup(){
         customer = new Customer("e01","rojul","samuel", Date.from(Instant.now()),"status","ojul","1234");
    }
    @AfterEach
    void cleanUp(){
        customer = new Customer();
    }

    @Test
    void getAllCustomer() {

        Customer customer1 = new
                Customer("e01","rojul","samuel", Date.from(Instant.now()),"status","ojul","1234");
        List<Customer> arrCustomer = new ArrayList<>();
        arrCustomer.add(customer);
        arrCustomer.add(customer1);

       when(customerRepository.findAll()).thenReturn(arrCustomer);
       List<Customer> arrc2 = customerServicelmpl.getAllCustomer();
       assertEquals(2, arrc2.size());
       verify(customerRepository,times(1)).findAll();

    }

    @Test
    void getById() {

        when(customerRepository.findById("e01")).
                thenReturn(Optional.of(customer));
        Customer customer = customerServicelmpl.getById("e01");
        assertEquals("rojul",customer.getFirstname());
        assertEquals("e01",customer.getId());
        assertEquals("1234",customer.getPassword());
        assertNotEquals("kiki",customer.getLastname());
    }

    @Test
    void getCustomerByIdNotPresent(){
        //ketika kita akan meng test exception kita bisa mengugnakn throw able

        //menampung exception
        Throwable ex = assertThrows(DataNotFoundException.class,() -> customerServicelmpl.getById("p01"));
//        System.out.println(ex.getMessage());
        assertEquals("resource customer wirh ID p01 not found",ex.getMessage());

    }
    @Test
    void saveCustomer() {
        customerServicelmpl.saveCustomer(customer);
        verify(customerRepository,times(1)).save(customer);
        assertEquals("rojul",customer.getFirstname());
    }
    //uppdate mengecek id saat test
    //saat unit testing bila method return nya void makan
    // hanya dapat n=meng test apakah repo nya terpangiigl
    //test datanya masuk ga
    //test apakah data sudah di ubah
    //kuncinya cari return nya

    @Test
    void deleteCustomer() {
        customerServicelmpl.deleteCustomer("01");
        verify(customerRepository,times(1)).deleteById("01");

    }


    @Test
    void getCustomerPage() {
//       String searchCustomerFirstName = "Samuel";
//       String getSearchCustomerLastName = "anam";
//       List<String> arrc = new ArrayList<>();
//        arrc.add(searchCustomerFirstName);
//        arrc.add(getSearchCustomerLastName);


    }

    @Test
    void getCustomerByName() {
    }
}