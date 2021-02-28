package ensta;

import ensta.ships.*;
import java.util.ArrayList;


public class TestBoard  
{
    public static void main( String[] args )
    {

 
    	//Test exercice 1
    	/*
        Board plateau = new Board("bataille navale", 5);
		plateau.print();

		Board plateau2 = new Board("bataille navale");
		plateau2.print();

		Board plateau3 = new Board("bataille navale", 16);
		plateau3.print();
		*/


		//Test exercice 3
		/*
		Board plateau = new Board("bataille navale");
		plateau.print();

		Submarine submarine1 = new Submarine();
		Submarine submarine2 = new Submarine(Orientation.NORTH);
		plateau.putShip(submarine1, 4, 1);
		plateau.putShip(submarine1, 9,9);
		plateau.putShip(submarine1, 3,1);
		plateau.putShip(submarine2, 5,5);


		plateau.print();
		*/

		//Test exercice 4
		Board plateau = new Board("bataille navale");
		Board plateau2 = new Board("bataille navale");

		Destroyer destroyer1 = new Destroyer();
		Submarine submarine1 = new Submarine();
		Carrier carrier1 = new Carrier();
		Submarine submarine2 = new Submarine();
		BattleShip battleship1 = new BattleShip();

		ArrayList<AbstractShip> vList = new ArrayList<>();
		vList.add(submarine1);
		vList.add(submarine2);
		vList.add(carrier1);
		vList.add(battleship1);
		vList.add(destroyer1);

		Player nathan = new Player(plateau, plateau2, vList);
		nathan.putShips();


    }
}
