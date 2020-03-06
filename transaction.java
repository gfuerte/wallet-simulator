import java.io.*;
import java.util.*;
import java.lang.*;

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

	public String toString() {
		return "Amount: $" + amount + 
		"\nDate: " + date.toString() + 
		"\nCategory: " + category;
	}
}