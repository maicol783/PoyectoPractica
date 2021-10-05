package com.proyectopractica.customerservice.controller.services;

import com.proyectopractica.customerservice.model.repository.CustomerRepository;
import com.proyectopractica.customerservice.view.dto.CustomerDTO;
import com.proyectopractica.customerservice.view.dto.util.ConverterDTO;
import com.proyectopractica.customerservice.view.entity.Customer;
import com.proyectopractica.customerservice.view.entity.IdentificationType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerServiceImp implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerDTO> listAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customersDTO = ConverterDTO.convertToDtoList(customers);
        return customersDTO;
    }

    @Override
    public List<CustomerDTO> findByAge(int age) {
        List<Customer> customers = customerRepository.findByAge(age);
        List<CustomerDTO> customersDTO = ConverterDTO.convertToDtoList(customers);
        return customersDTO;
    }

    @Override
    public CustomerDTO findByIdentificationTypeAndIdentificationNumber(IdentificationType identificationType, String identificationNumber) {
        Customer customers = customerRepository.findByIdentificationTypeAndIdentificationNumber(identificationType, identificationNumber);
        CustomerDTO customersDTO = ConverterDTO.convertToDto(customers);
        return customersDTO;
    }

    @Override
    public CustomerDTO getCustomer(String identificationNumber) {
        Customer customer = customerRepository.findById(identificationNumber).orElse(null);
        CustomerDTO customerDTO = ConverterDTO.convertToDto(customer);
        return customerDTO;
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        customerDTO.setStatus("CREATED");
        Customer customer = ConverterDTO.convertToEntity(customerDTO);
        customerRepository.save(customer);
        return customerDTO;
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        CustomerDTO customerDBDTO = getCustomer(customerDTO.getIdentificationNumber());
        if (customerDBDTO == null){
            return null;
        }
        customerDBDTO.setIdentificationNumber(customerDTO.getIdentificationNumber());
        customerDBDTO.setIdentificationType(customerDTO.getIdentificationType());
        customerDBDTO.setFirstName(customerDTO.getFirstName());
        customerDBDTO.setLastName(customerDTO.getLastName());
        customerDBDTO.setAge(customerDTO.getAge());
        customerDBDTO.setTown(customerDTO.getTown());
        customerDBDTO.setPhoto(customerDTO.getStatus());

        Customer customerDB = ConverterDTO.convertToEntity(customerDBDTO);
        customerRepository.save(customerDB);

        return customerDBDTO;
    }

    @Override
    public CustomerDTO deleteCustomer(String identificationNumber) {
        CustomerDTO customerDBDTO = getCustomer(identificationNumber);
        if (customerDBDTO == null){
            return null;
        }
        customerDBDTO.setStatus("DELETED");
        Customer customerDB = ConverterDTO.convertToEntity(customerDBDTO);
        customerRepository.save(customerDB);
        return customerDBDTO;
    }
}
