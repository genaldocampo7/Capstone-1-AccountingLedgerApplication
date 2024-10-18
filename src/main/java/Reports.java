import  java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Reports {
    public static void main(String[] args) {
        ReportsMenu(); // Reports menu to be called from Ledger
    }
    public static void ReportsMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Reports:");
        System.out.println("Please select one of the following: \n 1) Month to Date \n 2) Previous Month \n 3) Year to Date \n 4) Previous Year \n 5) Search by Vendor \n 0) Back ");

        ArrayList<Transactions> reports = new ArrayList<>(); // created an Array list to manage order of data from CSV file


        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("transactions.csv"));
            String line;
            bufferedReader.readLine(); // added bufferedReader .readline to skip first line & read second line where data starts
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(Pattern.quote("|"));
                Transactions t = new Transactions(LocalDate.parse(parts[0]), LocalTime.parse(parts[1]), parts[2], parts[3], Double.parseDouble(parts[4]));
                reports.add(t);
            }

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Month to Date:");
                        LocalDate today = LocalDate.now(); // today's date
                        LocalDate firstDayOfMonth = today.withDayOfMonth(1); // first day of Month
                        for (Transactions t : reports) {
                            if (!t.getDate().isBefore(firstDayOfMonth) && !t.getDate().isAfter(today)) {
                                System.out.println(t.toTransactionList());
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Previous Month:");
                        LocalDate firstDayMonth = LocalDate.now().minusMonths(1).withDayOfMonth(1); // used minus Months method to -1 month to get previous month
                        LocalDate LastDayMonth = LocalDate.now().minusMonths(1).withDayOfMonth(LocalDate.now().minusMonths(1).lengthOfMonth());
                        for (Transactions t : reports) {
                            if (!t.getDate().isBefore(firstDayMonth) && !t.getDate().isAfter(LastDayMonth)) {
                                System.out.println(t.toTransactionList());
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Year to Date:");
                        LocalDate firstDayYear = LocalDate.now().withDayOfYear(1);
                        for (Transactions t : reports) {
                            if (!t.getDate().isBefore(firstDayYear) && !t.getDate().isAfter(LocalDate.now())) {
                                System.out.println(t.toTransactionList());
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Previous Year:");
                        LocalDate firstDayLastYear = LocalDate.now().minusYears(1).withDayOfYear(1); // used minus Years method to -1 year to get previous year
                                LocalDate lastDayLastYear = LocalDate.now().minusYears(1).withDayOfYear(LocalDate.now().minusYears(1).lengthOfYear());
                        for (Transactions t : reports) {
                            if (!t.getDate().isBefore(firstDayLastYear) && !t.getDate().isAfter(lastDayLastYear)) {
                                System.out.println(t.toTransactionList());
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Search by vendor:");
                        scanner.nextLine();
                        System.out.println("Please type the name of vendor:");
                        String vendor = scanner.nextLine();
                        boolean match = false; // created boolean to check if vendor name is in transactions
                        for (Transactions t : reports) {
                            if (t.getVendor().equals(vendor)) {
                                System.out.println(t.toTransactionList());
                                match = true;
                            }
                        }
                             // if vendor is not found in transactions
                             if (!match) {
                                System.out.println("No transactions found. Please try again.");
                            }
                             break;
                    case 0:
                        System.out.println("back:"); // call back to Ledger menu
                        Ledger.LedgerMenu();
                        break;
                    default: // default if user inputs invalid choice
                        System.out.println("Invalid choice. Please try again.");
                }
                bufferedReader.close(); // bufferedReader closed
            } catch (IOException e) {
            System.out.println("Error reading file. " + e.getMessage()); // catch exception error and print message
        }
    }
}

