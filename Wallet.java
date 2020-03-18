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
	
	private ArrayList<Transaction> transactions;
	private ArrayList<Transaction> defaultList;
	private ArrayList<Transaction> deposits;
	private ArrayList<Transaction> withdrawals;
	private double balance;
	private double income;
	private double expenses;

	public Wallet() {
		this.transactions = new ArrayList<Transaction>();
		this.defaultList = new ArrayList<Transaction>();
		this.deposits = new ArrayList<Transaction>();
		this.withdrawals = new ArrayList<Transaction>();
		this.balance = 0.0;
		this.income = 0.0;
		this.expenses = 0.0;
	}
	/*
	public Wallet(txtFile) {

	}
	*/
	public void deposit(double amount) {
		Transaction temp = new Transaction(amount);
		this.transactions.add(temp);
		this.defaultList.add(temp);
		this.deposits.add(temp);
		this.balance += amount;
		this.income += amount;
	}

	public void deposit(double amount, String category) {
		Transaction temp = new Transaction(amount, category);
		this.transactions.add(temp);
		this.defaultList.add(temp);
		this.deposits.add(temp);
		this.balance += amount;
		this.income += amount;
	}

	public void deposit(double amount, int month, int day, int year) {
		Date date = new Date(day, month, year);
		Transaction temp = new Transaction(amount, date);
		this.transactions.add(temp);
		this.defaultList.add(temp);
		this.deposits.add(temp);
		this.balance += amount;
		this.income += amount;
	}

	public void deposit(double amount, String category, int month, int day, int year) {
		Date date = new Date(day, month, year);
		Transaction temp = new Transaction(amount, date, category);
		this.transactions.add(temp);
		this.defaultList.add(temp);
		this.deposits.add(temp);
		this.balance += amount;
		this.income += amount;
	}

	public void withdraw(double amount) {
		Transaction temp = new Transaction(amount*-1);
		this.transactions.add(temp);
		this.defaultList.add(temp);
		this.withdrawals.add(temp);
		this.balance -= amount;
		this.expenses += amount;
	}

	public void withdraw(double amount, String category) {
		Transaction temp = new Transaction(amount*-1, category);
		this.transactions.add(temp);
		this.defaultList.add(temp);
		this.withdrawals.add(temp);
		this.balance -= amount;
		this.expenses += amount;
	}

	public void withdraw(double amount, int month, int day, int year) {
		Date date = new Date(day, month, year);
		Transaction temp = new Transaction(amount*-1, date);
		this.transactions.add(temp);
		this.defaultList.add(temp);
		this.withdrawals.add(temp);
		this.balance -= amount;
		this.expenses += amount;
	}

	public void withdraw(double amount, String category, int month, int day, int year) {
		Date date = new Date(day, month, year);
		Transaction temp = new Transaction(amount*-1, date, category);
		this.transactions.add(temp);
		this.defaultList.add(temp);
		this.withdrawals.add(temp);
		this.balance -= amount;
		this.expenses += amount;
	}

	public void printBalance() {
		String balanceString = Double.toString(this.balance);
		if(balanceString.substring(balanceString.indexOf('.') + 1).length() == 1) {
			balanceString += "0";
		}
		System.out.println("Your total balance is: $" + balanceString);

	}

	public void printIncome() {
		String incomeString = Double.toString(this.income);
		if(incomeString.substring(incomeString.indexOf('.') + 1).length() == 1) {
			incomeString += "0";
		}
		System.out.println("Your total income is: $" + incomeString);

	}

	public void printExpenses() {
		String expensesString = Double.toString(this.expenses);
		if(expensesString.substring(expensesString.indexOf('.') + 1).length() == 1) {
			expensesString += "0";
		}
		System.out.println("Your total expenses are: $" + expensesString);
	}

	public void printTransactions() {
		for(int i = 0; i < transactions.size(); i++) {
			System.out.println(transactions.get(i).toString());
		}
	}

	public void printDeposits() {
		for(int i = 0; i < deposits.size(); i++) {
			System.out.println(deposits.get(i).toString());
		}
	}

	public void printWithdrawals() {
		for(int i = 0; i < withdrawals.size(); i++) {
			System.out.println(withdrawals.get(i).toString());
		}
	}

	public void sortDefault() {
		this.transactions = new ArrayList<Transaction>(defaultList);
	}

	public void sortCategory() {
		ArrayList<Transaction> sorted = new ArrayList<Transaction>(transactions);
		for(int i = 0; i < sorted.size(); i++) {
			for(int j = i+1; j < sorted.size(); j++) {
				if(sorted.get(i).getCategory().compareTo(sorted.get(j).getCategory()) > 0) {
					Transaction temp = sorted.get(i);
					sorted.set(i, sorted.get(j));
					sorted.set(j, temp);
				}
			}
		}
		this.transactions = new ArrayList<Transaction>(sorted);
	}

	public void sortNewest() {
		ArrayList<Transaction> sorted = new ArrayList<Transaction>(transactions);
		for(int i = 0; i < sorted.size(); i++) {
			for(int j = i+1; j < sorted.size(); j++) {
				if(sorted.get(i).getDate().getValue() < sorted.get(j).getDate().getValue()) {
					Transaction temp = sorted.get(i);
					sorted.set(i, sorted.get(j));
					sorted.set(j, temp);
				}
			}
		}
		this.transactions = new ArrayList<Transaction>(sorted);
	}

	public void sortOldest() {
		ArrayList<Transaction> sorted = new ArrayList<Transaction>(transactions);
		for(int i = 0; i < sorted.size(); i++) {
			for(int j = i+1; j < sorted.size(); j++) {
				if(sorted.get(i).getDate().getValue() > sorted.get(j).getDate().getValue()) {
					Transaction temp = sorted.get(i);
					sorted.set(i, sorted.get(j));
					sorted.set(j, temp);
				}
			}
		}
		this.transactions = new ArrayList<Transaction>(sorted);
	}

	/*
	public static void main(String[] args) {
		ArrayList<Transaction> wallet = new ArrayList<Transaction>(); 

		//test
		Date adate = new Date();
		Transaction a = new Transaction(2.0, adate, "Movie");
		wallet.add(a);
		System.out.println(wallet.get(0).toString());


		Date test = new Date(6, 12, 2020);
		Transaction b = new Transaction(40.00, test, "Gym");
		wallet.add(b);
		System.out.println(wallet.get(1).toString());
	}
	*/
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
	// PrintCurrentBalance
	*/

/* Self learned notes cause nobody has taught me these:
Encapsulation is defined as the wrapping up of data under a single unit. It is the mechanism that binds together code and the data it manipulates.
	- wallet is encapsulated because the global variables are private and can only be accessed via public methods

Inheritance is an important pillar of OOP(Object Oriented Programming). It is the mechanism in java by which one class is allow to inherit the features(fields and methods) of another class.
	- wallet (or any other object) can be subject to inheritence using 'extends' where a class receives all the fields a class has and adds onto it

*/
