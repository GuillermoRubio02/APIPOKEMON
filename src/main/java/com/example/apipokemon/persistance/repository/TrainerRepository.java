package com.example.apipokemon.persistance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apipokemon.persistance.model.Pokemon;
import com.example.apipokemon.persistance.model.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {

}
