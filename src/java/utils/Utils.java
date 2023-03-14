package utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class Utils {
    public static int getRandomNumber() {
    int min = 50;
    int max = 300;
    int range = max - min + 1;

    // generate a random number between 50 and 100
    int randomNumber = (int)(Math.random() * range) + min;

    return randomNumber;
}
}
