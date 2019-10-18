package main.java.Properties;

import java.util.ArrayList;
import java.io.*;
import java.lang.Exception;


public class PropertiesReader{

	public double[] readProperties(String fileName){
		
		double[] values = {2.0, 2.0};
		int p = 0;
		FileInputStream fstream = null;
		DataInputStream in = null;
		BufferedReader br = null;
		
		try {
			double[] savedValues = new double[10];
			fstream = new FileInputStream(fileName);
			in = new DataInputStream(fstream);
			br = new BufferedReader(new InputStreamReader(in));
			
			String oneLine = null;	
			while ((oneLine = br.readLine()) != null) {
				if (!oneLine.contains("#")) {
					if (oneLine.contains("=")) {
						String[] split = oneLine.split("=");	
						String key = split[0];
						String value = split[1];
						savedValues[p] = Double.parseDouble(value);
						//System.out.println(value);
						p++;
					}
				}
			}
	
			return savedValues;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return values;
	}
	
	public String[] readStringProperties(String fileName){
		
		String[] values = {"-1"};
		int p = 0;
		FileInputStream fstream = null;
		DataInputStream in = null;
		BufferedReader br = null;
		
		try {
			String[] savedValues = new String[10];
			fstream = new FileInputStream(fileName);
			in = new DataInputStream(fstream);
			br = new BufferedReader(new InputStreamReader(in));
			
			String oneLine = null;	
			while ((oneLine = br.readLine()) != null) {
				if (!oneLine.contains("#")) {
					if (oneLine.contains("=")) {
						String[] split = oneLine.split("=");	
						String key = split[0];
						String value = split[1];
						savedValues[p] = value;
						//System.out.println(value);
						p++;
					}
				}
			}
	
			return savedValues;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return values;
	}
	
	public ArrayList readProperties(String fileName, int iterate){
		int p = 0;
		FileInputStream fstream = null;
		DataInputStream in = null;
		BufferedReader br = null;
		
		try {
			//String[] savedValues = new String[10];
			ArrayList<String> savedValues = new ArrayList<String>();
			fstream = new FileInputStream(fileName);
			in = new DataInputStream(fstream);
			br = new BufferedReader(new InputStreamReader(in));
			
			String oneLine = null;	
			while ((oneLine = br.readLine()) != null) {
				if (!oneLine.contains("#")) {
					if (oneLine.contains("=")) {
						String[] split = oneLine.split("=");	
						String key = split[0];
						String value = split[1];
						savedValues.add(value);
						//System.out.println(value);
						p++;
					}
				if(iterate == p){
					return savedValues;
				}
				}
			}
	
			return savedValues;
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new IllegalArgumentException("Beep boop");
	}
	
	public String[] setNames(String fileName){
		
		String[] values = {"-1"};
		int p = 0;
		FileInputStream fstream = null;
		DataInputStream in = null;
		BufferedReader br = null;
		
		try {
			String[] savedValues = new String[243];
			fstream = new FileInputStream(fileName);
			in = new DataInputStream(fstream);
			br = new BufferedReader(new InputStreamReader(in));
			
			String oneLine = null;	
			while ((oneLine = br.readLine()) != null) {
				if (!oneLine.contains("#")) {
					values[p] = oneLine;
					p++;
					
					/*if (oneLine.contains("=")) {
						String[] split = oneLine.split("=");	
						String key = split[0];
						String value = split[1];
						savedValues[p] = value;
						//System.out.println(value);
					
					}*/
				}
			}
	
//			return savedValues;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return values;
	}
	
	
	
}