package src.main.java;

import java.util.Random;
import java.util.Scanner;

public class Abstract{

	private static Scanner initializeScanner(){
		Scanner read = new Scanner(System.in);
		return read;
	}

	public static int scannerInt(){
		int userInputInt = initializeScanner().nextInt();
		return userInputInt;
	}

	public static String scannerString(){
		String userInputString = initializeScanner().nextLine();
		return userInputString;
	}

	public static void pressAnyKey(){
		try{
			System.in.read();
		}catch(Exception e){
			System.out.print(e);
		}
	}
  
	public static void rotatePorts(String[] displayList){
		for(int i = 0; i < displayList.length; i++){
			System.out.println( (i + 1) +  ". " + displayList[i]);
		}
	}

	private static Random generateRandomValue(){
		Random randomValue = new Random();
		return randomValue;
	}

	public static int getRandomValue(int maxValue){
		return generateRandomValue().nextInt(maxValue);
	}

	public static int getRandomValue(){
		return generateRandomValue().nextInt();
	}

	public static int getRandomValue(int maxValue, int minValue){
		return generateRandomValue().nextInt(maxValue - minValue) + minValue;
	}

}
