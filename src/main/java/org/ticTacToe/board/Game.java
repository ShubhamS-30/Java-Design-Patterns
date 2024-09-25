package org.ticTacToe.board;

import org.ticTacToe.exceptions.IllegalMoveException;
import org.ticTacToe.pieces.PieceType;
import org.ticTacToe.players.Player;

import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    private Queue<Player> players;
    private Board board;
    private Boolean winnerFound;

    public Game(Queue<Player> players, Board board) {
        this.players = players;
        this.board = board;
        winnerFound = false;
    }

    public Queue<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Deque<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void PrintBoard() {
        int dimension = board.getDimension();
        PieceType[][] boardPieces = board.getBoard();
        System.out.print("  | ");
        for (int i = 0; i < dimension; i++) {
            System.out.print(i + " | ");
        }
        System.out.println();
        for (int row = 0; row < dimension; row++) {
            System.out.print(row + " | ");
            for (int col = 0; col < dimension; col++) {
                if (boardPieces[row][col] != null)
                    System.out.print(boardPieces[row][col]);
                else
                    System.out.print(" ");
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

    private void MakeAMove() throws IllegalMoveException {


        Player currentPlayer = players.peek();

        if (currentPlayer == null) {
            throw new IllegalMoveException("INVALID_PLAYER");
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Turn of player " + currentPlayer.getPlayerName() + " Piece : " + currentPlayer.getPlayingPiece().getPieceType());
        System.out.print("Enter row = ");
        Integer row = input.nextInt();
        System.out.print("Enter col = ");
        Integer col = input.nextInt();
        try {
            board.MarkBox(row, col, currentPlayer);
            if (isWinner(row, col)) {
                System.out.println("<--------------- WINNER : " + currentPlayer.getPlayerName() + "--------------->");
                winnerFound = true;
            } else {
                players.remove();
                players.add(currentPlayer);
            }
        } catch (IllegalMoveException e) {
            System.out.println("ERROR : " + e.getMessage());
            System.out.println("TRY AGAIN!!!");
        }
    }

    private Boolean isWinner(Integer row, Integer col) {
        Integer dimension = board.getDimension();
        PieceType[][] boardPieces = board.getBoard();
        if (row > 0 && row < dimension - 1 && (boardPieces[row][col] == boardPieces[row - 1][col] && boardPieces[row][col] == boardPieces[row + 1][col])) {
            return true;
        } else if (col > 0 && col < dimension - 1 && (boardPieces[row][col] == boardPieces[row][col + 1] && boardPieces[row][col] == boardPieces[row][col - 1])) {
            return true;
        } else if (col < dimension - 2 && (boardPieces[row][col] == boardPieces[row][col + 1] && boardPieces[row][col] == boardPieces[row][col + 2]))
            return true;
        else if (row < dimension - 2 && (boardPieces[row][col] == boardPieces[row + 1][col] && boardPieces[row][col] == boardPieces[row + 2][col]))
            return true;
        else if (col > 1 && (boardPieces[row][col] == boardPieces[row][col - 1] && boardPieces[row][col] == boardPieces[row][col - 2]))
            return true;
        else if (row > 1 && (boardPieces[row - 2][col] == boardPieces[row][col] && boardPieces[row][col] == boardPieces[row - 1][col]))
            return true;
        else if ((col < dimension - 2 && row < dimension - 2) && (boardPieces[row][col] == boardPieces[row + 1][col + 1] && boardPieces[row][col] == boardPieces[row + 2][col + 2]))
            return true;
        else if ((col > 1 && row > 1) && (boardPieces[row][col] == boardPieces[row - 1][col - 1] && boardPieces[row][col] == boardPieces[row - 2][col - 2]))
            return true;
        else if ((col < dimension - 2 && row > 1) && (boardPieces[row][col] == boardPieces[row - 1][col + 1] && boardPieces[row][col] == boardPieces[row - 2][col + 2]))
            return true;
        else if ((col > 1 && row < dimension - 2) && (boardPieces[row][col] == boardPieces[row + 1][col - 1] && boardPieces[row][col] == boardPieces[row + 2][col - 2]))
            return true;
        else if ((row > 0 && row < dimension - 1) && (col > 0 && col < dimension - 1) && (boardPieces[row][col] == boardPieces[row + 1][col + 1] && boardPieces[row][col] == boardPieces[row - 1][col - 1]))
            return true;
        else if ((row > 0 && row < dimension - 1) && (col > 0 && col < dimension - 1) && (boardPieces[row][col] == boardPieces[row - 1][col + 1] && boardPieces[row][col] == boardPieces[row + 1][col - 1]))
            return true;
        return false;
    }


    public void StartGame() throws IllegalMoveException {
        if (players == null || players.isEmpty()) {
            throw new IllegalMoveException("NO_PLAYER_FOUND");
        }
        PrintBoard();
        while (board.getPossibleMoves() > 0) {
            MakeAMove();
            PrintBoard();
            if (winnerFound) {
                break;
            }

        }

        if (!winnerFound) {
            System.out.println("----------DRAW-----------");
        }
    }
}
