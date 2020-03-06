import java.io.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;	


public class Wallet {
	
	//ArrayList<Transaction> wallet;

	public static void main(String[] args) {
		ArrayList<Transaction> wallet = new ArrayList<Transaction>(); 

		//test
		Date adate = new Date();
		Transaction a = new Transaction(2.0, adate, "Movie");
		wallet.add(a);
		System.out.println(wallet.get(0).toString());

	}
 	/*
	// Deposite/Add (amount, category, date)
	// Withdraw/Delete (amount, category, date)
	// SortRecently
	// SortLatest
	// SortCategory?
	// SortAmount
	// PrintTotalIncome
	// PrintTotalExpenses
	// PrintNetExpenses
	// PrintCurrentBalance
	
	Need to create transaction class which will be referenced by the wallet object
	*/
}

/* Self learned notes cause nobody has taught me these:
Encapsulation is defined as the wrapping up of data under a single unit. It is the mechanism that binds together code and the data it manipulates.
	- wallet is encapsulated because the global variables are private and can only be accessed via public methods

Inheritance is an important pillar of OOP(Object Oriented Programming). It is the mechanism in java by which one class is allow to inherit the features(fields and methods) of another class.
	- wallet (or any other object) can be subject to inheritence using 'extends' where a class receives all the fields a class has and adds onto it

*/
