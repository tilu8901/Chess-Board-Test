import java.util.ArrayList;
/*
 * This object holds a 2d array which represents the entire chess board
 * Initially the elements inside the array are all set to "0" to represent an empty square
 */
public class Board {
	private String chess_board[][]; //2d array to hold the chess board
	private static int HEIGHT = 8; //Size of the board 
	private static int WIDTH = 8;
	private static String EMPTY = "0";
	private ArrayList<ChessPieces> pieces;  //This list stores all the ChessPieces
	/*
	 * A list of ChessPieces is required when initiating this object for the 'method placeChess_pieces()' to pinpoint the board then return it
	 */
	public Board(ArrayList<ChessPieces> pieces){
		setChess_board(new String[HEIGHT][WIDTH]);
		setPieces(pieces);
	}
	/*
	 *  placeChess_pieces() will pinpoint the positions that are occupied by a chess piece inside the array
	 */
	public boolean placeChess_pieces(){
		Positions p = new Positions();
		for (ChessPieces s : pieces) {
			int x = p.getMatrix_row_position(Integer.parseInt(s.getRow()));
			int y = p.getMatrix_column_position(s.getColumn());
			String colour =  s.getColour();
			if(!chess_board[x][y].equals(EMPTY)){ // [Error] Two chess pieces occupying the same position
				return false;
			}
			chess_board[x][y] = colour;
		}
		return true;
	}
	public String[][] getChess_board() {
		return chess_board;
	}
	//================== Getter and Setter Methods ====================//
	/*
	 * Initialize the chess board with values of "0"
	 */
	public void setChess_board(String chess_board[][]) {
		for(int i = 0;i < HEIGHT;i ++){
			for(int j = 0;j < WIDTH;j ++){
				chess_board[i][j] = EMPTY;
			}
		}
		this.chess_board = chess_board;
	}
	public ArrayList<ChessPieces> getPieces() {
		return pieces;
	}
	public void setPieces(ArrayList<ChessPieces> pieces) {
		this.pieces = pieces;
	}
}
