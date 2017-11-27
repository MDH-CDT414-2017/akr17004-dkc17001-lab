import sun.security.util.Length;

/**
 * BowlingGame Score calculator
 *
 * @author CDT414 Student: dkc17001
 * @version 1.0
 * @date 2016-11-24
 */
public class BowlingGame {

	String game;
	
	/** BowlingGame Score calculator constructor which require string as input 
	 * @param game Expected format "[n,n][n,n]..[n,n]"
	 * 
	 */	 
	public BowlingGame(String game){	
		//TODO: create constructor for BowlingGame
		this.game = game;
	}

	/**
	 * getScore method returns a score of current Bowling game or -1 if error
	 * 
	 * @return Integer value of Bowling score, in case of error return value is
	 *         -1
	 */
	
	public int getScore() {
		int s1 = 0;
		int s2 = 0;
		int score = 0;
		if (verifyStringFormat(game) || verifyLastSpareStringFormat(game) || verifyLastStrikeStringFormat(game)){
			
			String arr = game.replace("]", ".");
			arr = arr.replace("[", "");
			String[] frames = arr.split("\\.");
	
			if (frames.length >= 10 || frames.length == 11) {  //max amount of frames in the game
				for (int i = 0; i < 10; i++) {
					// open
					if (open(frames[i])) {
						String[] array = frames[i].split(",");
						s1 = Integer.parseInt(array[0]);
						s2 = Integer.parseInt(array[1]);
						score = score + s2 + s1;
					}
					// Strike
					if (strike(frames[i])) {
						int br = i + 1; //check next ball thrown
						int strikeCount = 1;
						while (br <= frames.length) {
							if (i == 9){
								if (open(frames[br])) {  //Open after Strike, 10 points plus for next balls
									String[] array = frames[br].split(",");
									s1 = Integer.parseInt(array[0]);
									s2 = Integer.parseInt(array[1]);
										score = score + 10 + s1 + s2;
										return score;
								}
							}
							// Open after Strike
							if (open(frames[br])) {
								String[] array = frames[br].split(",");
								s1 = Integer.parseInt(array[0]);
								s2 = Integer.parseInt(array[1]);
								if (strikeCount > 1) {  //multiple strikes
									score = score + strikeCount * 10 + s1;
									score = score + 10 + s1 + s2;
									i = br - 1;
									break;
								} else {
									score = score + 10 + s1 + s2;
									break;
								}
								// Strike after Strike
							} else if (strike(frames[br])) {
								strikeCount = strikeCount + 1;
								// Perfect game!
								if (strikeCount == 10) {
									String[] array = frames[br+1].split(",");
									s1 = Integer.parseInt(array[0]);
									s2 = Integer.parseInt(array[1]);
									if (s1 == 10 && s2==10){
										score = 300;
										return score;
									}else{
										
									}
									
								} else if (br == 9) {
									String[] array = frames[br+1].split(",");
									s1 = Integer.parseInt(array[0]);
									s2 = Integer.parseInt(array[1]);
									score = score + strikeCount * 10 + s1;
									score = score + 10 + s1 + s2;
									return score;
								}else{
									br = br + 1;
								}
								// Spare after Strike
							} else if (spare(frames[br])) {
								String[] array = frames[br].split(",");
								s1 = Integer.parseInt(array[0]);
								s2 = Integer.parseInt(array[1]);
								if (strikeCount > 1) {
									score = score + strikeCount * 10 + s1;
									score = score + 10 + s1 + s2;
									i = br - 1;
									break;
								} else {
									score = score + 10 + s1 + s2;
									break;
								}
							}
						}
					}
					// Spare
					if (spare(frames[i])) {
						int br = i + 1;
						int spareCount = 1;
						while (br <= frames.length) {
							if(i == 9 ){
								s1 = Integer.parseInt(frames[br]);
								score = score + 10 + s1;
								return score;
							}
							// Open after Spare
							if (open(frames[br])) {
								String[] array = frames[br].split(",");
								s1 = Integer.parseInt(array[0]);
								s2 = Integer.parseInt(array[1]);
								if (spareCount > 1) {
									score = score + 10 + s1;
									i = br - 1;
									break;
								} else {
									score = score + 10 + s1;
									break;
								}
								// Multiple Spares
							} else if (spare(frames[br])) {
								
								String[] array = frames[br].split(",");
								s1 = Integer.parseInt(array[0]);
								s2 = Integer.parseInt(array[1]);
								score = score + 10 + s1;
								
								spareCount = spareCount + 1;
								if (br == 9){
									s1 = Integer.parseInt(frames[br+1]);
									score = score + 10 + s1;
									return score;
									
								}
								br = br + 1;
								// Strike after Spare
							} else if (strike(frames[br])) {
								String[] array = frames[br].split(",");
								s1 = Integer.parseInt(array[0]);
								s2 = Integer.parseInt(array[1]);
								if (spareCount > 1) {
									score = score + 10 + s1;
									i = br - 1;
									break;
								} else {
									score = score + 10 + s1;
									break;
								}
							}
	
						}
	
					}
	
				}
				return score;
				
			}
		
		}
			return (-1);
		
		
	}

	public boolean open(String a) {
		String[] arr = a.split(",");
		int s1 = Integer.parseInt(arr[0]);
		int s2 = Integer.parseInt(arr[1]);
		int result = s2 + s1;
		if (result < 10) {
			return true;
		} else {
			return false;
		}
	}

	public boolean strike(String a) {
		String[] arr = a.split(",");
		int s1 = Integer.parseInt(arr[0]);
		int s2 = Integer.parseInt(arr[1]);
		if (s1 == 10 && s2 == 0) {
			return true;
		}
		return false;
	}

	public boolean spare(String a) {
		String[] arr = a.split(",");
		int s1 = Integer.parseInt(arr[0]);
		int s2 = Integer.parseInt(arr[1]);
		int result = s2 + s1;
		if (result == 10 && s1 < 10 && s2 < 10) {
			return true;
		}
		return false;

	}
	public boolean verifyStringFormat(String game) {
		return game.matches("(\\[([0-9]|10),([0-9]|10)\\]){10}");
	}
	
	public boolean verifyLastStrikeStringFormat(String game) {
		return game.matches("(\\[([0-9]|10),([0-9]|10)\\]){10}\\[([0-9]|10),([0-9]|10)\\]");
	}
	
	public boolean verifyLastSpareStringFormat(String game) {
		return game.matches("(\\[([0-9]|10),([0-9]|10)\\]){10}\\[([0-9]|10)\\]");
	}

}
