/**
 * Author: Sam (Jia Wei) Liu
 * Revised: April 2, 2020
 *
 * Description: DotT enumerator
 */
package src;

/**
 * @brief An enumerator that represents different colored dots
 */
public enum DotT {
    R, B, Y, G, P;

    /**
     * @brief Method that returns a random DotT enum
     * @return A DotT enum
     */
    public static DotT getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
