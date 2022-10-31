package controller;

import model.Board;
import model.player.Player;


public class Game {
	
	private final Turn turn;
    private final Board board;

    public Game() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }
    
    public Game(int columns, int rows) {
        this.board = new Board(columns, rows);
        this.turn = new Turn(this.board);
    }

    public int getColumns() {
		return board.getColumns();
	}

	public int getRows() {
		return board.getRows();
	}
	
    public void initGame() {
        this.turn.makeFirstTurn();
    }

    public Integer playTurn() {
        int column;
        do {
        	column = getActivedPlayer().determineMove(this.board);
        } while (!isValidTurn(column));

        this.turn.putPiece(column);

    	return column;
    }

    public Player getActivedPlayer() {
        return this.turn.getActivePlayer();
    }

    public GoalStatus getGoal() {
        return this.turn.getGoal();
    }

    public boolean isValidTurn(int column) {
        return column >= 0 && column < this.board.getColumns() && !this.board.isFullColumn(column);
    }

    public boolean isInProgress() {
        return this.turn.isInProgress();
    }

    public String getSquare(int i, int j) {
        return this.board.getSquare(i, j);
    }

    public boolean isWinner() {
        return this.turn.isGoalWinner();
    }
    
    public void switchTurns() {
    	this.turn.update();
    }

}
