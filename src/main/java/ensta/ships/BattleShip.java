package ensta.ships;

public class BattleShip extends AbstractShip {
	
	public BattleShip(Orientation orientation){
		super("BattleShip", 'B', 4, orientation);
	}

	public BattleShip(){
		super("BattleShip", 'B', 4, Orientation.EAST);
	}
}
