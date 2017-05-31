

/**
 * Implementation for Engineer Character 
 * @author Jaryl
 */

 
public final class Engineer extends AbstractCharacter implements Character{
	
	Engineer(String charType, String charElement){
		setElement();
		setCharType();
	}
	/**
         * 
         * @param calc
         * @return return calc
         */
        @Override
	public Double powerup(Double calc){
		return calc = bonus( .1);
	}
	
	/**
         * 
         * @param bonus
         * @return bonus
         */
        @Override
        public Double bonus( Double bonus){
		return bonus;
	}
        /*
         * Set character element to thunder
         */
	
	public void setElement(){
		element = "thunder";
	}
	/**
         * Accessor for Level
         * @return level
         */
	public Integer getLevel(){
		return level;
	}
        /**Calculation for character experience 
         * Mutator for experience
         */
	
	public void setExperience(){
		experience +=  experience;
	}
	/**
         * Accessor for experience
         * @return experience  
         */
	public Integer getExperience(){
		return experience;
	}
	
        /**
         * Calculates next level hp
         * @return hp
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
         * Adds default items to the character
         * @param name 
         */
	
        public void addItem(String name){
		items.add("Shield");
                items.add("Tool Box");
                items.add ("Super boots");
	}
        
  
	
	/**
         * Add multiple techniques to the character
         * @param name 
         */
        public void learnTechnique(String name){
		techniques.add("Super sprinting");
                techniques.add("Super hearing");
	}
	/**
         * Adds engineer to the Party
         */
	public void addEngineerToParty(){
		Engineer e1 = new Engineer("Engineer","Thunder");
                party.add(e1);
		}
        
        /**
         * Adds huntress to the party
         */
         public void addHuntressToParty(){
		Huntress h1 = new Huntress("Huntress","wind");
		party.add(h1);
        }
         
         /**
          * Adds mariner to the party
          */
         public void addMarinerToParty(){
		Mariner m1 = new Mariner("Mariner","Water");
		party.add(m1);
	}
         
         /**
          * Adds commander to the party
          */
          public void addCommanderToParty(){
		Commander c1 = new Commander("Commander","fire");
		party.add(c1);
	}
          
          /**
           * Adds swordsman to the party
           */
          public void addSwordsmantoParty(){
		
               Swordsman s1 = new Swordsman("Swordsman","Earth");
               party.add (s1);
		}
	
        /**
         * Set character type
         */
	 public void setCharType(){
		 charType = "Engineer";
	 }
	
}

