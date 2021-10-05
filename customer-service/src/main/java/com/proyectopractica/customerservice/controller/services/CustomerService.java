package com.proyectopractica.customerservice.controller.services;

import com.proyectopractica.customerservice.view.dto.CustomerDTO;
import com.proyectopractica.customerservice.view.entity.Customer;
import com.proyectopractica.customerservice.view.entity.IdentificationType;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> listAllCustomers();
    List<CustomerDTO> findByAge(int age);
    CustomerDTO findByIdentificationTypeAndIdentificationNumber(IdentificationType identificationType, String identificationNumber);
    CustomerDTO getCustomer(String identificationNumber);
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(CustomerDTO customerDTO);
    CustomerDTO deleteCustomer(String identificationNumber);


}
