package main.java;

import main.java.Abstract.*;
import java.util.ArrayList;

public class CountryNames{
	private static final ArrayList<String> countryNames = new ArrayList<String>();
	
	public void setCountryNames(String[] passedCountryNames){
		for(int i = 0; i < passedCountryNames.length; i++){
			this.countryNames.add(passedCountryNames[i]);
		}
	}
	
	public static int getCountryListSize(){
		return countryNames.size();
	}
	
	public static ArrayList getCountryList(){
		return countryNames;
	}
	
	public static String getRandomCountryName(){
		return countryNames.get(Abstract.GetRandomValue(getCountryListSize(), 0));
	}
	
	public static String getCountryName(int passedValue){
		return countryNames.get(passedValue);
	}
	
}