import java.io.File;
import java.io.IOException;
import java.lang.System;
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
		System.out.print("\nChoose an action: (D)eposite, (W)ithdraw, (P)rint, (S)ort, (Q)uit => ");
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

		if (result == 'Q') {
			System.exit(0);
		} else if (result == 'C') {
			Wallet wallet = new Wallet();
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
				System.out.print("Enter amount => ");
				//try {
					double amount = scanner.nextDouble();
				//} catch (InputMismatchException e) {
				//	System.out.println("Please enter currency value only.");
				//	System.out.print("Enter amount => ");
				//	double amount = scanner.nextDouble();
				//} 
				//try catch negative and not doubles
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
}