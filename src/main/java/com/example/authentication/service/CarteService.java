package com.example.authentication.service;

import com.example.authentication.model.Carte;
import com.example.authentication.model.Operation;

import java.util.List;
import java.util.Optional;

public interface CarteService {
    public List<Carte> getCards();
    public Optional<Carte> getCard(Long id);
    public float getSolde(Long id);
    public List<Operation> getOperations(Long id);
    public void addOperationToCard(Long id,Operation operation);
}
