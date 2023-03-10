package model.player;

import model.Board;
import view.input.Reader;
import view.output.Message;

public class HumanPlayer extends Player {

	public HumanPlayer(String name, String piece, Boolean human) {
		super(name, piece, human);
	}
	
	public HumanPlayer(String name, String piece) {
		super(name, piece, true);
	}

	@Override
	public Integer determineMove(Board board) {
		int number;
		while (true) {
			try{
			    number = Integer.parseInt(Reader.read());
			    while (!(number >= 0 && number < board.getColumns() && !board.isFullColumn(number))) {
			    	Message.INPUT_ERROR.print();
					number = Integer.parseInt(Reader.read()); 
				}
			    break;
			}
			catch (NumberFormatException ex){
				Message.INPUT_ERROR.print();
			}
		}
        return number;
	}

}
