/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pokemon.library.console.app.dao;

import com.mycompany.pokemon.library.console.app.dto.Pokemon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kenny
 */
public class DaoImpl implements Dao{

    Map<Integer ,Pokemon> pokedex = new HashMap<>();
    
    @Override
    public Pokemon getPokemonById(int id) {
       return pokedex.get(id);
    }

    @Override
    public Pokemon getPokemonByName(String name) {
        List<Pokemon> pokemon = new ArrayList<>(pokedex.values());
        for(Pokemon p : pokemon){
            if(p.getName().equalsIgnoreCase(name)){
                return p;
            }
        }
        return null;
    }

    @Override
    public void removePokemonById(int id) {
        pokedex.remove(id);
    }

    @Override
    public void addPokemon(Pokemon pokemon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updatePokemon(Pokemon pokemon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pokemon> viewAllPokemon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
