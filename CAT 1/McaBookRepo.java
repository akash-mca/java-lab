/*
Java Programming/MCA272 CAT1 Component1
Program : Books Repository
Author: Akash Roshan A
Reg no: 2047207
GitHub: akashroshan135
*/

import java.io.*;

class McaBookRepo {
	static int totalBooks = 0;
	static Book bookObjs[] = new Book[10];

	static {
		System.out.println("\tMCA Books Repository\nby The Department of Computer Science\n");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice, choiceSearch, idSearch;
		String nameSearch;
		boolean isFound = false;

		do {
			System.out.println("\tMain Menu");
			System.out.println("1. Add new book\n2. Display all books\n3. Search for a book\n4. Exit");
			System.out.println("Enter your choice:");
			choice = Integer.parseInt(br.readLine());

			switch (choice) {
				case 1:
					if (totalBooks == 10) System.out.println("\nSorry, but you cannot add any more books\n");
					else bookObjs[totalBooks++] = new Book();
					break;
				case 2:
					System.out.println("\nAll The books in the repository are as follows");
					for (int i = 0; i < totalBooks; i++) bookObjs[i].display();
					break;
				case 3:
					isFound = false;
					System.out.println("\nDo you wanna search by");
					System.out.println("1. Book ID\n2. Book Name\n3. Go Back");
					System.out.println("Enter your choice:");
					choiceSearch = Integer.parseInt(br.readLine());

					switch (choiceSearch) {
						case 1:
							System.out.println("\nPlease enter the ID of the book you want to search for :");
							idSearch = Integer.parseInt(br.readLine());
							for (int i = 0; i < totalBooks; i++) {
								if (bookObjs[i].id == idSearch) {
									bookObjs[i].display();
									isFound = true;
									break;
								}
							}
							if (!isFound) System.out.println("\nSorry, the book you're searching for is not found\n");
							break;
						case 2:
							System.out.println("Please enter the name of the book you want to search for :");
							nameSearch = br.readLine();
							for (int i = 0; i < totalBooks; i++) {
								if (nameSearch.toUpperCase().equals(bookObjs[i].name)) {
									bookObjs[i].display();
									isFound = true;
								}
							}
							if (!isFound) System.out.println("\nSorry, the book you're searching for is not found\n");
							break;
						default:
							break;
					}
					break;
				default:
					System.out.println("Program will exit");
			}
		} while (choice < 4);
	}
}

class Book {
	int id;
	String name;
	String category;
	int yearOfPublishing;
	static int tempId = 1;

	Book() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("\nAdding new book");
		System.out.println("------------------------------");
		this.id = tempId++;

		System.out.println("Enter the name of the book : ");
		String name = br.readLine();
		if (name.isEmpty()) {
			System.out.println("No name has been entered. Default name \"CS\" is used\n");
			this.name = "CS";
		} else this.name = name.toUpperCase();

		System.out.println("Enter the category of the book (Programming or Theory): ");
		String category = br.readLine();
		category = category.toUpperCase();
		if (category.equals("PROGRAMMING")) this.category = category;
		else this.category = "THEORY";

		System.out.println("Enter the year of publishing (2015-2021): ");
		int year = Integer.parseInt(br.readLine());
		if (year >= 2015 && year <= 2021) this.yearOfPublishing = year;
		else {
			System.out.println("Incorrect year of publishing. Default year 2020 is used\n");
			this.yearOfPublishing = 2020;
		}

		System.out.println("\nThe book has been added to the repository\n");
	}

	void display() {
		System.out.println("------------------------------------------");
		System.out.println("Book ID            : " + id);
		System.out.println("Book Name          : " + name);
		System.out.println("Book Category      : " + category);
		System.out.println("Year of Publishing : " + yearOfPublishing);
		System.out.println("------------------------------------------");
	}
}