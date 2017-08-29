/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.week1summatives;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class DogGenetics {
    public static void main(String[] args) {
        int percentage = 100;
        int breed1 = 0;
        int breed2 = 0;
        int breed3 = 0;
        int breed4 = 0;
        int breed5 = 0;
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("What is your dog's name?");
        String dogName = sc.nextLine();
        
        System.out.println("Well then, I have this highly reliable report on " + dogName + "'s prestigious background right here.");
        System.out.println(dogName + " is:");
        System.out.println(" ");
        
        breed1 = r.nextInt(percentage);
        percentage -= breed1;
        
        breed2 = r.nextInt(percentage);
        percentage -= breed2;
        
        breed3 = r.nextInt(percentage);
        percentage -= breed3;
        
        breed4 = r.nextInt(percentage);
        percentage -= breed4;
        
        breed5 = percentage;
        percentage -= breed5;
        
        System.out.println(breed1 + "% St. Bernard");
        System.out.println(breed2 + "% Chihuahua");
        System.out.println(breed3 + "% Corgi");
        System.out.println(breed4 + "% German Shephard");
        System.out.println(breed5 + "% King Doberman");
        
        System.out.println(" ");
        System.out.println("Wow, " + dogName + " is QUITE the dog!");
    }
}
