/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pokemon.library.console.app.controller;

import com.mycompany.pokemon.library.console.app.dto.Pokemon;
import com.mycompany.pokemon.library.console.app.service.ServiceLayer;
import com.mycompany.pokemon.library.console.app.view.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kenny
 */
public class MainController {
    
    UserInterface ui;
    ServiceLayer sl;
    
    public MainController(UserInterface ui,ServiceLayer sl) {
        this.ui = ui;
        this.sl= sl;
    }

    public void run() {

        boolean keepRunning = true;

        ui.displayGreeting();

        while (keepRunning) {
            ui.displayMenu();
            String response = ui.userResponse("Insert number key to continue.");

            switch (response) {
                case "1":
                    addPokemon();
                    break;
                case "2":
                    System.out.println("Remove Pokemon");
                    break;
                case "3":
                    System.out.println("Update Pokemon");
                    break;
                case "4":
                    System.out.println("View all Pokemon");
                    break;
                case "5":
                    viewAllPokemon();
                    break;
                case "6" :
                    ui.displayExit();
                    keepRunning = false;
                    break;
                default:
                    displayUnavailible();
            }
        }
    }
    
    private void addPokemon(){
        sl.addPokemon(ui.promptUserPokemon());
        ui.pressEnterToContinue();
    }
    
    private void viewAllPokemon(){
        ui.displayAllPokemon(sl.viewAllPokemon());
        ui.pressEnterToContinue();
    }
    
    private void displayUnavailible(){
        ui.displayUnavailible();
    }
    
}
