package ensta;
import ensta.ships.*;
import java.util.ArrayList;

public class TestGame {

	private static void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main (String[] args) {

		Board plateau = new Board("bataille navale");
		plateau.print();

		Destroyer destroyer1 = new Destroyer();
		Submarine submarine1 = new Submarine();
		Carrier carrier1 = new Carrier();
		Submarine submarine2 = new Submarine();
		BattleShip battleship1 = new BattleShip();

		AbstractShip[] bArray = new AbstractShip[] {destroyer1, submarine1, carrier1, submarine2, battleship1};

		BattleShipsAI ai = new BattleShipsAI(plateau, plateau);
		ai.putShips(bArray);

		int coords[]=new int[2];
		Hit hit;

		int compteurNaviresCoulés = 0;

		while (compteurNaviresCoulés<bArray.length) {

			hit = ai.sendHit(coords);
			if (hit.getValue() > 0) {
				compteurNaviresCoulés += 1;
			}
			System.out.println(hit.toString());
			plateau.print();

			sleep(200);
		}

	}
}