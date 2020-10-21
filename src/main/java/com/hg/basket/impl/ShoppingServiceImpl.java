package com.hg.basket.impl;

import com.hg.basket.ShoppingService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ShoppingServiceImpl implements ShoppingService {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter String");
        String s = br.readLine();
        System.out.print("Enter Integer:");
        try {
            int i = Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        }
    }

    @Override
    public boolean getInputs() {
       /* Scanner scan = new Scanner(System.in);
        boolean validData = false;
        int number = 0;
        do {
            System.out.println("Enter a Number");
            try {
                number = scan.nextInt();//tries to get data. Goes to catch if invalid data
                validData = true;//if gets data successfully, sets boolean to true
            } catch (InputMismatchException e) {
                //executes when this exception occurs
                System.out.println("Input has to be a number. ");
            }
        } while (validData == false);//loops until validData is true*/
        return Boolean.TRUE;
    }

    @Override
    public BigDecimal calculateTotalPrice() {
        return null;
    }
}
