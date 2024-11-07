package com.pluralsight;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Homescreen {
    public static void main(String[] args) {

        HomeMenu(); //Made home menu method to call back from Ledger
    }

    public static void HomeMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome!");
        scanner.nextLine();
        System.out.println("What would you like to do? \n " +
                "D) Add Deposit \n " +
                "P) Make Payment(Debit) \n " +
                "L) Ledger \n " +
                "X) Exit");

        String choice = scanner.nextLine();

        // Try & catch method to catch exception error. Created bufferedwriter to write on CSV file. appended file using true
        try {  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("transactions.csv", true));

        // if & else if statement if user decides to Make a deposit or payment
            if (choice.equalsIgnoreCase("D")) { // used equalsIgnoreCase method to make user choice not case-sensitive
                LocalDate Date = LocalDate.now(); // locate date & time to enter in CSV file
                LocalTime Time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS); // used truncated method to remove milliseconds
                System.out.println("Please enter deposit description:");
                String depositDesc = scanner.nextLine();

                System.out.println("Please enter vendor information:");
                String vendor = scanner.nextLine();

                System.out.println("How much would you like to deposit?:");
                System.out.print("$ "); // print $ next to amount for detail
                double depositAmount = scanner.nextFloat();
                bufferedWriter.write("\n" + Date + "|" + Time + "|" + depositDesc + "|" + vendor + "|" + depositAmount); // format for data in CSV file

                System.out.println("You have deposited: $" + depositAmount);
                scanner.nextLine();
                System.out.println("Thank you have a nice day!");


            } else if (choice.equalsIgnoreCase("P")) {
                LocalDate Date = LocalDate.now();
                LocalTime Time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
                System.out.println("Please enter payment description:");
                String payDesc = scanner.nextLine();

                System.out.println("Please enter vendor information:");
                String paymentVendor = scanner.nextLine();

                System.out.println("How much would you like to pay?:");
                System.out.print("$ ");
                double paymentAmount = -1 * scanner.nextFloat(); // -1* to show payments in negative value
                bufferedWriter.write("\n" + Date + "|" + Time + "|" + payDesc + "|" + paymentVendor + "|" + paymentAmount);
                System.out.println("You paid: $" + paymentAmount);
                scanner.nextLine();
                System.out.println("Thank you have a nice day!");
            }
            // crated if & else if statement if user chooses Ledger or to Exit
            if (choice.equalsIgnoreCase("L")) {
                Ledger.LedgerMenu();
            } else if (choice.equalsIgnoreCase("X")) {
                System.out.println("Exiting...");
                System.out.println("Thank you have a nice day!");
                scanner.close();
            }
            bufferedWriter.close(); // bufferedWriter closed
        } catch (IOException e) {
            System.out.println(" Error" + e.getMessage()); // catch exception error and print message
        }
    }
}

