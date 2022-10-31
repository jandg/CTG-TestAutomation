package model;


public class Board implements Cloneable{
	private final static String EMPTY = " ";
    private final static int PIECES_TO_WIN = 4;

    private final int columns;
	private final int rows;
    private final String[][] grid;
    private int[] coordinate;

    public Board() {
    	// default connect4 dimensions
    	this.columns = 7;
    	this.rows = 6;
        this.grid = initBoard();
    }
    
    public Board(int columns, int rows) {
    	this.columns = columns;
    	this.rows = rows;
        this.grid = initBoard();
    }
    
    public int getColumns() {
		return columns;
	}

	public int getRows() {
		return rows;
	}
	
	
	public int hashCode(){
		String b="";
		for(int i=0; i<grid.length; i++)
			b+=String.valueOf(grid[0]);
		return b.hashCode();
	}

	public Object clone() throws CloneNotSupportedException {
        Board new_state=new Board(this.columns, this.rows);
		for (int i=0; i<this.rows; i++)
			new_state.grid[i] = (String[]) this.grid[i].clone();
		return new_state;
	}
	
    public void putPiece(String piece, int column) {
        int row = 0;
        for (int i = 0; i < this.rows; i++) {
            if (grid[i][column].equals(EMPTY)) {
                row = i;
                break;
            }
        }
        this.grid[row][column] = piece;
        updateCoordinate(row, column);
    }

    public boolean isFullColumn(int column) {
        for (int i = 0; i < this.rows; i++) {
            if (grid[i][column].equals(EMPTY)) {
                return false;
            }
        }
        return true;
    }

    public Boolean isCompleted() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if (EMPTY.equals(grid[i][j])) {
                    return Boolean.FALSE;
                }
            }
        }
        return Boolean.TRUE;
    }

    public String getSquare(int i, int j) {
        return grid[i][j];
    }
    
    public boolean isEmptySquare(int i, int j) {
        return EMPTY.equals(grid[i][j]);
    }

    public boolean isConnect4() {
        return checkLines() || checkDiagonals();
    }

    private String[][] initBoard() {
        String[][] board = new String[rows][columns];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                board[i][j] = EMPTY;
            }
        }
        return board;
    }

    public void updateCoordinate(Integer row, int column) {
        this.coordinate = new int[]{row, column};
    }

    private String getCoordinateContent() {
        return getSquare(this.coordinate[0], this.coordinate[1]);
    }

    private boolean checkDiagonals() {
        return  (checkInverseDiagonalsUp() + checkInverseDiagonalsBotton() >= PIECES_TO_WIN - 1)
                || (countDiagonalUp() + countDiagonalBotton() >= PIECES_TO_WIN - 1);
    }

    private boolean checkLines() {
        return checkHorizontal() || checkVertical();
    }

    private boolean checkHorizontal() {
        int count = 0;
        for (int j = 0; j < this.columns; j++) {
            if (grid[this.coordinate[0]][j].equals(getCoordinateContent())) {
                count++;
            } else {
                count = 0;
            }
            if (count >= PIECES_TO_WIN) {
                return true;
            }
        }
        return false;
    }

    private boolean checkVertical() {
        int count = 0;
        for (int i = 0; i < this.rows; i++) {
            if (grid[i][this.coordinate[1]].equals(getCoordinateContent())) {
                count++;
            } else {
                count = 0;
            }
            if (count >= PIECES_TO_WIN) {
                return true;
            }
        }
        return false;
    }

    private int checkInverseDiagonalsBotton() {
        int count = 0;
        for (int i = 1; i < PIECES_TO_WIN - 1; i++) {
            if (this.coordinate[0] - i < -1 && this.coordinate[1] + i < this.columns - 1
                    && getCoordinateContent().equals(this.grid[this.coordinate[0] - i][this.coordinate[1] + i])) {
                count++;
            } else {
                return count;
            }
            if (count == PIECES_TO_WIN - 1) {
                return count;
            }
        }
        return count;
    }

    private int checkInverseDiagonalsUp() {
        int count = 0;
        for (int i = 1; i < PIECES_TO_WIN - 1; i++) {
            if (this.coordinate[0] + i < this.rows - 1 && this.coordinate[1] - i > -1
                    && getCoordinateContent().equals(this.grid[this.coordinate[0] + i][this.coordinate[1] - i])) {
                count++;
            } else {
                return count;
            }
            if (count == PIECES_TO_WIN - 1) {
                return count;
            }
        }
        return count;
    }

    private int countDiagonalBotton() {
        int count = 0;
        for (int i = 1; i < PIECES_TO_WIN - 1; i++) {
            if (this.coordinate[0] + i < this.rows - 1 && this.coordinate[1] + i < this.columns - 1
                    && getCoordinateContent().equals(this.grid[this.coordinate[0] + i][this.coordinate[1] + i])) {
                count++;
            } else {
                return count;
            }
            if (count == PIECES_TO_WIN - 1) {
                return count;
            }
        }
        return count;
    }

    private int countDiagonalUp() {
        int count = 0;
        for (int i = 1; i < PIECES_TO_WIN - 1; i++) {
            if (this.coordinate[0] - i > -1 && this.coordinate[1] - i > -1
                    && getCoordinateContent().equals(this.grid[this.coordinate[0] - i][this.coordinate[1] - i])) {
                count++;
            } else {
                return count;
            }
            if (count == PIECES_TO_WIN - 1) {
                return count;
            }
        }
        return count;
    }
}
