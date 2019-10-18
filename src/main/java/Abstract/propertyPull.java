package main.java.Abstract;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class propertyPull{

	public static String compareStringToPropertyName(String passedString, String filePath){
		System.out.println("InputCode: " + passedString);
		
		try{
			FileInputStream fstream = null;
			DataInputStream in = null;
			BufferedReader br = null;

			String outputValue = "NOT_SET";
		
			fstream = new FileInputStream(filePath);
			in = new DataInputStream(fstream);
			br = new BufferedReader(new InputStreamReader(in));
			
			String oneLine = null;	
			System.out.println("Reading properties file " + filePath);
			while ((oneLine = br.readLine()) != null) {
				System.out.println("Property -> " + oneLine);
				if (!oneLine.contains("#")) { 	
					String[] split = oneLine.split("=");	
					String key = split[0].trim();
					String value = split[1].trim();
					System.out.println("Adding claimType: " + key + " value: " + value);
					System.out.println("inputCode: " + passedString);
					if (passedString.equalsIgnoreCase(key)) {
						outputValue = value;
						break;
					}
				}
			}
		
		return outputValue;
		
		} catch(Exception e){
			return "" + e;
		}
		
	}
	
	public static String compareValueToPropertyName(int iterativeCount, String filePath){
		System.out.println("iterativeCount: " + iterativeCount);
		
		try{
			FileInputStream fstream = null;
			DataInputStream in = null;
			BufferedReader br = null;

			String outputValue = "NOT_SET";
		
			fstream = new FileInputStream(filePath);
			in = new DataInputStream(fstream);
			br = new BufferedReader(new InputStreamReader(in));
			
			String oneLine = null;	
			System.out.println("Reading properties file " + filePath);
			while ((oneLine = br.readLine()) != null) {
				System.out.println("Property -> " + oneLine);
				if (!oneLine.contains("#")) { 	
					String[] split = oneLine.split("=");	
					String key = split[0].trim();
					String value = split[1].trim();
					System.out.println("Adding claimType: " + key + " value: " + value);
					System.out.println("iterativeCount: " + iterativeCount);
			//		if (passedString.equalsIgnoreCase(key)) {
			//			outputValue = value;
			//			break;
			//		}
				}
			}
		
		return outputValue;
		
		} catch(Exception e){
			return "" + e;
		}
		
	}
	
}