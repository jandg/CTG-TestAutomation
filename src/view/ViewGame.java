package view;

import controller.Game;
import view.board.ViewBoard;
import view.output.Message;

public class ViewGame extends ModelView {

	ViewGame(Game game) {
        super(game);
    }
	
	// start of game
    public void startGame() {
        Message.START_GAME.print();
        this.game.initGame();
    }

    public void play() {
    	
    	// inform user of new turn
        showPlayerOrder();
        
        // play turn
        Integer column = this.game.playTurn();
        
        // show played column in case of non human player
        if (!this.game.getActivedPlayer().isHuman()) Message.CHOSEN_COLUMN.print(column.toString());
        
        // turn has finished
        this.game.switchTurns();
    }

    public boolean isInProgress() {
        return this.game.isInProgress();
    }

    // end of game
    public void endGame() {
        ViewBoard.printBoard(this.game);
        Message.END_GAME.print();
        Message.HEADER_SEPARATOR.print();
        Message.RESULT_GAME.print(game.getGoal().toString());

        if (game.isWinner()) {
            Message.RESULT_WINNER.print(game.getActivedPlayer().toString());
        }
    }

    
    // player switch
    private void showPlayerOrder() {
        Message.PLAYER_TURN.print(this.game.getActivedPlayer().toString());
        ViewBoard.printBoard(this.game);
        
        // ask for input if human player
        if (this.game.getActivedPlayer().isHuman()) Message.CHOOSE_COLUMN.print();
    }

}
