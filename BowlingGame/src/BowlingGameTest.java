/** BowlingGameTest 
 *
 * @author CDT414 Student:
 * @version 1.0 
 * @date 2016-11-24
 */
import junit.framework.TestCase;

/** BowlingGame Score calculator test cases 
 *  
 */	 
public class BowlingGameTest extends TestCase {
	
        
	/** test01 
	 * 	
	 *  If no game is provided, score should be -1 (error)   
	 */	     
	public void test01() {
        BowlingGame bowlingGame = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
        assertEquals(81, bowlingGame.getScore());
    }	
	
	public void testOpen(){
		BowlingGame bg = new BowlingGame("");
		assertEquals(true, bg.open("1,3"));
	}
	
	public void testStrike(){
		BowlingGame bg = new BowlingGame("");
		assertEquals(true, bg.strike("10,0"));
	}
	
	public void testSpare(){
		BowlingGame bg = new BowlingGame("");
		assertEquals(true, bg.spare("6,4"));
	}
	
	//TODO: Add more test cases below...
	
}