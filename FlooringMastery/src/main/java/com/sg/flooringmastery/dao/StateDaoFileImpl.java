/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.State;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class StateDaoFileImpl implements StateDao {

    public static final String STATE_FILE = "Taxes.txt";
    public static final String DELIMITER = ",";

    private Map<String, State> states = new HashMap<>();

    private void readStateAndTax() throws FlooringPersistenceException {
        Scanner scanner;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(STATE_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException(" -_- Could not load the order number into memory.", e);
        }

        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentTokens = currentLine.split(DELIMITER);

            State currentState = new State(currentTokens[0]);
            currentState.setStateTax(new BigDecimal(currentTokens[1]));

            states.put(currentState.getState(), currentState);
        }

        scanner.close();
    }

    public State getStateTax(String state) throws FlooringPersistenceException {
        readStateAndTax();
        return states.get(state);
    }
    
    public List<State> getStateList() throws FlooringPersistenceException {
        readStateAndTax();
        List<State> stateList = new ArrayList<>(states.values());
        return stateList; 
    }
    
}
