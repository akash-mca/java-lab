import java.io.*;
import java.util.*;

class mockTest1 {
	public static String sortString(String input) { 
		char tempArray[] = input.toCharArray(); 
		Arrays.sort(tempArray); 
		return new String(tempArray); 
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		int choice;
		String text1, text2;
		do {
			System.out.println("\tString Operations");
			System.out.println("1. Anagram\n2. Abecedarian\n3. Doubloon\n4. Exit");
			System.out.println("Enter your choice:");
			choice = Integer.parseInt(br.readLine());

			switch (choice) {
				case 1:
					System.out.println("Enter 2 strings:");
					text1 = br.readLine();	
					text2 = br.readLine();	
					if (sortString(text1).equals(sortString(text2))) System.out.println("Anagram");
					else System.out.println("Not an Anagram");
					break;
				case 2:
					System.out.println("Enter a string:");
					text1 = br.readLine();	
					if (text1.equals(sortString(text1))) System.out.println("Abecedarian");
					else System.out.println("Not an Abecedarian");
					break;
				case 3:
					System.out.println("Enter a string:");
					text1 = br.readLine();
					text1 = sortString(text1);
					boolean doubloon = true;
					for (int i = 0; i < text1.length(); i += 2) {
						if (text1.charAt(i) != text1.charAt(i + 1)) {
							doubloon = false;
							break;
						}
					}
					if (doubloon == true)  System.out.println("Doubloon");
					else System.out.println("Not an Doubloon");
					break;
				default:
					System.out.println("\nProgram will exit");
					break;
			}

			System.out.println("\nPress Enter to Continue...");
			br.readLine();
		} while (choice < 4);
	}
}