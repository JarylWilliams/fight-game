/**  Implementation for the Huntress Character.
 *   
 * @author Jaryl
 *
 */
public final class Huntress extends AbstractCharacter implements Character{
	
	Huntress(String charType, String charElement){
		setElement();
		setCharType();
	}
	/**
         * Calculates double bonus
         * @param calc
         * @return calc
         */
        @Override
	public Double powerup(Double calc){
	return calc = bonus (.1);	
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
	
	/**
         * Sets character element to wind
         */
        public void setElement(){
		element = "wind";
	}
	
	/**
         * Accessor method for level
         * @return level
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
         * accessor method for experience
         * @return 
         */
	public Integer getExperience(){
		return experience;
	}
	/**
         * Calculates next level health
         * @return health
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
         * adds default items to character
         * @param name 
         */
	
	public void addItem(String name){
		items.add("Bow");
                items.add("Sword");
                items.add ("Mana pack");
	}
	
        /**
         * adds techniques to the character
         * @param name 
         */
	public void learnTechnique(String name){
		techniques.add("Mana Stealing");
                techniques.add("Super hearing");
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
           * Adds Engineer to the party
           */
          public void addEngineerToParty(){
		Engineer e1 = new Engineer("Engineer","Thunder");
                party.add(e1);
		}
	
        /**
         * set character type to Huntress
         */
	 public void setCharType(){
		 charType = "Huntress";
	 }
	
}
