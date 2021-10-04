package com.proyectopractica.customerservice.view.dto.util;

import com.proyectopractica.customerservice.view.dto.CustomerDTO;
import com.proyectopractica.customerservice.view.entity.Customer;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

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
        List<CustomerDTO> customersDTO = new ArrayList<CustomerDTO>();
        for(Customer customer : listCustomers) {
            customersDTO.add(convertToDto(customer));
        }
        return customersDTO;
    }
}
