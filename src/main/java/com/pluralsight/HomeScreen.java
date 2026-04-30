package com.pluralsight;

import java.time.*;
import java.util.*;

public class HomeScreen {

    private Scanner scanner;
    private ArrayList<Transaction> transactions;

    public HomeScreen(Scanner scanner, ArrayList<Transaction> transactions) {
        this.scanner = scanner;
        this.transactions = transactions;
    }

    // display code block
    public void display() {

        // checks if application is running
        boolean running = true;

        while (running) {
            System.out.println("\n----- HOME SCREEN -----");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.print("\nEnter option: ");

            String input = scanner.nextLine().toUpperCase();

            if (input.equals("D")) {
                addDeposit();
            } else if (input.equals("P")) {
                makePayment();
            } else if (input.equals("L")) {
                System.out.println("Ledger coming soon...");
            } else if (input.equals("X")) {
                System.out.println("Goodbye!");
                running = false;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }
    // deposit code block
    public void addDeposit() {
        System.out.println("\n----- ADD DEPOSIT -----");

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Vendor: ");
        String vendor = scanner.nextLine();

        System.out.print("Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        Transaction t = new Transaction(date, time, description, vendor, amount);

        transactions.add(t);
        FileManager.saveTransaction(t);

        System.out.println("Deposit saved!");
    }
    // payment code block
    public void makePayment() {
        System.out.println("\n----- MAKE PAYMENT -----");

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Vendor: ");
        String vendor = scanner.nextLine();

        System.out.print("Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        // payments are always negative
        if (amount > 0) {
            amount = -amount;
        }

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        Transaction t = new Transaction(date, time, description, vendor, amount);

        transactions.add(t);
        FileManager.saveTransaction(t);

        System.out.println("Payment saved!");
    }
}