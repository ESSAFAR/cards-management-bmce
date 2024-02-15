package com.example.authentication.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employe {
    @Id
    @GeneratedValue
    private String id;
    private String nom;
    private String prenom;
    private String tele;
    @Column(unique = true)
    private String identite;
    private Date ddn;
    private Sex sex;
    @OneToMany(mappedBy = "employe",fetch = FetchType.EAGER)
    private Collection<CarteNominative> cartesNominatives;
    @ManyToOne
    @JsonManagedReference
    private Entreprise entreprise;

    public Employe(String nom, String prenom, String identite, Date ddn, Sex sex) {
        this.nom = nom;
        this.prenom = prenom;
        this.identite = identite;
        this.ddn = ddn;
        this.sex = sex;
    }

    public Employe(String nom, String identite, Date ddn, Sex sex) {
        this.nom = nom;
        this.identite = identite;
        this.ddn = ddn;
        this.sex = sex;
    }
    public Employe(String nom, String tele, String identite, Date ddn, Sex sex, Entreprise entreprise) {
        this.nom = nom;
        this.tele = tele;
        this.identite = identite;
        this.ddn = ddn;
        this.sex = sex;
        this.entreprise = entreprise;
    }

    public static Date ddn(String ddnString){
        Date ddn = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            ddn = dateFormat.parse(ddnString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return ddn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return id == employe.id && Objects.equals(nom, employe.nom) && Objects.equals(prenom, employe.prenom) && Objects.equals(tele, employe.tele) && Objects.equals(identite, employe.identite) && Objects.equals(ddn, employe.ddn) && sex == employe.sex && Objects.equals(cartesNominatives, employe.cartesNominatives) && Objects.equals(entreprise, employe.entreprise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, tele, identite, ddn, sex, cartesNominatives, entreprise);
    }
}
