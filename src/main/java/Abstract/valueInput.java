package main.java.Abstract;

import java.util.Scanner;

public class valueInput extends Comparitors{

	private static Scanner InitializeScanner(){ // All user input commands use this function first.  This initializes the input scanner.   
		Scanner readUserInput = new Scanner(System.in);
		return readUserInput;
	}

	public static int ScannerInt(){ // This method uses "initializeScanner", and then converts the data to an Int.  I should probably add a 'try' and 'catch' here eventually.
		int convertScanToInt = InitializeScanner().nextInt();
		return convertScanToInt;
	}

	public static String ScannerString(){ // Pretty much the same thing as "scannerInt".  Initializes the scanner, and converts the data to a String.
		String convertScanToString = InitializeScanner().nextLine();
		return convertScanToString;
	}
	
	public static char ScannerChar(){ // Pretty much the same thing as "scannerInt".  Initializes the scanner, and converts the data to a char.
		String convertStringToChar = ScannerString();
		return convertStringToChar.charAt(0);
	}
	
	public static void PressAnyKey(){ // Requires the user to press any key before moving on.  
		try{
			System.in.read();
		}catch(Exception e){ // If for whatever reason the machine can't get text back, it uses this error throwing.  
			System.err.print(e);
		}
	}

}