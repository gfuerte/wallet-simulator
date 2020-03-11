import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class User {

	static Scanner scanner = new Scanner(System.in);
	static String optionStart = "cuq";
	static String optionMain = "dwpsq";
	static String optionPrint = "iebsq";
	static String optionPrintAlt = "omy";
	static String optionSort = "rlcq";
	static String options = "abcdefghijklmnopqrstuvwxyz";
	
	public static char getOption() {
		System.out.print("\nChoose action: h");
		System.out.print("(p)rint Tree, ");
		System.out.print("(h)tml, ");
		System.out.print("(r)eplace tag, ");
		System.out.print("(b)oldface row, ");
		System.out.print("(d)elete tag, ");
		System.out.print("(a)dd tag, or ");
		System.out.print("(q)uit? => ");
		char result = scanner.nextLine().toLowerCase().charAt(0);
		while (!options.contains(result + "")) {
			System.out.print("\tYou must enter one of p, h, r, b, d, a, or q => ");
			result = scanner.nextLine().toLowerCase().charAt(0);
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to Wallet-Simulator!");
		System.out.println("This program simulates a wallet by essentially allowing you to create a budget spreadsheet"); 
		System.out.println("and provides a set of functions that can help you organize your budget.\n");
		// TODO Auto-generated method stub
		System.out.print("Enter HTML file name => ");
		String htmlFile = scanner.nextLine();
		//Tree tree = new Tree(new Scanner(new File(htmlFile)));
		//tree.build();
		
		char option;
		while ((option = getOption()) != 'q') {
			System.out.println();
			if (option == 'h') {
				//System.out.print(tree.getHTML());
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
		}
	}
}