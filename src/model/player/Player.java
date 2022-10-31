package model.player;

import model.Board;

public abstract class Player {
	private final String name;
    private final String piece;
    private boolean isActive;
    private final boolean isHuman;

    public Player(String name, String piece, Boolean human) {
        this.name = name;
        this.piece = piece;
        this.isHuman = human;
    }
    
    @Override
    public String toString() {
        return name;
    }

    public String getPiece() {
        return piece;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
    
    public Boolean isHuman() {
    	return isHuman;
    }
    
    public abstract Integer determineMove(Board board);
}
