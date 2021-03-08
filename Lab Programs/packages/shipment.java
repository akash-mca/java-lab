package packages;
import java.io.*;

public class shipment {
	static int id = 1;
	int Shipment_ID;
	customer Shipment_Sender;
	customer Shipment_Reciever;
	float Shipment_Price;	
	String Shipment_Hub;
	String Shipment_Courier;
	String Shipment_Status;

	public shipment() throws IOException, PriceException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		this.Shipment_ID = id++;

		System.out.println("Enter Sender Details:");
		Shipment_Sender = new customer();
		
		System.out.println("Enter Reciever Details:");
		Shipment_Reciever = new customer();

		System.out.println("Enter price of the shipment (More than 100):");
		try {
			this.Shipment_Price = Float.parseFloat(br.readLine());
			validate(this.Shipment_Price);
		} catch (NumberFormatException e) {
			System.out.println("Incorrect input. Price is set to 100");
			this.Shipment_Price = 100;
		} catch (Exception e) {
			System.out.println(e);
			this.Shipment_Price = 100;
		}

		System.out.println("Enter current hub location:");
		this.Shipment_Hub = br.readLine();

		System.out.println("Enter current courier incharge:");
		this.Shipment_Courier = br.readLine();

		this.Shipment_Status = "Yet to send";
	}

	public void update_status() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice;

		System.out.println("Update shipment status\nCurrent Status = " + Shipment_Status);
		System.out.println("\n1. 'In Transit'\n2. 'In Hub'\n3. 'Out for Delivery'\n4. 'Delivered'\n5. 'Not Delivered'\n6. 'Returned to Sender'\n7. No Change\n\nSelect new status:");
		try {
			choice = Integer.parseInt(br.readLine());
		} catch (Exception e) {
			System.out.println("Incorrect input. Program will go back");
			choice = 7;
		}
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
			default:
				break;
		}
		System.out.println("\nCurrent Status = " + Shipment_Status);
	}

	public void update_details() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice;
		String modString;

		System.out.println("Update Hub and Courier details");
		System.out.println("\nCurrent Hub = " + Shipment_Hub + "\nCurrent Courier = " + Shipment_Courier);
		System.out.println("\n1. Update Hub and Courier\n2. Update Hub\n3. Update Courier\n4. No Change\n\nSelect module:");
		try {
			choice = Integer.parseInt(br.readLine());
		} catch (Exception e) {
			System.out.println("Incorrect input. Program will go back");
			choice = 7;
		}
		switch (choice) {
			case 1:
				System.out.println("Enter current hub location:");
				modString = br.readLine();
				if (modString != "") this.Shipment_Hub = modString;

				System.out.println("Enter current courier incharge:");
				modString = br.readLine();
				if (modString != "") this.Shipment_Courier = modString;

				break;
			case 2:
				System.out.println("Enter current hub location:");
				modString = br.readLine();
				if (modString != "") this.Shipment_Hub = modString;
				break;
			case 3:
				System.out.println("Enter current courier incharge:");
				modString = br.readLine();
				if (modString != "") this.Shipment_Courier = modString;
			default:
				break;
		}
		System.out.println("\nCurrent Status = " + Shipment_Status);
	}

	public void display() throws IOException {
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

	static void validate(float price) throws PriceException {
		if (price < 100) throw new PriceException("Price less than 100, Price is set to 100");
	}

}
