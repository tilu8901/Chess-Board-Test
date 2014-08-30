import java.util.ArrayList;
public class Knight implements ChessPieces{
	//============= All the possible Moves for a knight =========//
	private static final int ONE_OCLOCK = 1;
	private static final int TWO_OCLOCK = 2;
	private static final int FOUR_OCLOCK = 4;
	private static final int FIVE_OCLOCK = 5;
	private static final int SEVEN_OCLOCK = 7;
	private static final int EIGHT_OCLOCK = 8;
	private static final int TEN_OCLOCK = 10;
	private static final int ELEVEN_OCLOCK = 11;
	//============ Type, colour and position of this knight
	private String type;
	private String colour;
	private String position;
	private String row;
	private String column;
	private ArrayList<String> moves = new ArrayList<String>(); //List to store all the valid moves
	private static final int MIN = -1;
	private static final int MAX = 8;
	private static String EMPTY = "0";
	public Knight(){
	}
	/*
	 * Checks all the valid moves for the current square
	 */
	public void checkMoves(String[][] board){
		validateMove(board,ONE_OCLOCK);
		validateMove(board,TWO_OCLOCK);
		validateMove(board,FOUR_OCLOCK);
		validateMove(board,FIVE_OCLOCK);
		validateMove(board,SEVEN_OCLOCK);
		validateMove(board,EIGHT_OCLOCK);
		validateMove(board,TEN_OCLOCK);
		validateMove(board,ELEVEN_OCLOCK);	
	}
	/*
	 * validateMove will take a direction and a 2d array to check to see if its a valid move, if so it will be stored in the 'moves' list
	 * Note that for each possible move for a knight I'm changing the value of row and column instead of writing 8 different conditions
	 */
	public void validateMove(String[][] board,int direction){
		Positions position = new Positions();
		int current_row = position.getMatrix_row_position(Integer.parseInt(getRow()));
		int current_column = position.getMatrix_column_position(getColumn());
		int row = 0;
		int column = 0;
		// ---------------- The 8 possible moves for a knight
		if(direction == ONE_OCLOCK){
			row = current_row - 2;
			column = current_column + 1;
		}
		else if(direction == TWO_OCLOCK){
			row = current_row - 1;
			column = current_column + 2;
		}
		else if (direction == FOUR_OCLOCK){
			row = current_row + 1;
			column = current_column + 2;
		}
		else if (direction == FIVE_OCLOCK){
			row = current_row + 2;
			column = current_column + 1;
		}
		else if (direction == SEVEN_OCLOCK){
			row = current_row + 2;
			column = current_column - 1;
		}
		else if (direction == EIGHT_OCLOCK){
			row = current_row + 1;
			column = current_column - 2;
		}
		else if (direction == TEN_OCLOCK){
			row = current_row - 1;
			column = current_column - 2;
		}
		else if(direction == ELEVEN_OCLOCK){
			row = current_row - 2;
			column = current_column - 1;
		}
		/*
		 * If the move is not out of bounds check for validation
		 */ 
		if(row > MIN && column > MIN && row < MAX && column < MAX){ 
			String value = board[row][column];
			if(value.equals(EMPTY) || !value.equals(getColour())){ //If the square is empty or is occupied by a piece of different colour
				String move = position.getChess_column_position(column)+position.getChess_row_position(row);
				moves.add(move);  //Add this move to 'moves' list
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
