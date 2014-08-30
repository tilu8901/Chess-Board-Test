import java.util.ArrayList;
/*
 * This interface allows the system to add more types of chess pieces following a similar structure
 */
public interface ChessPieces {
	public String getType();
	public void setType(String type);
	public String getColour();
	public void setColour(String colour);
	public String getPosition();
	public void setPosition(String position);
	public String getRow();
	public void setRow(String row);
	public String getColumn();
	public void setColumn(String column);
	public void checkMoves(String[][] board);
	public ArrayList<String> getMoves();
	public void validateMove(String[][] board,int direction);
	public void displayMoves();
}
