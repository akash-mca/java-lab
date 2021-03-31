/*
Program 10, 11
Program: Implement generics and collection concept
Domain: Courier Management System
Author: Akash Roshan A
Reg No: 2047207
Github: akashroshan135
*/

import packages.*;
import java.io.*;
import java.util.*;

// class courierMgmtSys. Used as main class
class courierMgmtSys extends Thread {
	public static Thread myThread;
	public static courierMgmtSys obj;

	static int managerID = 1;
	static int adminID = 1;
	static int courierID = 1;
	static int shipmentID = 1;

	static person adminObjects[] = new admin[10];
	static person managerObjects[] = new manager[10];
	static person courierObjects[] = new courier[10];
	static shipment shipmentObjects[] = new shipment[10];

	static ArrayList<String> packages = new ArrayList<String>();
	
	static {
		System.out.println("    Courier Management System\n\tby akashroshan135\n");
	}

	public static void main(String[] args) throws IOException, PriceException {
		obj = new courierMgmtSys();
		myThread = new Thread(obj);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice;
		System.out.println("\tMain Menu");
		System.out.println("1. Admin Module\n2. Manager Module\n3. Courier Module\n4. Shipment Module\n5. Packages\n6. Exit");
		System.out.println("Enter your choice:");

		if (args.length == 0) {
			try {
				choice = Integer.parseInt(br.readLine());
			} catch (Exception e) {
				System.out.println("Incorrect input. Program will exit");
				choice = 6;
			}
		} else {
			try {
				choice = Integer.parseInt(args[0]);
			} catch (Exception e) {
				System.out.println("Incorrect input. Program will exit");
				choice = 6;
			}
		}

		switch (choice) {
			case 1:
				admin_program();
				break;
			case 2:
				manager_program();
				break;
			case 3:
				courier_program();
				break;
			case 4:
				myThread.start();
				try {
					myThread.join();
				} catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case 5:
				package_program();
				break;
			default:
				System.out.println("\nProgram will exit");
				return;
		}
		do {
			System.out.println("\tMain Menu");
			System.out.println("1. Admin Module\n2. Manager Module\n3. Courier Module\n4. Shipment Module\n5. Packages\n6. Exit");
			System.out.println("Enter your choice:");

			try {
				choice = Integer.parseInt(br.readLine());
			} catch (Exception e) {
				System.out.println("Incorrect input. Program will exit");
				choice = 6;
			}

			switch (choice) {
				case 1:
					admin_program();
					break;
				case 2:
					manager_program();
					break;
				case 3:
					courier_program();
					break;
				case 4:
					myThread.start();
					try {
						myThread.join();
					} catch(Exception e) {
						e.printStackTrace();
					}
					break;
				case 5:
					package_program();
					break;
				default:
					System.out.println("\nProgram will exit");
					break;
			}
		} while (choice < 6);
	}

	public static int menu(int i) throws IOException {
		String module[] = {"Admin", "Manager", "Courier"};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\tCheck " + module[i]);
		System.out.println("1. Add new " + module[i] + "\n2. Modify " + module[i] + " details\n3. Display all " + module[i] + "s\n4. Go Back");
		System.out.println("Enter your choice:");
		try {
			return Integer.parseInt(br.readLine());
		} catch (Exception e) {
			System.out.println("Incorrect input. Program will go back");
			return 4;
		}
	}

	// allows user to use admin module
	public static void admin_program() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice, id;

		do {
			choice = menu(0);

			switch (choice) {
				case 1:
					adminObjects[adminID++] = new admin();
					break;
				case 2:
					if (adminID == 1) {
						System.out.println("Please add an admin first");
						break;
					}
					System.out.println("Enter Admin ID:");
					try {
						id = Integer.parseInt(br.readLine());
					} catch (Exception e) {
						System.out.println("Incorrect ID");
						break;
					}
					adminObjects[id].modify();
					System.out.println("Modified Details:");
					adminObjects[id].display();
					break;
				case 3:
					if (adminID == 1) {
						System.out.println("Please add an admin first");
						break;
					}
					System.out.println("************Admin Details************\n");
					printPerson(adminID, adminObjects);
					System.out.println("*************************************");
					break;
				default:
					System.out.println("\nProgram will go to the main menu\n");
					return;
			}

			System.out.println("\nPress Enter to Continue...");
			br.readLine();
		} while (choice < 4);
	}

	// allows user to use manager module
	public static void manager_program() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice, id;
		do {
			choice = menu(1);
			switch (choice) {
				case 1:
					managerObjects[managerID++] = new manager();
					break;
				case 2:					
					if (managerID == 1) {
						System.out.println("Please add a manager first");
						break;
					}
					System.out.println("Enter Manager ID:");
					try {
						id = Integer.parseInt(br.readLine());
					} catch (Exception e) {
						System.out.println("Incorrect ID");
						break;
					}
					managerObjects[id].modify();
					System.out.println("Modified Details:");
					managerObjects[id].display();
					break;
				case 3:
					if (managerID == 1) {
						System.out.println("Please add a manager first");
						break;
					}
					System.out.println("***********Manager Details***********\n");
					printPerson(managerID, managerObjects);
					System.out.println("*************************************");
					break;
				default:
					System.out.println("\nProgram will go to the main menu\n");
					return;
			}

			System.out.println("\nPress Enter to Continue...");
			br.readLine();
		} while (choice < 4);
	}

	// allows user to use courier module
	public static void courier_program() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice, id;

		do {
			choice = menu(2);

			switch (choice) {
				case 1:
					courierObjects[courierID++] = new courier();
					break;
				case 2:
					if (courierID == 1) {
						System.out.println("Please add a courier first");
						break;
					}
					System.out.println("Enter Courier ID:");
					try {
						id = Integer.parseInt(br.readLine());
					} catch (Exception e) {
						System.out.println("Incorrect ID");
						break;
					}
					courierObjects[id].modify();
					System.out.println("Modified Details:");
					courierObjects[id].display();
					break;
				case 3:
					if (courierID == 1) {
						System.out.println("Please add a courier first");
						break;
					}
					System.out.println("***********Courier Details***********\n");
					printPerson(courierID, courierObjects);
					System.out.println("*************************************");
					break;
				default:
					System.out.println("\nProgram will go to the main menu\n");
					return;
			}

			System.out.println("\nPress Enter to Continue...");
			br.readLine();
		} while (choice < 4);
	}

	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice, id;

		do {
			System.out.println("\tCheck Shipments");
			System.out.println("1. Add new Shipment\n2. Update Status\n3. Update Location details\n4. Display Shipment\n5. Display all Shipments\n6. Go Back");
			System.out.println("Enter your choice:");
			try {
				choice = Integer.parseInt(br.readLine());
			} catch (Exception e) {
				System.out.println("Incorrect Option, Program will go back");
				choice = 6;
			}

			switch (choice) {
				case 1:
				try {
					shipmentObjects[shipmentID++] = new shipment();
				} catch (IOException | PriceException e1) {
					e1.printStackTrace();
				}
					break;
				case 2:
					System.out.println("Enter Shipment ID:");
					try {
						id = Integer.parseInt(br.readLine());
					} catch (Exception e) {
						System.out.println("Incorrect ID");
						break;
					}
				try {
					shipmentObjects[id].update_status();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
					System.out.println("Modified Details:\n");
				try {
					shipmentObjects[id].display();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
					break;
				case 3:
					System.out.println("Enter Shipment ID:");
					try {
						id = Integer.parseInt(br.readLine());
					} catch (Exception e) {
						System.out.println("Incorrect ID");
						break;
					}
				try {
					shipmentObjects[id].update_details();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
					System.out.println("Modified Details:\n");
				try {
					shipmentObjects[id].display();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
					break;
				case 4:
					System.out.println("Enter Shipment ID:");
					try {
						id = Integer.parseInt(br.readLine());
					} catch (Exception e) {
						System.out.println("Incorrect ID");
						break;
					}
				try {
					shipmentObjects[id].display();
				} catch (IOException e) {
					e.printStackTrace();
				}
					break;
				case 5:
					System.out.println("*********All Shipment Details********\n");
					for(int i = 1; i < shipmentID; i++) {
						try {
							shipmentObjects[i].display();
						} catch (IOException e) {
							e.printStackTrace();
						}
						System.out.println("*************************************");
						System.out.println("*************************************");
					}
					break;
				default:
					System.out.println("\nProgram will go to the main menu\n");
					return;
			}

			System.out.println("\nPress Enter to Continue...");
			try {
				br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (choice < 6);
	}

	public static void package_program() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice, index;

		do {
			System.out.println("\tPackage Menu");
			System.out.println("1. Add a package\n2. Display all packages\n3. Change a package\n4. Remove a package\n5. Go Back");
			System.out.println("\nEnter your choice:");

			try {
				choice = Integer.parseInt(br.readLine());
			} catch (Exception e) {
				System.out.println("Incorrect input. Program will exit");
				choice = 5;
			}

			switch (choice) {
				case 1:
					System.out.println("Enter a new package name : ");
					packages.add(br.readLine());
					
					System.out.println("\nPackage List:");
					for (String i : packages) System.out.println(i);
					System.out.println("");
					break;
				case 2:
					System.out.println("List of packages:");
					for (String i : packages) System.out.println(i);
					System.out.println("");
					break;
				case 3:
					System.out.println("Enter the package you want to change = ");
					String oldVal = br.readLine();
					System.out.println("Enter the new package name = ");
					String newVal = br.readLine();
					Collections.replaceAll(packages, oldVal, newVal);

					System.out.println("\nPackage List:");
					for (String i : packages) System.out.println(i);
					System.out.println("");
					break;
				case 4:
				System.out.println("Enter the package index : ");
					try {
						index = Integer.parseInt(br.readLine());
					} catch (Exception e) {
						System.out.println("Incorrect input. Program will go back");
						return;
					}
					packages.remove(index);
					break;
				default:
					System.out.println("\nProgram will go back");
					break;
			}
		} while (choice < 5);
	}

	public static <Y> void printPerson(int id, Y[] object) {
		for(int i = 1; i < id; i++) {
			((person) object[i]).display();
			System.out.println("-------------------------------------\n");
		}
	}
}
