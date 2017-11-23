/** BowlingGameTest 
 *
 * @author CDT414 Student:
 * @version 1.0 
 * @date 2016-11-24
 */
import org.junit.Before;

import junit.framework.TestCase;

/** BowlingGame Score calculator test cases 
 *  
 */	 
public class BowlingGameTest extends TestCase {
        
	/** test01 
	 * 	
	 *  If no game is provided, score should be -1 (error)   
	 */	    

	
	public void testOpenScore() {
        BowlingGame bowlingGame = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
        assertEquals(81, bowlingGame.getScore());
    }	
	

	//TODO: Add more test cases below...
	
	public void testOpen() {
        BowlingGame bowlingGame = new BowlingGame("");
        assertEquals(true, bowlingGame.open( "1,3" ));
    }	
	public void testStrike() {
        BowlingGame bowlingGame = new BowlingGame("");
        assertEquals(true, bowlingGame.strike( "10,0" ));
    }	
	public void testSpare() {
        BowlingGame bowlingGame = new BowlingGame("");
        assertEquals(true, bowlingGame.spare( "8,2" ));
    }	
	
	
	
	
	
}