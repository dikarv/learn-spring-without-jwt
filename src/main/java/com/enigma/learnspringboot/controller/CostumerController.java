package com.enigma.learnspringboot.controller;


import com.enigma.learnspringboot.constant.apiURLConstant;
import com.enigma.learnspringboot.entity.Customer;
import com.enigma.learnspringboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(apiURLConstant.CUSTOMER)
public class CostumerController {

    @Autowired
    CustomerService customerService;
    @GetMapping("/{id}")
    //nerima balikan dari servie
    public Customer getId(@PathVariable Integer id){
        return customerService.getById(id);
        //kirim ke service .impl
    }

    @PostMapping()
    public Customer createCustomer(@RequestBody Customer customer){
        return  customerService.saveCustomer(customer);

    }

    @PutMapping()
    public void updateCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
    }

    @DeleteMapping()//mapping method alamat dan method yang digunakan oleh REST api d
    public void deleteCustomer(@RequestParam Integer id){//memebuat method dimana parameter mengisi alamt yang ada
        customerService.deleteCustomer(id);//memanggil fungsi dari class repository
    }

    @GetMapping()
    public Page<Customer> getCustomerPage(@RequestParam(name = "page", defaultValue ="0") Integer page,
                                           @RequestParam(name = "size", defaultValue = "3")Integer sizePerPage,
                                           @RequestParam(name = "sortBy", defaultValue = "name")String sort,
                                           @RequestParam(name = "direction" ,defaultValue = "asc")String direction){
        Sort sort1 = Sort.by(Sort.Direction.fromString(direction),sort);
        Pageable pageable = PageRequest.of(page,sizePerPage, sort1);
        return customerService.getCustomerPage(pageable);
    }

}
