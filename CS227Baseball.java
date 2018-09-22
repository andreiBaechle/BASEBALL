package hw2;

/**
 * Simplified model of American baseball.
 *
 * @author ANDREI BAECHLE
 */
public class CS227Baseball
{
  /**
   * Constant indicating that a pitch results in a ball.
   */
  public static final int BALL = 0;
  
  /**
   * Constant indicating that a pitch results in a strike.
   */
  public static final int STRIKE = 1;
  
  /**
   * Constant indicating that a pitch results in an out from a fly ball.
   */
  public static final int POP_FLY = 2;
  
  /**
   * Number of strikes causing a player to be out.
   */
  public static final int MAX_STRIKES = 3;
  
  /**
   * Number of balls causing a player to walk.
   */
  public static final int MAX_BALLS = 4;
  
  /**
   * Number of outs before the teams switch.
   */
  public static final int MAX_OUTS = 3;
  
  private int inning = 1;
  private int innings;
  private boolean isOver;
  private boolean top = true;
  private int outs = 0;
  private int score1 = 0;
  private int score0 = 0;
  private int strikes = 0;
  private int balls = 0;
  private boolean first = false;
  private boolean second = false;
  private boolean third = false;
  
  
  
  
/**
 * Constructs a game that has the given number of innings and starts at the top of inning 1.
 * @param givenNumInnings
 */
  public CS227Baseball( int givenNumInnings)
  {
	  innings = givenNumInnings;
	  if (inning > innings)
	  {
		  isOver = true;
	  }
  }
  
/**
 * Advances all players on base by one base, updating the score if there is currently a player on third.  
 * @param newPlayerOnFirst
 */
  public void advanceRunners(boolean newPlayerOnFirst) 
  {
	  if (third == true)
	  {
		  if (top) score0++;
		  else score1++;
		  third = false;
	  }
	  if (second == true)
	  {
		  third = true;
		  second = false;
	  }
	  if (first == true)
	  {
		  second = true;
	  }
	  if (newPlayerOnFirst)
	  {
		  first = true;  
	  } 
  }

  /**
   * Returns the number of balls for the current batter.
   * @return
   */
  public int getBalls() 
  {
	  return balls;
  }
  
  /**
   * Returns the current inning.
   * @return
   */
  public int getInning() 
  {
	  return inning;
  }
  
  /**
   * Returns the number of outs for the current batter.
   * @return
   */
  public int getOuts() 
  {
	  return outs;
  }
  
  /**
   * Returns the score of the indicated team, where an argument of true indicates
   *  team 0 (batting in the top of the inning) and an argument of false indicates team 1 (batting in the bottom of the inning).
   * @param team0
   * @return
   */
  public int getScore (boolean team0) 
  {
	  if (team0) {
		  return score0;
	  }
	  else 
	  {
		  return score1;
	  }
  }
  
  /**
   * Returns the number of strikes for the current batter.
   * @return
   */
  public int getStrikes()
  {
	  return strikes;
  }
  
  /**
   * Returns true if the game is over, false otherwise.
   * @return
   */
  public boolean isOver() 
  {
	  
		  return isOver;
  }
  
  /**
   * Returns true if it's the first half of the inning (team 0 is at bat).
   * @return
   */
  public boolean isTop() 
  {
	  return top;
  }
  
  /**
   * Pitch not resulting in a hit.
   * @param outcome
   */
  public void pitch(int outcome)
  {
	  if (outcome == BALL)	  
	  {
		 balls++;
	  }
	  else if (outcome == STRIKE)
	  {
		  strikes++;
		  if (strikes == 3) {
			  strikes = 0;
			  balls = 0;
			  outs++;
		  }
	  }
	  else if (outcome == POP_FLY)
	  {
		  strikes = 0;
		  balls = 0;
		  outs++;
	  }
	  if (balls == 4)
		 {
			 advanceRunners(true);
			 balls = 0;
			 strikes = 0;
		 }
	  if (outs == 3)
	  {
		  if (top == true)
		  {
			  top = false;
		  }
		  else if (top == false)
		  {
			  inning++;
			  if (inning > innings)
			  {
				  isOver = true;
			  }
			  top = true;
		  }
		  outs = 0;
	  }
	  
  }
  
  /**
   * Pitch resulting in a hit where no player is out.
   * @param numBass
   */
  public void pitchWithHit(int numBass) 
  { 
	    if (numBass == 4)
	  {
	    	 if (top) score0++;
			  else score1++;
	    
		  if (first)
		  {
			  if (top) score0++;
			  else score1++;
			  first = false;
		  }
		  if (second)
		  {
			  if (top) score0++;
			  else score1++;
			  second = false;
		  }
		  if (third)
		  {
			  if (top) score0++;
			  else score1++;
			  third = false;
		  }
		
	  }
	    if (numBass == 3)
	    {
	    	if (third)
	    	{
	    		if (top) score0++;
				  else score1++;
	    	}
	    	if (second)
	    	{
	    		if (top) score0++;
				  else score1++;
	    		second = false;
	    	}
	    	if (first)
	    	{
	    		if (top) score0++;
				  else score1++;
	    		first = false;
	    	}
	    	third = true;
	    }
	    if (numBass == 2)
	    {
	    	if (third)
	    	{
	    		if (top) score0++;
				  else score1++;
	    		third = false;
	    	}
	    	if (second)
	    	{
	    		if (top) score0++;
				  else score1++;
	    	}
	    	if (first)
	    	{
	    		third = true;
	    		first = false;
	    	}
	    	second = true;
	    }
	    if (numBass == 1)
	    {
	    	if (third)
	    	{
	    		if (top) score0++;
				  else score1++;
	    		third = false;
	    	}
	    	if (second)
	    	{
	    		third = true;
	    		second = false;
	    	}
	    	if (first)
	    	{
	    		second = true;
	    		first = true;
	    	}
	    	first = true;
	    	
	    }
	    strikes = 0;
	    balls = 0;
  }
  
  /**
   * Pitch resulting in a hit and a possible out.
   * @param numBass
   * @param whichBaseFielded
   */
  public void pitchWithHitAndOut(int numBass, int whichBaseFielded)
  {
	    if (numBass == 4)
	    {
	    	if(whichBaseFielded == 4)
	    	{
	    		outs++;
	    	}
	    	if (third)
	    	{
	    		if (top) score0++;
				  else score1++;
	    		if (whichBaseFielded == 3)
	    		{
					  third = false;
					  outs++;
	    		}
	    	
	    		if (whichBaseFielded == 2)
	    		{
					  second = false;
	    		}
	    		if (whichBaseFielded == 1)
	    		{
					  first = false;
	    		}
	    	if (second)
	    	{
	    		if (top) score0++;
				  else score1++;
	    		second = false;
	    		if (whichBaseFielded == 3)
	    		{
					  third = false;
	    		}
	    		if (whichBaseFielded == 2)
	    		{
					  second = false;
	    		}
	    	
	    		if (whichBaseFielded == 1)
	    		{
					  first = false;
	    	}
	    	if (first)
	    	{
	    		if (top) score0++;
				  else score1++;
	    		first = false;
	    		if (whichBaseFielded == 3)
	    		{
					  third = false;
	    		}
	    		if (whichBaseFielded == 2)
	    		{
					  second = false;
	    		}
	    		if (whichBaseFielded == 1)
	    		{
					  first = false;
				  }
	    }
	    }
	    }
	    }
	    if (numBass == 3)
	    {
	    	if (third)
	    	{
	    		if (top) score0++;
				  else score1++;
	    		if (whichBaseFielded == 3)
	    		{
					  third = false;
					  outs++;
	    		}
	    	
	    		if (whichBaseFielded == 2)
	    		{
					  second = false;
	    		}
	    		if (whichBaseFielded == 1)
	    		{
					  first = false;
	    		}
	    	if (second)
	    	{
	    		if (top) score0++;
				  else score1++;
	    		second = false;
	    		if (whichBaseFielded == 3)
	    		{
					  third = false;
	    		}
	    		if (whichBaseFielded == 2)
	    		{
					  second = false;
	    		}
	    	
	    		if (whichBaseFielded == 1)
	    		{
					  first = false;
	    	}
	    	if (first)
	    	{
	    		if (top) score0++;
				  else score1++;
	    		first = false;
	    		if (whichBaseFielded == 3)
	    		{
					  third = false;
	    		}
	    		if (whichBaseFielded == 2)
	    		{
					  second = false;
	    		}
	    		if (whichBaseFielded == 1)
	    		{
					  first = false;
				  }
	    		
	    	
	    	third = true;
	    }
	    }
	    	}
	    }
	    if (numBass == 2)
	    {
	    	if (third)
	    	{
	    		if (top) score0++;
				  else score1++;
	    		third = false;
	    		if (whichBaseFielded == 3)
	    		{
					  third = false;
	    		}
	    		if (whichBaseFielded == 2)
	    		{
					  second = false;
	    		}
	    		if (whichBaseFielded == 1)
	    		{
					  first = false;
	    		}
	    		
	    	
	    	}
	    	if (second)
	    	{
	    		if (top) score0++;
				  else score1++;
	    		if (whichBaseFielded == 3)
	    		{
					  third = false;
	    		}
	    		if (whichBaseFielded == 2)
	    		{
					  second = false;
					  outs++;
	    		}
	    		if (whichBaseFielded == 1)
	    		{
					  first = false;
	    		}
	    		
	    	}
	    	if (first)
	    	{
	    		third = true;
	    		first = false;
	    		if (whichBaseFielded == 3)
	    		{
					  third = false;
					  outs++;
	    		}
	    		if (whichBaseFielded == 2)
	    		{
					  second = false;
	    		}
	    		if (whichBaseFielded == 1)
	    		{
					  first = false;
	    		}
	    	}
	    	second = true;
	    }
	    if (numBass == 1)
	    {
	    	if (third)
	    	{
	    		if (top) score0++;
				  else score1++;
	    		third = false;
	    		if (whichBaseFielded == 3)
	    		{
					   third= false;
	    		}
	    		if (whichBaseFielded == 2)
	    		{
					  second = false;
	    		}
	    		if (whichBaseFielded == 1)
	    		{
					  first = false;
	    		}
	    	}
	    	if (second)
	    	{
	    		third = true;
	    		second = false;
	    		if (whichBaseFielded == 3)
	    		{
					  third = false;
	    		}
	    		if (whichBaseFielded == 2)
	    		{
					  second = false;
	    		}
	    		if (whichBaseFielded == 1)
	    		{
					  first = false;
	    		}
	    	}
	    	if (first)
	    	{
	    		second = true;
	    		first = true;
	    		if (whichBaseFielded == 3)
	    		{
					  third = false;
	    		}
	    		if (whichBaseFielded == 2)
	    		{
					  second = false;
	    		}
	    		if (whichBaseFielded == 1)
	    		{
	    			  outs++;
					  first = false;
	    		
	    		}
	    	}
	    	first = true;
	    	
	    	}
	    strikes = 0;
	    balls = 0;
	    	}
	    	
  /**
   * Returns whether there is a player on first base.
   * @return
   */
  public boolean playerOnFirst() {
	  
		  return first;
  }
  
  /**
   * Returns whether there is a player on second base.
   * @return
   */
  public boolean playerOnSecond() {
	  
		  return second;
  }
  
  /**
   * Returns whether there is a player on third base.
   * @return
   */
  public boolean playerOnThird() {
	  
		  return third;
  }
  
  /**
   * Returns a three-character string representing the players on base, 
   * in the order first, second, and third, where 'X' indicates a player 
   * is present and 'o' indicates no player.  For example, the string "XXo" 
   * means that there are players on first and second but not on third.
   * @return
   *   three-character string showing players on base
   */
  public String getBases()
  {
    return (playerOnFirst() ? "X" : "o") +
        (playerOnSecond() ? "X" : "o") +
        (playerOnThird() ? "X" : "o");
  }

  /**
   * Returns a one-line string representation of the current game state.
   * The format is:
   * <pre>
   *    ooo Inning:1 (T) Score:0-0 Balls:0 Strikes:0 Outs:0
   * </pre>
   * The first three characters represent the players on base as returned by 
   * the <code>getBases()</code> method. The 'T' after the inning number indicates 
   * it's the top of the inning, and a 'B' would indicate the bottom.
   * 
   * @return
   *   one-line string representation of the game state
   */
  public String toString()
  {
    String bases = getBases();
    String topOrBottom = (isTop() ? "T" : "B");
    String fmt = "%s Inning:%d (%s) Score:%d-%d Balls:%d Strikes:%d Outs:%d";
    return String.format(fmt, bases, getInning(), topOrBottom, getScore(true), getScore(false), getBalls(), getStrikes(), getOuts());
  }

  /**
   * Returns a multi-line string representation of the current game state.
   * The format is:  
   * <pre>
   *     o - o    Inning:1 (T)
   *     |   |    Score:0-0
   *     o - H    Balls:0 Strikes:0 Outs:0
   * </pre>
   * The 'T' after the inning number indicates it's the top of the inning, 
   * and a 'B' would indicate the bottom.
   * @return
   *   multi-line string representation of current game state
   */
  public String toDisplayString()
  {
    String firstChar = (playerOnFirst() ? "X" : "o");
    String secondChar = (playerOnSecond() ? "X" : "o");
    String thirdChar = (playerOnThird() ? "X" : "o");
    String topOrBottom = (isTop() ? "T" : "B");
    String firstLine = String.format("%s - %s    Inning:%d (%s)\n", secondChar, firstChar, getInning(), topOrBottom);
    String secondLine = String.format("|   |    Score:%d-%d\n", getScore(true), getScore(false));
    String thirdLine = String.format("%s - H    Balls:%d Strikes:%d Outs:%d\n", thirdChar, getBalls(), getStrikes(), getOuts());
    return firstLine + secondLine + thirdLine;   
  }
  
}
