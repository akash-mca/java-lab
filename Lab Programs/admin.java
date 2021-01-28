/*
Program: control statements
Author: Akash Roshan A
Reg No: 2047207
Github: akashroshan135
*/

import java.io.*;
class admin {
	int Admin_ID;
	String Admin_Name;
	String Admin_EmailID;
	private String Admin_Password;
	String Admin_Phone;
	static int id = 1;

	admin() {
		Admin_ID = id++;
		Admin_Name = "empty";
		Admin_EmailID = "empty";
		Admin_Password = "testing";
		Admin_Phone = "0000000000";
	}
	admin(String name, String email, String password, String phone) {
		Admin_ID = id++;
		Admin_Name = name;
		Admin_EmailID = email;
		Admin_Password = password;
		if (phone.length() == 10) this.Admin_Phone = phone;
		else {
			System.out.println("Invalid Phone no, default no: 0000000000 is placed");
			Admin_Phone = "0000000000";
		}
	}

	public void modify()throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		
		System.out.println("Please enter your password, " + Admin_Name + ": ");
		String password = br.readLine();

		if (password.equals(Admin_Password)) {
			System.out.println("Enter the details\n");

			System.out.println("Name:");
			Admin_Name = br.readLine();
			System.out.println("Email ID:");
			Admin_EmailID = br.readLine();
			System.out.println("Phone:");
			String phone = br.readLine();
			if (phone.length() == 10) Admin_Phone = phone;
			else System.out.println("Invalid Phone no. Not modified");
		} else System.out.println("Invalid Password");

	}
	public void display() {
		System.out.println("ID       : " + Admin_ID);
		System.out.println("Name     : " + Admin_Name);
		System.out.println("Email ID : " + Admin_EmailID);
		System.out.println("Phone    : " + Admin_Phone);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		int choice;

		admin A1 = new admin();
		admin A2 = new admin("test1", "test1@email.com", "testpass", "1234567898");
		admin A3 = new admin("test2", "test2@email.com", "testpass", "1234567898");

		do {
			System.out.println("\tCheck Admins");
			System.out.println("1. Display all admins\n2. Modify admin details\n3. Exit");
			System.out.println("Enter your choice:");
			choice = Integer.parseInt(br.readLine());

			switch (choice) {
				case 1: A1.display();
						A2.display();
						A3.display();
						break;
				case 2: A3.modify();
						A3.display();
						break;
				default:break;
			}

			System.out.println("\nPress Enter to Continue...");
			br.readLine();
		} while (choice < 3);
	}
}