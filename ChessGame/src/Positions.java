/*
 *	I have implemented this class to convert the given positions to x/y coordinates that correspond to a 2d array
 *	eg. in a 2d array e would become 4(y) and 3 would become 5(x) and so the square e3 would mean [5][4] in a 2d array 
 *  I can also convert the 2d array coordinates back to the format of the chess board eg coordinate [0][2] can be converted back to c8
 */
public class Positions {

	public int getMatrix_column_position(String position){ // Cannot use switch on a String due to older version of Java
		if(position.equals("a")){
			return 0;
		}
		if(position.equals("b")){
			return 1;
		}
		if(position.equals("c")){
			return 2;
		}
		if(position.equals("d")){
			return 3;
		}
		if(position.equals("e")){
			return 4;
		}
		if(position.equals("f")){
			return 5;
		}
		if(position.equals("g")){
			return 6;
		}
		if(position.equals("h")){
			return 7;
		}
		return (Integer) null;
	}
	public int getMatrix_row_position(int position){
		 switch (position) {
	         case 1:  return 7;
	         case 2:  return 6;
	         case 3:  return 5;
	         case 4:  return 4;
	         case 5:  return 3;
	         case 6:  return 2;
	         case 7:  return 1;
	         case 8:  return 0;
		 }
		return (Integer) null;
	}
	public String getChess_column_position(int position){
        switch (position) {
            case 0:  return "a";
            case 1:  return "b";
            case 2:  return "c";
            case 3:  return "d";
            case 4:  return "e";
            case 5:  return "f";
            case 6:  return "g";
            case 7:  return "h";
        }
		return null;
	}
	public String getChess_row_position(int position){
		switch (position) {
	        case 0:  return "8";
	        case 1:  return "7";
	        case 2:  return "6";
	        case 3:  return "5";
	        case 4:  return "4";
	        case 5:  return "3";
	        case 6:  return "2";
	        case 7:  return "1";
		}
		return null;
	}
}
