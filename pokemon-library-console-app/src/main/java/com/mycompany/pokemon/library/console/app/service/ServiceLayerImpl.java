/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pokemon.library.console.app.service;

import com.mycompany.pokemon.library.console.app.dao.Dao;
import com.mycompany.pokemon.library.console.app.dao.DaoImpl;
import com.mycompany.pokemon.library.console.app.dto.Pokemon;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author kmlnd
 */

public class ServiceLayerImpl implements ServiceLayer{
    
    Dao dao;
   
    public ServiceLayerImpl(Dao dao){
       this.dao = dao;
    }
    
    @Override
    public Pokemon getPokemonById(int id) {
       return dao.getPokemonById(id);
    }

    @Override
    public Pokemon getPokemonByName(String name) {
        return dao.getPokemonByName(name);
    }

    @Override
    public void removePokemonById(int id) {
       dao.removePokemonById(id);
    }

    @Override
    public void addPokemon(Pokemon pokemon) {
        dao.addPokemon(pokemon);
    }

    @Override
    public void updatePokemon(Pokemon pokemon) {
        dao.updatePokemon(pokemon);
    }

    @Override
    public List<Pokemon> viewAllPokemon() {
        return dao.viewAllPokemon();
    }
    
}
