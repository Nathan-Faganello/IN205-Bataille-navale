package ensta;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import ensta.ships.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testSetOrientation() {
        Submarine submarine1 = new Submarine();
        submarine1.setOrientation(Orientation.NORTH);
        assertTrue(submarine1.getOrientation() == Orientation.NORTH);
    }

    public void testSetHit() {
        Board plateau = new Board("Essai");
        plateau.setHit(true, 4, 1);
        assertTrue(plateau.getHit(4, 1)==true);
    }

    public void testPutShip(){
        Board plateau = new Board("Essai");
        Submarine submarine1 = new Submarine();
        plateau.putShip(submarine1, 3, 3);
        assertTrue(plateau.hasShip(3,3));
    }

    public void testGetHitHorsPlateau() {
        Board plateau = new Board("Essai");
        assertTrue(plateau.getHit(15, 0)==false);
    }

    public void testHasShipHorsPlateay() {
        Board plateau = new Board("Essai");
        assertTrue(plateau.hasShip(15, 0)==false);
    }
}
