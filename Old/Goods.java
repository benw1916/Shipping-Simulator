package src.main.java;

public class Goods{
	private int[] availableContainers = new int[2];
	/*** Amount of containers --> price per container ***/
	
	private int maximumAmountOfContainersInOut = 200;
	private int maximumValueOfContainersInOut = 50;
	
	private int maximumContainerPrice = 500;
	
	/*  private int[] buildingMaterialContainers = new int[2];
	private int[] consumerGoodsContainers = new int[2];
	private int[] durableGoodsContainers = new int[2];*/

	public Goods(){
		this.availableContainers[0] = Abstract.getRandomValue(1000);
		this.availableContainers[1] = Abstract.getRandomValue(maximumContainerPrice, 20);
	}

	public void iteration(User playerObject){
		int goodsChoice = 0;
		do{
			containerPriceAndAmountSanityCheck(playerObject);
			increaseDecreaseContainerPrice();
			increaseDecreaseContainerAmount();
			containerOutput();
			containerPrice();
			goodsMenu();
			System.out.print(": ");
			goodsChoice = parseGoodsMenu(Abstract.scannerInt(), playerObject);
		}while(goodsChoice != 3);
		//playerObject.setCurrentContainers(50);
	//	loadedContainers(Abstract.scannerInt(), playerObject);
	//	containerOutput();
		//System.out.println(playerObject.getCurrentContainers());
	}

	private void goodsMenu(){
		Abstract.rotatePorts(MenuDisplays.getGoodsMenu());
	}
	
	private int parseGoodsMenu(int userInputGoodsMenuDecision, User playerObject){
		switch(userInputGoodsMenuDecision){
			case 1: 
			//Load unload containers
				//loadedContainers(Abstract.scannerInt(), playerObject);
				containerMenu(playerObject);
				return 1;
			case 2:
			//Ship upgrade
				System.out.println("Ship upgrade here");
				new ShoreSide();
				return 2;
			case 3:
			//Leave port
				return 3;
			default: 
				System.out.println("That is not an acceptable answer");
				iteration(playerObject);
				return 0;
		}

	}
  
	private void containerOutput(){
		System.out.println("Containers in Port: " + this.availableContainers[0]);
	}

	private void containerPrice(){
		System.out.println("Current container price: $" + this.availableContainers[1] + ".00");
	}
  
	private void containerPriceAndAmountSanityCheck(User playerObject){
		if(this.availableContainers[0] < 30){
			this.availableContainers[0] = playerObject.getMaximumContainers();
		}
		if(this.availableContainers[1] < 20){
			this.availableContainers[1] = maximumContainerPrice;
		}
	}

	private void increaseDecreaseContainerAmount(int daysPassed){
		int dayCount = 0;
		while(daysPassed < dayCount){
			int dailyUpDown = Abstract.getRandomValue(100);
			if(dailyUpDown >= 51){
				this.availableContainers[0] += Abstract.getRandomValue(maximumValueOfContainersInOut);
			} else{
				this.availableContainers[0] -= Abstract.getRandomValue(maximumValueOfContainersInOut);
			}
		dayCount++;
		}
	}
	
	private void increaseDecreaseContainerAmount(){
		int dailyUpDown = Abstract.getRandomValue(100);
		if(dailyUpDown >= 51){
			this.availableContainers[0] += Abstract.getRandomValue(maximumAmountOfContainersInOut);
		} else{
			this.availableContainers[0] -= Abstract.getRandomValue(maximumAmountOfContainersInOut);
		}
	}
	
	private void increaseDecreaseContainerPrice(int daysPassed){
		int dayCount = 0;
		while(daysPassed < dayCount){
			int dailyUpDown = Abstract.getRandomValue(100);
			if(dailyUpDown >= 51){
				this.availableContainers[1] += Abstract.getRandomValue(maximumValueOfContainersInOut);
			} else{
				this.availableContainers[1] -= Abstract.getRandomValue(maximumValueOfContainersInOut);
			}
		dayCount++;
		}
	}
  
	private void increaseDecreaseContainerPrice(){
		int dailyUpDown = Abstract.getRandomValue(100);
		if(dailyUpDown >= 51){
			this.availableContainers[1] += Abstract.getRandomValue(maximumValueOfContainersInOut);
		} else{
			this.availableContainers[1] -= Abstract.getRandomValue(maximumValueOfContainersInOut);
		}
	}

	private void containerMenu(User playerObject){
		int containerChoice = 0;
		do{
			System.out.println("Maximum Containers allowed on Ship: " + playerObject.getMaximumContainers());
			System.out.println("Current containers on ship: " + playerObject.getCurrentContainers());
			System.out.println("Load or Unload");
			Abstract.rotatePorts(MenuDisplays.getContainerMenu());
			containerChoice = containerParser(Abstract.scannerInt(), playerObject);
		}while(containerChoice != 3);
	}
	
	private int containerParser(int userDecision, User playerObject){
		switch(userDecision){
			case 1:
				//Load Containers
				loadContainers(playerObject);
				return 1;
				//break;
			case 2:
				//Unload Containers
				unloadContainers(playerObject);
				return 2;
				//break;
			case 3:
				//Exit
				return 3;
				//break;
		}
		playerObject.getContainerReadout();
		return 0;
	}
	
	private void loadContainers(User playerObject){
		if(playerObject.isFullShip() == true){
			System.out.println("Your ship already has a full load!");
		} else {
			System.out.print("How many containers would you like to load: ");
			int loadRequest = Abstract.scannerInt();
			if((loadRequest - playerObject.getCurrentContainers()) >= 0){
				playerObject.setCurrentContainers((loadRequest + playerObject.getCurrentContainers()));
			}
		}
	}
	
	private void unloadContainers(User playerObject){
		if(playerObject.isEmptyShip() == true){
			System.out.println("Your ship is already empty!");	
		} else{
			System.out.print("How many containers would you like to unload: ");
			int unloadRequest = Abstract.scannerInt();
			if((unloadRequest + playerObject.getCurrentContainers()) < playerObject.getMaximumContainers()){
				playerObject.setCurrentContainers((unloadRequest - playerObject.getCurrentContainers()));
			}
			containerPayout(unloadRequest);
		}
	}
	
	private void containerPayout(int userDefinedUnloadedContainers){
		System.out.println("Containers are currently being unloaded at $" + availableContainers[1] + " per container");
		System.out.println("You made $" + (userDefinedUnloadedContainers * availableContainers[1]) );
	}
	
	/*private void loadedContainers(int userGeneratedContainersPickedup, User playerObject){
		if(this.availableContainers[0] - userGeneratedContainersPickedup > 0){
			this.availableContainers[0] = (this.availableContainers[0] - userGeneratedContainersPickedup);
			int alreadyLoadedCurrentContainers = playerObject.getCurrentContainers();
			playerObject.setCurrentContainers(alreadyLoadedCurrentContainers + userGeneratedContainersPickedup);
		}
	}*/
}
