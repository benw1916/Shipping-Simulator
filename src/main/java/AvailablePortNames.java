package main.java;

import java.util.ArrayList;


public class AvailablePortNames{
	private static final ArrayList<String> portName = new ArrayList<String>();
	
	public void setPorts(String[] passedPortNames){
		for(int i = 0; i < passedPortNames.length; i++){
			this.portName.add(passedPortNames[i]);
		}
	}
	
	public void setPorts(String passedPortNames){
		this.portName.add(passedPortNames);
	}
	
	public static ArrayList getPorts(){
		return portName;
	}
	
	public static int getPortSize(){
		return portName.size();
	}
	
	public static String getPortName(int specificPort){
		return portName.get(specificPort);
	}
	
}