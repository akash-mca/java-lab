/*
Program: Control statements and arrays
Domain: Courier Management System
Author: Akash Roshan A
Reg No: 2047207
Github: akashroshan135
*/

import java.io.*;

class courierMgmtSys {
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

	public static void admin_program() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		int choice;

		admin A1 = new admin();
		admin A2 = new admin("test1", "test1@email.com", "testpass", "1234567898");
		admin A3 = new admin("test2", "test2@email.com", "testpass", "1234567898");
		// do while used to loop the statements until choice selected is 3
		do {
			System.out.println("\tCheck Admins");
			System.out.println("1. Display all admins\n2. Modify admin details (only ID:3)\n3. Go Back");
			System.out.println("Enter your choice:");
			choice = Integer.parseInt(br.readLine());
			// switch used to switch to the required case
			switch (choice) {
				case 1:
					A1.display();
					A2.display();
					A3.display();
					break;
				case 2:
					A3.modify();
					A3.display();
					break;
				default:
					break;
			}

			System.out.println("\nPress Enter to Continue...");
			br.readLine();
		} while (choice < 3);
	}

	public static void manager_program() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		int choice;

		//manager[] managerObjects = new manager[2];
		manager M1 = new manager();
		manager M2 = new manager("test1", "test1@email.com", "testpass", "1234567898", "Bangalore", 50000);
		manager M3 = new manager("test2", "test2@email.com", "testpass", "1234567898", "Bangalore", 50000);
		// do while used to loop the statements until choice selected is 3
		do {
			System.out.println("\tCheck Managers");
			System.out.println("1. Display all managers\n2. Modify managers details (only ID:3)\n3. Go Back");
			System.out.println("Enter your choice:");
			choice = Integer.parseInt(br.readLine());
			// switch used to switch to the required case
			switch (choice) {
				case 1:
					M1.display();
					M2.display();
					M3.display();
					break;
				case 2:
					M3.modify();
					M3.display();
					break;
				default:
					break;
			}

			System.out.println("\nPress Enter to Continue...");
			br.readLine();
		} while (choice < 3);
	}

}

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

	// private function only usable in this class
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
	}
	
}

class manager {
	int Manager_ID;
	String Manager_Name;
	String Manager_EmailID;
	private String Manager_Password;
	String Manager_Phone;
	String Manager_Hub;
	float Manager_Salary;
	String[] Manager_Courier = new String[5];
	static int id = 1;

	// default constructor is used to assign default data to a new object
	manager() {
		Manager_ID = id++;
		Manager_Name = "empty";
		Manager_EmailID = "empty";
		Manager_Password = "testing";
		Manager_Phone = "0000000000";
		Manager_Hub = "Bangalore";
		Manager_Salary = 50000;
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
		Manager_Courier[0] = "test1";
		Manager_Courier[1] = "test2";
		Manager_Courier[2] = "test3";
		Manager_Courier[3] = "test4";
		Manager_Courier[4] = "test5";
	}

	// private function only usable in this class
	protected void modify()throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		
		System.out.println("Please enter your password, " + Manager_Name + ": ");
		String password = br.readLine();

		// checks if the input password and the stored password matches
		if (password.equals(Manager_Password)) {
			System.out.println("Enter the details\n");

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
		System.out.print("\n");
	}

}
