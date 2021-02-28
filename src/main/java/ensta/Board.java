package ensta;

import ensta.ships.*;

public class Board implements IBoard {

	protected String nom;
	protected char tableauNavires[][];
	protected boolean tableauFrappes[][];

	/* constructeur valué 
	* @param nom = nom de la grille
	* @param taille = taille de la grille 
	Créer une grille nom de dimension taille x taille
	*/

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

	/* constructeur valué 
	* @param nom = nom de la grille
	* @param taille = taille de la grille 
	Créer une grille nom de dimension 10 x 10 
	*/
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

	/* print les noms des 2 tableaux de jeux */
	public void printEnTete() {
		int taille = tableauNavires.length;
		System.out.print("Navires :");
		for (int n=0; n<taille-4;n++) {
			System.out.print("  ");
		}
		if (taille>9){
			System.out.print(" ");
		}
		System.out.print("     Frappes :\n");
		if (taille>9){
			System.out.print(" ");
		}
	}


	/* print les en-têtes de colonnes*/
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
			if (taille>9){
				System.out.print(" ");
			}
		}
		System.out.print("\n");
	}

	/* print les lignes (noms lignes + contenus) */
	public void printTableaux() {
		int taille = tableauNavires.length;
		for (int i=0; i<taille; i++) {
			System.out.print(i+1+" ");
			if (i<9 && taille>9){
				System.out.print(" ");
			}
			for(int j=0; j<taille; j++){
				System.out.print(tableauNavires[i][j]);
				System.out.print(" ");
			}
			System.out.print("    ");
			System.out.print(i+1+" ");
			if (i<9 && taille>9){
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

	/* print l'ensemble des 2 grilles de jeu */
	public void print() {

		printEnTete();
		printNomColonnes();
		printTableaux();
	}

	/* @return la taille de la grille */
	public int getSize(){
        return tableauNavires.length;
    }

    /* Place un bateau dans la grille
    * @param ship = bateau à placer
    * @param x = abscisse (colonne)
    * @param y = ordonnée (ligne)
    */
    public void putShip(AbstractShip ship, int x, int y) { 
        int tailleShip = ship.getLength();

        try {
	        switch(ship.getOrientation()) {
	            case NORTH:
	            	if (y-tailleShip <0) {
	            		throw new Exception("Piece hors plateau");
	            	}
	            	else {
	            		for (int i=0; i<tailleShip; i++){
	            			if (tableauNavires[y-i][x]!='.'){
	            				throw new Exception("Il y a déjà un bateau placé sur cet emplacement");
	            			}
	            		}
	            		for (int i=0; i<tailleShip; i++){
	            			tableauNavires[y-i][x]=ship.getLabel();
	            		}
	            		ship.setPut();		            		
	            	}
	            	break;

	            case SOUTH:
	            	if (y+tailleShip > getSize()) {
	            		throw new Exception("Piece hors plateau");
	            	}
	            	else {
	            		for (int i=0; i<tailleShip; i++){
	            			if (tableauNavires[y+i][x]!='.'){
	            				throw new Exception("Il y a déjà un bateau placé sur cet emplacement");
	            			}
	            		}
	            		for (int i=0; i<tailleShip; i++){
	            			tableauNavires[y+i][x]=ship.getLabel();
	            		}	
	            		ship.setPut();   	                   		
	            	}
	            	break;

	            case WEST:
	            	if (x-tailleShip <0) {
	            		throw new Exception("Piece hors plateau");
	            	}
	            	else {
	            		for (int i=0; i<tailleShip; i++){
	            			if (tableauNavires[y][x-i]!='.'){
	            				throw new Exception("Il y a déjà un bateau placé sur cet emplacement");
	            			}
	            		}
	            		for (int i=0; i<tailleShip; i++){
	            			tableauNavires[y][x-i]=ship.getLabel();
	            		}	
	            		ship.setPut();            		
	            	}
	            	break;

	            case EAST:
	            	if (x+tailleShip > getSize()) {
	            		throw new Exception("Piece hors plateau");
	            	}
	            	else {
	            		for (int i=0; i<tailleShip; i++){
	            			if (tableauNavires[y][x+i]!='.'){
	            				throw new Exception("Il y a déjà un bateau placé sur cet emplacement");
	            			}
	            		}
	            		for (int i=0; i<tailleShip; i++){
	            			tableauNavires[y][x+i]=ship.getLabel();
	            		}
	            		ship.setPut();
	            	
	            	}
	            	break;
	        }
	    }
	    catch (Exception e) {
	    	System.out.println(e.toString());
	    }
    }

    /* vérifie s'il y a un bateau à une certaine coordonnée 
    * @param x = abscisse (colonne)
    * @param y = ordonnée (ligne)
    * @return un booléen indiquant s'il y a un bateau ou non
    */

    public boolean hasShip(int x, int y) {
    	if (tableauNavires[y][x]!='.') {
    		return true;
    	}

    	else {
    		return false;
    	}
    }

    public void setHit(boolean hit, int x, int y) {
    	tableauFrappes[y][x] = hit;
    }

    /* Récupère la frappe à une certaine coordonnée 
    * @param x = abscisse (colonne)
    * @param y = ordonnée (ligne)
    * @return un booléen indiquant s'il y a eu une frappe ou non
    */
    public Boolean getHit(int x, int y) {
    	return tableauFrappes[y][x];
    }

}
