# Workshop 4

Task 1

Write an application that counts the number of keywords in a Java source file. If a keyword is in a comment (include line comment or block comment) or in a string, don’t count it. Pass the Java file name from the command line. Assume the Java source code is correct and line comments and paragraph comments do not overlap. Properly handle all the exceptions in the program.
You can find list of java keywords on the following link,
https://www.w3schools.in/java-tutorial/keywords/

Task 2

Banks lend money to each other. In tough economic times, if a bank goes bankrupt, it may not be able to pay back the loan. A bank’s total assets are its current balance plus its loans to other banks. The diagram below shows five banks. The banks’ current balances are 25, 125, 175, 75, and 181 million dollars, respectively. The directed edge from node 1 to node 2 indicates that bank 1 lends 40 million dollars to bank 2.
If a bank’s total assets are under a certain limit, the bank is unsafe. The money it borrowed cannot be returned to the lender, and the lender cannot count the loan in its total assets. Consequently, the lender may also be unsafe, if its total assets are under the limit.
Write a program to find all the unsafe banks. Your program reads the input as follows.
1. It first reads two integers n and limit, where n indicates the number of banks and limit is
the minimum total assets for keeping a bank safe.
2. It then reads n lines that describe the information for n banks with IDs from 0 to n-1.
The first number in the line is the bank’s balance, the second number indicates the number of
banks that borrowed money from the bank, and the rest are pairs of two numbers. Each pair
describes a borrower. The first number in the pair is the borrower’s ID and the second is the
amount borrowed. For example, the input for the five banks in above picture is as follows (note
that the limit is 201):
Number of banks: 5
Minimum asset limit: 201
Bank # 0  Balance: 25  Number of banks Loaned: 2  Bank ID: 1  Amount: 100.5  Bank
ID: 4  Amount: 320.5
Bank # 1  Balance: 125  Number of banks Loaned: 2  Bank ID: 2  Amount: 40  Bank
ID: 3  Amount: 85
Bank # 2  Balance: 175  Number of banks Loaned: 2  Bank ID: 0  Amount: 125  Bank
ID: 3  Amount: 75
Bank # 3  Balance: 75  Number of banks Loaned: 1  Bank ID: 0  Amount: 125
Bank # 4  Balance: 181  Number of banks Loaned: 1  Bank ID: 2  Amount: 125
The total assets of bank 3 are (75 + 125), which is under 201, so bank 3 is unsafe. After bank 3
becomes unsafe, the total assets of bank 1 fall below (125 + 40). Thus, bank 1 is also unsafe.
The output of the program should be
Unsafe banks are 3 and Bank 1

Task 3

Rewrite the program given in the “Java Networking Slides” where single client and server are
presenting a scenario of chatting. Your program should introduce two clients to chat.
Implement one server that serves both the clients. Sample output below,
- Server side:

MultiThreadServer started at Thu Dec 14 04:53:15 EST 2017
Connection from Socket[addr=/127.0.0.1,port=57327,localport=8000] at Thu Dec 14 04:53:36 EST
2017
Connection from Socket[addr=/127.0.0.1,port=57328,localport=8000] at Thu Dec 14 04:54:34 EST
2017
user1: hi how are you?
user2: i am fine
user2: How are you?

- Client side:

Enter you name: user1
Enter Text: hi how are you?
Enter Text:

Enter you name: user2
Enter Text: i am fine
Enter Text: How are you?
Enter Text:
