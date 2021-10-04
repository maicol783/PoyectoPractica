package com.proyectopractica.customerservice.view.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Table(name = "customer_tbl")
@Entity
public class Customer {
    @Id
    @Size(min = 5, max = 15, message = "El tamaño del numero debe tener entre 5 a 15 caracteres")
    @Column(name = "numero_identificacion", unique = true)
    private String identificationNumber;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_identificacion")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private IdentificationType identificationType;

    @Size(min = 3, max = 50, message = "El tamaño del nombre debe tener entre 3 a 50 caracteres")
    @NotEmpty(message = "El nombre no puede estar vacio")
    private String firstName;

    @Size(min = 3, max = 50, message = "El tamaño del apellido debe tener entre 3 a 50 caracteres")
    @NotEmpty(message = "El nombre no puede estar vacio")
    private String lastName;

    @NotNull(message = "El nombre no puede estar vacio")
    @Positive(message = "Se debe ingresar una edad correcta")
    private int age;

    @Size(max = 25, message = "El tamaño de la ciudad sobrepasa los 25 caracteres")
    @NotEmpty(message = "El nombre no puede estsar vacio")
    private String town;

    private String status;

    private String photo;

}
