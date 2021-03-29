package collections;

import java.io.*;
import java.util.*;

public class test {
	static ArrayList<String> packages = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice;

		do {
			System.out.println("\tMain Menu");
			System.out.println("1. Add a package\n2. Get number of packages\n3. Display all packages\n4. Change a package\n5. Remove a package\n6. Exit");
			System.out.println("\nEnter your choice:");

			try {
				choice = Integer.parseInt(br.readLine());
			} catch (Exception e) {
				System.out.println("Incorrect input. Program will exit");
				choice = 6;
			}

			switch (choice) {
				case 1:
					System.out.println("Enter a new package name : ");
					packages.add(br.readLine());
					
					System.out.println("New List:");
					for (String i:packages) System.out.println(i);
					System.out.println("\n");
					break;
				case 2:
					System.out.println("Total Number of packages = " + packages.size());
					break;
				case 3:	
					System.out.println("List of packages:");
					for (String i:packages) System.out.println(i);
					System.out.println("\n");
					break;
				case 4:
					System.out.println("Enter the package you want to change = ");
					String oldVal = br.readLine();
					System.out.println("Enter the new package name = ");
					String newVal = br.readLine();
					Collections.replaceAll(packages, oldVal, newVal);

					System.out.println("New List:");
					for (String i:packages) System.out.println(i);
					System.out.println("\n");
					break;
				case 5:
					remove_element();
					break;
				default:
					System.out.println("\nProgram will exit");
					break;
			}
		} while (choice < 6);
	}

	static void remove_element() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice, index;

		System.out.println("\tHow do you want to remove");
		System.out.println("1. Using index\n2. Name of the package\n3. First package\n4. Last package\n5. Go back");
		System.out.println("\nEnter your choice:");

		try {
			choice = Integer.parseInt(br.readLine());
		} catch (Exception e) {
			System.out.println("Incorrect input. Program will go back");
			choice = 5;
		}

		switch (choice) {
			case 1:
				System.out.println("Enter the package index : ");
				try {
					index = Integer.parseInt(br.readLine());
				} catch (Exception e) {
					System.out.println("Incorrect input. Program will go back");
					return;
				}
				packages.remove(index);
				break;
			case 2:
				System.out.println("Enter the package index : ");
				String pack = br.readLine();
				packages.remove(pack);
				break;
			case 3:
				packages.remove(0);
				break;
			case 4:
				packages.remove(packages.size()-1);
				break;
			case 5:
			default:
				return;					
		}
		System.out.println("New List:");
		for (String i:packages) System.out.println(i);
		System.out.println("\n");	
	}
}
