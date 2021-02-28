package ensta;

import ensta.ships.*;


public class TestBoard  
{
    public static void main( String[] args )
    {

    	/*
    	//Test exercice 1
        Board plateau = new Board("bataille navale", 5);
		plateau.print();

		Board plateau2 = new Board("bataille navale");
		plateau2.print();

		Board plateau3 = new Board("bataille navale", 16);
		plateau3.print();
		*/

		//Test exercice 

		Board plateau = new Board("bataille navale");
		plateau.print();

		Submarine submarine1 = new Submarine();
		Submarine submarine2 = new Submarine(Orientation.NORTH);
		plateau.putShip(submarine1, 4, 1);
		plateau.putShip(submarine1, 9,9);
		plateau.putShip(submarine1, 3,1);
		plateau.putShip(submarine2, 5,5);


		plateau.print();
    }
}
