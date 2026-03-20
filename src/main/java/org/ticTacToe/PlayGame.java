package org.ticTacToe;

import org.ticTacToe.board.Board;
import org.ticTacToe.board.Game;
import org.ticTacToe.exceptions.IllegalMoveException;
import org.ticTacToe.pieces.PieceType;
import org.ticTacToe.pieces.PlayingPiece;
import org.ticTacToe.players.Player;

import java.util.LinkedList;
import java.util.Queue;

/**
 * PlayGame - Main entry point for the Tic Tac Toe game
 *
 * This game demonstrates multiple design patterns:
 * 1. Builder Pattern (creating Game, Board, Players, Pieces)
 * 2. Exception Handling Pattern (IllegalMoveException)
 * 3. Object Composition (Player has PlayingPiece, Game has Board and Players)
 * 4. Queue Pattern (managing player turns in order)
 *
 * Game Features:
 * - Supports any number of players (3+ players in this example)
 * - Supports variable board size (4x4 board in this example)
 * - Detects winners and draws
 * - Handles invalid moves gracefully
 */
public class PlayGame {

    public static void main(String[] args) {

        // Step 1: Create the game board (4x4 size)
        Board board = new Board(4);

        // Step 2: Create players with their respective pieces
        // Each player needs a name and a unique piece type
        Player player1 = new Player("player 1", new PlayingPiece(PieceType.X));
        Player player2 = new Player("player 2", new PlayingPiece(PieceType.O));
        Player player3 = new Player("player 3", new PlayingPiece(PieceType.$));

        // Step 3: Add players to a Queue to manage turn order
        // Queue ensures players take turns in a circular fashion
        Queue<Player> players = new LinkedList<Player>();
        players.add(player1);
        players.add(player2);
        players.add(player3);

        // Step 4: Create and start the game
        // Game manages the game logic, board state, and player turns
        Game game = new Game(players, board);

        // Step 5: Start the game with exception handling
        // Catches any illegal moves or invalid game states
        try {
            game.StartGame();
        } catch (IllegalMoveException e) {
            System.out.println(e.getMessage());
        }

    }
}
