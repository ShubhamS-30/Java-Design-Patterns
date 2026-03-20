package org.ticTacToe.exceptions;

/**
 * IllegalMoveException - Custom Exception for invalid Tic Tac Toe moves
 *
 * Purpose: Represents an invalid move in the game
 *
 * When thrown:
 * 1. Player tries to mark a position outside board bounds
 * 2. Player tries to mark an already occupied position
 * 3. Invalid player or game state
 *
 * Design Pattern: Custom Exception Pattern
 * - Extends Java's Exception class
 * - Provides game-specific error information
 * - Allows caller to specifically catch game-related errors
 *
 * Usage:
 * try {
 *     board.MarkBox(row, col, player);
 * } catch (IllegalMoveException e) {
 *     System.out.println(e.getMessage());
 * }
 */
public class IllegalMoveException extends Exception {
    /**
     * Constructor creates exception with a detailed error message
     * @param msg - Description of what went wrong
     */
    public IllegalMoveException(String msg) {
        super("Illegal move: " + msg);
    }
}
