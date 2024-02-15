package com.example.authentication.api;

import com.example.authentication.Repositories.EntrepriseRepository;
import com.example.authentication.model.Carte;
import com.example.authentication.model.Entreprise;
import com.example.authentication.model.Operation;
import jakarta.transaction.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/dashboard")
public class DashboardController {
    public final EntrepriseRepository entrepriseRepository;


    @GetMapping("/balance")
    public double getBalanceGlobale(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Entreprise entreprise =  entrepriseRepository.findByNom(authentication.getName());

        return entreprise.getCartes().stream().mapToDouble(Carte::getSolde).sum();
    }

    @GetMapping("/transactions")
    public List<Operation> getListeTransaction(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Entreprise entreprise =  entrepriseRepository.findByNom(authentication.getName());
        List<Operation> transactions = new ArrayList<>();
        for(Carte carte : entreprise.getCartes()){
            for(Operation transaction : carte.getOperations()){
                transactions.add(transaction);
            }
        }

        return transactions;
    }

    @GetMapping("/listcartes")
    public List<Carte> getListeCartes() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Entreprise entreprise =  entrepriseRepository.findByNom(authentication.getName());
        List<Carte> cartes = entreprise.getCartes();
        return cartes.stream().toList();
    }

}
