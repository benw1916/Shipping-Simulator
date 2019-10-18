package main.java;

import main.java.Abstract.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateDisplay{
	
	private final static String startDate = "1992-11-20";
	LocalDate outputDate;
	int totalDays;
	final static int defaultStartDate = 0;	 // When DateDisplay is initialized, 0 is the value it starts with.
	
	public DateDisplay(){ // Constructor; sets the total days to the default value and sets the output date to the default.  
		this.totalDays = defaultStartDate;
		this.outputDate = LocalDate.parse(startDate);
	}

	public void IncreaseDateRandom(){ // If something bad occurs, this will increase the date by a max of 30 days.
		this.totalDays = this.totalDays + Abstract.GetRandomValue(30);
		//this.outputDate.plusDays(this.totalDays);
		IncreaseDay(this.totalDays);
	}

	public void IncreaseMonth(){
		IncreaseMonth(1);
	}
	
	public void IncreaseMonth(int passedMonths){
		this.outputDate.plusMonths(passedMonths);
	}
	
	public void IncreaseDay(){ // Increase the date by one day.
		this.totalDays++;
		//this.outputDate.plusDays(this.totalDays);
		IncreaseDay(this.totalDays);
	}
	
	public void IncreaseDay(int passedDays){
		this.outputDate.plusDays(passedDays);
		
	}
	
	public String GetDate(){ //Displays the date in the MM/dd/yyyy format.
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DatePattern.getPattern());//this.dateDisplayPattern);
		return "" + (this.outputDate.plusDays(this.totalDays).format(formatter));
	}
	
	public String ReturnDate(){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DatePattern.getPattern());//this.dateDisplayPattern);
		return (this.outputDate.plusDays(this.totalDays).format(formatter));
	}
	
}

class contractDate{
	private LocalDate startDate;
	private LocalDate completionDate;
	private int monthContract;
	private static final int defaultContract = 3;
	
	public contractDate(LocalDate passedCurrentDate){
		this.startDate = passedCurrentDate;
		this.monthContract = defaultContract;
		this.completionDate = setCompletionDate(this.startDate, this.monthContract);
	}
	
	public contractDate(LocalDate passedCurrentDate, int passedContractLength){
		this.startDate = passedCurrentDate;
		this.monthContract = passedContractLength;
		this.completionDate = setCompletionDate(this.startDate, this.monthContract);
	}
	
	public contractDate(){
		DateTimeFormatter startFormat = DateTimeFormatter.ofPattern(DatePattern.getPattern());
		this.startDate = LocalDate.parse("01/01/1990", startFormat);
		this.monthContract = generateContract();
		DateTimeFormatter format = DateTimeFormatter.ofPattern(DatePattern.getPattern());
		this.completionDate = LocalDate.parse("01/02/1990", format);
	}
	
	public String getStartDate(){
		return "" + this.startDate;
	}
	
	public void setStartDate(String passedDate){
		String[] splitDate = passedDate.split("");
		boolean exists = false;
		for(int i=0; i < splitDate.length; i++){
			if(splitDate[i].equals('/')){
				exists = true;
			}
		}
		if(exists == false){
			System.err.println("Sorry, this is formatted incorrectly");
		}
		this.startDate.parse(passedDate);
		
	}
	
	public String getCompletionDate(){
		return "" + this.completionDate;
	}
	
	/*public LocalDate formatDate(LocalDate passedDate){
		DateTimeFormatter startFormat = DateTimeFormatter.ofPattern(DatePattern.getPattern());
		return LocalDate.parse(passedDate, startFormat);
	}*/
	
	public void setCompletionDate(String passedDate){
				String[] splitDate = passedDate.split("");
		boolean exists = false;
		for(int i=0; i < splitDate.length; i++){
			if(splitDate[i].equals('/')){
				exists = true;
			}
		}
		if(exists == false){
			System.err.println("Sorry, this is formatted incorrectly");
		}
		this.completionDate.parse(passedDate);
	}
	
	public void setCompletionDate(LocalDate passedDate){
		this.completionDate = passedDate;
	}
	
	public LocalDate setCompletionDate(LocalDate passedDate, int monthContract){
		return this.completionDate.plusMonths(monthContract);
	}
	
	public int getMonthContract(){
		return this.monthContract;
	}
	
	public void setMonthContract(int passedValue){
		this.monthContract = passedValue;
	}
	
	public int generateContract(){
		return Abstract.GetRandomValue(60, 3);
	}
	
/*	public boolean isContractComplete(LocalDate currentDate){
		if(this.completionDate < formatDate(currentDate) ){
			return true;
		} else {
			return false;
		}
	}*/
	
}

class DatePattern{
	private final static String datePattern = "MM/dd/yyyy"; // Initially starts as: Year -- Month -- Day  Changed to MM/DD/YYYY
	
	public static String getPattern(){
		return datePattern;
	}
	
}