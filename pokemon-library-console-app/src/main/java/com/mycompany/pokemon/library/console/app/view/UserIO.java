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
public interface UserIO {

    public void displayMsg(String msg);

    public String readMsg(String msg);

    public void displayInt(int msg);
    
    public int readInt(int msg);
    
}
