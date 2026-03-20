package org.ticTacToe.pieces;

/**
 * PieceType - Enum for different piece types in Tic Tac Toe
 *
 * Purpose: Defines all available piece types that players can use
 *
 * Using Enum Benefits:
 * 1. Type-safe: Only valid piece types can be created
 * 2. Prevents invalid values: No "Z" or "invalid" pieces
 * 3. Easy comparison and switching on piece types
 *
 * Piece Types:
 * X - Traditional X piece (player 1)
 * O - Traditional O piece (player 2)
 * $ - Dollar sign piece (for additional players)
 * C - Another piece type
 * T - Another piece type
 *
 * This design supports multi-player Tic Tac Toe (more than 2 players)
 */
public enum PieceType {
    X, O, $, C, T
}
