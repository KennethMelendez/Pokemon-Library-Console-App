/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pokemon.library.console.app.main;

import com.mycompany.pokemon.library.console.app.controller.MainController;
import com.mycompany.pokemon.library.console.app.dao.Dao;
import com.mycompany.pokemon.library.console.app.dao.DaoImpl;
import com.mycompany.pokemon.library.console.app.service.ServiceLayer;
import com.mycompany.pokemon.library.console.app.service.ServiceLayerImpl;
import com.mycompany.pokemon.library.console.app.view.UserIO;
import com.mycompany.pokemon.library.console.app.view.UserIOImpl;
import com.mycompany.pokemon.library.console.app.view.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Kenny
 */

public class App {

    public static void main(String[] args) {

        // hardcoding for now..later using spring di
        UserIO io = new UserIOImpl();
        Dao d = new DaoImpl();
        ServiceLayer sl = new ServiceLayerImpl(d);
        UserInterface ui = new UserInterface(io);
        MainController controller = new MainController(ui,sl);
        controller.run();
        
    }
}
