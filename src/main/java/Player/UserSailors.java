package main.java.Player;

import main.java.Sailor.Sailor;
import main.java.Sailor.Skillset;

import java.util.ArrayList;

public class UserSailors extends UserDamage{ // This extension controls the sailors hired for the ship.
	private ArrayList<Sailor> PlayerSailors = new ArrayList<Sailor>(); //This is the big arraylist that holds the current player's sailors.
	private main.java.Sailor.Skillset Skillset; // This variable holds the skill name and combined value.
	double totalSalary = 0.0; // This holds the total salary owed weekly
	
	public UserSailors(){ // Constructor starts a new version of skillset and jumps into recalculating the levels.
		this.Skillset = new Skillset();
		recalculateLevels();
	}
	
	public void addSailor(Sailor passedCrewmen){ // This is the function that is used when a sailor is added to the player's ship.
		this.PlayerSailors.add(passedCrewmen);
	}
	
	public void removeSailor(int passedValue){ // Function that is used when a sailor is removed from the ship.
		this.PlayerSailors.remove(passedValue);
	}
	
	public void recalculateLevels(){ // This recalculates the total salary cost and total skill values of everyone aboard.  
		collectSkillValues();
		collectSalaryValue();
	}

	private void collectSalaryValue(){ //Gathers every sailor's salary requirements.  
		for(int i = 0; i <= this.PlayerSailors.size() - 1; i++){
			this.totalSalary = this.PlayerSailors.get(i).GetSalary();
		}
	}
	
	private void collectSkillValues(){
		for(int i = 0; i < Skillset.getSkillSize(); i++){
			int cumulativeValue = 0;
			for(int x = 0; x < this.PlayerSailors.size(); x++){
				cumulativeValue += this.PlayerSailors.get(x).GetSkill(i);
			}
			this.Skillset.setSkill(i, cumulativeValue);
		}
	}
	
	public double getSalaryTotal(){ // Returns salary value as a double.
		return this.totalSalary;
	}
	
	public Sailor getSailors(int passedValue){ // Returns the specific sailor package, specified by argument.
		return this.PlayerSailors.get(passedValue);
	}
	
	public int getSailorCount(){ // Returns the number of sailors aboard.  
		return this.PlayerSailors.size();
	}
	
	public void displaySailorCount(){ // Not much different from getSailorCount, returns total sailor count in a presentable way.
		System.out.println("Sailors aboard: " + getSailorCount());
	}
	
	public void DisplayTotals(){ // Displays the total sailors aboard, weekly salary costs, and total skill levels.  
		System.out.println("\n----- Skill and Salary Totals -----");
		displaySailorCount();
		System.out.println("Weekly Salary Spend: $" + getSalaryTotal());
		for(int i = 0; i < new Skillset().getSkillSize(); i++){
			System.out.println("Total " + this.Skillset.getSkillTitle(i) + ": " + this.Skillset.getSkillValue(i));
		}
		System.out.println("\n");
	}
	
	public boolean AnySailors(){ // Sanity check to see if you have any sailors aboard.
		if(getSailorCount() == 0){
			return false;
		} else {
			return true;
		}
	}

	/*public void checkSailors(){ // This function checks whether your sailors contracts are complete.
		if(getSailorCount() != 0){
			for(int i = 0; i < getSailorCount(); i++){
				isContractComplete(i, GetDate());
			}
		//	GetDate();
		}
	}*/

/*	public boolean isContractComplete(int passedValue, LocalDate passedDate){
		this.PlayerSailors.get(passedValue).isContractComplete(passedDate);
	}*/
}