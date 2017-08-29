/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.week1summatives;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class HealthyHearts {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int beginningHeartRate = 220;
        System.out.println("What is your Age?");
        int userAge = sc.nextInt();
        int maxHeartRate = beginningHeartRate - userAge;
        int minRange = (int) (maxHeartRate/2);
        int maxRange = (int)(maxHeartRate * .85);

    System.out.println ("Your maximum heart rate should be " + maxHeartRate + " beats per minute.");
    System.out.println("Your target Heart Rate Zone is " + minRange + " - " + maxRange + " beats per minute.");
    }
}
