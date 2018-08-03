/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pokemon.library.console.app.view;

import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kenny
 */


public class UserIOImpl implements UserIO{

    // beans at repository or component where i would
    // @controller
    // put autowired at constructor
    private Scanner scanner = new Scanner(System.in);
    
    //@Autowired
 
    public UserIOImpl(){
        
    }
    
    @Override
    public void displayMsg(String msg) {
        System.out.println(msg);
    }

    @Override
    public String readMsg(String msg) {
        String result = "";
        this.displayMsg(msg);
        return result = scanner.nextLine();
    }

    @Override
    public void displayInt(int msg) {
        System.out.println(msg);
    }

    @Override
    public int readInt(String msg) {
        String result;
        this.displayMsg(msg);
        result = scanner.nextLine();
        return Integer.parseInt(result);
    }
    
}
