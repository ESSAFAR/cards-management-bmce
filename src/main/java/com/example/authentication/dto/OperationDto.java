package com.example.authentication.dto;

import com.example.authentication.model.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
public class OperationDto {
    private TypeOperation typeOperation;
    private String description;
    private double montant;
    private Date date;
    private Long numeroCarte;
    private String entreprise;
    private Double balance;
    private String nomPerson;
    private String personId;
    private Status status;

    public OperationDto(Operation operation, CarteNominative carte) {
        this.typeOperation = operation.getTypeOperation();
        this.description = operation.getDescription();
        this.montant = operation.getMontant();
        this.date = operation.getDate();
        this.numeroCarte = carte.getId();
        this.entreprise = carte.getEntreprise().getNom();
        this.balance = carte.getEntreprise().getBalance();
        this.nomPerson = carte.getEmploye().getNom();
        this.personId = carte.getEmploye().getIdentite();
        this.status = carte.getStatus();
    }
}