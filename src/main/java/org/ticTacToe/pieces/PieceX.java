package org.ticTacToe.pieces;

/**
 * PieceX - Concrete X piece for Tic Tac Toe
 *
 * This class demonstrates the Factory Pattern variant
 * Instead of creating PlayingPiece(PieceType.X) everywhere,
 * clients can use new PieceX() for cleaner code
 *
 * Benefits:
 * - Encapsulates piece type creation
 * - More readable and self-documenting code
 * - Easy to add piece-specific behavior later if needed
 */
public class PieceX extends PlayingPiece {
    /**
     * Constructor automatically creates an X piece
     * No need for clients to specify PieceType.X
     */
    public PieceX() {
        super(PieceType.X);
    }
}
