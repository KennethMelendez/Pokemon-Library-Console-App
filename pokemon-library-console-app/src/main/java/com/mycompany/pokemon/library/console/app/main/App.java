/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pokemon.library.console.app.main;

import com.mycompany.pokemon.library.console.app.controller.Controller;
import com.mycompany.pokemon.library.console.app.view.UserIO;
import com.mycompany.pokemon.library.console.app.view.UserIOImpl;
import com.mycompany.pokemon.library.console.app.view.UserInterface;

/**
 *
 * @author Kenny
 */
public class App {
    public static void main(String[] args) {
        UserIO io = new UserIOImpl();
        UserInterface ui = new UserInterface(io);
        Controller c = new Controller(ui);
        c.run();
        
    }
}
