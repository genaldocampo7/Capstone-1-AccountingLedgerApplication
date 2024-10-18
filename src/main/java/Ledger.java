import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Ledger {
    public static void main(String[] args) {

        LedgerMenu(); // Ledger menu to be called from Homescreen
    }
    public static void LedgerMenu () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ledger:");
        System.out.println("Please select one of the following: \n " +
                "A) All - Displays all entries \n " +
                "D) Deposits \n " +
                "P) Payments \n " +
                "R) Reports \n " +
                "H) Home ");


        ArrayList<Transactions> entryList = new ArrayList<>(); // created an Array list to manage order of data from CSV file

        // Try & catch method to catch exception error. Created bufferedReader to read CSV file.
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("transactions.csv"));
            String line;
            bufferedReader.readLine(); // added bufferedReader .readline to skip first line & read second line where data starts
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(Pattern.quote("|")); // split method to remove columns between data
                Transactions t = new Transactions(LocalDate.parse(parts[0]), LocalTime.parse(parts[1]), parts[2], parts[3], Double.parseDouble(parts[4]));
                entryList.add(t); // parsed data and added to Array list
                Collections.sort(entryList, Comparator.comparing(Transactions::getDate).thenComparing(Transactions::getTime).reversed()); // used Collections to sort date and time, reversed to show newest to oldest entries
            }

            String choice = scanner.nextLine();

            switch (choice) {
                case ("A"): case ("a"):        // made switch statement not case-sensitive
                    System.out.println("All entries: Newest-Oldest");
                    for (Transactions t : entryList)
                        System.out.println(t.toTransactionList());
                    break;
                case ("D"): case ("d"):
                    System.out.println("Deposits");
                    for (Transactions t : entryList)
                        if (t.getAmount()>0) { // all deposit amount greater than zero
                            System.out.println(t.toTransactionList());
                        }
                    break;
                case ("P"): case ("p"):
                    System.out.println("Payments");
                    for (Transactions t : entryList)
                        if (t.getAmount()<0) { // if amount is less than zero/ shows negative value it is a payment
                            System.out.println(t.toTransactionList());
                        }
                    break;
                case ("R"): case ("r"):
                    Reports.ReportsMenu(); // call to Reports class
                    break;
                case ("H"): case ("h"):
                    System.out.println("Home");
                    Homescreen.HomeMenu(); // call back to Homescreen
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
            bufferedReader.close(); // bufferedReader closed
        } catch (IOException e) {
            System.out.println(" Error" + e.getMessage()); // catch exception error and print message
        }
    }
}

