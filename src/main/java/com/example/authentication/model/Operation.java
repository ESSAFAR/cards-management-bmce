package com.example.authentication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Operation {
    @Id
    @GeneratedValue
    private Long id;
    private TypeOperation typeOperation;
    private String description;
    private double montant;
    private Date date;

    public Operation(TypeOperation typeOperation, String description, double montant, Date date) {
        this.typeOperation = typeOperation;
        this.description = description;
        this.montant = montant;
        this.date = date;
    }
}
