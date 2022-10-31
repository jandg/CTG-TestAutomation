package model.player;

import model.Board;

public class ComputerPlayer extends Player {

	public ComputerPlayer(String name, String piece, Boolean human) {
		super(name, piece, human);
	}
	
	public ComputerPlayer(String name, String piece) {
		super(name, piece, false);
	}

	/*
	 * Computer player that chooses random column
	 */
	@Override
	public Integer determineMove(Board board) {
		int number;
		do {
			number = 0 + (int)(Math.random() * (board.getColumns() - 1));
		} while (number < 0 && number >= board.getColumns() && board.isFullColumn(number));
		return number;
	}
	
}
