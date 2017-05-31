

/**
 * Implementation for Mariner
 * @author Jaryl
 */
public final class Mariner extends AbstractCharacter implements Character{
	
	Mariner(String charType, String charElement){
		setElement();
		setCharType();
	}
	/**
         * Power bonus calculation 
         * @param calc
         * @return 
         */
        @Override
	public Double powerup(Double calc){
		return calc = bonus( .1);
	}
        /**
         * 
         * @param bonus
         * @return 
         */
	
        @Override
	public Double bonus( Double bonus){
		return bonus;
	}
        /**
         * Sets character element to Water
         */
	
	public void setElement(){
		element = "Water";
	}
        /**
         * 
         * @return level
         */
	
	public Integer getLevel(){
		return level;
	}
	/**
         * Calculation for next level experience
         */
	public void setExperience(){
		experience +=  experience;
	}
        /**
         * Accessor for experience
         * @return 
         */
	
	public Integer getExperience(){
		return experience;
	}
	/**
         * 
         * @return next level hp
         */
	public Integer nextLevel(){
		return (int)Math.floor((health/20)^2);
	}
	
        /**
        * Calculates health after damage
        * @return health
        */
           
        
        public Integer oppAttack () {
            health = attack - defense;
            return health;
            }
        
        public Integer oppAttack( Integer health){
		return health;
	}
        
        /**
         * Setter and getter for money
         * Assigns each character with 20 coins
         */
          public void setMoney (){
                money = 20;
            }
        public Integer getMoney (){
               return money;
            }  
            
        /**
         * Add default items to character
         * @param name 
         */
	public void addItem(String name){
		items.add("Boat");
                items.add("Poision Dart");
                items.add("Water thrower");
                }
	/**
         * Add techniques to the character 
         * @param name 
         */
	public void learnTechnique(String name){
		techniques.add("Underwater breathing");
                techniques.add("Super hearing");
	}
	
	/**
         * Adds mariner to the party
         */
        public void addMarinerToParty(){
		Mariner m1 = new Mariner("Mariner","Water");
		party.add(m1);
	}
        
        /**
         * Adds swordsman to the party
         */
        public void addSwordsmantoParty(){
		
               Swordsman s1 = new Swordsman("Swordsman","Earth");
               party.add (s1);
		
	}
        
        /**
         * Adds engineer to the party
         */
        public void addEngineerToParty(){
		Engineer e1 = new Engineer("Engineer","Thunder");
                party.add(e1);
		}
        
        /**
         * adds huntress to party
         */
        public void addHuntressToParty(){
		Huntress h1 = new Huntress("Huntress","wind");
		party.add(h1);
        }
        
        /**
         * Adds Commander to party
         */
         public void addCommanderToParty(){
		Commander c1 = new Commander("Commander","fire");
		party.add(c1);
	}
        
           
        /**
         * Sets character type to Mariner
         */
	
	 public void setCharType(){
		 charType = "Mariner";
	 }
}
	