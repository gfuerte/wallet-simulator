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

public class Transaction {

	private double amount;
	private Date date; 
	private String category; 
	
	public Transaction() {
		this.amount = 0.0;
		this.date = new Date();
		this.category = "";
	}

	public Transaction(double amount) {
		this.amount = amount;
		this.date = new Date();
		this.category = "Unassigned";
	}

	public Transaction(double amount, Date date) {
		this.amount = amount;
		this.date = date;
		this.category = "Unassigned";
	}

	public Transaction(double amount, String category) {
		this.amount = amount;
		this.date = new Date();
		this.category = category;
	}

	public Transaction(double amount, Date date, String category) {
		this.amount = amount;
		this.date = date;
		this.category = category;
	}

	public double getAmount() {
		return this.amount;
	}

	public Date getDate() {
		return this.date;
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