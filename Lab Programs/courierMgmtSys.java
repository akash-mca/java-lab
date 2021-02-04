/*
Program 2
Program: Implement the concept of class, data members, member functions and access specifiers
Domain: Courier Management System
Author: Akash Roshan A
Reg No: 2047207
Github: akashroshan135
*/

import java.io.*;

// class courierMgmtSys. Used as main class
class courierMgmtSys {
	// data members
	static int managerID = 1;
	static int adminID = 1;

	// member functions
	// public as it is main()
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		int choice;
		// do while used to loop the statements until choice selected is 3
		do {
			System.out.println("\tCourier Management System");
			System.out.println("1. Admin Module\n2. Manager Module\n3. Exit");
			System.out.println("Enter your choice:");
			choice = Integer.parseInt(br.readLine());
			// switch used to switch to the required case
			switch (choice) {
				case 1:
					admin_program();
					break;
				case 2:
					manager_program();
					break;
				default:
					break;
			}
		} while (choice < 3);
	}
	
	// allows user to use admin module
	// set to public
	public static void admin_program() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		int choice;

		admin adminObjects[] = new admin[10];

		// do while used to loop the statements until choice selected is 4
		do {
			System.out.println("\tCheck Admins");
			System.out.println("1. Add new admin\n2. Modify admin details\n3. Display all admins\n4. Go Back");
			System.out.println("Enter your choice:");
			choice = Integer.parseInt(br.readLine());
			// switch used to switch to the required case
			switch (choice) {
				case 1:
					System.out.println("Name:");
					String name = br.readLine();
					System.out.println("Email ID:");
					String email = br.readLine();
					System.out.println("Password:");
					String password = br.readLine();
					System.out.println("Phone:");
					String phone = br.readLine();
					if (phone.length() != 10) {
						System.out.println("Invalid Phone no. Default 0000000000 is placed");
						phone = "0000000000";
					}
					adminObjects[adminID++] = new admin(name, email, password, phone);
					break;
				case 2:
					System.out.println("Enter admin ID:");
					int id = Integer.parseInt(br.readLine());
					adminObjects[id].modify();
					adminObjects[id].display();
					break;
				case 3:
					System.out.println("************Admin Details************\n");
					for(int i = 1; i < adminID; i++) {
						adminObjects[i].display();
						System.out.println("-------------------------------------\n");
					}
					System.out.println("*************************************");
					break;
				default:
					break;
			}

			System.out.println("\nPress Enter to Continue...");
			br.readLine();
		} while (choice < 3);
	}
	// allows user to use manager module
	// set to public
	public static void manager_program() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		int choice;

		manager managerObjects[] = new manager[10];
		// do while used to loop the statements until choice selected is 4
		do {
			System.out.println("\tCheck Managers");
			System.out.println("1. Add new manager\n2. Modify managers details\n3. Display all managers\n4. Go Back");
			System.out.println("Enter your choice:");
			choice = Integer.parseInt(br.readLine());
			// switch used to switch to the required case
			switch (choice) {
				case 1:
					System.out.println("Name:");
					String name = br.readLine();
					System.out.println("Email ID:");
					String email = br.readLine();
					System.out.println("Password:");
					String password = br.readLine();
					System.out.println("Phone:");
					String phone = br.readLine();
					if (phone.length() != 10) {
						System.out.println("Invalid Phone no. Default 0000000000 is placed");
						phone = "0000000000";
					}
					System.out.println("Hub:");
					String hub = br.readLine();
					System.out.println("Salary:");
					float salary = Float.parseFloat(br.readLine());
					managerObjects[managerID++] = new manager(name, email, password, phone, hub, salary);
					break;
				case 2:
					System.out.println("Enter Manager ID:");
					int id = Integer.parseInt(br.readLine());
					managerObjects[id].modify();
					managerObjects[id].display();
					break;
				case 3:
					System.out.println("***********Manager Details***********\n");
					for(int i = 1; i < managerID; i++) {
						managerObjects[i].display();
						System.out.println("-------------------------------------\n");
					}
					System.out.println("*************************************");
					break;
				default:
					break;
			}

			System.out.println("\nPress Enter to Continue...");
			br.readLine();
		} while (choice < 4);
	}
	
}
// class admin for admins
class admin {
	int Admin_ID;
	String Admin_Name;
	String Admin_EmailID;
	private String Admin_Password;
	String Admin_Phone;
	static int id = 1;

	// default constructor is used to assign default data to a new object
	admin() {
		Admin_ID = id++;
		Admin_Name = "empty";
		Admin_EmailID = "empty";
		Admin_Password = "testing";
		Admin_Phone = "0000000000";
	}
	// parametrized constructor is used to assign args data to a new object
	admin(String name, String email, String password, String phone) {
		Admin_ID = id++;
		Admin_Name = name;
		Admin_EmailID = email;
		Admin_Password = password;
		// checks if the length of the phone no is 10. If not, a default value is inserted
		if (phone.length() == 10) Admin_Phone = phone;
		else {
			System.out.println("Invalid Phone no, default no: 0000000000 is placed");
			Admin_Phone = "0000000000";
		}
	}

	// protected function only usable in this class and sub classes
	protected void modify()throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		
		System.out.println("Please enter your password, " + Admin_Name + ": ");
		String password = br.readLine();

		// checks if the input password and the stored password matches
		if (password.equals(Admin_Password)) {
			System.out.println("Enter the details\n");

			System.out.println("Name:");
			Admin_Name = br.readLine();
			System.out.println("Email ID:");
			Admin_EmailID = br.readLine();
			System.out.println("Phone:");
			String phone = br.readLine();
			// checks if the length of the phone no is 10. If not, a default value is inserted
			if (phone.length() == 10) Admin_Phone = phone;
			else System.out.println("Invalid Phone no. Not modified");
		} else System.out.println("Invalid Password");

	}
	// protected function only usable in this class and subclasses
	protected void display() {
		System.out.println("ID       : " + Admin_ID);
		System.out.println("Name     : " + Admin_Name);
		System.out.println("Email ID : " + Admin_EmailID);
		System.out.println("Phone    : " + Admin_Phone);
		System.out.println("");
	}
	
}
// class manager used for managers
class manager {
	int Manager_ID;
	String Manager_Name;
	String Manager_EmailID;
	private String Manager_Password;
	String Manager_Phone;
	String Manager_Hub;
	float Manager_Salary;
	// array of string objects
	String[] Manager_Courier = new String[5];
	static int id = 1;

	// default constructor is used to assign default data to a new object. Will not be used so can be removed
	manager() {
		Manager_ID = id++;
		Manager_Name = "empty";
		Manager_EmailID = "empty";
		Manager_Password = "testing";
		Manager_Phone = "0000000000";
		Manager_Hub = "Bangalore";
		Manager_Salary = 50000;
		// terrible code and repeated
		Manager_Courier[0] = "test1";
		Manager_Courier[1] = "test2";
		Manager_Courier[2] = "test3";
		Manager_Courier[3] = "test4";
		Manager_Courier[4] = "test5";
	}
	// parametrized constructor is used to assign args data to a new object
	manager(String name, String email, String password, String phone, String hub, float salary) {
		Manager_ID = id++;
		Manager_Name = name;
		Manager_EmailID = email;
		Manager_Password = password;
		// checks if the length of the phone no is 10. If not, a default value is inserted
		if (phone.length() == 10) Manager_Phone = phone;
		else {
			System.out.println("Invalid Phone no, default no: 0000000000 is placed");
			Manager_Phone = "0000000000";
		}
		Manager_Hub = hub;
		Manager_Salary = salary;
		// find a way to recieve input from user
		Manager_Courier[0] = "test1";
		Manager_Courier[1] = "test2";
		Manager_Courier[2] = "test3";
		Manager_Courier[3] = "test4";
		Manager_Courier[4] = "test5";
	}

	// protected function only usable in this class and subclass
	protected void modify()throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		
		System.out.println("Please enter your password, " + Manager_Name + ": ");
		String password = br.readLine();

		// checks if the input password and the stored password matches
		if (password.equals(Manager_Password)) {
			System.out.println("Enter the new details\n");

			System.out.println("Name:");
			Manager_Name = br.readLine();
			System.out.println("Email ID:");
			Manager_EmailID = br.readLine();
			System.out.println("Phone:");
			String phone = br.readLine();
			if (phone.length() == 10) Manager_Phone = phone;
			else System.out.println("Invalid Phone no. Not modified");
			System.out.println("Hub:");
			Manager_Hub = br.readLine();
			System.out.println("Salary:");
			Manager_Salary = Float.parseFloat(br.readLine());
		} else System.out.println("Invalid Password");

	}
	// protected function only usable in this class and subclasses
	protected void display() {
		System.out.println("ID       : " + Manager_ID);
		System.out.println("Name     : " + Manager_Name);
		System.out.println("Email ID : " + Manager_EmailID);
		System.out.println("Phone    : " + Manager_Phone);
		System.out.println("Hub      : " + Manager_Hub);
		System.out.println("Salary   : " + Manager_Salary);
		System.out.println("Couriers : ");
		for (int i = 0; i < 5; i++) System.out.print(Manager_Courier[i] + ", ");
		System.out.println("\n");
	}

}
