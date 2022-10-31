package view;

import controller.Game;

public class View extends ModelView {
	private final ViewGame viewGame;

    public View(Game game) {
        super(game);
        this.viewGame = new ViewGame(this.game);
    }

    public void initGame() {
        this.viewGame.startGame();
    }

    public void play() {
        this.viewGame.play();
    }

    public boolean isInProgress() {
        return this.viewGame.isInProgress();
    }

    public void endGame() {
        this.viewGame.endGame();
    }

}
