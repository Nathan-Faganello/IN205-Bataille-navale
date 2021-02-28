package ensta;
import ensta.ships.*;


public class Board {

	protected String nom;
	protected char tableauNavires[][];
	protected boolean tableauFrappes[][];

	public Board(String nom, int taille) {
		this.nom=nom;
		this.tableauNavires=new char[taille][taille];
		this.tableauFrappes=new boolean[taille][taille];
		for (int i=0; i<taille; i++) {
			for (int j=0; j<taille;j++) {
				this.tableauFrappes[i][j]= false;
				this.tableauNavires[i][j]='.';
			}
		}
	}

	public Board(String nom) {
		this.nom=nom;
		this.tableauNavires=new char[10][10];
		this.tableauFrappes=new boolean[10][10];
		for (int i=0; i<10; i++) {
			for (int j=0; j<10;j++) {
				this.tableauFrappes[i][j]= false;
				this.tableauNavires[i][j]= '.';
			}
		}
	}


	public void printEnTete() {
		int taille = tableauNavires.length;
		System.out.print("Navires :");
		for (int n=0; n<taille-4;n++) {
			System.out.print("  ");
		}
		if (taille>10){
			System.out.print(" ");
		}
		System.out.print("     Frappes :\n");
		if (taille>10){
			System.out.print(" ");
		}
	}

	public void printNomColonnes() {
		int taille = tableauNavires.length;
		for (int l=0; l<2; l++) {
			System.out.print("  ");
			char caracAff='A';
			for (int k=0;k<taille; k++){
				System.out.print(caracAff);
				System.out.print(" ");
				caracAff++;
			}
			System.out.print("    ");
			if (taille>10){
				System.out.print(" ");
			}
		}
		System.out.print("\n");
	}

	public void printTableaux() {
		int taille = tableauNavires.length;
		for (int i=0; i<taille; i++) {
			System.out.print(i+" ");
			if (i<10 && taille>10){
				System.out.print(" ");
			}
			for(int j=0; j<taille; j++){
				System.out.print(tableauNavires[i][j]);
				System.out.print(" ");
			}
			System.out.print("    ");
			System.out.print(i+" ");
			if (i<10 && taille>10){
				System.out.print(" ");
			}
			for(int j=0; j<taille; j++){
				if (tableauFrappes[i][j] == true) {
					System.out.print("X ");
				}
				else {
					System.out.print(". ");
				}
			}
			System.out.print("\n");
		}
	}

	public void print() {

		printEnTete();
		printNomColonnes();
		printTableaux();
	}

}
