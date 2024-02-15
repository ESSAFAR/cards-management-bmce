package com.example.authentication.dto;

import com.example.authentication.model.Entreprise;
import com.example.authentication.model.Operation;
import com.example.authentication.model.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class CarteDto {

    private Long id;
    private float solde;

    private Entreprise entreprise;

    @OneToMany
    private Collection<Operation> operations;
    @Enumerated(EnumType.STRING)
    private Status status;
}
