/**
 * Author: Sam (Jia Wei) Liu
 * Revised: April 2, 2020
 *
 * Description: A view module for printing out the state of the game
 */

package src;

import src.Board2D;
import src.DotT;
import java.util.ArrayList;

/**
 * @brief Class that prints out the board, remaining moves, and remaining dots
 */
public class ViewBoard {

    /**
     * @brief Prints out the contents of the 2D ArrayList and labels the rows
     * and columns
     * @param board Represents the 2D ArrayList of DotT enum values to be printed out
     */
    public void printBoard(ArrayList<ArrayList<DotT>> board) {
        System.out.println("  0 1 2 3 4 5");
        for (int row = 0; row < 6; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < 6; col++) {
                if (col == 5) {
                    System.out.println(board.get(row).get(col));
                } else {
                    System.out.print(board.get(row).get(col) + " ");
                }
            }
        }
    }

    /**
     * @brief Prints out the number of remaining moves
     * @param remainingMoves Represents the number of remaining moves as an integer input
     */
    public void printRemainingMoves(int remainingMoves) {
        System.out.println("Remaining moves: " + remainingMoves);
    }

    /**
     * @brief Prints out the number of remaining dots left to clear
     * @param remainingDots Represents the number of remaining dots left to clear
     * as an integer input
     */
    public void printRemainingDots(int remainingDots) {
        System.out.println("Remaining R dots left: " + remainingDots);
    }
}
