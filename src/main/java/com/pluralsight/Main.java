package com.pluralsight;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Transaction> transactions = FileManager.loadTransactions();

        for (int i = 0; i < transactions.size(); i++) {
            Transaction t = transactions.get(i);
            System.out.println(t.getDate() + " | " + t.getVendor() + " | " + t.getAmount());
        }
    }
}