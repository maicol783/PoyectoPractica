package com.proyectopractica.customerservice.view.dto;

import com.proyectopractica.customerservice.view.entity.IdentificationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor @NoArgsConstructor @Data @Builder
public class CustomerDTO implements Serializable {

    private String identificationNumber;

    private IdentificationType identificationType;

    private String firstName;

    private String lastName;

    private int age;

    private String town;

    private String status;

    private String photo;
}
