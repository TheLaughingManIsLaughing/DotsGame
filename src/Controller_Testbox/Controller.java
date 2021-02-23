/**
 * Author: Sam (Jia Wei) Liu
 * Revised: April 2, 2020
 *
 * Description: Controller module for interfacing between Board2D and ViewBoard
 */

import src.DotT;
import src.PointT;
import src.Board2D;
import src.ViewBoard;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @brief This module takes in user input and converts it to an ArrayList of PointT
 * objects, which is then used as the input for the Board2D ADT. This controller module
 * calls the Board2D methods to manipulate the board, and then calls the ViewBoard
 * module to print out information on the game state stored in Board2D.
 */
public class Controller {
    public static void main (String [] args) {

        // Create instance of game and the view
        Board2D dotGame = new Board2D();
        ViewBoard view = new ViewBoard();
        // Print out the initial state of the game
        view.printRemainingMoves(dotGame.getRemainingMoves());
        view.printRemainingDots(dotGame.getRemainingDots());
        view.printBoard(dotGame.getBoard());

        // Get and process user input
        while (dotGame.getRemainingDots() > 0 && dotGame.getRemainingMoves() > 0) {
            System.out.println("Enter your moves as coordinates in the form of a 2-digit number (ex. 00,01,02): ");
            Scanner keyboard = new Scanner(System.in);
            String input = keyboard.nextLine();
            String[] input_array = input.split(",");
            ArrayList<PointT> inputPoints = new ArrayList<>();

            for (int i = 0; i < input_array.length; i++) {
                String input_pair = input_array[i];
                if (input_pair.length() > 2) {
                    throw new IllegalArgumentException("Invalid input list!");
                }
                int row = Integer.parseInt(Character.toString(input_pair.charAt(0)));
                int col = Integer.parseInt(Character.toString(input_pair.charAt(1)));

                inputPoints.add(new PointT(row, col));
            }

            // Update the game and print it out
            dotGame.executeMove(inputPoints);
            view.printRemainingMoves(dotGame.getRemainingMoves());
            view.printRemainingDots(dotGame.getRemainingDots());
            view.printBoard(dotGame.getBoard());

            // Win/lose conditions
            if (dotGame.getRemainingDots() == 0) {
                System.out.println("You win!");
            } else if (dotGame.getRemainingMoves() == 0) {
                System.out.println("You lose!");
            }
        }
    }
}
