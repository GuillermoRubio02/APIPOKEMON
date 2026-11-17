package com.example.apipokemon.persistance.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pokemon")
@Data
@NoArgsConstructor
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "imagen_url")
    private String imagen_url;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;


    @ManyToMany
    @JoinTable(
    name = "pokemon_abilities",
    joinColumns = @JoinColumn(name = "pokemon_id"),
    inverseJoinColumns = @JoinColumn(name = "ability_id"))
    private Set<Ability> abilities = new HashSet<>();


}
