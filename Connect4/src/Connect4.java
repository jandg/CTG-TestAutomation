import controller.Game;
import view.View;

public class Connect4 {

	private final Game game;
    private final View view;

    public Connect4() {
    	
        this.game = new Game();
        this.view = new View(this.game);
    }
    
    public Connect4(int cols, int rows) {
    	
        this.game = new Game(cols, rows);
        this.view = new View(this.game);
    }

    private void play() {
        this.view.initGame();

        do {
            this.view.play();
        } while (this.view.isInProgress());

        this.view.endGame();
    }

    /*
     * Default dimensions: 7 columns, 6 rows
     * 
     * Optional program arguments: #columns #rows
     */
    public static void main(String[] args) {
    	int cols = 7, rows = 6;
    	if(args.length==2){
    		cols = Integer.parseInt(args[0]);
    		rows = Integer.parseInt(args[1]);
    	}
        new Connect4(cols,rows).play();
    }

}
