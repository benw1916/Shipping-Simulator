package main.java;

import main.java.Abstract.*;

class Temperature{ // This class contains the temperature settings.
	private int temperature; // contains the temperature as a solid value, rather than a double.
	private final static int maximumChangeInTemp = 4; // Maximum change in temperature up or down.  This can be changed, but I'm trying not to have too crazy of temperature swings.
	private final static int maximumTemperature = 90; // Maximum temperature allowed, any higher, and the temperature will reset.
	private final static int minimumTemperature = 30; // Minimum temperature allowed, any lower, and the temperature will reset.
	
	protected Temperature(){ // Constructor where if value isn't passed, temperature is set to random value.  
		this.temperature = Abstract.GetRandomValue(this.maximumTemperature, this.minimumTemperature);
	}
	
	protected Temperature(int initializedValue){ // Constructor for temperature that when argument is passed, sets the temperature.
		this.temperature = initializedValue;
	}
	
	
	protected int getTemperature(){ // Returns temperature value.
		return this.temperature;
	}
	
	protected int increaseDecreaseTemperature(){ // Increases or decreases temperature value.
		return Abstract.IncreaseDecrease(maximumChangeInTemp, 0);
	}
	
	protected void setTemperature(int passedValue){ // Passed integer sets temperature.
		this.temperature = passedValue;
	}
	
}

class Conditions{ // Class contains weather conditions.
	private String conditions; // Contains the weather condition string.
	
	protected Conditions(){ // Constructor for conditions, without arguments.  If run, a random condition will be chosen.
		this.conditions = MenuDisplays.GetWeatherOptions(Abstract.GetRandomValue(MenuDisplays.GetWeatherOptionLength(), 1));
	}
	
	protected Conditions(int conditionValue){ // Constructor for conditions, with a integer argument.  Chooses the corresponding array element.
		this.conditions = MenuDisplays.GetWeatherOptions(conditionValue);
	}
	
	protected void setConditions(){ // Sets the condition variable to a random option.
		this.conditions = MenuDisplays.GetWeatherOptions(Abstract.GetRandomValue(MenuDisplays.GetWeatherOptionLength(), 1));
	}
	
	protected String getConditions(){ // Returns the weather condition string.
		return this.conditions;
	}
	
}

public class Weather{
	
	private Temperature Temperature; // temperature class from above.
	private Conditions Conditions; // Condition class from above.
	
//	ArrayList dailyTemperature = new ArrayList();
//	String[] dailyConditions;
	
	public Weather(){
		this.Temperature = new Temperature(); //
		this.Conditions = new Conditions(); //
	}
	
	public Weather(int temperatureSetting){
		this.Temperature = new Temperature(temperatureSetting);
		this.Conditions = new Conditions();
	}

	public void setTemperature(int userDefinedTemperature){ // Passthrough to the temperature class; passed integer 
		this.Temperature.setTemperature(userDefinedTemperature);
	}

	private int getTemperature(){ // Passthrough to the temperature class, and returns the temperature value.
		return this.Temperature.getTemperature();
	}

	private String getConditions(){ // Passthrough to the condition class, and returns the condition value.
		return this.Conditions.getConditions();
	}
	
	public String formattedTemperature(){ // Displays formatted temperature.
		return getTemperature() + "F";
	}

	public void FormattedWeatherAndTemperature(){ // Displays formatted temperature and conditions.
		System.out.println(formattedTemperature() + " -- " + getConditions());
	}

	public void FormattedWeatherAndTemperature(int dayCount){ // Basically same thing as FormattedWeatherAndTemperature, this provides multiple days in the future, as far as the argument integer is.
		for(int i = 0; i < dayCount; i++){
			FormattedWeatherAndTemperature();
		}
	}
	
/*	public void FormattedWeatherAndTemperature(Boat playerObject, int dayCount){
		for(int i = 0; i < dayCount; i++){
			System.out.println(playerObject.GetAndIncreaseDate() + " -- " + getTemperature(dayCount) + "F -- " + GetWeather());
			IncreaseDecreaseTemperature();
		}
	}*/

}