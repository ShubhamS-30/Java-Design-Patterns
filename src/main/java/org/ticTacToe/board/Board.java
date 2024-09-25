package org.ticTacToe.board;

import org.ticTacToe.exceptions.IllegalMoveException;
import org.ticTacToe.pieces.PieceType;
import org.ticTacToe.players.Player;

public class Board {
    private Integer dimension;
    private PieceType[][] board;
    private Integer possibleMoves;

    public Board(Integer dimension) {
        this.dimension = dimension;
        board = new PieceType[dimension][dimension];
        possibleMoves = dimension*dimension;
    }

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

    public void MarkBox(Integer row, Integer col, Player player) throws IllegalMoveException
    {
        if(row >= dimension || col >= dimension || row < 0 || col < 0)
            throw new IllegalMoveException("Row or Column out of bounds");
        if(board[row][col] != null)
            throw new IllegalMoveException("Piece is already occupied");

        board[row][col] = player.getPlayingPiece().getPieceType();
        possibleMoves--;
    }
}
