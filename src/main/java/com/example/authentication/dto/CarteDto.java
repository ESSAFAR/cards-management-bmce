package com.example.authentication.dto;

import com.example.authentication.model.*;
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

    private Collection<Operation> operations;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String employe;


    public CarteDto(CarteNominative carte) {
        this.id = carte.getId();
        this.solde = carte.getSolde();
        this.status = carte.getStatus();
        this.employe = carte.getEmploye().getIdentite();
    }


    public CarteDto(Carte carte) {
        this.id = carte.getId();
        this.solde = carte.getSolde();
        this.operations = carte.getOperations();
        this.status = carte.getStatus();
    }
}
