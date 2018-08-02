/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pokemon.library.console.app.view;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kenny
 */

public class UserInterface {
    
    
    private UserIO io;
   
    
    public UserInterface(UserIO io){
        this.io = io;
    }
    
    public void displayGreeting(){
        io.displayMsg("Welcome to the Pokemon Library Application");
        io.displayMsg("Keep track of your favorite Pokemon.");
    }
    
    public void menu(){
        
        int keyValue = 0;
        for(String m :menuOptions()){
            keyValue++;
            io.displayMsg(keyValue + m);
        }

       
        
    }
    
    public List<String> menuOptions(){
        // menu list array
        List<String> menuList = new ArrayList<>();
        // add pokemon
        MenuOptions add = MenuOptions.ADD_POKEMON;
        // adding to the array
        menuList.add(add.getMenuOptions());
        
        MenuOptions remove = MenuOptions.REMOVE_POKEMON;
        menuList.add(remove.getMenuOptions());
        
        MenuOptions update = MenuOptions.UPDATE_POKEMON;
        menuList.add(update.getMenuOptions());
        
        MenuOptions viewAll = MenuOptions.VIEW_ALL_POKEMON;
        menuList.add(viewAll.getMenuOptions());
        
        MenuOptions view = MenuOptions.VIEW_POKEMON;
        menuList.add(view.getMenuOptions());
        
        MenuOptions exit = MenuOptions.EXIT;
        menuList.add(exit.getMenuOptions());
        
        return menuList;
    }
    
    
}
