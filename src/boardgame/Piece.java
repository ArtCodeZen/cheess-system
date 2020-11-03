package boardgame;

public class Piece {
	protected Position position;
	private Board board;
	public Piece(Board board) {		
		this.board = board;
		position = null; // o java já coloca como nulo, mas vamos exemplificar
	
	}
	protected Board getBoard() {
		return board;
	}
}
