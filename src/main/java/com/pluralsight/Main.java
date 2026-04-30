package com.pluralsight;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Transaction> transactions = FileManager.loadTransactions();
        Scanner scanner = new Scanner(System.in);

        HomeScreen homeScreen = new HomeScreen(scanner, transactions);
        homeScreen.display();

        scanner.close();

       /*

        for (int i = 0; i < transactions.size(); i++) {
            Transaction t = transactions.get(i);
            System.out.println(t.getDate() + " | " + t.getVendor() + " | " + t.getAmount());

        */
    }
}