package org.ticTacToe.pieces;

/**
 * PieceO - Concrete O piece for Tic Tac Toe
 *
 * This class demonstrates the Factory Pattern variant
 * Instead of creating PlayingPiece(PieceType.O) everywhere,
 * clients can use new PieceO() for cleaner code
 *
 * Benefits:
 * - Encapsulates piece type creation
 * - More readable and self-documenting code
 * - Easy to add piece-specific behavior later if needed
 */
public class PieceO extends PlayingPiece {
    /**
     * Constructor automatically creates an O piece
     * No need for clients to specify PieceType.O
     */
    public PieceO() {
        super(PieceType.O);
    }
}
