package ensta;
import java.io.Serializable;
import java.util.List;
import ensta.ships.*;

public class Player {
    /* **
     * Attributs
     */
    protected Board board;
    protected Board opponentBoard;
    protected int destroyedCount;
    protected AbstractShip[] ships;
    protected boolean lose;

    /* **
     * Constructeur
     */
    public Player(Board board, Board opponentBoard, List<AbstractShip> ships) {
        this.board = board;
        this.ships = ships.toArray(new AbstractShip[0]);
        this.opponentBoard = opponentBoard;
    }

    /* **
     * Méthodes
     */

    /**
     * Read keyboard input to get ships coordinates. Place ships on given coodrinates.
     */
    public void putShips() {
        boolean done = false;
        int i = 0;

        do {
            AbstractShip s = ships[i];
            String msg = String.format("placer %d : %s(%d)", i + 1, s.getName(), s.getLength());
            System.out.println(msg);
            InputHelper.ShipInput res = InputHelper.readShipInput();
            System.out.println(res);
            Orientation orient = Orientation.NORTH;



            // TODO set ship orientation
            switch(res.orientation) {
                case "n":
                    s.setOrientation(orient);
                    break;

                case "s":
                    orient=Orientation.SOUTH;
                    s.setOrientation(orient);
                    break;

                case "e":
                    orient=Orientation.EAST;
                    s.setOrientation(orient);
                    break;

                case "w":
                    orient=Orientation.WEST;
                    s.setOrientation(orient);
                    break;

            }


            // TODO put ship at given position
            board.putShip(s, res.x, res.y);

            // TODO when ship placement successful
            if (s.getPut()) {
                ++i;
            }
            done = i == 5;

            board.print();
        } while (!done);
    }


    public Hit sendHit(int[] coords) {
        boolean done;
        Hit hit = null;

        do {
            System.out.println("où frapper?");
            InputHelper.CoordInput hitInput = InputHelper.readCoordInput();
            // TODO call sendHit on this.opponentBoard

            hit = opponentBoard.sendHit(hitInput.x, hitInput.y);

            // TODO : Game expects sendHit to return BOTH hit result & hit coords.
            // return hit is obvious. But how to return coords at the same time ?
            // Quand on veut return 2 éléments simultanément, on peut utiliser une des variables d'entrée pour stocker ce qu'on veut récupérer. C'est pourquoi, on va stocker les coordonées retournées dans coords
            coords[0]=hitInput.x;
            coords[1]=hitInput.y;

            done = true;
        } while (!done);

        return hit;
    }

    

    public AbstractShip[] getShips() {
        return ships;
    }

    public void setShips(AbstractShip[] ships) {
        this.ships = ships;
    }

}
