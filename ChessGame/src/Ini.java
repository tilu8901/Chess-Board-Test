import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Ini {
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	
	public void run(){
		ArrayList<ChessPieces> pieces = new ArrayList<ChessPieces>(); //List to store all the chess pieces
		try{
			//==================================== Get User Inputs ====================================//
	        int total_pieces = getTotalPieces();
	        for(int i = 0;i < total_pieces;i ++){
	        	System.out.println();
	        	int counter = i+1;
	        	System.out.println("Piece "+counter);
	        	String colour = getColour();
	        	String type = getType();
	        	String position = getPosition();
	        	/*
	        	 * If type equals b or n create a new 'ChessPieces' object
	        	 */
	        	if(type.equalsIgnoreCase("b")){ //Create a new Bishop piece and store colour,type,position
	        		ChessPieces new_piece = new Bishop();
	        		new_piece.setColour(colour);
	        		new_piece.setType(type);
	        		new_piece.setPosition(position);
	        		pieces.add(new_piece);
	        	}
	        	else if(type.equalsIgnoreCase("n")){ //Create a new Knight piece and store colour,type,position
	        		ChessPieces new_piece = new Knight();
	        		new_piece.setColour(colour);
	        		new_piece.setType(type);
	        		new_piece.setPosition(position);
	        		pieces.add(new_piece);
	        	}
	        }
	        Board chessboard = new Board(pieces); //object to store the chessboard(2d array)
	        boolean success = chessboard.placeChess_pieces();
	        if(!success){  //If the returned value is false that means two pieces are occupying the same square
	        	System.out.println("[Error] Two chess pieces occupying the same position.");
	        	run();
	        }
	        else{ //Success
	        	printResult(pieces,chessboard);
		        getContinue();
	        }
		}catch(Exception e){
			e.printStackTrace();
			System.exit(0);
		}
	}
	public void printResult(ArrayList<ChessPieces> pieces,Board board){ //Prints the result
		System.out.println("Valid moves");
		for (ChessPieces piece : pieces) {
			piece.checkMoves(board.getChess_board());
			piece.displayMoves();
		}
	}
	//======================== Methods To Get User Inputs (with error handling) =========================//
	public int getTotalPieces() throws IOException{
		System.out.print("Enter number of pieces: ");
        String number_of_pieces = br.readLine();
        if(!isInteger(number_of_pieces)){
        	System.out.println("[Error] Please Enter A Number.");
        	run();
        }
        if(Integer.parseInt(number_of_pieces) < 1){
        	System.out.println("[Error] Please Enter A Number Larger Than 0.");
        	run();
        }
        return Integer.parseInt(number_of_pieces);
	}
	public String getColour() throws IOException{
    	System.out.print("Enter colour (W/B): ");
    	String colour = br.readLine();
    	if(!colour.equals("W") && !colour.equals("B")){
    		System.out.println("[Error] Invalid Colour.");
    		run();
    	}
    	return colour;
	}
	public String getType() throws IOException{
		System.out.print("Enter type (B/N): ");
    	String type = br.readLine();
    	if(!type.equals("B") && !type.equals("N")){
    		System.out.println("[Error] Invalid Type.");
    		run();
    	}
    	return type;
	}
	public String getPosition() throws IOException{
		System.out.print("Enter position: ");
    	String position = br.readLine();
    	if(position.length() != 2){
    		System.out.println("[Error] Please Enter A Letter (a-h) Followed By A Number (1-8).");
    		run();
    	}
    	return position;
	}
	public void getContinue() throws IOException{
		System.out.print("Continue (Y/N)?: ");
    	String cont = br.readLine();
    	if(cont.equalsIgnoreCase("Y")){
    		run();
    	}
    	else{
    		System.exit(0);
    	}
	}
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    return true;
	}
}