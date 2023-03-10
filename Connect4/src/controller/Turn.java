package controller;

import java.util.Objects;

import model.Board;
import model.player.ComputerPlayer;
import model.player.HumanPlayer;
import model.player.MinimaxPlayer;
import model.player.Player;


public class Turn {
	
	private final static int NUMBER_OF_PLAYERS = 2;
	
	private final static String PLAYER_1_NAME = "Player 1";
    private final static String PLAYER_2_NAME = "Player 2";
    private final static String PIECE_1 = "X";
    private final static String PIECE_2 = "O";

    private final Player[] players;
    private final Board board;
    private GoalStatus goal;
    private int activePlayer;

    public Turn(Board board) {
        this.board = board;
        this.players = new Player[]{new HumanPlayer(PLAYER_1_NAME, PIECE_1),new ComputerPlayer(PLAYER_2_NAME, PIECE_2)};
    }

    public GoalStatus getGoal() {
        return this.goal;
    }

    public void makeFirstTurn() {
        this.goal = GoalStatus.IN_PROGRESS;
        this.activePlayer = 0;
    }

    public void update() {
    	if (this.board.isConnect4()) {
            this.goal = GoalStatus.WIN;
        } else if (this.board.isCompleted()) {
            this.goal = GoalStatus.FULL_BOARD;
        } else {
            makeNextTurn();
        }
    }

    public void makeNextTurn() {
        if(Objects.nonNull(getActivePlayer())){
            updateNextPlayer();
        }
    }

    public Player getActivePlayer(){
       return this.players[activePlayer];
    }

    public void putPiece(int column) {
        this.board.putPiece(getActivePlayer().getPiece(), column);
    }

    private void updateNextPlayer() {
        if(activePlayer + 1 < NUMBER_OF_PLAYERS){
            this.activePlayer++;
        } else {
            this.activePlayer = 0;
        }
    }

    public boolean isGoalWinner() {
        return GoalStatus.WIN.equals(this.goal);
    }

    public boolean isInProgress() {
        return GoalStatus.IN_PROGRESS.equals(this.goal);
    }
}
