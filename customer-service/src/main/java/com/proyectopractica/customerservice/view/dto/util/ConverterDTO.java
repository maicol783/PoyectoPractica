package com.proyectopractica.customerservice.view.dto.util;

import com.proyectopractica.customerservice.view.dto.CustomerDTO;
import com.proyectopractica.customerservice.view.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConverterDTO {
    public static Customer convertToEntity(CustomerDTO customerDTO) {
        ModelMapper modelMapper=new ModelMapper();
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        return customer;
    }

    public static CustomerDTO convertToDto(Customer customer) {
        ModelMapper modelMapper=new ModelMapper();
        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
        return customerDTO;
    }

    public static List<CustomerDTO> convertToDtoList(List<Customer> listCustomers) {
        /*List<CustomerDTO> customersDTO = new ArrayList<>();
        for(Customer customer : listCustomers) {
            customersDTO.add(convertToDto(customer));
        }*/
        List<CustomerDTO> customersDTO = listCustomers.stream().map(ConverterDTO::convertToDto).collect(Collectors.toList());
        return customersDTO;
    }
}
