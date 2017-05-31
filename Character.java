/**
 * 
 * @author Jaryl
 *
 *The following is an interface for the program
 * 
 */


public interface Character {
	
	public static final int BASE_HEALTH = 500;

	/**
	 *  powerup calculates the character's powerup from level
	 *  to the next.
	 *  
	 * @param calc
	 * @return
	 */
	Double powerup(Double calc);
	
	/**
	 * bonus calculates powerups from outside the character
	 * object. Examples: Items, teammates, field advantages.
	 * @param bonus - numerical value of bonus gained
	 * @return resulting bonus.
	 */
	Double bonus( Double bonus);
	
	
	/**
	 *  Based on hp, we calculate the experience for next level. 
	 * @param hp - the character health points.
	 * @return xp - experience points to the next level.
	 */
	default Integer nextLevel(Integer hp)
	{
		Integer xp = (int) Math.ceil((hp/20)^2);
		return xp;
	}
}
