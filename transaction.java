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

/*Dates
--> new Date() - current
--> new Date(int year, int month, int date)
hrs min sec if needed
*/

/*BigDecimal
BigDecimal a = new BigDecimal("1.234");
BigDecimal b = a.setScale(2, RoundingMode.DOWN); // => BigDecimal("1.23")
*/

public class Transaction {

	private double amount;
	private Date date; 
	private String category; 
	
	public Transaction() {
		this.amount = 0.0;
		this.date = new Date();
		this.category = "";
	}

	public Transaction(double amount, Date date) {
		this.amount = amount;
		this.date = date;
		this.category = "Unassigned";
	}

	public Transaction(double amount, Date date, String category) {
		this.amount = amount;
		this.date = date;
		this.category = category;
	}

	public double getAmount() {
		return this.amount;
	}

	public String getDate() {
		return this.date.toString();
	}

	public String getCategory() {
		return this.category;
	}

	public String toString() {
		return "Amount: $" + amount + 
		"\tDate: " + date.toString() + 
		"\tCategory: " + category;
	}
}