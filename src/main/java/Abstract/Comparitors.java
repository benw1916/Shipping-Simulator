package main.java.Abstract;
import java.util.ArrayList;

public class Comparitors extends Randomize{

	public static int convertStringToInt(String passedString, String[] setOfData){
		for(int i = 0; i < setOfData.length; i++){
			if(passedString.contains(setOfData[i])){
				return i;
			}
		}
		return -555555;
	}
	
	public static int convertArrayListToInt(String passedString, ArrayList setOfData){
		try{
			for(int i = 0; i < setOfData.size(); i++){
				if(passedString.equals(setOfData.get(i))){
					return i;
				}
			}
		} catch(ArrayIndexOutOfBoundsException aioobe){
			System.err.println("Could not convert Arraylist to Integer" + aioobe);
			return -999;
		}
		return -999;
	}
	
	public static double convertStringToDouble(String passedString, double[] setOfData){
		try{
			for(int i = 0; i < setOfData.length; i++){
				if(passedString.contains("" + setOfData[i])){
					return i;
				}
			}
		}catch(ArrayIndexOutOfBoundsException aioobe){
			System.err.println("Could not convert String to Double" + aioobe);
			return -444.444;
		}
		return -444.444;
	}
	
	public static double compareStringToTableToDouble(String passedString, String[] table, double[] setOfData){
		for(int i = 0; i < setOfData.length; i++){
			if(passedString.contains(table[i])){
				return setOfData[i];
			}
		}
		return -888.888;
	}

}