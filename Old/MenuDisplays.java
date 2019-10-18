package src.main.java;

public class MenuDisplays{

	final static private String[] goodsDisplayMenu = {"Load / Unload Containers", "Step Ashore" ,"Depart Port"};

	private static final String[] AvailablePorts1 = {"LA", "SY", "HK"};
	/*** Long Beach --> Sydney --> Hong Kong ***/
	//private static final String[] AvailablePorts2 = {"VC", "TK", "LM"};
	/*** Vancouver --> Tokyo --> Lima ***/

	private static final String[] containerMenu = {"Load Containers", "Unload Containers", "Go Back"};
	
	private static final String[] shoreOptionMenu = {"Check Weather Report", "Check Ship Status", "Check Port Prices", "Go Back"};
	
	private static final String[] weatherOptions = {"Sunny", "Partly Cloudy", "Partly Sunny", "Cloudy", "Light Rain", "Rain", "Heavy Rain", "Light Snow", "Snow", "Heavy Snow"};
	
	public static String[] getGoodsMenu(){
		return goodsDisplayMenu;
	}

	public static String getAvailablePorts(int userChosenValue){
		return "" + AvailablePorts1[userChosenValue - 1];
	}
	
	public static String getAvailablePortsNoOffset(int userChosenValue){
		return "" + AvailablePorts1[userChosenValue];
	}
	
	public static String[] getAvailablePorts(){
		return AvailablePorts1;
	}
	
	public static String[] getContainerMenu(){
		return containerMenu;
	}
	
	public static String[] getShoreOptionMenu(){
		return shoreOptionMenu;
	}
	
	public static int getWeatherOptionLength(){
		return weatherOptions.length;
	}
	
	public static String[] getWeatherOptions(){
		return weatherOptions;
	}
	
	public static String getWeatherOptions(int arrayChoice){
		return weatherOptions[arrayChoice - 1];
	}
	
	public static int getAvailablePortsSize(){
		return AvailablePorts1.length;
	}
	
}