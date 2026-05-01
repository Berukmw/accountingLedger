package com.pluralsight;

import java.util.*;


public class LedgerScreen {

    private Scanner scanner;
    private ArrayList<Transaction> transactions;

    public LedgerScreen(Scanner scanner, ArrayList<Transaction> transactions) {
        this.scanner = scanner;
        this.transactions = transactions;
    }

    public void display() {

        boolean running = true;

        while (running) {
            System.out.println("\n----- FINANCIAL LEDGER -----");
            System.out.println("A) All Entries");
            System.out.println("D) Revenue");
            System.out.println("P) Expenses");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            System.out.print("\nEnter option: ");

            String input = scanner.nextLine().toUpperCase();

            if (input.equals("A")) {
                displayAll();
            } else if (input.equals("D")) {
                displayRevenue();
            } else if (input.equals("P")) {
                displayExpenses();
            } else if (input.equals("R")) {
                ReportsScreen reportsScreen = new ReportsScreen(scanner, transactions);
                reportsScreen.display();
            } else if (input.equals("H")) {
                running = false;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }

    public void displayAll() {
        System.out.println("\n--- ALL ENTRIES ---");
        for (int i = 0; i < transactions.size(); i++) {
            Transaction t = transactions.get(i);
            System.out.println(t.getDate() + " | " + t.getTime() + " | " + t.getDescription() + " | " + t.getVendor() + " | " + t.getAmount());
        }
    }

    public void displayRevenue() {
        System.out.println("\n--- REVENUE ---");
        for (int i = 0; i < transactions.size(); i++) {
            Transaction t = transactions.get(i);
            if (t.getAmount() > 0) {
                System.out.println(t.getDate() + " | " + t.getTime() + " | " + t.getDescription() + " | " + t.getVendor() + " | " + t.getAmount());
            }
        }
    }

    public void displayExpenses() {
        System.out.println("\n--- EXPENSES ---");
        for (int i = 0; i < transactions.size(); i++) {
            Transaction t = transactions.get(i);
            if (t.getAmount() < 0) {
                System.out.println(t.getDate() + " | " + t.getTime() + " | " + t.getDescription() + " | " + t.getVendor() + " | " + t.getAmount());
            }
        }
    }
}