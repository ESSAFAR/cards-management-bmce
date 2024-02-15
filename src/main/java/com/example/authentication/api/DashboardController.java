package com.example.authentication.api;

import com.example.authentication.Repositories.EntrepriseRepository;
import com.example.authentication.model.Carte;
import com.example.authentication.model.Entreprise;
import com.example.authentication.model.Operation;
import jakarta.transaction.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Dashboard")
public class DashboardController {
    public final EntrepriseRepository entrepriseRepository;


    @GetMapping("/balance/{id}")
    public double getBalanceGlobale(Long id){
        Entreprise entreprise =  entrepriseRepository.findById(id).get();
        return entreprise.getCartes().stream().mapToDouble(Carte::getSolde).sum();
    }

    @GetMapping("/transactions/{id}")
    public List<Operation> getListeTransaction(Long id){
        Entreprise entreprise =  entrepriseRepository.findById(id).get();
        List<Operation> transactions = new ArrayList<>();
        for(Carte carte : entreprise.getCartes()){
            for(Operation transaction : carte.getOperations()){
                transactions.add(transaction);
            }
        }

        return transactions;
    }

    @GetMapping("/cartes/{id}")
    public List<Carte> getListeCartes(@PathVariable Long id) {
        Entreprise entreprise =  entrepriseRepository.findById(id).get();
        return entreprise.getCartes();
    }

}
