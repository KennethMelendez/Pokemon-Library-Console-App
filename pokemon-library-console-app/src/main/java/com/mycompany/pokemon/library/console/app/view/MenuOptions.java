/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pokemon.library.console.app.view;

/**
 *
 * @author Kenny
 */


public enum MenuOptions {
    
    ADD_POKEMON("Add Pokemon"), 
    REMOVE_POKEMON("Remove Pokemon"), 
    UPDATE_POKEMON("Update Pokemon"), 
    VIEW_POKEMON("View Pokemon"), 
    VIEW_ALL_POKEMON("View All Pokemon"), 
    EXIT("Exit Application");

    private String menu;

    MenuOptions(String menu) {
        this.menu = menu;
    }
    
    String getMenuOptions(){
        return menu;
    }

}
