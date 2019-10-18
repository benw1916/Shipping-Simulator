package main.java.Sailor;

import main.java.Abstract.Abstract;

import java.util.ArrayList;

public class Skillset{ // Daisy-chained to class skill
	private static final String[] skillList = {"Defense", "Loading", "Steering", "Engineering"}; // Core skill list.
	private String[] additionalSkills = {}; // Add additional s kills here.
	private ArrayList<Skill> SailorSkill = new ArrayList<Skill>(); // This holds the skill name and value together.

	// ****** Initializer ******
	public Skillset(){
		for(int i = 0; i < skillList.length; i++){
			this.SailorSkill.add(new Skill(skillList[i], skillLevelGeneration()));
		}
		if(this.additionalSkills.length > 0){
			for(int x = skillList.length; x < (this.skillList.length + this.additionalSkills.length); x++ ){
				this.SailorSkill.add(new Skill(additionalSkills[x], skillLevelGeneration()));
			}
		}
	}

	// ****** Set Skill ******
	public void setSkill(int passedChoice, int passedSkill){
		this.SailorSkill.get(passedChoice).setSkill(passedSkill);
	}

	// ****** Upgrade / Downgrade *****
	public void upgradeSkill(int passedChoice){
		this.SailorSkill.get(passedChoice).upgradeSkill();
	}

	public void downgradeSkill(int passedChoice){
		this.SailorSkill.get(passedChoice).downgradeSkill();
	}

	public void addAdditionalSkill(String passedSkill){
		if(additionalSkills.length == 0){
			additionalSkills[0] = passedSkill;
		} else {
			additionalSkills[additionalSkills.length + 1] = passedSkill;
		}
	}

	public int getSkillSize(){
		return this.SailorSkill.size();
	}

	public static String getSkillList(int passedValue){
		return skillList[passedValue];
	}

	public String getSkillTitle(int passedValue){
		return this.SailorSkill.get(passedValue).getTitle();
	}

	public void getSkillTitles(){
		for(int i = 0; i < this.SailorSkill.size(); i++){
			System.out.println(this.SailorSkill.get(i).getTitle());
		}
	}

	public int getSkillValue(int passedValue){
		return this.SailorSkill.get(passedValue).getSkill();
	}

	public String displaySkillTitleAndValue(int passedValue){
		return getSkillTitle(passedValue) + ": " + getSkillValue(passedValue);
	}

	public int getSkillValue(String skillName){
		for(int i = 0; i < this.SailorSkill.size(); i++){
			if(this.SailorSkill.get(i).getTitle().equalsIgnoreCase(skillName)){
				return this.SailorSkill.get(i).getSkill();
			}
		}
		return 0;
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
