/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pokemon.library.console.app.view;

import com.mycompany.pokemon.library.console.app.dto.Pokemon;
import com.mycompany.pokemon.library.console.app.exceptions.InvalidResponseException;
import com.mycompany.pokemon.library.console.app.exceptions.PersistenceException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Kenny
 */
public class UserInterface {

    private UserIO io;

    public UserInterface(UserIO io) {
        this.io = io;
    }

    public void displayGreeting() {
        io.displayMsg("Welcome to the Pokemon Library Application");
        io.displayMsg("Keep track of your favorite Pokemon.");
    }

    public void displayMenu() {
        int keyValue = 0;
        for (String m : menuOptions()) {
            keyValue++;
            io.displayMsg(keyValue + " " + m);
        }
    }

    private List<String> menuOptions() {
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

    public String userResponse(String msg) {
        return io.readMsg(msg);
    }

    public Pokemon promptUserPokemon() {

        Pokemon p = new Pokemon();
        String id = userResponse("Insert Pokemons ID");
        String name = userResponse("Insert Name.");
        String description = userResponse("Insert Description");
        String type1 = userResponse("Insert Pokemons Type.");
        String type2 = userResponse("Insert Pokemons Second Type.");

        p.setPokemonId(Integer.parseInt(id));
        p.setName(name);
        p.setDescription(description);
        p.setType1(type1);
        p.setType2(type2);

        return p;
    }

    public Pokemon editPokemon(Pokemon p) {
        io.displayMsg("Edit this Pokemon?");
        this.displayPokemon(p);

        boolean invalidResponse = true;

        while (invalidResponse) {
            try {
                p = editPokemonIntID(p, "Edit PokemonID?", "Insert Pokemons ID.");
                invalidResponse = false;
            } catch (InvalidResponseException ex) {
                invalidResponse = true;
            }
        }
        invalidResponse = true;
        while (invalidResponse) {
            try {
                p = editPokemonStringName(p, "Edit Pokemon Name?", "Insert Pokemons Names.");
                invalidResponse = false;
            } catch (InvalidResponseException ex) {
                invalidResponse = true;
            }
        }
        invalidResponse = true;
        while (invalidResponse) {
            try {
                p = editPokemonStringDescription(p, "Edit Pokemon Description?", "Insert Pokemons Description.");
                invalidResponse = false;
            } catch (InvalidResponseException ex) {
                invalidResponse = true;
            }
        }
        invalidResponse = true;
        while (invalidResponse) {
            try {
                p = editPokemonStringType(p, "Edit Pokemon Type?", "Insert Pokemons Type.");
                invalidResponse = false;
            } catch (InvalidResponseException ex) {
                invalidResponse = true;
            }
        }
        invalidResponse = true;
        while (invalidResponse) {
            try {
                p = editPokemonStringSecondaryType(p, "Edit Pokemon Type?", "Insert Pokemons Type.");
                invalidResponse = false;
            } catch (InvalidResponseException ex) {
                invalidResponse = true;
            }
        }

        io.displayMsg("New Edited Pokemon");
        this.displayPokemon(p);

        return p;
    }

    private Pokemon editPokemonIntID(Pokemon p, String askWhatToEdit, String yesResultMessage) throws InvalidResponseException {
        String response = this.yesOrNoEditPrompt(askWhatToEdit);
        if (response.equalsIgnoreCase("y")) {
            String id = userResponse(yesResultMessage);
            p.setPokemonId(Integer.parseInt(id));
        } else if (response.equalsIgnoreCase("n")) {
            io.displayMsg("No changes were made.");
        } else {
            throw new InvalidResponseException();
        }
        return p;
    }

    private Pokemon editPokemonStringName(Pokemon p, String askWhatToEdit, String yesResultMessage) throws InvalidResponseException {
        String response = this.yesOrNoEditPrompt(askWhatToEdit);
        if (response.equalsIgnoreCase("y")) {
            String name = userResponse(yesResultMessage);
            p.setName(name);
        } else if (response.equalsIgnoreCase("n")) {
            io.displayMsg("No changes were made.");
        } else {
            throw new InvalidResponseException();
        }
        return p;
    }

    private Pokemon editPokemonStringDescription(Pokemon p, String askWhatToEdit, String yesResultMessage) throws InvalidResponseException {
        String response = this.yesOrNoEditPrompt(askWhatToEdit);
        if (response.equalsIgnoreCase("y")) {
            String name = userResponse(yesResultMessage);
            p.setName(name);
        } else if (response.equalsIgnoreCase("n")) {
            io.displayMsg("No changes were made.");
        } else {
            throw new InvalidResponseException();
        }
        return p;
    }

    private Pokemon editPokemonStringType(Pokemon p, String askWhatToEdit, String yesResultMessage) throws InvalidResponseException {
        String response = this.yesOrNoEditPrompt(askWhatToEdit);
        if (response.equalsIgnoreCase("y")) {
            String name = userResponse(yesResultMessage);
            p.setType1(name);
        } else if (response.equalsIgnoreCase("n")) {
            io.displayMsg("No changes were made.");
        } else {
            throw new InvalidResponseException();
        }
        return p;
    }

    private Pokemon editPokemonStringSecondaryType(Pokemon p, String askWhatToEdit, String yesResultMessage) throws InvalidResponseException {
        String response = this.yesOrNoEditPrompt(askWhatToEdit);
        if (response.equalsIgnoreCase("y")) {
            String name = userResponse(yesResultMessage);
            p.setType2(name);
        } else if (response.equalsIgnoreCase("n")) {
            io.displayMsg("No changes were made.");
        } else {
            throw new InvalidResponseException();
        }
        return p;
    }

    private String yesOrNoEditPrompt(String describeEditMsg) {
        io.displayMsg(describeEditMsg);
        return io.readMsg("Yes or No? please respond with(Y/N).");
    }

    public void displayAllPokemon(List<Pokemon> pokemon) {
        io.displayMsg("Pokemon List");
        for (Pokemon currentPokemon : pokemon) {
            io.displayMsg("");
            io.displayMsg("PokemonID : " + currentPokemon.getPokemonId());
            io.displayMsg("PokemonName : " + currentPokemon.getName());
            io.displayMsg("PokemonDescription : " + currentPokemon.getDescription());
            io.displayMsg("PokemonType : " + currentPokemon.getType1());
            io.displayMsg("PokemonType2 : " + currentPokemon.getType2());
            io.displayMsg("");
        }
    }

    public void displayPokemon(Pokemon currentPokemon) {
        io.displayMsg("Current Pokemon");
        io.displayMsg("PokemonID : " + currentPokemon.getPokemonId());
        io.displayMsg("PokemonName : " + currentPokemon.getName());
        io.displayMsg("PokemonDescription : " + currentPokemon.getDescription());
        io.displayMsg("PokemonType : " + currentPokemon.getType1());
        io.displayMsg("PokemonType2 : " + currentPokemon.getType2());
        io.displayMsg("");
    }

    public void pokemonDeletedMessage() {
        io.displayMsg("** Pokemon Removed.  ** ");
    }

    public void pokemonAddedMessage() {
        io.displayMsg("** Pokemon Added.  ** ");
    }

    public String inputPokemonName() {
        return io.readMsg("Please insert Pokemon Name.");
    }

    public int inputPokemonID() {
        return io.readInt("Please Insert PokemonID.");
    }

    public void pokemonRemovedMsg() {
        io.displayMsg("Pokemon Removed.");
    }

    public void pokemonUpdatedMsg() {
        io.displayMsg("Pokemon Updated.");
    }

    public void pressEnterToContinue() {
        io.readMsg("Press Enter To Continue.");
    }

    public void displayUnavailible() {
        io.displayMsg("Unavailible");
    }

    public void displayExit() {
        io.displayMsg("Exiting Application");
    }
}
