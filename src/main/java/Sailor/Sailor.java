package main.java.Sailor;

import java.util.ArrayList;

import main.java.Abstract.*;
import main.java.MenuDisplays;
import main.java.Sailor.*;

enum gender{Male, Female} // enum setting for gender.

interface SailorCalls{
	String GetName();

	void SetName(String passedName);

	String DisplayName();

	String GetSkillTitle(int passedValue);

	String GetNationality();

	String DisplayNationality();

	String GetGender();

	String DisplayGender();

	String GetAssignedPosition();

	void SetAssignedPosition(String passedPosition);

	int GetSkill(int passedValue);

	double GetSalary();

	String DisplaySalary();

	String DisplaySailorVitals();


}

class Skill{ // I would like to implement the ability to have as many or as few skills as wanted.
	private String title;
	private int value;

	/*public Skill(int passedValue){
		this.value = passedValue;
		this.title = "";
	}

	public Skill(String passedTitle){
		this.value = 2;
		this.title = passedTitle;
	}*/

	public Skill(String passedTitle, int passedValue){
		this.value = passedValue;
		this.title = passedTitle;
	}

/*	public Skill(){
		this.value = skillLevelGeneration();
	}*/

	// ***** Skill setter ******
	public void setTitle(String passedTitle){
		this.title = passedTitle;
	}

	public void setSkill(int passedValue){
		this.value = passedValue;
	}

	public void setRandomSkill(){
		this.value = skillLevelGeneration();
	}

	// ***** Skill getter *****
	public String getTitle(){
		return this.title;
	}

	public int getSkill(){
		return this.value;
	}

	// **** Upgrade Downgrade Skill ******
	public void downgradeSkill(){
		this.value--;
	}

	public void upgradeSkill(){
		this.value++;
	}

	public static int skillLevelGeneration(){
		int totalSkill = 0;
		int firstValue = Abstract.GetRandomValue(10, 0);
		for(int i = 0; i < 5; i++){
			totalSkill += firstValue;
		}
		totalSkill = totalSkill / 5;
		return totalSkill;
	}
}

class Salary{
	private double salary;
	private static final double cutDownValue = 0.2;
	
	public Salary(Skillset skillset){
		calculateSalary(skillset);
	}

	public void calculateSalary(Skillset skillset){ //Calculates the sailor salary, not completely great, but coming along.
		double skillValues = 1.0;
		for(int i = 0; i < skillset.getSkillSize(); i++){
			if(skillset.getSkillValue(i) == 0){
				;
			} else {
				skillValues *= (double)skillset.getSkillValue(i);
			}
		}
		this.salary = skillValues * cutDownValue;
	}
	
	public double getSalary(){ //Returns the salary value.
		return Abstract.roundValue(this.salary);
	}
	
}

class AssignedPosition{
	private String position;
	private static final String blankPosition = "None";
	
	public AssignedPosition(){ //Sets the initial position as blank.
		SetPosition(blankPosition);
	}
	
	public void SetPosition(String passedPosition){ // Allows the user to define where the sailor will work.
		this.position = passedPosition;
	}
	
	public String GetPosition(){ //Returns the working position
		return this.position;
	}
}

public class Sailor implements SailorCalls{
	private String Name; // Generated sailor name.
	private gender Gender; // variable that holds gender setting.
	private String Nationality; // Randomly generated nationality.
	private Salary salary; //Randomly generated salary.  Eventually I would like this to coordinate with the skills a sailor has.
	private Skillset skillset;
	private AssignedPosition assignedPosition = new AssignedPosition();
//	private contractDate contractDate; // Contract function for sailor.  Right now randomly generated.
	
	public static class Builder{
		private String Name; // Generated sailor name.
		private gender Gender; // variable that holds gender setting.
		private String Nationality; // Randomly generated nationality.
		private Salary salary; //Randomly generated salary.  Eventually I would like this to coordinate with the skills a sailor has.
		private Skillset skillset;
	//	private contractDate contractDate; // Contract function for sailor.  Right now randomly generated.

		public Builder Name() { 
			Gender();
			if(this.Gender == gender.Male){
				this.Name = MenuDisplays.GetMaleNames(Abstract.GetRandomValue(MenuDisplays.GetMaleNameCount(), 0));
			} else{
				this.Name = MenuDisplays.GetFemaleNames(Abstract.GetRandomValue(MenuDisplays.GetFemaleNameCount(), 0));
			}
			this.Name += " " + MenuDisplays.GetLastNames(Abstract.GetRandomValue(MenuDisplays.GetLastNameCount(), 0));
			return this;
        }
		
		public Builder Gender(){ // builder function that generates random value, for gender setting.  If 1, then male, and if 2, then female.  This is really only for the naming scheme.
			int randomValue = Abstract.GetRandomValue(2, 0);
			if(randomValue == 1){
				this.Gender = gender.Male;
			} else{
				this.Gender = gender.Female;
			}
			return this;
		}
		
	/*	public Builder Contract(){
			this.contractDate = new contractDate();
			return this;
		}*/
			
		public Builder Nationality() { // Builder function that randomly sets the sailor country 
			this.Nationality = MenuDisplays.GetCountry(Abstract.GetRandomValue(MenuDisplays.GetCountryCount(), 0));
			return this;
        }
		
		public Builder Salary() { // Builder function that tries to generate a sane salary value.  Eventually I want it to be handcuffed to sailor skills.
		//	this.Salary = Math.round(Abstract.GetRandomDoubleValue(100, 5) * 100.0) / 100.0;
			this.salary = new Salary(this.skillset);
			return this;
        }
		
		public Builder Skills(){
			this.skillset = new Skillset();
			return this;
		}
		
		public Sailor build() {
			return new Sailor(this);
        }
		
	}
	
	public Sailor(Builder builder) {
		Gender = builder.Gender;
		Name = builder.Name;
		Nationality = builder.Nationality;
		salary = builder.salary;
	//	contractDate = builder.contractDate;
		skillset = builder.skillset;
    }

    @Override
	public void SetName(String passedName){ // I don't really know why I have this, I don't know why you'd change a name.
		this.Name = passedName;
	}

	@Override
	public String GetName(){ // Passthrough function that returns the sailor name.
		return this.Name;
	}

	@Override
	public String DisplayName(){ // Displays sailor name in formatted way.
		return "Name: " + GetName();
	}

	@Override
	public String GetGender(){ // Passthrough function that returns the sailor gender as a String.
		return "" + this.Gender;
	}

	@Override
	public String DisplayGender(){ // Displays sailor gender in presentable way.
		return "Gender: "+  GetGender();
	}

	@Override
	public String GetSkillTitle(int passedValue){ //Returns the skill name of a passed argument.
		return this.skillset.getSkillTitle(passedValue);
	}

	@Override
	public String GetNationality(){ // Passthrough function that returns the sailor nationality.
		return this.Nationality;
	}

	@Override
	public String DisplayNationality(){ // Displays sailor nationality in a presentable way.
		return "Nationality: " + GetNationality();
	}

	@Override
	public double GetSalary(){ // Passthrough function that returns the sailor salary.
		return this.salary.getSalary();
	}

	@Override
	public String DisplaySalary(){ // Displays the salary information in a slightly more presentable way.
		return "Salary: $" + GetSalary();
	}

	@Override
	public int GetSkill(int passedValue){ // Returns the skill value of a passed argument.
		return this.skillset.getSkillValue(passedValue);
	}

/*	public boolean isContractComplete(LocalDate passedDate){
		this.contractDate.isContractComplete(passedDate);
	}*/
	@Override
	public String GetAssignedPosition(){ // Returns the user defined position.
		return this.assignedPosition.GetPosition();
	}

	@Override
	public void SetAssignedPosition(String passedPosition){ // Allows the user to define where the sailor will work.
		this.assignedPosition.SetPosition(passedPosition);
	}
	
/*	public int getContractLength(){ // Returns initial contract length.
		return this.contractDate.getMonthContract();
	}*/
	
/*	public void displayContractLength(){ // Displays the contract length in a slightly more attractive way.
		System.out.println("Contract length: " + getContractLength() + " months" );
	}*/
	
	public void DisplaySkills(){
		for(int i = 0; i < this.skillset.getSkillSize(); i++){
			System.out.println(this.skillset.displaySkillTitleAndValue(i));
		}
	}

	@Override
	public String DisplaySailorVitals(){ // Displays sailor name, gender, nationality,
		return DisplayName() + "\n" + DisplayGender() + "\n" + /*	DisplayNationality(passedSailor); */ DisplaySalary();
	//	displayContractLength();
	}
	
}
