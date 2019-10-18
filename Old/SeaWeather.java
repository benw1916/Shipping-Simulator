package src.main.java;

public class SeaWeather{
	
	private int temperature;
	private int maximumChangeInTemp = 4;
	private int maximumTemperature = 70;
	private int minimumTemperature = 40;
	
	public SeaWeather(){
		setRandomTemperature();
	}
	
	private void setRandomTemperature(){
		this.temperature = Abstract.getRandomValue(this.maximumTemperature, this.minimumTemperature);
	}
	
	private void setTemperature(int userDefinedTemperature){
		this.temperature = userDefinedTemperature;
	}
	
	public int getTemperature(){
		return this.temperature;
	}

	public String getWeather(){
		return MenuDisplays.getWeatherOptions(Abstract.getRandomValue(MenuDisplays.getWeatherOptionLength(), 1));
	}
	
	private void increaseDecreaseTemperature(){
		int dailyUpDown = Abstract.getRandomValue(100);
		if(dailyUpDown >= 51){
			this.temperature += Abstract.getRandomValue(maximumChangeInTemp);
		} else{
			this.temperature -= Abstract.getRandomValue(maximumChangeInTemp);
		}
	}
	
	public void formattedWeatherAndTemperature(){
		System.out.println(this.temperature + "F -- " + MenuDisplays.getWeatherOptions());
	}

	public void formattedWeatherAndTemperature(int dayCount){
		for(int i = 0; i < dayCount; i++){
			System.out.println((i + 1) + " -- " + getTemperature() + "F -- " + getWeather());
			increaseDecreaseTemperature();
		}
	}
	
}