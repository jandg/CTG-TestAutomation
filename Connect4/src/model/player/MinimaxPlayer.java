package model.player;

import java.util.ArrayList;

import model.Board;

public class MinimaxPlayer extends Player {

	int depth = 3;
	Integer x=0;
	
	public MinimaxPlayer(String name, String piece, Boolean human) {
		super(name, piece, human);
	}

	@Override
	public Integer determineMove(Board board) {
		try {
			max_value(board, depth);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return x;
	}

	public MinimaxPlayer(String name, String piece) {
		super(name, piece, false);
	}

	
	public ArrayList<Integer> getOpenColumns(Board b) {
    	ArrayList<Integer> actions=new ArrayList<Integer>();
		for(int j=0; j<b.getColumns(); j++)
			if(b.isEmptySquare(b.getRows()-1, j))
				actions.add(j);
		return actions;
    }
	
	private String getOpposite() { 
		if (this.getPiece().equals("X")) return "O";
		else return "X";
	}
	
	public Board generateSuccessor(Board b, int action) throws CloneNotSupportedException {

		Board new_board = (Board)b.clone();
		if (!new_board.isFullColumn(action)) new_board.putPiece(getPiece(), action);
		
		return new_board;
	}
	
	public double evaluationFunction(Board b){
    	for (int i = 0; i < b.getRows(); i++) {
	        for (int j = 0; j < b.getColumns(); j++) {
	            if (!b.isEmptySquare(i, j)) {
	            	b.updateCoordinate(i,j);
	            	if (b.isConnect4()) {
	            		if (getPiece().equals(b.getSquare(i, j)) )
	            			return 1000.0;
	                	
	                	if (getOpposite().equals(b.getSquare(i, j) ) )
	            			return -1000.0;
	            	}
	            }
	        }
	    }
    	return 0.0;
    }
	
	public double max_value(Board b, int d) throws CloneNotSupportedException
	{	
		ArrayList<Integer> children = getOpenColumns(b);
		if(d ==0) {
			return evaluationFunction(b);
		}
		else{
			children = getOpenColumns(b);
			double v = -1000000;
		
			double z;
			for(int i =0; i<children.size();i++)
			{
				z = min_value(generateSuccessor(b,children.get(i)),d);
				if(z >= v)
				{
					v =z;
					x = children.get(i);
				}
			}
			return v;
		}
	}
	
	public double min_value(Board b, int d) throws CloneNotSupportedException
	{
		
		ArrayList<Integer> children = getOpenColumns(b);
		if(d ==0) {
			return evaluationFunction(b);
		}
		else{
			children = getOpenColumns(b);
		
			double v = 1000000;

			double z;
			for(int i =0; i<children.size();i++)
			{
				z= max_value(generateSuccessor(b,children.get(i)),d-1);
				if(z <= v) v=z;
			}
			return v;
		}
	}
	
}
