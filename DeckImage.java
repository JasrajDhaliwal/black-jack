package termProject;



public class DeckImage {
	
	int index = 51;
	int [] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
			22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41,
			42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52};
	int place = 0;
	// clubs 1 to 13
	// spades 14 to 26
	// diamonds 27 to 39
	// hearts 40 to 52
	
	public int getImage() {
		int x = 0;
		do {
			x = (int)(Math.random()*(index+1));
		} while(num[x]==0);
		
		place = x;
		return num[x];
	}
	
	
	public void delete() {
		num[place] = 0;
	}
	
}
	