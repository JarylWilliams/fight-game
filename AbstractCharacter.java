/** The following is an AbstractCharacter class
 *  @author Jaryl
 *    
 */
import java.util.*;

public abstract class AbstractCharacter implements Character {
	
	/**
         * getter for health
         * @return health
         */
    
    
    public Integer getHealth()
	{
		return health;
	}
    /**
     * Setter for health
     * @param health 
     */

	public  void setHealth(Integer health)
	{
		this.health = health;
	}
        /**
         * getter for attack
         * @return attack
         */
        public Integer getAttack()
	{
		return attack;
	}

        /**
         * setter for attack
         * @param attack 
         */
	public  void setAttack(Integer attack)
	{
		this.attack = attack;
	}
        /**
         * getter for defense
         * @return defense
         */
        public Integer getDefense()
	{
		return defense;
	}
        /**
         * setter for defense
         * @param defense 
         */

	public  void setDefense(Integer defense)
	{
		this.defense = defense;
	}
	protected ArrayList<String> items;
	protected ArrayList<String> techniques;
	protected ArrayList<AbstractCharacter> party;
	protected Integer health, experience, level, attack, defense,money;
	protected String element, charType;
}
