

/**
 * Implementation for swordsman Character
 * @author Jaryl
 */
public final class Swordsman extends AbstractCharacter implements Character{
	
	Swordsman(String charType, String charElement){
		setElement();
		setCharType();
	}
	
	/**
         * 
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
         * Sets element to earth
         */
	
	public void setElement(){
		element = "Earth";
	}
	/**
         * Accessor for level
         * @return 
         */
	public Integer getLevel(){
		return level;
	}
        /**
         * Sets character experience
         */
	
	public void setExperience(){
		experience +=  experience;
	}
        /**
         * 
         * @return experience 
         */
	
	public Integer getExperience(){
		return experience;
	}
        /**
         * Calaculation for next level hp
         * @return hp
         */
	
	public Integer nextLevel(){
		return (int)Math.floor((health/20)^2);
	}
	
       /**
        * Method that calculates hp after attack
        * @return health
        */
        
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
         * add items to character
         * @param name 
         */
	public void addItem(String name){
		items.add("Dual swords");
                items.add("Shield");
                items.add("Mask");
                
	}
	/**
         * add techniques that can be learn to the character
         * @param name 
         */
	public void learnTechnique(String name){
		techniques.add("Super strength");
                techniques.add("agility");
	}
        
      
        
         /**
         * Add Swordsman to Party
         
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
         * Set character type to Swordsman
         */
	
	 public void setCharType(){
		 charType = "Swordsman";
	 }
         
}
	