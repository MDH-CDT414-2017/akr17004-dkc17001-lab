/** BowlingGame Score calculator 
 *
 * @author CDT414 Student: 
 * @version 1.0 
 * @date 2016-11-24
 */
public class BowlingGame {
	
	 String game;

		/** getScore method returns a score of current Bowling game or -1 if error
		 * 
		 * @return Integer value of Bowling score, in case of error return value is -1 
		 */ 
	 
	 public int getScore() {
		 int s1 = 0;
		 int s2 = 0;
		int score = 0;
			String array = game.replace("]",".");
			array = array.replace("[","");
			String [] frames = array.split("\\.");
			if (frames.length == 10){
				for (int i = 0; i < frames.length; i++) {
					if (open(frames[i])){
						String [] arr = frames[i].split(",");
						s1 = Integer.parseInt(arr[0]);
						s2 = Integer.parseInt(arr[1]);
						score = score + s2 +s1;
					}	
				}
				return score;
			}
			 
			return(-1);
		}
	 
	public boolean open (String a ){
		String [] arr = a.split(",");
		int s1 = Integer.parseInt(arr[0]);
		int s2 = Integer.parseInt(arr[1]);
		int result = s2 +s1;
		if ( result < 10 ){
			return true;
		}else{
			return false;
		}
	}

	public boolean strike(String a){
		String [] arr = a.split(",");
		int s1 = Integer.parseInt(arr[0]);
		int s2 = Integer.parseInt(arr[1]);
		if (s1 == 10  && s2 == 0){
			return true;
		}
		return false ;
	}
	
	public boolean spare (String a ){
		String [] arr = a.split(",");
		int s1 = Integer.parseInt(arr[0]);
		int s2 = Integer.parseInt(arr[1]);
		int result = s2 +s1;
		if(result == 10 && s1<10 && s2<10){
			return true;
		}
		return false;
		
	}
	
	
	 
	
	
	/** BowlingGame Score calculator constructor which require string as input 
	 * @param game Expected format ""
	 * 
	 */	 
	public BowlingGame(String game)
	{	
		this.game = game; 
	}
	
	
	
}
