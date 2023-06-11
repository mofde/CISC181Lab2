package cisc181.lab_2;
import org.junit.Test;
import static org.junit.Assert.*;
public class KangarooPieceTest {
    @org.junit.Test
    public void isHidden() {
        System.out.println("Testing isHidden");
        KangarooPiece tstKP = new KangarooPiece();
        assertTrue(tstKP.isHidden());
    }
    @Test
    public void test_jumped() {
        System.out.println("Testing jumped");
        KangarooPiece tstKP = new KangarooPiece("Kanga",false,5,10);
        assertEquals(tstKP.getNumJumps(),5);
        tstKP.jumped();
        tstKP.jumped();
        System.out.println("Testing changeKicks");
        assertEquals(tstKP.getNumJumps(), 7);
        tstKP.changeKicks(-8);
        assertEquals(tstKP.getNumKicks(), 2);
        tstKP.changeKicks(4);
        assertEquals(tstKP.getNumKicks(), 6);
        tstKP.changeKicks(-8);
        assertEquals(tstKP.getNumKicks(), 0);
    }
    @Test
    public void test_offSpring() {
        System.out.println("Testing offSpring");
        KangarooPiece tstKP = new KangarooPiece("Kanga", false, 3, 7);
        KangarooPiece babyKP = tstKP.offSpring("-baby");
        assertEquals(7, babyKP.getNumKicks());
        assertEquals(3, babyKP.getNumJumps());
        assertEquals("Kanga-baby", babyKP.getSymbol());
        assertFalse(tstKP.isHidden());
        assertFalse(tstKP == babyKP);
        KangarooPiece tstKP1 = new KangarooPiece("Meli", true, 0, 0);
        KangarooPiece babyKP1 = tstKP1.offSpring("ssa");
        assertEquals(0, babyKP1.getNumKicks());
        assertEquals(0, babyKP1.getNumJumps());
        assertEquals("Melissa", babyKP1.getSymbol());
        KangarooPiece tstKP2 = new KangarooPiece("J", true, 1, 3);
        KangarooPiece babyKP2 = tstKP2.offSpring("C");
        assertEquals(1, babyKP2.getNumJumps());
        assertEquals(3, babyKP2.getNumKicks());
        assertEquals("JC", babyKP2.getSymbol());
        KangarooPiece tstKP3 = new KangarooPiece("Maye", false, 2, 8);
        KangarooPiece babyKP3 = tstKP3.offSpring("tte");
        assertEquals(2, babyKP3.getNumJumps());
        assertEquals(8, babyKP3.getNumKicks());
        assertEquals("Mayette", babyKP3.getSymbol());
    }
}