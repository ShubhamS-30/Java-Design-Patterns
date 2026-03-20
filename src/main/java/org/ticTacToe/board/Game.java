package org.ticTacToe.board;

import org.ticTacToe.exceptions.IllegalMoveException;
import org.ticTacToe.pieces.PieceType;
import org.ticTacToe.players.Player;

import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

/**
 * Game - Orchestrates the Tic Tac Toe game logic
 *
 * Purpose: Manages game flow, player turns, move validation, and win detection
 *
 * Key Responsibilities:
 * 1. Manage player queue for turn order
 * 2. Handle each player's move
 * 3. Validate moves through the board
 * 4. Check for winners after each move
 * 5. Display the board state
 * 6. Handle game end (win or draw)
 *
 * Design Pattern: Game Engine/State Machine
 * - Manages the overall game state and flow
 * - Coordinates between Board, Players, and Pieces
 * - Enforces game rules (valid moves, win detection)
 *
 * Game Flow:
 * 1. Players take turns in queue order (Queue manages round-robin)
 * 2. After each move, check if current player won
 * 3. If won, game ends. If not, rotate to next player
 * 4. Continue until win or board is full (draw)
 */
public class Game {
    // Queue of players for managing turn order (round-robin)
    private Queue<Player> players;

    // The game board
    private Board board;

    // Flag to indicate if a winner has been found
    private Boolean winnerFound;

    /**
     * Constructor initializes a game
     * @param players - Queue of players (order determines turn order)
     * @param board - The board to play on
     */
    public Game(Queue<Player> players, Board board) {
        this.players = players;
        this.board = board;
        winnerFound = false;
    }

    // Getters and Setters
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

    /**
     * Displays the current board state in a formatted way
     * Shows column headers and all pieces on the board
     */
    public void PrintBoard() {
        int dimension = board.getDimension();
        PieceType[][] boardPieces = board.getBoard();

        // Print column headers
        System.out.print("  | ");
        for (int i = 0; i < dimension; i++) {
            System.out.print(i + " | ");
        }
        System.out.println();

        // Print each row with row header
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

    /**
     * Processes one player's move
     *
     * Steps:
     * 1. Get current player from queue peek (without removing)
     * 2. Ask player for row and column input
     * 3. Try to mark that position on the board
     * 4. If successful, check for winner
     * 5. If winner found, game ends; otherwise rotate player
     * 6. If move is invalid, ask player to try again
     *
     * Queue rotation: When move succeeds, remove current player from front
     * and add them to the back (next in queue)
     */
    private void MakeAMove() throws IllegalMoveException {

        // Get the current player without removing from queue
        Player currentPlayer = players.peek();

        if (currentPlayer == null) {
            throw new IllegalMoveException("INVALID_PLAYER");
        }

        // Get move input from player
        Scanner input = new Scanner(System.in);
        System.out.println("Turn of player " + currentPlayer.getPlayerName() + " Piece : " + currentPlayer.getPlayingPiece().getPieceType());
        System.out.print("Enter row = ");
        Integer row = input.nextInt();
        System.out.print("Enter col = ");
        Integer col = input.nextInt();

        // Try to execute the move
        try {
            board.MarkBox(row, col, currentPlayer);

            // Move was successful, check if player won
            if (isWinner(row, col)) {
                System.out.println("<--------------- WINNER : " + currentPlayer.getPlayerName() + "--------------->");
                winnerFound = true;
            } else {
                // No winner yet, rotate to next player
                // Remove current player from front and add to back
                players.remove();
                players.add(currentPlayer);
            }
        } catch (IllegalMoveException e) {
            // Move was invalid, display error and ask to try again
            System.out.println("ERROR : " + e.getMessage());
            System.out.println("TRY AGAIN!!!");
        }
    }

    /**
     * Checks if the current move results in a winning position
     *
     * Winning conditions:
     * 1. Three pieces in a row (horizontal)
     * 2. Three pieces in a column (vertical)
     * 3. Three pieces in diagonals
     *
     * Checks multiple patterns:
     * - Vertical: piece above and below
     * - Horizontal: piece left and right
     * - Diagonal patterns (4 directions)
     *
     * @param row - Row of the last placed piece
     * @param col - Column of the last placed piece
     * @return true if the move wins the game, false otherwise
     */
    private Boolean isWinner(Integer row, Integer col) {
        Integer dimension = board.getDimension();
        PieceType[][] boardPieces = board.getBoard();

        // Check vertical: piece above and below current position
        if (row > 0 && row < dimension - 1 && (boardPieces[row][col] == boardPieces[row - 1][col] && boardPieces[row][col] == boardPieces[row + 1][col])) {
            return true;
        }
        // Check horizontal: piece left and right at center
        else if (col > 0 && col < dimension - 1 && (boardPieces[row][col] == boardPieces[row][col + 1] && boardPieces[row][col] == boardPieces[row][col - 1])) {
            return true;
        }
        // Check horizontal: piece to right and further right
        else if (col < dimension - 2 && (boardPieces[row][col] == boardPieces[row][col + 1] && boardPieces[row][col] == boardPieces[row][col + 2]))
            return true;
        // Check vertical: piece below and further below
        else if (row < dimension - 2 && (boardPieces[row][col] == boardPieces[row + 1][col] && boardPieces[row][col] == boardPieces[row + 2][col]))
            return true;
        // Check horizontal: piece to left and further left
        else if (col > 1 && (boardPieces[row][col] == boardPieces[row][col - 1] && boardPieces[row][col] == boardPieces[row][col - 2]))
            return true;
        // Check vertical: piece above and further above
        else if (row > 1 && (boardPieces[row - 2][col] == boardPieces[row][col] && boardPieces[row][col] == boardPieces[row - 1][col]))
            return true;
        // Check diagonal (down-right)
        else if ((col < dimension - 2 && row < dimension - 2) && (boardPieces[row][col] == boardPieces[row + 1][col + 1] && boardPieces[row][col] == boardPieces[row + 2][col + 2]))
            return true;
        // Check diagonal (up-left)
        else if ((col > 1 && row > 1) && (boardPieces[row][col] == boardPieces[row - 1][col - 1] && boardPieces[row][col] == boardPieces[row - 2][col - 2]))
            return true;
        // Check diagonal (up-right)
        else if ((col < dimension - 2 && row > 1) && (boardPieces[row][col] == boardPieces[row - 1][col + 1] && boardPieces[row][col] == boardPieces[row - 2][col + 2]))
            return true;
        // Check diagonal (down-left)
        else if ((col > 1 && row < dimension - 2) && (boardPieces[row][col] == boardPieces[row + 1][col - 1] && boardPieces[row][col] == boardPieces[row + 2][col - 2]))
            return true;
        // Check diagonal (center piece with diagonal neighbors)
        else if ((row > 0 && row < dimension - 1) && (col > 0 && col < dimension - 1) && (boardPieces[row][col] == boardPieces[row + 1][col + 1] && boardPieces[row][col] == boardPieces[row - 1][col - 1]))
            return true;
        // Check diagonal (other direction center)
        else if ((row > 0 && row < dimension - 1) && (col > 0 && col < dimension - 1) && (boardPieces[row][col] == boardPieces[row - 1][col + 1] && boardPieces[row][col] == boardPieces[row + 1][col - 1]))
            return true;
        return false;
    }

    /**
     * Main game loop - orchestrates the entire game
     *
     * Game Flow:
     * 1. Validate that players exist
     * 2. Display initial empty board
     * 3. Loop while there are possible moves and no winner:
     *    - Process current player's move
     *    - Display updated board
     *    - Check if game is over (winner found)
     * 4. If no winner found, announce draw
     *
     * @throws IllegalMoveException - If no players or invalid game state
     */
    public void StartGame() throws IllegalMoveException {
        // Validate game setup
        if (players == null || players.isEmpty()) {
            throw new IllegalMoveException("NO_PLAYER_FOUND");
        }

        // Display initial board state
        PrintBoard();

        // Main game loop - continue while there are moves and no winner
        while (board.getPossibleMoves() > 0) {
            MakeAMove();           // Current player makes a move
            PrintBoard();          // Display updated board
            if (winnerFound) {     // Check if game should end
                break;
            }
        }

        // Game over - announce result
        if (!winnerFound) {
            System.out.println("----------DRAW-----------");
        }
    }
}
