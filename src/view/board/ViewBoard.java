package view.board;

import controller.Game;

public class ViewBoard {
	public static void printBoard(Game game) {
        printHeaderBoard(game.getColumns());
        for (int i = game.getRows() - 1; i >= 0; i--) {
            for (int j = 0; j < game.getColumns(); j++) {
                BoardElement.EDGE_SEPARATOR.print();
                BoardElement.SQUARE.print(game.getSquare(i, j));
                if (j == (game.getColumns() - 1)) {
                    BoardElement.FINAL_EDGE_SEPARATOR.print();
                }
            }
        }
        BoardElement.LINE_SEPARATOR.print();
    }

    private static void printHeaderBoard(Integer columns) {
        String headerColumn = " ";
        for (int i = 0; i < columns; i++) {
            headerColumn = headerColumn.concat(i + " ");
        }
        BoardElement.COLUMN_HEADER.print(headerColumn);
        BoardElement.LINE_SEPARATOR.print();
    }
}
