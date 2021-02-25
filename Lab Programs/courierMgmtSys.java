/*
Program 6
Program: Implement the concept of inheritance, super, abstract and this keywords in java.
Domain: Courier Management System
Author: Akash Roshan A
Reg No: 2047207
Github: akashroshan135
*/

import java.io.*;

// class courierMgmtSys. Used as main class
class courierMgmtSys {
	static int managerID = 1;
	static int adminID = 1;
	static int courierID = 1;
	static int shipmentID = 1;

	static Admin adminObjects[] = new Admin[10];
	static Manager managerObjects[] = new Manager[10];
	static Courier courierObjects[] = new Courier[10];
	static Shipment shipmentObjects[] = new Shipment[10];

	static {
		System.out.println("    Courier Management System\n\tby akashroshan135\n");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice;
		System.out.println("\tMain Menu");
		System.out.println("1. Admin Module\n2. Manager Module\n3. Courier Module\n4. Shipment Module\n5. Exit");
		System.out.println("Enter your choice:");
		
		if (args.length == 0) choice = Integer.parseInt(br.readLine());
		else choice = Integer.parseInt(args[0]);

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
				shipment_program();
				break;
			default:
				System.out.println("\nProgram will exit");
				return;
		}
		do {
			System.out.println("\tMain Menu");
			System.out.println("1. Admin Module\n2. Manager Module\n3. Courier Module\n4. Shipment Module\n5. Exit");
			System.out.println("Enter your choice:");
			choice = Integer.parseInt(br.readLine());

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
					shipment_program();
					break;
				default:
					System.out.println("\nProgram will exit");
					break;
			}
		} while (choice < 5);
	}

	public static int menu(int i) throws IOException {
		String module[] = {"Admin", "Manager", "Courier"};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\tCheck " + module[i]);
		System.out.println("1. Add new " + module[i] + "\n2. Modify " + module[i] + " details\n3. Display all " + module[i] + "s\n4. Go Back");
		System.out.println("Enter your choice:");
		return Integer.parseInt(br.readLine());
	}

	// allows user to use admin module
	public static void admin_program() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice;

		do {
			choice = menu(0);

			switch (choice) {
				case 1:
					adminObjects[adminID++] = new Admin();
					break;
				case 2:
					System.out.println("Enter Admin ID:");
					int id = Integer.parseInt(br.readLine());
					adminObjects[id].modify();
					System.out.println("Modified Details:");
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
		int choice;
		do {
			choice = menu(1);
			switch (choice) {
				case 1:
					managerObjects[managerID++] = new Manager();
					break;
				case 2:
					System.out.println("Enter Manager ID:");
					int id = Integer.parseInt(br.readLine());
					managerObjects[id].modify();
					System.out.println("Modified Details:");
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
		int choice;

		do {
			choice = menu(2);

			switch (choice) {
				case 1:
					courierObjects[courierID++] = new Courier();
					break;
				case 2:
					System.out.println("Enter Courier ID:");
					int id = Integer.parseInt(br.readLine());
					courierObjects[id].modify();
					System.out.println("Modified Details:");
					courierObjects[id].display();
					break;
				case 3:
					System.out.println("***********Courier Details***********\n");
					for(int i = 1; i < courierID; i++) {
						courierObjects[i].display();
						System.out.println("-------------------------------------\n");
					}
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
	public static void shipment_program() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice;
		int id;

		do {
			System.out.println("\tCheck Shipments");
			System.out.println("1. Add new Shipment\n2. Update Status\n3. Update Location details\n4. Display Shipment\n5. Display all Shipments\n6. Go Back");
			System.out.println("Enter your choice:");
			choice =  Integer.parseInt(br.readLine());

			switch (choice) {
				case 1:
					shipmentObjects[shipmentID++] = new Shipment();
					break;
				case 2:
					System.out.println("Enter Shipment ID:");
					id = Integer.parseInt(br.readLine());
					shipmentObjects[id].update_status();
					System.out.println("Modified Details:\n");
					shipmentObjects[id].display();
					break;
				case 3:
					System.out.println("Enter Shipment ID:");
					id = Integer.parseInt(br.readLine());
					shipmentObjects[id].update_details();
					System.out.println("Modified Details:\n");
					shipmentObjects[id].display();
					break;
				case 4:
					System.out.println("Enter Shipment ID:");
					id = Integer.parseInt(br.readLine());
					shipmentObjects[id].display();
					break;
				case 5:
					System.out.println("*********All Shipment Details********\n");
					for(int i = 1; i < shipmentID; i++) {
						shipmentObjects[i].display();
						System.out.println("*************************************");
						System.out.println("*************************************");
					}
					break;
				default:
					System.out.println("\nProgram will go to the main menu\n");
					return;
			}

			System.out.println("\nPress Enter to Continue...");
			br.readLine();
		} while (choice < 6);
	}

}


// Base class with common features and functions
class Person {
	String Name, EmailID, Phone;

	void add() throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter Name:");
		this.Name = br.readLine();

		System.out.println("Enter Email ID:");
		this.EmailID = br.readLine();

		System.out.println("Enter Phone:");
		String Phone = br.readLine();

		// checks if the length of the phone no is 10. If not, a default value is inserted
		if (Phone.length() == 10) this.Phone = Phone;
		else {
			System.out.println("Invalid Phone no. Default 0000000000 is placed");
			this.Phone = "0000000000";
		}
	}

	void add(String Name, String EmailID, String Phone) {	
		this.Name = Name;
		this.EmailID = EmailID;
		if (Phone.length() == 10) this.Phone = Phone;
		else {
			System.out.println("Invalid Phone no. Default 0000000000 is placed");
			this.Phone = "0000000000";
		}
	}

	void modify() throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("\nPress Enter to Continue...");
		br.readLine();
		System.out.println("\nEnter the new details (leave blank to not change)");

		System.out.println("Enter new Name:");
		String Name = br.readLine();
		if (Name != "") this.Name = Name;

		System.out.println("Enter new Email ID:");
		String EmailID = br.readLine();
		if (EmailID != "") this.EmailID = EmailID;

		System.out.println("Enter new Phone:");
		String Phone = br.readLine();
		if (Phone.length() == 10 && Phone != "") this.Phone = Phone;
	}

	void display() {
		System.out.println("Name     : " + Name);
		System.out.println("Email ID : " + EmailID);
		System.out.println("Phone    : " + Phone);
	}
}


// class admin used for admins
class Admin extends Person {
	static int id = 1;
	int Admin_ID;
	private String Admin_Password;

	// default constructor is used to assign default data to a new object
	Admin() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		this.Admin_ID = id++;
		super.add();
		System.out.println("Enter Password:");
		this.Admin_Password = br.readLine();
	}
	// protected function only usable in this class and sub classes
	protected void modify() throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Please enter your password, " + Name + ": ");
		String password = br.readLine();
		// checks if the input password and the stored password matches
		if (password.equals(Admin_Password)) {
			super.modify();
		} else System.out.println("Invalid Password");
	}

	// protected function only usable in this class and subclasses
	protected void display() {
		System.out.println("ID       : " + Admin_ID);
		super.display();
		System.out.println("");
	}
	
}

// class manager used for managers
class Manager extends Person {
	static int id = 1;
	int Manager_ID;
	private String Manager_Password;
	String Manager_Hub;
	float Manager_Salary;

	// default constructor is used to assign default data to a new object. Will not be used so can be removed
	Manager() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		this.Manager_ID = id++;
		super.add();

		System.out.println("Enter Password:");
		this.Manager_Password = br.readLine();

		System.out.println("Enter Hub:");
		this.Manager_Hub = br.readLine();

		System.out.println("Enter Salary:");
		this.Manager_Salary = Float.parseFloat(br.readLine());
	}
	// protected function only usable in this class and subclass
	protected void modify() throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Please enter your password, " + Name + ": ");
		String password = br.readLine();

		// checks if the input password and the stored password matches
		if (password.equals(Manager_Password)) {
			super.modify();

			System.out.println("Enter new Hub:");
			String hub = br.readLine();
			if (hub != "") this.Manager_Hub = hub;

			System.out.println("Enter new Salary:");
			String salary = br.readLine();
			if (salary != "") this.Manager_Salary = Float.parseFloat(salary);

		} else System.out.println("Invalid Password");

	}
	// protected function only usable in this class and subclasses
	protected void display() {
		System.out.println("ID       : " + Manager_ID);
		super.display();
		System.out.println("Hub      : " + Manager_Hub);
		System.out.println("Salary   : " + Manager_Salary);
		System.out.println("");
	}
}

// class courier used for couriers
class Courier extends Person {
	static int id = 1;
	int Courier_ID;
	private String Courier_Password;
	String Courier_Hub;
	String Courier_Manager;
	float Courier_Salary;

	// default constructor is used to assign default data to a new object. Will not be used so can be removed
	Courier() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		this.Courier_ID = id++;
		super.add();

		System.out.println("Enter Password:");
		this.Courier_Password = br.readLine();

		System.out.println("Enter Hub:");
		this.Courier_Hub = br.readLine();

		System.out.println("Enter Manager:");
		this.Courier_Manager = br.readLine();

		System.out.println("Enter Salary:");
		this.Courier_Salary = Float.parseFloat(br.readLine());
	}
	// protected function only usable in this class and subclass
	protected void modify() throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Please enter your password, " + Name + ": ");
		String password = br.readLine();

		// checks if the input password and the stored password matches
		if (password.equals(Courier_Password)) {
			super.modify();

			System.out.println("Enter new Hub:");
			String hub = br.readLine();
			if (hub != "") this.Courier_Hub = hub;

			System.out.println("Enter new Manager:");
			String manager = br.readLine();
			if (manager != "") this.Courier_Manager = manager;

			System.out.println("Enter new Salary:");
			String salary = br.readLine();
			if (salary != "") this.Courier_Salary = Float.parseFloat(salary);

		} else System.out.println("Invalid Password");

	}
	// protected function only usable in this class and subclasses
	protected void display() {
		System.out.println("ID       : " + Courier_ID);
		super.display();
		System.out.println("Hub      : " + Courier_Hub);
		System.out.println("Manager  : " + Courier_Manager);
		System.out.println("Salary   : " + Courier_Salary);
		System.out.println("");
	}
}

// class customer used for customers
class Customer extends Person {
	static int id = 1;
	int Customer_ID;
	String Customer_Address;

	// default constructor is used to assign default data to a new object. Will not be used so can be removed
	Customer() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		this.Customer_ID = id++;
		super.add();

		System.out.println("Enter Address:");
		this.Customer_Address = br.readLine();
	}
	// protected function only usable in this class and subclasses
	protected void display() {
		System.out.println("ID       : " + Customer_ID);
		super.display();
		System.out.println("Address  : " + Customer_Address);
		System.out.println("");
	}
}

// class Shipment used for Shipments
class Shipment {
	static int id = 1;
	int Shipment_ID;
	Customer Shipment_Sender;
	Customer Shipment_Reciever;
	float Shipment_Price;	
	String Shipment_Hub;
	String Shipment_Courier;
	String Shipment_Status;

	Shipment() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		this.Shipment_ID = id++;

		System.out.println("Enter Sender Details:");
		Shipment_Sender = new Customer();
		
		System.out.println("Enter Reciever Details:");
		Shipment_Reciever = new Customer();

		System.out.println("Enter price of the shipment:");
		this.Shipment_Price = Float.parseFloat(br.readLine());

		System.out.println("Enter current hub location:");
		this.Shipment_Hub = br.readLine();

		System.out.println("Enter current courier incharge:");
		this.Shipment_Courier = br.readLine();

		this.Shipment_Status = "Yet to send";
	}

	void update_status() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Update shipment status\nCurrent Status = " + Shipment_Status);
		System.out.println("\n1. 'In Transit'\n2. 'In Hub'\n3. 'Out for Delivery'\n4. 'Delivered'\n5. 'Not Delivered'\n6. 'Returned to Sender'\n7. No Change\n\nSelect new status:");
		int choice = Integer.parseInt(br.readLine());
		switch (choice) {
			case 1:
				this.Shipment_Status = "In Transit";
				break;
			case 2:
				this.Shipment_Status = "In Hub";
				break;
			case 3:
				this.Shipment_Status = "Out for Delivery";
				break;
			case 4:
				this.Shipment_Status = "Delivered";
				break;
			case 5:
				this.Shipment_Status = "Not Delivered";
				break;
			case 6:
				this.Shipment_Status = "Returned to Sender";
				break;
			default:
				break;
		}
		System.out.println("\nCurrent Status = " + Shipment_Status);
	}

	void update_details() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Update Hub and Courier details");
		System.out.println("\nCurrent Hub = " + Shipment_Hub + "\nCurrent Courier = " + Shipment_Courier);
		System.out.println("\n1. Update Hub and Courier\n2. Update Hub\n3. Update Courier\n4. No Change\n\nSelect module:");
		int choice = Integer.parseInt(br.readLine());
		switch (choice) {
			case 1:
				System.out.println("Enter current hub location:");
				this.Shipment_Hub = br.readLine();

				System.out.println("Enter current courier incharge:");
				this.Shipment_Courier = br.readLine();

				break;
			case 2:
				System.out.println("Enter current hub location:");
				this.Shipment_Hub = br.readLine();
				break;
			case 3:
				System.out.println("Enter current courier incharge:");
				this.Shipment_Courier = br.readLine();
				break;
			default:
				break;
		}
		System.out.println("\nCurrent Status = " + Shipment_Status);
	}

	void display() throws IOException {
		System.out.println("***********Shipment " + Shipment_ID + "***********");

		System.out.println("Sender:\n");
		Shipment_Sender.display();
		System.out.println("--------------------------------");

		System.out.println("Receiver:\n");
		Shipment_Reciever.display();
		System.out.println("--------------------------------");
		
		System.out.println("Price    : " + Shipment_Price);
		System.out.println("Hub      : " + Shipment_Hub);
		System.out.println("Courier  : " + Shipment_Courier);
		System.out.println("Status   : " + Shipment_Status);
		System.out.println("");
	}
}
