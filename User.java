import java.io.File;
import java.io.IOException;
import java.lang.System;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class User {

	static Scanner scanner = new Scanner(System.in);
	static String optionStart = "cuqCUQ";
	static String optionMain = "dwpsqDWPSQ";
	static String optionPrint = "iebsqIEBSQ";
	static String optionPrintAlt = "omyOMY";
	static String optionSort = "rlcqRLCQ";
	
	public static char getOption() {
		System.out.print("\nChoose an action: (D)eposit, (W)ithdraw, (P)rint, (S)ort, (Q)uit => ");
		char result = scanner.nextLine().toUpperCase().charAt(0);
		while (!optionMain.contains(result + "")) {
			System.out.print("\tYou must enter one of D, W, P, S, Q => ");
			result = scanner.nextLine().toUpperCase().charAt(0);
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("\nWelcome to Wallet-Simulator!");
		System.out.println("This program simulates a wallet by essentially allowing you to create a personal budget spreadsheet."); 
		System.out.println("As well as providing you with a set of functions that can help you organize your budget.");
		
		System.out.print("\nChoose a starting action: (C)reate new Wallet, (U)pload txt Wallet, (Q)uit => ");
		char result = scanner.nextLine().toUpperCase().charAt(0);
		while (!optionStart.contains(result + "")) {
			System.out.print("\tYou must enter one of C, U, Q => ");
			result = scanner.nextLine().toUpperCase().charAt(0);
		}

		Wallet wallet = new Wallet();
		if (result == 'Q') {
			System.exit(0);
		} else if (result == 'C') {
			System.out.print("\nWallet created!");
		} else {
			System.out.print("Enter txt file name => ");
			String txtFile = scanner.nextLine();
			//Tree tree = new Tree(new Scanner(new File(txtFile)));
			//tree.build();
			System.out.println("\nWallet uploaded!");
		}
		
		char option;
		while ((option = getOption()) != 'Q') {
			System.out.println();
			if (option == 'D') {
				double amount = 0.0;
				String category = "";
				int month = 0;
				int day = 0;
				int year = 0;
				boolean error = true;
				do {
					try {
						System.out.print("Enter amount => $");
						BigDecimal amountBD = scanner.nextBigDecimal();
						amountBD = amountBD.setScale(2, RoundingMode.HALF_DOWN);
						amount = amountBD.doubleValue(); 
						if (amount > 0) {
							error = false;
						} else {
							System.out.println("Please enter positive values only.\n");
						}
					} catch (InputMismatchException e) {
						System.out.println("Input not money value. Please try again.\n");
					}
					scanner.nextLine();
				} while (error);
				error = true;
				do {
					try {
						System.out.print("Enter category => ");
						category = scanner.nextLine();
						error = false;
					} catch (InputMismatchException e) {
						System.out.println("Input not string. Please try again.\n");
					}
				} while (error);
				error = true;
				do {
					System.out.print("Enter date (Date formate MM/DD/YYYY) => ");
					String date = scanner.nextLine();
					if(date.length() == 0) {
						error = false;
					}
					if (date.length() == 10) {
						boolean valid = true;
						for(int i = 0; i < date.length(); i++) {
							if (i != 2 && i != 5) {
								valid = numCheck(date.charAt(i));
								if (valid == false) {
									break;
								}
							} else if (i == 2 || i == 5) {
								if (date.charAt(i) != '/') {
									valid = false;
									break;
								}
							}
						}
						if (valid) {
							month = Integer.parseInt(date.substring(0, 2));
							day = Integer.parseInt(date.substring(3, 5));
							year = Integer.parseInt(date.substring(6));
							error = false;
						}
					}
					if (error) {
						System.out.println("Invalid format or value. Please use numerical values and include '/'.\n");
					}
				} while (error);

				System.out.print("\n");
				String amountString = Double.toString(amount);
				if(amountString.substring(amountString.indexOf('.') + 1).length() == 1) {
					amountString += "0";
				}

				if(category.equals("") && month == 0 && day == 0 && year == 0) {
					wallet.deposit(amount);
					System.out.println("Deposited $" + amount + ". Category and date are 'Unassigned'.");
				} else if (category.equals("")) {
					wallet.deposit(amount, month, day, year);
					System.out.println("Deposited $" + amount + " on " + month + "/" + day + "/" + year + ". Category is 'Unassigned'.");
				} else if (month == 0 && day == 0 && year == 0) {
					wallet.deposit(amount, category);
					System.out.println("Deposited $" + amount + " under category '" + category + "'. Date is unassigned.");
				} else {
					wallet.deposit(amount, category, month, day, year);
					System.out.println("Deposited $" + amount + " on " + month + "/" + day + "/" + year + " under category '" + category + "'.");
				}


				
			} else if (option == 'W') {

			}
			/*
			if (option == 'h') {
				//System.out.print(tree.getTXT());
			} else if (option == 'p') {
					//tree.print();
			} else if (option == 'r') {
				System.out.print("\tEnter old tag => ");
				String oldTag = scanner.nextLine();
				System.out.print("\tEnter new tag => ");
				String newTag = scanner.nextLine();
				//tree.replaceTag(oldTag, newTag);
			} else if (option == 'b') {
				System.out.print("\tEnter row number (1..n) => ");
				int row;
				while (true) {
					try {
						row = Integer.parseInt(scanner.nextLine());
						if (row > 0) {
							break;
						} else {
							throw new NumberFormatException();
						}
					} catch (NumberFormatException e) {
						System.out.print("\tYou must enter a positive integer => ");
					}
				}
				try {
					//tree.boldRow(row);
				} catch (IllegalArgumentException iae) {
					//System.out.println("\tTable does not have row " + row);
				}
			} else if (option == 'd') {
				System.out.print("\tEnter tag to remove => ");
				//tree.removeTag(scanner.nextLine().trim());
			} else if (option == 'a') {
				System.out.print("\tEnter text to tag => ");
				String text = scanner.nextLine().trim();
				System.out.print("\tEnter tag => ");
				String tag = scanner.nextLine().trim();
				//tree.addTag(text, tag);
			}
			*/
		}
	}

	private boolean checkMonth(String month) {
		month = month.substring(0, 1).toUpperCase() + month.substring(1).toLowerCase();
		boolean result = false;
		if(month.equals("January") || month.equals("February") || month.equals("March") || month.equals("April") || month.equals("May")
			|| month.equals("June") || month.equals("July") || month.equals("August") || month.equals("September") || month.equals("October")
			|| month.equals("November") || month.equals("December")) {
			result = true;
		}
		return result;
	}

	private static boolean numCheck(char num) {
		boolean result = false;
		if (num == '0' || num == '1' || num == '2' || num == '3' || num == '4' || num == '5' || 
			num == '6' || num == '7' || num == '8' || num == '9') {
			result = true;
		}
		return result;
	}
}