/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pokemon.library.console.app.controller;

import com.mycompany.pokemon.library.console.app.view.UserInterface;

/**
 *
 * @author Kenny
 */
public class Controller {

    UserInterface ui;

    public Controller(UserInterface ui) {
        this.ui = ui;
    }

    public void run() {

        boolean keepRunning = true;

        ui.displayGreeting();

        while (keepRunning) {
            ui.displayMenu();
            String response = ui.userResponse("Insert number key to continue.");

            switch (response) {
                case "1":
                    System.out.println("Add Pokemon");
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
                    System.out.println("View Pokemon");
                    break;
                case "6" :
                    System.out.println("Exit");
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Unavailible");
            }

        }

    }
}
