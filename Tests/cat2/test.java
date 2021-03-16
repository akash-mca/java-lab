import java.io.*;

public class test {
	static int SIBcustID = 1;
	static int AXIScustID = 1;
	static CustomerSIB SIBcustObj[] = new CustomerSIB[10];
	static CustomerAXIS AXIScustObj[] = new CustomerAXIS[10];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice, bank, innerchoice;
		int custId = 0;
		double amount = 0;
		
		do {
			System.out.println("\n\tBank");
			System.out.println("1. Create new Account\n2. Display Account Details\n3. Display Highest in Bank\n4. Deposit\n5. Withdraw\n6. Get Balance of customer\n7. Exit");
			System.out.println("Enter your choice");

			try {
				choice = Integer.parseInt(br.readLine());
			} catch (Exception e) {
				System.out.println("Incorrect input. Program will exit");
				choice = 7;
			}
			
			switch (choice) {
				case 1:
					bank = menu();
					if (bank > 3) break;

					String Phone;
					double Balance = 0;

					System.out.println("Enter Name : ");
					String Name = br.readLine();

					System.out.println("Enter TypeOfAccount : ");
					String TypeOfAccount = br.readLine();

					boolean isPhone = false;
					do {
						System.out.println("Enter Phone:");
						Phone = br.readLine();
						if (Phone.length() == 10) isPhone = true;
						else System.out.println("Invalid Phone no. Please enter correct phone no : ");
					} while (!isPhone);


					boolean isBalance = false;
					do {
						System.out.println("Enter Balance (minimum 1000) : ");
						try {
							Balance = Double.parseDouble(br.readLine());
							if (Balance >= 1000) isBalance = true;
							else System.out.println("Please Deposit to the minimum balance");	
						} catch (Exception e) {
							System.out.println("Invalid Balance");
						}
					} while (!isBalance);

					switch (bank) {
						case 1:
							SIBcustObj[SIBcustID] = new CustomerSIB();
							SIBcustObj[SIBcustID].CreateAccount(Name, TypeOfAccount, Phone, Balance);
							SIBcustObj[SIBcustID].AccountDetails();
							SIBcustID++;
							break;
						case 2:
							AXIScustObj[AXIScustID] = new CustomerAXIS();
							AXIScustObj[AXIScustID].CreateAccount(Name, TypeOfAccount, Phone, Balance);
							AXIScustObj[AXIScustID].AccountDetails();
							AXIScustID++;
						default:
							break;
					}
					break;
				
				case 2:
					bank = menu();
					if (bank > 3) break;

					System.out.println("\n1. Print Individual Account\n2. Print all Accounts\n3. Go Back");
					try {
						innerchoice = Integer.parseInt(br.readLine());
					} catch (Exception e) {
						System.out.println("Incorrect input. Program will exit");
						innerchoice = 3;
					}

					switch (innerchoice) {
						case 1:
							System.out.println("Enter Customer ID : ");
							try {
								custId = Integer.parseInt(br.readLine());
								if (bank == 1) {
									if (custId > SIBcustID) System.out.println("Account Doesnt exist");
									else SIBcustObj[custId].AccountDetails();
								} else {
									if (custId > AXIScustID) System.out.println("Account Doesnt exist");
									else AXIScustObj[custId].AccountDetails();
								}
							} catch (Exception e) {
								System.out.println("Incorrect ID");
							}
							break;
						case 2:
							if (bank == 1) {
								System.out.println("All SIB Accounts");
								for (int i = 1; i < SIBcustID; i++) {
									System.out.println("-----------------------------------------");
									SIBcustObj[i].AccountDetails();
									System.out.println("-----------------------------------------");
								}
							} else {
								System.out.println("All AXIS Accounts");
								for (int i = 1; i < AXIScustID; i++) {
									System.out.println("-----------------------------------------");
									AXIScustObj[i].AccountDetails();
									System.out.println("-----------------------------------------");
								}
							}
						default:
							break;
					}
					break;
				
				case 3:
					bank = menu();
					if (bank > 3) break;

					int highestID = 0;
					double highestAmount = 0;

					if (bank == 1) {
						for (int i = 1; i < SIBcustID; i++) {
							if (SIBcustObj[i].Balance > highestAmount) {
								highestAmount = SIBcustObj[i].Balance;
								highestID = i;
							}
						}
						System.out.println("Account with higest balance:");
						SIBcustObj[highestID].AccountDetails();
					} else {
						for (int i = 1; i < AXIScustID; i++) {
							if (AXIScustObj[i].Balance > highestAmount) {
								highestAmount = AXIScustObj[i].Balance;
								highestID = i;
							}
						}
						System.out.println("Account with higest balance:");
						AXIScustObj[highestID].AccountDetails();
					}
					break;

				case 4:
					bank = menu();
					if (bank > 3) break;

					System.out.println("\nEnter account ID : ");
					try {
						custId = Integer.parseInt(br.readLine());
					} catch (Exception e) {
						System.out.println("Incorrect input");
						break;
					}
					System.out.println("\nEnter Deposit amount : ");
					try {
						amount = Integer.parseInt(br.readLine());
					} catch (Exception e) {
						System.out.println("Incorrect input");
						break;
					}

					switch (bank) {
						case 1:
							if (custId > SIBcustID) System.out.println("Account Doesnt exist");
							else {
								SIBcustObj[custId].Deposit(amount);
							}
							break;
						case 2:
							if (custId > AXIScustID) System.out.println("Account Doesnt exist");
							else {
								AXIScustObj[custId].Deposit(amount);
							}
						default:
							break;
					}
					break;

				case 5:
					bank = menu();
					if (bank > 3) break;

					System.out.println("\nEnter account ID : ");
					try {
						custId = Integer.parseInt(br.readLine());
					} catch (Exception e) {
						System.out.println("Incorrect input");
						break;
					}
					System.out.println("\nEnter Withdraw amount : ");
					try {
						amount = Integer.parseInt(br.readLine());
					} catch (Exception e) {
						System.out.println("Incorrect input");
						break;
					}

					switch (bank) {
						case 1:
							if (custId > SIBcustID) System.out.println("Account Doesnt exist");
							else {
								amount = SIBcustObj[custId].Withdraw(amount);
							}
							break;
						case 2:
							if (custId > AXIScustID) System.out.println("Account Doesnt exist");
							else {
								amount = AXIScustObj[custId].Withdraw(amount);
							}
						default:
							break;
					}
					System.out.println("Withdraw Amount = " + amount);
					break;

				case 6:
					bank = menu();
					if (bank > 3) break;

					System.out.println("\nEnter account ID : ");
					try {
						custId = Integer.parseInt(br.readLine());
					} catch (Exception e) {
						System.out.println("Incorrect input");
						break;
					}

					switch (bank) {
						case 1:
							if (custId > SIBcustID) System.out.println("Account Doesnt exist");
							else {
								SIBcustObj[custId].GetBalance();
							}
							break;
						case 2:
							if (custId > AXIScustID) System.out.println("Account Doesnt exist");
							else {
								AXIScustObj[custId].GetBalance();
							}
						default:
							break;
					}
					break;

				default:
					System.out.println("\nProgram will exit");
					break;
			}

	
		} while (choice < 7);
	}

	public static int menu() throws IOException {
		String banks[] = {"SIB", "AXIS"};

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\tSelect Bank");
		System.out.println("1. " + banks[0] + "\n2. " + banks[1] + "\n3. Go Back");
		System.out.println("Enter your choice:");
		try {
			return Integer.parseInt(br.readLine());
		} catch (Exception e) {
			System.out.println("Incorrect input. Program will go back");
			return 3;
		}
	}

}

public interface Bank {
	void CreateAccount(String branch, String location, String ifsc);
	void Deposit(double amount);
	double Withdraw(double amount);
	void GetBalance();
}

abstract class SIB implements Bank {
	static int id = 1;
	public int BankID;
	public String Branch;
	public String Location;
	public String IFSC;
	public double Interest;

	public void CreateAccount(String branch, String location, String ifsc) {
		this.BankID = id++;
		this.Branch = branch;
		this.Location = location;
		this.IFSC = ifsc;
	}
	public abstract void Deposit(double amount);
	public abstract double Withdraw(double amount);
	public abstract void GetBalance();

	void SetMonthlyInterest(double interest) {
		this.Interest = interest;
	}
}

class CustomerSIB extends SIB {
	static int id = 1;
	public int CustomerID;
	public String Name;
	public String TypeOfAccount;
	public String Phone;
	public double Balance;

	public void CreateAccount(String Name, String TypeOfAccount, String Phone, double Balance) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		this.CustomerID = id++;
		this.Name = Name;
		this.TypeOfAccount = TypeOfAccount;
		this.Phone = Phone;
		this.Balance = Balance;

		System.out.println("Enter Branch Name : ");
		String branch = br.readLine();

		System.out.println("Enter Branch Location : ");
		String location = br.readLine();

		System.out.println("Enter Branch IFSC : ");
		String ifsc = br.readLine();

		super.CreateAccount(branch, location, ifsc);
	}
	
	public void Deposit(double amount) {
		this.Balance += amount;
		this.GetBalance();
	}
	public double Withdraw(double amount) {
		if (this.Balance < amount) {
			System.out.println("Cannot Withdraw due to insufficent balance");
			return 0;
		}
		else this.Balance -= amount;
		this.GetBalance();
		return amount;
	}
	public void GetBalance() {
		System.out.println("Total Balance = " + this.Balance);
	}

	public void AccountDetails() {
		String NameOut = Name.substring(0, 1).toUpperCase() + Name.substring(1);

		System.out.println("Customent ID             = " + CustomerID);
		System.out.println("Name                     = " + NameOut);
		System.out.println("Phone                    = " + Phone);
		System.out.println("Type of Account          = " + TypeOfAccount);
		System.out.println("Balance                  = " + Balance);
		System.out.println("Current Monthly Interest = " + Interest);
		System.out.println("Bank ID                  = " + BankID);
		System.out.println("Branch Name              = " + Branch);
		System.out.println("Branch Location          = " + Location);
		System.out.println("Branch IFSC              = " + IFSC);
	}
}



abstract class AXIS implements Bank {
	static int id = 1;
	public int BankID;
	public String Branch;
	public String Location;
	public String IFSC;
	public double Interest;

	public void CreateAccount(String branch, String location, String ifsc) {
		this.BankID = id++;
		this.Branch = branch;
		this.Location = location;
		this.IFSC = ifsc;
	}
	public abstract void Deposit(double amount);
	public abstract double Withdraw(double amount);
	public abstract void GetBalance();

	void SetMonthlyInterest(double interest) {
		this.Interest = interest;
	}
}

class CustomerAXIS extends AXIS {
	static int id = 1;
	public int CustomerID;
	public String Name;
	public String TypeOfAccount;
	public String Phone;
	public double Balance;

	public void CreateAccount(String Name, String TypeOfAccount, String Phone, double Balance) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		this.CustomerID = id++;
		this.Name = Name;
		this.TypeOfAccount = TypeOfAccount;
		this.Phone = Phone;
		this.Balance = Balance;

		System.out.println("Enter Branch Name : ");
		String branch = br.readLine();

		System.out.println("Enter Branch Location : ");
		String location = br.readLine();

		System.out.println("Enter Branch IFSC : ");
		String ifsc = br.readLine();

		super.CreateAccount(branch, location, ifsc);
	}
	
	public void Deposit(double amount) {
		this.Balance += amount;
		this.GetBalance();
	}
	public double Withdraw(double amount) {
		if (this.Balance < amount) {
			System.out.println("Cannot Withdraw due to insufficent balance");
			return 0;
		}
		else this.Balance -= amount;
		this.GetBalance();
		return amount;
	}
	public void GetBalance() {
		System.out.println("Total Balance = " + this.Balance);
	}

	public void AccountDetails() {
		System.out.println("Customent ID             = " + CustomerID);
		System.out.println("Name                     = " + Name);
		System.out.println("Phone                    = " + Phone);
		System.out.println("Type of Account          = " + TypeOfAccount);
		System.out.println("Balance                  = " + Balance);
		System.out.println("Current Monthly Interest = " + Interest);
		System.out.println("Bank ID                  = " + BankID);
		System.out.println("Branch Name              = " + Branch);
		System.out.println("Branch Location          = " + Location);
		System.out.println("Branch IFSC              = " + IFSC);
	}
}