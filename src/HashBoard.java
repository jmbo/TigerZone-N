/**********************************************************************

	Created By: Group N

	Logic:

		Board is created using a HashMap that will map the values
		of the Positions to the Tile. Two functions that basically
		control the class:

			1.  didAddTile -- which returns a boolean value
				true: a tile was added to the board;
				false: a tile was not added to the board;

			2.  checkOpenSpots -- which will return a Set
				of the possible locations that a tile can be
				placed.

		CheckOpenSpots can be used by the Player in the future
		to allow the user/ai to pick which spot will be available

***********************************************************************/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.Iterator;
import java.util.Scanner;

public class HashBoard{
	
	HashMap <Position, Tile> gBoard;
	Set <Position> set;

	public HashBoard(){
		gBoard = new HashMap<Position, Tile>();
		//Initializing Possible spots for users
		set = new HashSet<Position>();
		//gBoard.put(new Position(0, 0), new Tile());


		//Attempt to Scale
		
		/*	

			Known Bug:
			Comparsion in the HashMap with Position doesn't work
			Talk about tomorrow in the group

			Test Case:
			1. Try a tile that is already on the board
			2. Try an invalid placement

		*/

		// gBoard.put(new Position(1, 0), new Tile());
		// gBoard.put(new Position(-1, 0), new Tile());
		// gBoard.put(new Position(0, 1), new Tile());
		// gBoard.put(new Position(0, -1), new Tile());
	}

	public void printKeys(){

		Set<Position> keySet = gBoard.keySet();

		System.out.println("Key Set");

		for(Position pos: keySet){
			System.out.println("Coordinates: " + pos.getXPosition() + " " + pos.getYPosition());
		}
		System.out.println("Open Spaces");
		for(Position pos: set){
			System.out.println("Coordinates:" + pos.getXPosition() + " " + pos.getYPosition());
		}

	}

	public boolean didAddTile(Position pos, Tile tile){

		//Check All avaliable spots
		Set<Position> set = checkOpenSpots();

		//Check Spot Exist?
		for (Position s : set) {

			System.out.println(s.getXPosition() + " " + s.getYPosition());

			//Position was found in set
			if(  (s.getXPosition() != pos.getXPosition()) && 
				 (s.getYPosition() != pos.getYPosition())) {
				//gBoard.put(pos, tile);
				//return true;
			}

		}

		//Position was not found in the Set
		return false;
	}


	public void checkOpenSpots(Position newpos){
		Set<Position> keySet = gBoard.keySet();
		Iterator<Position> it = keySet.iterator();

		Position set_rPosX = new Position(newpos.getXPosition() + 1, newpos.getYPosition());
		Position set_lPosX = new Position(newpos.getXPosition() - 1, newpos.getYPosition());
		Position set_tPosY = new Position(newpos.getXPosition(), newpos.getYPosition() + 1);
		Position set_bPosY = new Position(newpos.getXPosition(), newpos.getYPosition() - 1);

		for(Position pos: keySet){
			if(set_rPosX.equals(pos)){
				break;
			}
			else {set.add(set_rPosX);}
		}
		for(Position pos: keySet){
			if(set_.lPosX.equals(pos)){
				break;
			}
			else {set.add(set_lPosX);}
		}
		for(Position pos: keySet){
			if(set_tPosX.equals(pos)){
				break;
			}
			else {set.add(set_tPosY);}
		}
		for(Position pos: keySet){
			if(set_bPosX.equals(pos)){
				break;
			}
			else {set.add(set_bPosY);}
		}

		Iterator<Position> deletespace = set.iterator();
		while (deletespace.hasNext()) {
			Position holder = iterator.next();
			if (newpos.equal(holder)) {
				deletespace.remove();
				break;
			}
		}



	/*

		while(it.hasNext()){

			Position pos = it.next();

			//System.out.println(pos.getXPosition() + " " + pos.getYPosition());

			Position set_pPosX = new Position(pos.getXPosition() + 1, pos.getYPosition());
			Position set_nPosX = new Position(pos.getXPosition() - 1, pos.getYPosition());
			Position set_pPosY = new Position(pos.getXPosition(), pos.getYPosition() + 1);
			Position set_nPosY = new Position(pos.getXPosition(), pos.getYPosition() - 1);

			if(gBoard.containsKey(pos)){
				set.remove(pos);
			}

			//Position is checked to the Right
			if(!gBoard.containsKey(set_pPosX)){

				set.add(set_pPosX);
			} 

			//Position is checked to the Top
			if(!gBoard.containsKey(set_nPosX)){

				set.add(set_nPosX);
			}

			//Position is checked to the Left
			if(!gBoard.containsKey(set_pPosY)){

				set.add(set_pPosY);
			}

			//Position is checked to the Bottom
			if(!gBoard.containsKey(set_pPosY)){

				set.add(set_nPosY);
			}

		}

		*/
	}

	public static void main(String[] args){

		HashBoard board = new HashBoard();
		board.gBoard.put(new Position(0, 0), new Tile());
		board.checkOpenSpots(new Position(0, 0));
		board.printKeys();
		board.gBoard.put(new Position(1, 0), new Tile());
		board.checkOpenSpots(new Position(1, 0));
		board.printKeys();
		/**System.out.println("We Have Started a New Game");
		System.out.println("Choose Your Position (Format: X Y )");
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();

		System.out.println("X Location: " + x + " \nY Location: " + y);

		if(board.didAddTile(new Position(x, y), new Tile())){
			System.out.println("That is a viable location.");
		} else {
			System.out.println("Nahhhhhhh");
		}
		 **/
	}



}