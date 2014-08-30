import java.util.ArrayList;
public class Bishop implements ChessPieces{
	//============= All the possible directions for a Bishop =========//
	private static final int TOP_LEFT = 1;
	private static final int TOP_RIGHT = 2;
	private static final int BOTTOM_RIGHT = 3;
	private static final int BOTTOM_LEFT = 4;
	//============ Type, colour and position of this Bishop
	private String type;
	private String colour;
	private String position;
	private String row;
	private String column;
	ArrayList<String> moves = new ArrayList<String>(); //List to store all the valid moves
	private static String EMPTY = "0";
	private static int ARRAY_MAX = 7;
	private static int ARRAY_MIN = 0;
	public Bishop(){
	}
	/*
	 * Checks all the valid moves for the current square
	 */
	public void checkMoves(String[][] board){
		validateMove(board,TOP_LEFT);
		validateMove(board,TOP_RIGHT);
		validateMove(board,BOTTOM_RIGHT);
		validateMove(board,BOTTOM_LEFT);
	}
	/*
	 * validateMove will take a direction and a 2d array to check for all valid moves in the given direction
	 * value of row and column are altered inside the while loop depending on what the direction is, this avoids 
	 * writing the same code for each direction
	 */
	public void validateMove(String[][] board,int direction){
		Positions position = new Positions();
		int current_row = position.getMatrix_row_position(Integer.parseInt(getRow()));
		int current_column = position.getMatrix_column_position(getColumn());
		boolean finished = false;
		int counter = 1;
		int row = 0;
		int column = 0;
		while(!finished){ //top left
			if(direction == TOP_LEFT){ //Direction for top left in a 2d array
				row = current_row - counter;
				column = current_column - counter;
			}
			else if(direction == TOP_RIGHT){ //Direction for top right in a 2d array
				row = current_row - counter;
				column = current_column + counter;
			}
			else if(direction == BOTTOM_RIGHT){ //Direction for bottom right in a 2d array
				row = current_row + counter;
				column = current_column + counter;
			}
			else if(direction == BOTTOM_LEFT){ //Direction for bottom left in a 2d array
				row = current_row + counter;
				column = current_column - counter;
			}
			if(row < ARRAY_MIN || column < ARRAY_MIN || row > ARRAY_MAX || column > ARRAY_MAX){  //Break out of loop if values are out of bounds
				finished = true;
			}
			else{
				String value = board[row][column];
				if(value.equals(EMPTY)){ //If the next square is empty add it to the 'moves' list
					String move = position.getChess_column_position(column)+position.getChess_row_position(row);
					moves.add(move); 
					counter ++;	//Increment counter to get the next square
				}
				else if(!value.equals(getColour())){  //If the next square is occupied by a piece of different colour add to 'moves'
					String move = position.getChess_column_position(column)+position.getChess_row_position(row);
					moves.add(move);
					finished = true; //Exit loop
				}
				else if(value.equals(getColour())){ //If the next square is occupied by the same colour
					finished = true; //Exit loop
				}
			}
		}
	}
	/*
	 * Method to print out all the valid moves for this chess piece
	 */
	public void displayMoves(){
		String s = "[";
		for(String move : moves){
			s += move + ",";
		}
		s += "]";
		System.out.println(getType()+" on "+getPosition()+": "+s);
	}
	//================== Getter and Setter Methods ====================//
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
		setColumn(position.substring(0,1)); // column is the first letter in position
		setRow(position.substring(1,2)); // row is the second digit 
	}
	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}	
	public ArrayList<String> getMoves(){
		return moves;
	}
}
