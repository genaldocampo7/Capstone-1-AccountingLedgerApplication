## Capstone 1 Ledger Accounting Application
 
In this capstone project,I created a CLI Ledger Accounting Application. This application is able to track all financial transactions for business or personal use. All transactions were written and read through a csv file named “transactions” with the format of date|time|description|vendor|amount. to keep track of data in transactions, I created 3 classes: Homescreen, Ledger, and Reports. 

The Homescreen prompts the user to choose the following choices: make a deposit, make a payment, view Ledger, or Exit. 



In the Ledger class, the user is able to view all entries which displays all entries from newest to oldest, deposits, payments which results in a negative value, Reports, and an option to go back to the Homescreen.


In the Reports class, the user is able to view Reports from Month to Date, Previous Month, Year To Date, Previous Year, Search by Vendor, an option to go back to the Report page, and an option to go back to the Homescreen


Interesting code: One code I found intersting was the collection.sort() method. I was able to sort the Local Date and Local Time to compare and reverse it so it can display the dates in order from newest to oldest.
!