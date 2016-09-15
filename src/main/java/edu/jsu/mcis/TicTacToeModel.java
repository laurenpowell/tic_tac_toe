package edu.jsu.mcis;

public class TicTacToeModel {

    private char[][] grid;
	private char mark;

    public TicTacToeModel() {
        grid = new char[3][3];
		mark = 'X';
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public char getMark(int row, int col) {
        char mark = grid[row][col];
        return mark;
    }

    public char makeMark(char mark, int r, int c) {
        if (grid[r][c] == ' ') {
            grid[r][c] = mark;
        }
        return mark;
    }
	
	public char getWinner(){
		char win = ' ';
		for(int i = 0; i < 3; i++){
            if(getMark(i,0) == getMark(i,1) &&
               getMark(i,1) == getMark(i,2)){
					win = getMark(i,0);
					break;
            }
			if(getMark(0,i) == getMark(1,i) &&
               getMark(1,i) == getMark(2,i)){
					win = getMark(0,i);
					break;
            }
        }
		
		if(getMark(0,0) == getMark(1,1) &&
           getMark(1,1) == getMark(2,2)){
				win = getMark(0,0);
		}
		
		if(getMark(2,0) == getMark(1,1) &&
           getMark(1,1) == getMark(0,2)){
				win = getMark(2,0);
		}
		return win;
	}
	
	public boolean checkTie(){
		boolean tie = true;
		for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (getMark(i,j) == ' ') {
                    tie = false;
				}
			}
		}
		return tie;
	}
}