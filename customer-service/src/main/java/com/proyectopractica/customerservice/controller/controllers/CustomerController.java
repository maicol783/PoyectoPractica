package com.proyectopractica.customerservice.controller.controllers;

import com.proyectopractica.customerservice.controller.services.CustomerServiceImp;
import com.proyectopractica.customerservice.model.repository.CustomerRepository;
import com.proyectopractica.customerservice.view.dto.CustomerDTO;
import com.proyectopractica.customerservice.view.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerServiceImp customerServiceImp;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> listAllCustomers(){
        List<CustomerDTO> customersDTO = customerServiceImp.listAllCustomers();
        if(customersDTO == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customersDTO);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO){
        CustomerDTO customerDTO1 = customerServiceImp.createCustomer(customerDTO);
        if (customerDTO1 == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(customerDTO1);
    }
}
