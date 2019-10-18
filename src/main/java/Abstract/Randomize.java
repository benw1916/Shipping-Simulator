package main.java.Abstract;

import java.util.Random;
import java.text.DecimalFormat;

public class Randomize extends propertyPull{

	private static Random GenerateRandomValue(){ // Similar setup to "initializeScanner", all random values start here.
		Random randomGeneratedValue = new Random();
		//randomValue.setSeed(System.currentTimeMillis());
		return randomGeneratedValue;
	}

	public static int GetRandomValue(int maxValue){ // Obtains random value from "generateRandomValue", uses the maxValue integer to make sure it's below that, and returns.
		return GenerateRandomValue().nextInt(maxValue);
	}

	public static int GetRandomValue(){ // Provides a completely random value.  No limitations.  
		return GenerateRandomValue().nextInt();
	}

	public static int GetRandomValue(int maxValue, int minValue){ // Provides a random value between the two set min and max values.
		return GenerateRandomValue().nextInt(maxValue - minValue) + minValue;
	}
	
	/*private static int getDistancePerDay(int UserSpeed){
		return UserSpeed * 24;
	}*/

	public static <E> String GetDoubleDecimal(E passedDoubleValue){
		DecimalFormat df = new DecimalFormat("#.00");
		return "" + df.format(passedDoubleValue);
	}
	
		public static double GetRandomDoubleValue(){
		return (double)GenerateRandomValue().nextDouble();
	}
	
	public static double GetRandomDoubleValue(int maxValue){
		return ((double)maxValue) * GenerateRandomValue().nextDouble();
	}
	
	public static double GetRandomDoubleValue(double maxValue){ // Returns a "double" random value, with maximum value limiter.
		return maxValue * GenerateRandomValue().nextDouble();
	}
	
	public static double GetRandomDoubleValue(int maxValue, int minValue){
		return ((double)minValue) + (double)(maxValue - minValue) * GenerateRandomValue().nextDouble();
	}
	
	public static double GetRandomDoubleValue(double maxValue, double minValue){ // Returns a "double" random value, set between min and max values.
		return minValue + (maxValue - minValue) * GenerateRandomValue().nextDouble();
	}
	
	/*public static int GetRandomizedDistancePerDay(int passedUserSpeed){
		return GetRandomValue(passedUserSpeed, (passedUserSpeed / 2) )* 24;
	}*/
	
	public static double GetRandomizedDistancePerDay(double passedUserSpeed){
		return GetRandomDoubleValue(passedUserSpeed, (passedUserSpeed / 2.0) )* 24.0;
	}

}