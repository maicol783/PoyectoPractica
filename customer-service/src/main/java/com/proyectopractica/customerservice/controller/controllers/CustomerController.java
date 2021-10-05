package com.proyectopractica.customerservice.controller.controllers;

import com.proyectopractica.customerservice.controller.services.CustomerServiceImp;
import com.proyectopractica.customerservice.model.repository.CustomerRepository;
import com.proyectopractica.customerservice.view.dto.CustomerDTO;
import com.proyectopractica.customerservice.view.dto.util.ConverterDTO;
import com.proyectopractica.customerservice.view.entity.Customer;
import com.proyectopractica.customerservice.view.entity.IdentificationType;
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

    @GetMapping("/{age}")
    public ResponseEntity<List<CustomerDTO>> findByAge(@PathVariable("age") int age){
        List<CustomerDTO> customersDTO = customerServiceImp.findByAge(age);
        if (customersDTO.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customersDTO);
    }

    @GetMapping("/{identificationType}/{identificationNumber}")
    public ResponseEntity<CustomerDTO> findByIdentificationTypeAndIdentificationNumber(@PathVariable Long identificationType, @PathVariable String identificationNumber){
        CustomerDTO customerDTO = customerServiceImp.findByIdentificationTypeAndIdentificationNumber(IdentificationType.builder().id(identificationType).build(), identificationNumber);
        if (customerDTO == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customerDTO);
    }

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

    @PutMapping("/{identificationNumber}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable("identificationNumber") String identificationNumber, @RequestBody CustomerDTO customerDTO){
        customerDTO.setIdentificationNumber(identificationNumber);
        CustomerDTO customerDTO1 = customerServiceImp.updateCustomer(customerDTO);
        if (customerDTO1 == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customerDTO1);
    }

    @DeleteMapping("/{identificationNumber}")
    public ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable("identificationNumber") String identificationNumber){
        CustomerDTO customerDTO = customerServiceImp.deleteCustomer(identificationNumber);
        if (customerDTO == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customerDTO);
    }

}
