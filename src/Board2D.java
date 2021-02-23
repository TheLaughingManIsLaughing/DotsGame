/**
 * Author: Sam (Jia Wei) Liu
 * Revised: April 2, 2020
 *
 * Description: An ADT that represents a board of colored dots
 */

package src;

import src.PointT;
import src.DotT;
import java.util.ArrayList;

/**
 * @brief An ADT that represents a matrix of DotT enums
 * using a 2D array and provides methods for manipulating
 * the content in the matrix
 */
public class Board2D {

    protected ArrayList<ArrayList<DotT>> board;
    protected int nRow = 6;
    protected int nCol = 6;
    private int remainingMoves = 5;
    private int remainingDots = 10;
    private DotT color = DotT.R;

    /**
     * @brief Checks if a row index value is within the
     * number of rows in the 2D array
     * @param i Represents the row index value as an integer
     * @return A boolean where true represents that the
     * row index value is within the number of rows
     */
    private boolean validRow(int i) {
        if (0 <= i && i <= nRow) {
            return true;
        }
        return false;
    }

    /**
     * @brief Checks if a column index value is within the
     * number of rows in the 2D array
     * @param j Represents the column index value as an integer
     * @return A boolean where true represents that the
     * column index value is within the number of columns
     */
    private boolean validCol(int j) {
        if (0 <= j && j <= nCol) {
            return true;
        }
        return false;
    }

    /**
     * @brief Checks if the point is with the number of rows
     * and columns of the 2D array
     * @param p Represents a point of type PointT
     * @return A boolean where true represents that the
     * row and column values are within the 2D array
     */
    private boolean validPoint(PointT p) {
        if (validRow(p.row()) && validCol(p.col())) {
            return true;
        }
        return false;
    }

    /**
     * @brief Initializes a Board2D object. Creates a 6 x 6
     * 2D ArrayList of random DotT enum values.
     * Use with the Controller!
     */
    /*
    public Board2D() {
        board = new ArrayList<>();
        for (int i = 0; i < nRow; i++) {
            ArrayList<DotT> newRow = new ArrayList<>();
            for (int j = 0; j < nCol; j++) {
                DotT randomDotT = DotT.getRandom();
                newRow.add(randomDotT);
            }
            board.add(newRow);
        }
    }
     */

    /**
     * @brief Initializes a Board2D object with a manually created
     * 2D ArrayList.
     * ONLY FOR TESTING PURPOSES. Comment out this constructor
     * and use the constructor above with the controller!
     * @param b Represents the 2D ArrayList as an input
     */
    public Board2D(ArrayList<ArrayList<DotT>> b) {
        board = b;
    }


    /**
     * @brief Takes in a PointT object and returns the DotT value
     * at that position of the 2D ArrayList
     * @throws IndexOutOfBoundsException if the PointT object is not
     * a valid point
     * @param p Represents the PointT object as an input
     * @return A DotT value
     */
    public DotT getDot(PointT p) {
        if (!(validPoint(p))) {
            throw new IndexOutOfBoundsException();
        }
        return board.get(p.row()).get(p.col());
    }

    /**
     * @brief Takes in a PointT object and a DotT value, and then
     * replaces the value in the 2D ArrayList at the PointT position
     * with the DotT value
     * @throws IndexOutOfBoundsException if the PointT object is not
     * a valid point
     * @param p Represents a PointT object as an input
     * @param d Represents a DotT enum as an input
     */
    public void setDot(PointT p, DotT d) {
        if (!(validPoint(p))) {
            throw new IndexOutOfBoundsException();
        }
        board.get(p.row()).set(p.col(), d);
    }

    /**
     * @brief Takes in an ArrayList of PointT objects and checks
     * if each point is next to each other and if the DotT value
     * in the 2D ArrayList is the same
     * @param pList Represents the ArrayList of PointT objects as input
     * @return Boolean value where 'true' represents that the ArrayList of
     * PointT objects is a valid list and 'false' if not
     */
    public boolean validPointList(ArrayList<PointT> pList) {
        if (pList.size() <= 1) {
            return false;
        }
        for (int i = 0; i < pList.size() - 1; i++) {
            if (pList.get(i).row() == pList.get(i + 1).row()) {
                if (pList.get(i).col() + 1 == pList.get(i + 1).col() || pList.get(i).col() - 1 == pList.get(i + 1).col()) {
                    if (getDot(pList.get(i)) == getDot(pList.get(i + 1))) {
                        return true;
                    }
                }
            } else if (pList.get(i).col() == pList.get(i + 1).col()) {
                if (pList.get(i).row() + 1 == pList.get(i + 1).row() || pList.get(i).row() - 1 == pList.get(i + 1).row()) {
                    if (getDot(pList.get(i)) == getDot(pList.get(i + 1))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    /**
     * @brief Takes in an ArrayList of PointT objects and sets
     * those positions in the 2D ArrayList to null
     * @param pList Represents the ArrayList of PointT objects as input
     */
    public void clearDots(ArrayList<PointT> pList) {
        for (int i = 0; i < pList.size(); i++) {
            setDot(pList.get(i), null);
        }
    }

    /**
     * @brief Moves all the nulls in the 2D ArrayList to the 'top' of
     * the 2D ArrayList
     */
    public void moveNulls() {
        int counter = 5;
        while (counter > 0){
            for (int row = 1; row < 6; row++) {
                for (int col = 0; col < 6; col++) {
                    if (board.get(row).get(col) == null) {
                        DotT temp = board.get(row - 1).get(col);
                        board.get(row - 1).set(col, null);
                        board.get(row).set(col, temp);
                    }
                }
            }
            counter--;
        }
    }

    /**
     * @brief Replaces all the nulls in the 2D ArrayList with
     * a random DotT enum value
     */
    public void fillNulls() {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                if (board.get(row).get(col) == null) {
                    board.get(row).set(col, DotT.getRandom());
                }
            }
        }
    }

    /**
     * @brief Consists of all the actions in a single turn. Checks
     * if the inputted ArrayList of PointT objects is valid or not.
     * Subtracts 'remainingDots' by size of pList if the DotT selected
     * in pList matches the state variable 'color'. Executes the methods
     * clearDots(), moveNulls(), and fillNulls() in that order, and then
     * subtracts the state variable 'remainingMoves' by 1.
     * @param pList Represents the ArrayList of PointT objects as input
     */
    public void executeMove(ArrayList<PointT> pList) {
        if (!validPointList(pList)) {
            throw new IllegalArgumentException("Invalid input list!");
        }
        if (getDot(pList.get(0)) == color) {
            remainingDots = remainingDots - pList.size();
            if (remainingDots < 0) {
                remainingDots = 0;
            }
        }
        clearDots(pList);
        moveNulls();
        fillNulls();
        remainingMoves = remainingMoves - 1;
    }

    /**
     * @brief Getter method for 'board'
     * @return The board as a 2D ArrayList
     */
    public ArrayList<ArrayList<DotT>> getBoard() {
        return board;
    }

    /**
     * @brief Getter method for 'remainingMoves'
     * @return An integer
     */
    public int getRemainingMoves() {
        return remainingMoves;
    }

    /**
     * @brief Getter method for 'remainingDots'
     * @return An integer
     */
    public int getRemainingDots() {
        return remainingDots;
    }
}
