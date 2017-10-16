package queens;

public class Chessboard {
		
	private static String board[][];
	private int queenNum;
	private int n = 8;
	
	public Chessboard() {
		queenNum = 0;
		board = new String[n][n];
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < n; j++) {
				board[i][j] = "| ";
			}
		}
	}
	
	public int getQueenNum() {
		
		return queenNum;
	}
	
	public void start() {
		
		solve(0);
	}
	
	public boolean solve(int queenNum) {
		if (queenNum == 8) {
			System.out.println("Done!");
			this.printBoard();
			return true;
		}
		else {

			for(int i = 0; i < 8; i++) {
				
				for (int j = 0; j < 8; j++) {
					
					if(isValid(i,j) == 0) {
						this.placeQueen(i, j, 0);
						queenNum++;
						if (solve(queenNum)) {
							return true;
						}
						else {
							this.placeQueen(i, j, 1);
							queenNum--;
						}
					}
				}
			}
		}
		return false;
	}
	
	public static int isValid(int x, int y) {
		//Checks Straight
		for (int i = 0; i < 8; i++ ) {
			if (get(x, i) == "|Q") {
				return -1;
			}
			if(get(i, y) == "|Q") {
				return -1;
			}
		}
		
		//Checks Diagonal
		for (int i = 0; i < 8; i++) {
			
			if (get(x-i, y-i) == "|Q") {
				return -1;
			}
			if (get(x-i, y+i) == "|Q") {
				return -1;
			}
			if (get(x+i, y-i) == "|Q") {
				return -1;
			}
			if (get(x+i, y+i) == "|Q") {
				return -1;
			}
		}
		return 0;
	}
	
	public static String get(int x, int y) {
		
		if (x < 0 || y < 0 || x >= 8 || y >= 8) {
			
			return "";
		}
		return board[x][y];
	}
	
	public int placeQueen(int x, int y, int type) {
		
		if (type == 0 ) {
			board[x][y] = "|Q";
			queenNum++;
			return 0;
		}
		else if (type == 1) {
			board[x][y] = "| ";
			return 0;
		}
		System.out.println("Wrong type!");
		return -3;
	}
	

	
	public void printBoard() {
		
		for (int i = 0; i < 8; i++) {
			
			for (int j = 0; j <8; j++) {
				System.out.print(this.get(i,j) + "");
			}
			System.out.println("|");
		}
	}
} 

