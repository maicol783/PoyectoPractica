package com.proyectopractica.customerservice.model.repository;

import com.proyectopractica.customerservice.view.dto.CustomerDTO;
import com.proyectopractica.customerservice.view.entity.Customer;
import com.proyectopractica.customerservice.view.entity.IdentificationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    @Query("Select c from Customer c where c.age>=?1")
    List<Customer> findByEdad(int edad);

    List<Customer> findByIdentificationTypeAndIdentificationNumber(IdentificationType identificationType, String identificationNumber);

}
