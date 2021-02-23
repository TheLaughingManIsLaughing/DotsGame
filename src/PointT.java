/**
 * Author: Sam (Jia Wei) Liu
 * Revised: April 2, 2020
 *
 * Description: An ADT that represents a coordinate
 */

package src;

/**
 * An ADT that represents a point on a matrix
 */
public class PointT {

    private Integer r;
    private Integer c;

    /**
     * @brief Initializes a PointT object
     * @param row Represents the row index for the matrix
     * @param col Represents the column index for the matrix
     */
    public PointT(int row, int col) {
        r = row;
        c = col;
    }

    /**
     * @brief Getter method for the row
     * @return The row index value as an integer
     */
    public int row() {
        return r;
    }

    /**
     * @brief Getter method for the column
     * @return The column index value as an integer
     */
    public int col() {
        return c;
    }
}