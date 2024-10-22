## Capstone 1 Ledger Accounting Application
 
In this capstone project, I created a CLI Ledger Accounting Application. This application is able to track all financial transactions for business or personal use. All transactions were written and read through a csv file named “transactions” with the format of date|time|description|vendor|amount. to keep track of data in transactions, I created 3 classes: Homescreen, Ledger, and Reports. 

The Homescreen prompts the user to choose the following choices: make a deposit, make a payment, view Ledger, or Exit. 


<img width="336" alt="Screenshot 2024-10-18 at 1 52 06 AM" src="https://github.com/user-attachments/assets/b7de53fc-3278-435a-810b-b26f6dc18cf5">


<img width="297" alt="Screenshot 2024-10-18 at 1 52 59 AM" src="https://github.com/user-attachments/assets/881531a2-6302-4dcc-95b5-3f70c0ceb5bf">


In the Ledger class, the user is able to view all entries which displays all entries from newest to oldest, deposits, payments which results in a negative value, Reports, and an option to go back to the Homescreen.

<img width="480" alt="Screenshot 2024-10-18 at 12 13 44 AM" src="https://github.com/user-attachments/assets/799590fd-0090-4b8f-ad84-3f0040851e56">

<img width="429" alt="Screenshot 2024-10-18 at 1 54 14 AM" src="https://github.com/user-attachments/assets/e73a133f-c0c7-4951-b2ad-8bc21cc5f7bf">

<img width="434" alt="Screenshot 2024-10-18 at 1 55 38 AM" src="https://github.com/user-attachments/assets/47ee557b-7aa8-4911-a98a-4aff84a0afa6">

<img width="446" alt="Screenshot 2024-10-18 at 1 54 56 AM" src="https://github.com/user-attachments/assets/c66204db-6432-4b17-ac5e-efe080a1e6be">

In the Reports class, the user is able to view Reports from Month to Date, Previous Month, Year To Date, Previous Year, Search by Vendor, an option to go back to the Report page, and an option to go back to the Homescreen

<img width="495" alt="Screenshot 2024-10-18 at 12 26 56 AM" src="https://github.com/user-attachments/assets/8a765d71-a392-496b-9aa1-4506d666b705">


<img width="461" alt="Screenshot 2024-10-18 at 1 56 13 AM" src="https://github.com/user-attachments/assets/85126b35-b9d2-401a-bf7b-d30fc955a67f">



Interesting code: One code I found intersting was the collection.sort() method. I was able to sort the Local Date and Local Time to compare and reverse it so it can display the dates in order from newest to oldest.


<img width="1058" alt="Screenshot 2024-10-18 at 12 29 29 AM" src="https://github.com/user-attachments/assets/824dd2f3-a2ea-4a84-8d5a-5850d2494782">
