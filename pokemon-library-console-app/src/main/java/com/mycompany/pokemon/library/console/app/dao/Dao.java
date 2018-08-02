/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pokemon.library.console.app.dao;

import com.mycompany.pokemon.library.console.app.dto.Pokemon;
import java.util.List;

/**
 *
 * @author Kenny
 */
public interface Dao {

    Pokemon getPokemonById(int id);

    Pokemon getPokemonByName(String name);

    void removePokemonById(int id);

    void addPokemon(Pokemon pokemon);

    void updatePokemon(Pokemon pokemon);

    List<Pokemon> viewAllPokemon();
    
}
