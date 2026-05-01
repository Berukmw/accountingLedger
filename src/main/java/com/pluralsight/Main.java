package com.pluralsight;

import java.util.*;

public class Main {

    public static final String BLUE = "\u001B[34m";
    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) {

        System.out.println(BLUE + "╔══════════════════════════════════════════╗");
        System.out.println("║                                          ║");
        System.out.println("║      SEATTLE MARINERS 2026 FINANCES      ║");
        System.out.println("║                                          ║");
        System.out.println("╚══════════════════════════════════════════╝" + RESET);
        System.out.println("\nLoading... " + BLUE + "Go M's!" + RESET + "\n");

        ArrayList<Transaction> transactions = FileManager.loadTransactions();
        Scanner scanner = new Scanner(System.in);

        HomeScreen homeScreen = new HomeScreen(scanner, transactions);
        homeScreen.display();

        scanner.close();
    }
}