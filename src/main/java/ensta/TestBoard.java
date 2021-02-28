package ensta;
import ensta.ships.*;


public class TestBoard  
{
    public static void main( String[] args )
    {
        Board plateau = new Board("bataille navale", 5);
		plateau.print();

		Board plateau2 = new Board("bataille navale");
		plateau2.print();

		Board plateau3 = new Board("bataille navale", 16);
		plateau3.print();
    }
}
