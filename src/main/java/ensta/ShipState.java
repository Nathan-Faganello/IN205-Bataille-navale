package ensta;
import ensta.ships.*;

public class ShipState {
	
	AbstractShip ship;
	boolean struck;

	/* Constructeur par défaut */
	public ShipState(){
		this.struck = false;
	}

	/* Constructeur valué */
	public ShipState(AbstractShip ship){
		this.ship = ship;
		this.struck = false;
	}

	public void addStrike(){
		if (!isStruck()){
			struck=true;
		}
	}
	public boolean isStruck(){
		return struck;
	}

	public String toString(){
		if (ship!=null) {
			if (struck) {
				return ColorUtil.colorize(ship.getLabel(), ColorUtil.Color.RED);
			}
			else {
				return ColorUtil.colorize(ship.getLabel(), ColorUtil.Color.WHITE);
			}
		}
		else {
			return ColorUtil.colorize(".", ColorUtil.Color.WHITE);
		}
	}

	boolean isSunk(){
		if(ship.isSunk()) {
			return true;
		}

		return false;
	}

	AbstractShip getShip(){
		return ship;
	}
}