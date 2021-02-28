package ensta;

import ensta.ships.*;

public class Board implements IBoard {

	protected String nom;
	protected ShipState tableauNavires[][];
	protected Boolean tableauFrappes[][];

	/* constructeur valué 
	* @param nom = nom de la grille
	* @param taille = taille de la grille 
	Créer une grille nom de dimension taille x taille
	*/

	public Board(String nom, int taille) {
		this.nom=nom;
		this.tableauNavires=new ShipState[taille][taille];
		this.tableauFrappes=new Boolean[taille][taille];
		for (int i=0; i<taille; i++) {
			for (int j=0; j<taille;j++) {
				this.tableauFrappes[i][j]= null;
				this.tableauNavires[i][j]= new ShipState();
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
		this.tableauNavires=new ShipState[10][10];
		this.tableauFrappes=new Boolean[10][10];
		for (int i=0; i<10; i++) {
			for (int j=0; j<10;j++) {
				this.tableauFrappes[i][j]= null;
				this.tableauNavires[i][j]= new ShipState();
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
				System.out.print(tableauNavires[i][j].toString());
				System.out.print(" ");
			}
			System.out.print("    ");
			System.out.print(i+1+" ");
			if (i<9 && taille>9){
				System.out.print(" ");
			}
			for(int j=0; j<taille; j++){
				if (tableauFrappes[i][j] == null) {
					System.out.print(ColorUtil.colorize(". ", ColorUtil.Color.WHITE));
				}
				else if (tableauFrappes[i][j] == false){
					System.out.print(ColorUtil.colorize("X ", ColorUtil.Color.WHITE));
				}
				else {
					System.out.print(ColorUtil.colorize("X ", ColorUtil.Color.RED));
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

    /* return le nom de la board */
    public String getName() {
    	return nom;
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
	            	if (y+1-tailleShip <0) {
	            		throw new Exception("Piece hors plateau");
	            	}
	            	else {
	            		for (int i=0; i<tailleShip; i++){
	            			if (tableauNavires[y-i][x].ship!=null){
	            				throw new Exception("Il y a déjà un bateau placé sur cet emplacement");
	            			}
	            		}
	            		ship.setPut();
	            		for (int i=0; i<tailleShip; i++){
	            			tableauNavires[y-i][x]= new ShipState(ship);
	            		}	            		
	            	}
	            	break;

	            case SOUTH:
	            	if (y+tailleShip > getSize()) {
	            		throw new Exception("Piece hors plateau");
	            	}
	            	else {
	            		for (int i=0; i<tailleShip; i++){
	            			if (tableauNavires[y+i][x].ship!=null){
	            				throw new Exception("Il y a déjà un bateau placé sur cet emplacement");
	            			}
	            		}
	            		ship.setPut();
	            		for (int i=0; i<tailleShip; i++){
	            			tableauNavires[y+i][x]= new ShipState(ship);
	            		}	   	                   		
	            	}
	            	break;

	            case WEST:
	            	if (x+1-tailleShip <0) {
	            		throw new Exception("Piece hors plateau");
	            	}
	            	else {
	            		for (int i=0; i<tailleShip; i++){
	            			if (tableauNavires[y][x-i].ship!=null){
	            				throw new Exception("Il y a déjà un bateau placé sur cet emplacement");
	            			}
	            		}
	            		ship.setPut();
	            		for (int i=0; i<tailleShip; i++){
	            			tableauNavires[y][x-i]= new ShipState(ship);
	            		}	         		
	            	}
	            	break;

	            case EAST:
	            	if (x+tailleShip > getSize()) {
	            		throw new Exception("Piece hors plateau");
	            	}
	            	else {
	            		for (int i=0; i<tailleShip; i++){
	            			if (tableauNavires[y][x+i].ship!=null){
	            				throw new Exception("Il y a déjà un bateau placé sur cet emplacement");
	            			}
	            		}
	            		ship.setPut();
	            		for (int i=0; i<tailleShip; i++){
	            			tableauNavires[y][x+i]= new ShipState(ship);
	            		}
	            	
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
    	try {
	    	if (tableauNavires[y][x].ship != null && !tableauNavires[y][x].isSunk()) {
	    		return true;
	    	}

	    	else {
	    		return false;
	    	}
	    }
	    catch (Exception e) {
	    	System.out.println("indice hors tableau : false par défaut");
	    	return false;
	    }
    }

    public void setHit(boolean hit, int x, int y) {
    	try {
    		tableauFrappes[y][x] = hit;
    	}
    	catch (Exception e) {
    		System.out.println("indice hors tableau : frappe non comptabilisée");
    	}
    }

    /* Récupère la frappe à une certaine coordonnée 
    * @param x = abscisse (colonne)
    * @param y = ordonnée (ligne)
    * @return un booléen indiquant s'il y a eu une frappe ou non
    */
    public Boolean getHit(int x, int y) {
    	try {
    		return tableauFrappes[y][x];
    	}
    	catch (Exception e) {
    		System.out.println("indice hors tableau : false par défaut");
    		return false;
    	}
    }

    /* Envoie une frappe sur un plateau 
    * @param x = abscisse
    * @param y = ordonnée
    * @return la valeur du Hit */
    public Hit sendHit(int x, int y) {

    	try {
	    	if (!tableauNavires[y][x].isStruck()) {
	    		if (tableauNavires[y][x].ship != null) {
	    			if (!tableauNavires[y][x].isSunk()){
	    				tableauNavires[y][x].addStrike();
	    				tableauNavires[y][x].ship.addStrike();
	    				if (tableauNavires[y][x].isSunk()) {
	    					System.out.println(tableauNavires[y][x].ship.getLabel()+" : Navire coulé");
	    					return Hit.fromInt(tableauNavires[y][x].ship.getLength());
	    				}
	    				else {
	    					return Hit.STIKE;
	    				}
	    			}
	    			else {
	    				return Hit.MISS;
	    			}
	    		}
	    		else {
	    			return Hit.MISS;
	    		}

	    	}
	    	else {
	    		System.out.println("Coordonée déjà visée : frappe manquée");
	    		return Hit.MISS;
	    	}
	    }
	    catch (Exception e){
	    	System.out.println("Coordonées hors tableau");
	    	return Hit.MISS;
    	}
    }

}
