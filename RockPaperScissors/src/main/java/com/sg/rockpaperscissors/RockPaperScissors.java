/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.rockpaperscissors;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class RockPaperScissors {

    public static void main(String[] args) {       
        boolean playAgain;
        
        

        do {
            int usersChoice;
        Random computersChoice = new Random(3);
        Scanner sc = new Scanner(System.in);
        ArrayList userThrows = new ArrayList();
        ArrayList computerThrows = new ArrayList();
            Scanner sc2 = new Scanner(System.in);
            int numOfTies = 0;
        int playerWins = 0;
        int computerWins = 0;

            System.out.println("Thanks for coming to play Rock Paper Scissors! "
                    + "How many rounds would you like to play?"
                    + " Please Pick a number between 1 and 10.");
            int roundsDesired = sc.nextInt();

            if (roundsDesired < 1) {
                System.out.println("That is not valid! we can't play 0 rounds or negative rounds silly! Restart the program!");
            } else if (roundsDesired > 10) {
                System.out.println("Too many rounds! Let's stay under 10, if you'd like to play more then we can start a new game later! Restart the program!");
            } else {
                for (int i = 1; i < roundsDesired + 1; i++) {
                    System.out.println("Please choose a number to represent your pick, 0 = Rock, 1 = Paper, and 2 = Scissors!");
                    usersChoice = sc.nextInt();
                    if (usersChoice == 0) {
                        //System.out.println("Round " + i + " You chose Rock!");
                        userThrows.add(0);
                    } else if (usersChoice == 1) {
                        //System.out.println("Round " + i + " You chose Paper!");
                        userThrows.add(1);
                    } else if (usersChoice == 2) {
                        //System.out.println("Round " + i + " You chose Scissors!");
                        userThrows.add(2);
                    } else {
                        System.out.println("Please choose a valid choice between 0 and 2.");
                        i -= 1;
                    }
                }
            }
            for (int i = 1; i < roundsDesired + 1; i++) {
                if (computersChoice.nextInt(3) == 0) {
                    //System.out.println("Round " + i + " Computer has chosen Rock!");
                    computerThrows.add(0);
                } else if (computersChoice.nextInt(3) == 1) {
                    //System.out.println("Round " + i + " Computer has chosen Paper!");
                    computerThrows.add(1);
                } else if (computersChoice.nextInt(3) == 2) {
                    //System.out.println("Round " + i + " Computer has chosen Scissors!");
                    computerThrows.add(2);
                } else {
                    i -= 1;
                }
            }
            System.out.println("The user's throws are as follows: " + userThrows);
            System.out.println("Computer's throws are as follows: " + computerThrows);

            int userSize = userThrows.size();
            for (int j = 0; j < userSize; j++) {
                if (userThrows.get(j) == computerThrows.get(j)) {
                    numOfTies += 1;
                } if ((int) userThrows.get(j) == 2 && (int) computerThrows.get(j) == 0) {
                    playerWins += 1;
                } if ((int) userThrows.get(j) == 2 && (int) computerThrows.get(j) == 1) {
                    computerWins += 1;
                } if ((int) userThrows.get(j) == 1 && (int) computerThrows.get(j) == 0) {
                    playerWins += 1;
                } if ((int) userThrows.get(j) == 1 && (int) computerThrows.get(j) == 2) {
                    computerWins += 1;
                } if ((int) userThrows.get(j) == 0 && (int) computerThrows.get(j) == 2) {
                    playerWins += 1;
                } if ((int) userThrows.get(j) == 0 && (int) computerThrows.get(j) == 1) {
                    computerWins += 1;
                } else {
                }
            }
            System.out.println("You and the computer tied " + numOfTies + " times!");
            System.out.println("You beat the computer " + playerWins + " times!");
            System.out.println("The computer beat you " + computerWins + " times!");

            System.out.println("That was fun wasn't it? To play again type 'true'. To quit, type 'false'.");
            playAgain = sc2.nextBoolean();
        
        } while (playAgain == true);
    }
}

