package org.ticTacToe.pieces;

/**
 * PlayingPiece - Represents a game piece that a player uses
 *
 * Purpose: Encapsulates the piece type and provides methods to access it
 *
 * Design Pattern: Value Object
 * - Contains a value (PieceType)
 * - Immutable behavior (once created, piece type defines the piece)
 * - Can be shared among multiple game instances
 */
public class PlayingPiece {
    // The type of this piece (X, O, $, etc.)
    private PieceType pieceType;

    /**
     * Constructor creates a piece of the specified type
     * @param pieceType - The type of piece (X, O, $, etc.)
     */
    public PlayingPiece(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    /**
     * Gets the piece type
     * @return The PieceType of this piece
     */
    public PieceType getPieceType() {
        return pieceType;
    }

    /**
     * Sets the piece type (allows changing piece after creation)
     * @param pieceType - The new piece type
     */
    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }
}
