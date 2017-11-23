/** BowlingGame Score calculator 
 *
 * @author CDT414 Student: 
 * @version 1.0 
 * @date 2016-11-24
 */
public class BowlingGame {
	
	String game = "[n,n][n,n]";
	

	/** BowlingGame Score calculator constructor which require string as input 
	 * @param game Expected format "[n,n][n,n]..[n,n]"
	 * 
	 */	 
	public BowlingGame(String game)
	{	
		//TODO: create constructor for BowlingGame
		this.game = game;
	}
	
	/** getScore method returns a score of current Bowling game or -1 if error
	 * 
	 * @return Integer value of Bowling score, in case of error return value is -1 
	 */
	public int getScore() {
		//TODO: calculate the score of game and return correct value
		int score = 0;
		String arr = game.replace("]", ".");
		arr = arr.replace("[", "");
		String[] frames = arr.split("\\.");
		if(frames.length == 10){
			for(int i=0; i<frames.length; i++){
				if(open(frames[i])){
					String[] array = frames[i].split(",");
					int a = Integer.parseInt(array[0]);
					int b = Integer.parseInt(array[1]);
					score = score+ a+b;
				}
				
			}
			return score;
		}
		
		return(-1);
	}
	
	public boolean open(String game){
		String[] array = game.split(",");
		int a = Integer.parseInt(array[0]);
		int b = Integer.parseInt(array[1]);
		int result = a+b;
		if(result < 10){
			return true;
		}
		else
			return false;
	}
	
	public boolean strike(String game){
		String[] array = game.split(",");
		int a = Integer.parseInt(array[0]);
		int b = Integer.parseInt(array[1]);
		if((a == 10) &&(b == 0)){
			return true;
		}
		return false;
	}
	
	public boolean spare(String game){
		String[] array = game.split(",");
		int a = Integer.parseInt(array[0]);
		int b = Integer.parseInt(array[1]);
		int result = a+b;
		if((a<10)&&(b<10)&&(result == 10)){
			return true;
		}
		return false;
	}
	
	
	
	
}
