package org.ticTacToe.players;

import org.ticTacToe.pieces.PlayingPiece;

/**
 * Player - Represents a player in Tic Tac Toe
 * 
 * Purpose: Encapsulates player information
 * 
 * Player has two main attributes:
 * 1. Name - Identifies the player
 * 2. Playing Piece - The piece type this player uses (X, O, $, etc.)
 * 
 * Design Pattern: Value Object / Entity
 * - Represents a player entity in the game
 * - Contains player state and identity
 * - Can be passed around and stored in collections
 * 
 * Note: Players are managed in a Queue to handle turn order
 */
public class Player {
    // Player's name
    private String playerName;
    
    // The piece type this player uses in the game
    private PlayingPiece playingPiece;

    /**
     * Constructor creates a player with a name and piece
     * @param playerName - The name of the player
     * @param playingPiece - The piece this player will use (X, O, $, etc.)
     */
    public Player(String playerName, PlayingPiece playingPiece) {
        this.playerName = playerName;
        this.playingPiece = playingPiece;
    }

    // Getters and Setters
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public PlayingPiece getPlayingPiece() {
        return playingPiece;
    }

    public void setPlayingPiece(PlayingPiece playingPiece) {
        this.playingPiece = playingPiece;
    }
}
