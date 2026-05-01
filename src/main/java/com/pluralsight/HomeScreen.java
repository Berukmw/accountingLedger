package com.pluralsight;

import java.time.*;
import java.util.*;


public class HomeScreen {
    // creating blue color text
    public static final String BLUE = "\u001B[34m";
    public static final String RESET = "\u001B[0m";

    private Scanner scanner;
    private ArrayList<Transaction> transactions;

    public HomeScreen(Scanner scanner, ArrayList<Transaction> transactions) {
        this.scanner = scanner;
        this.transactions = transactions;
    }

    public void display() {

        boolean running = true;

        while (running) {
            System.out.println("\n" + BLUE + "----- HOME SCREEN -----" + RESET);
            System.out.println(BLUE + "D)" + RESET + " Add Revenue");
            System.out.println(BLUE + "P)" + RESET + " Add Expense");
            System.out.println(BLUE + "L)" + RESET + " Financial Ledger");
            System.out.println(BLUE + "X)" + RESET + " Exit");
            System.out.print("\nEnter option: ");

            String input = scanner.nextLine().toUpperCase();

            if (input.equals("D")) {
                addRevenue();
            } else if (input.equals("P")) {
                addExpense();
            } else if (input.equals("L")) {
                LedgerScreen ledgerScreen = new LedgerScreen(scanner, transactions);
                ledgerScreen.display();
            } else if (input.equals("X")) {
                System.out.println("Goodbye!");
                running = false;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }

    public void addRevenue() {
        System.out.println("\n" + BLUE + "----- ADD REVENUE -----" + RESET);

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Payee: ");
        String vendor = scanner.nextLine();

        System.out.print("Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        if (amount < 0) amount = Math.abs(amount);

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        Transaction t = new Transaction(date, time, description, vendor, amount);
        transactions.add(t);
        FileManager.saveTransaction(t);
        System.out.println("Revenue of $" + String.format("%.2f", amount) + " saved successfully.");
    }

    public void addExpense() {
        System.out.println("\n" + BLUE + "----- ADD EXPENSE -----" + RESET);

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Payee: ");
        String vendor = scanner.nextLine();

        System.out.print("Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        if (amount > 0) amount = -amount;

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        Transaction t = new Transaction(date, time, description, vendor, amount);
        transactions.add(t);
        FileManager.saveTransaction(t);
        System.out.println("Expense of $" + String.format("%.2f", Math.abs(amount)) + " saved successfully.");
    }
}