import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	
	private TicTacToeModel model;
	private char mark;
	
	
	public void startNewGame() {
		model = new TicTacToeModel();
	}
	
	public void markLocation(int r, int c) {
		if(mark =='X')
			mark = 'O';
		else
			mark = 'X';
		model.makeMark(mark,r,c);
	}
	
	public char getMark(int r, int c) {
		return model.getMark(r,c);
	}
    
	public char getWinner(){
		if(model.checkTie()){
			return 'T';
		}
		return model.getWinner();
	}
}