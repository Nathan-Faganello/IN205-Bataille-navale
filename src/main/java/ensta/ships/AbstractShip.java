package ensta.ships;

public abstract class AbstractShip {

	protected char label;
	protected String nom;
	protected int taille;
	protected Orientation orientation;
	protected boolean put;
	protected int strikeCount;

	public char getLabel() {
		return label;
	}

	public String getName() {
		return nom;
	}

	public int getLength() {
		return taille;
	}

	public Orientation getOrientation(){
		return orientation;
	}

	public void setOrientation(Orientation orient) {
		orientation=orient;
	}

	public boolean getPut() {
		return put;
	}

	public void setPut() {
		put = true;
	} 

	public void addStrike() {
		strikeCount += 1;
	}

	public boolean isSunk() {
		if (strikeCount == taille) {
			return true;
		}

		return false;
	}

	public AbstractShip(String nom, char label, int taille, Orientation orientation) {
		this.nom=nom;
		this.label=label;
		this.taille=taille;
		this.orientation=orientation;
		this.put=false;
	}
}
