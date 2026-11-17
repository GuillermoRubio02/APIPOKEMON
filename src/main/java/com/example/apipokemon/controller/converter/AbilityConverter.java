package com.example.apipokemon.controller.converter;

import org.springframework.stereotype.Component;

import com.example.apipokemon.controller.dto.AbilityDto;
import com.example.apipokemon.persistance.model.Ability;

@Component
public class AbilityConverter {

    public AbilityDto convertToDto(Ability ability) {

        AbilityDto abilityDto = new AbilityDto();

        abilityDto.setId(ability.getId());
        abilityDto.setName(ability.getName());
        abilityDto.setDescription(ability.getDescription());

        return abilityDto;
    }

    public Ability convertToEntity(AbilityDto abilityDto) {

        Ability ability = new Ability();

        ability.setId(abilityDto.getId());
        ability.setName(abilityDto.getName());
        ability.setDescription(abilityDto.getDescription());

        return ability;
    }

}
