/**
 * Author: Sam (Jia Wei) Liu
 * Revised: April 2, 2020
 *
 * Description: Testing of Board2D module
 */

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import java.util.ArrayList;
import java.util.Arrays;

import src.DotT;
import src.PointT;
import src.Board2D;

public class TestBoard2D {

    private ArrayList<ArrayList<DotT>> b;
    private Board2D board;
    private ArrayList<PointT> goodPointList;
    private ArrayList<PointT> badPointList;
    private PointT p1;
    private PointT p2;
    private PointT p3;
    private ArrayList<PointT> goodPointList2;

    @Before
    public void setUp() {
        b = new ArrayList<>();
        b.add(new ArrayList<DotT>(Arrays.asList(DotT.R, DotT.R, DotT.B, DotT.G, DotT.P, DotT.B)));
        b.add(new ArrayList<DotT>(Arrays.asList(DotT.G, DotT.R, DotT.Y, DotT.G, DotT.P, DotT.Y)));
        b.add(new ArrayList<DotT>(Arrays.asList(DotT.G, DotT.Y, DotT.Y, DotT.P, DotT.P, DotT.P)));
        b.add(new ArrayList<DotT>(Arrays.asList(DotT.Y, DotT.R, DotT.G, DotT.G, DotT.P, DotT.Y)));
        b.add(new ArrayList<DotT>(Arrays.asList(DotT.R, DotT.R, DotT.Y, DotT.G, DotT.P, DotT.R)));
        b.add(new ArrayList<DotT>(Arrays.asList(DotT.B, DotT.B, DotT.Y, DotT.P, DotT.P, DotT.Y)));
        board = new Board2D(b);

        p1 = new PointT(4, 0);
        p2 = new PointT(4, 1);
        p3 = new PointT(3, 1);
        goodPointList = new ArrayList<>();
        goodPointList.add(p1);
        goodPointList.add(p2);
        goodPointList.add(p3);

        badPointList = new ArrayList<>();
        badPointList.add(p1);
        badPointList.add(p3);
        badPointList.add(p2);

        goodPointList2 = new ArrayList<>();
        goodPointList2.add(new PointT(0,4));
        goodPointList2.add(new PointT(1,4));
        goodPointList2.add(new PointT(2,4));
        goodPointList2.add(new PointT(3,4));
        goodPointList2.add(new PointT(4,4));
        goodPointList2.add(new PointT(5,4));
    }

    @After
    public void tearDown() {
        b = null;
        board = null;
        goodPointList = null;
        badPointList = null;
        p1 = null;
        p2 = null;
        p3 = null;
        goodPointList2 = null;
    }

    @Test
    public void testGetDot() {
        assertEquals(board.getDot(p1), DotT.R);
    }

    @Test
    public void testSetDot1() {
        board.setDot(p1, DotT.B);
        assertEquals(board.getDot(p1), DotT.B);
    }

    @Test
    public void testSetDot2() {
        board.setDot(p3, null);
        assertNull(board.getDot(p3));
    }

    @Test
    public void testValidPointList1() {
        assertTrue(board.validPointList(goodPointList));
    }

    @Test
    public void testValidPointList2() {
        assertFalse(board.validPointList(badPointList));
    }

    @Test
    public void testValidPointList3() {
        assertTrue(board.validPointList(goodPointList2));
    }

    @Test
    public void testClearDots1() {
        board.clearDots(goodPointList);

        assertNull(board.getDot(p1));
        assertNull(board.getDot(p2));
        assertNull(board.getDot(p3));
    }

    @Test
    public void testClearDots2() {
        board.clearDots(goodPointList2);

        for (PointT pointT : goodPointList2) {
            assertNull(board.getDot(pointT));
        }
    }

    @Test
    public void testMoveNulls1() {
        board.clearDots(goodPointList);
        board.moveNulls();
        PointT pNull1 = new PointT(0,0);
        PointT pNull2 = new PointT(0,1);
        PointT pNull3 = new PointT(1,1);

        assertNull(board.getDot(pNull1));
        assertNull(board.getDot(pNull2));
        assertNull(board.getDot(pNull3));
    }

    @Test
    public void testMoveNulls2() {
        board.clearDots(goodPointList2);
        board.moveNulls();

        for (PointT pointT : goodPointList2) {
            assertNull(board.getDot(pointT));
        }
    }

    @Test
    public void testFillNulls1() {
        board.clearDots(goodPointList);
        board.moveNulls();
        board.fillNulls();
        PointT pNull1 = new PointT(0,0);
        PointT pNull2 = new PointT(0,1);
        PointT pNull3 = new PointT(1,1);

        assertTrue(board.getDot(pNull1) instanceof DotT);
        assertTrue(board.getDot(pNull2) instanceof DotT);
        assertTrue(board.getDot(pNull3) instanceof DotT);
    }

    @Test
    public void testFillNulls2() {
        PointT newPoint = new PointT(2,3);

        board.setDot(newPoint, null);
        assertNull(board.getDot(newPoint));

        board.fillNulls();
        assertTrue(board.getDot(newPoint) instanceof DotT);
    }

    @Test
    public void testExecuteMove1() {
        board.executeMove(goodPointList);
        PointT pNull1 = new PointT(0, 0);
        PointT pNull2 = new PointT(0, 1);
        PointT pNull3 = new PointT(1, 1);

        assertTrue(board.getDot(pNull1) instanceof DotT);
        assertTrue(board.getDot(pNull2) instanceof DotT);
        assertTrue(board.getDot(pNull3) instanceof DotT);

        assertEquals(board.getRemainingMoves(), 4);
        assertEquals(board.getRemainingDots(), 7);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testExecuteMove2() {
        board.executeMove(badPointList);
    }

    @Test
    public void testGetBoard() {
        for (int row = 0; row < board.getBoard().size(); row++) {
            for (int col = 0; col < board.getBoard().size(); col++) {
                assertEquals(board.getBoard().get(row).get(col), b.get(row).get(col));
            }
        }
    }
}
