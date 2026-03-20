package org.ticTacToe.board;

import org.ticTacToe.exceptions.IllegalMoveException;
import org.ticTacToe.pieces.PieceType;
import org.ticTacToe.players.Player;

/**
 * Board - Represents the Tic Tac Toe game board
 *
 * Purpose: Manages the board state and validates moves
 *
 * Key Responsibilities:
 * 1. Store the current state of the board (which pieces are placed where)
 * 2. Validate moves (check bounds, check if position is empty)
 * 3. Mark positions when players make moves
 * 4. Track the number of remaining possible moves
 *
 * Board Features:
 * - Variable size (4x4, 5x5, NxN supported)
 * - 2D array to represent the board (null = empty, PieceType = occupied)
 * - Throws IllegalMoveException for invalid moves
 */
public class Board {
    // Dimension of the board (4 = 4x4 board)
    private Integer dimension;

    // 2D array representing the board state
    // null = empty cell, PieceType = occupied cell
    private PieceType[][] board;

    // Number of empty cells remaining on the board
    private Integer possibleMoves;

    /**
     * Constructor initializes an empty board
     * @param dimension - The size of the board (dimension x dimension)
     */
    public Board(Integer dimension) {
        this.dimension = dimension;
        board = new PieceType[dimension][dimension];
        // Initially all cells are empty, so all cells are possible moves
        possibleMoves = dimension * dimension;
    }

    // Getters and Setters
    public Integer getPossibleMoves() {
        return possibleMoves;
    }

    public PieceType[][] getBoard() {
        return board;
    }

    public void setBoard(PieceType[][] board) {
        this.board = board;
    }

    public Integer getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    /**
     * Marks a position on the board with a player's piece
     *
     * Validates:
     * 1. Row and column are within board bounds
     * 2. The cell is not already occupied
     *
     * @param row - Row position (0 to dimension-1)
     * @param col - Column position (0 to dimension-1)
     * @param player - The player making the move
     * @throws IllegalMoveException - If move is invalid
     */
    public void MarkBox(Integer row, Integer col, Player player) throws IllegalMoveException
    {
        // Validate bounds: row and column must be within 0 to dimension-1
        if(row >= dimension || col >= dimension || row < 0 || col < 0)
            throw new IllegalMoveException("Row or Column out of bounds");

        // Validate cell is empty: if cell already has a piece, it's occupied
        if(board[row][col] != null)
            throw new IllegalMoveException("Piece is already occupied");

        // Mark the cell with the player's piece type
        board[row][col] = player.getPlayingPiece().getPieceType();

        // Decrement available moves since one cell is now filled
        possibleMoves--;
    }
}
