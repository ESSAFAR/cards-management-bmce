package com.example.authentication.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Objects;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", length = 4)
public abstract class Carte {
    @Id
    @GeneratedValue
    private Long id;
    private float solde;
    @ManyToOne
    @JsonManagedReference
    @JsonIgnore
    private Entreprise entreprise;

    @OneToMany
    private Collection<Operation> operations;
    @Enumerated(EnumType.STRING)
    private Status status;

}
