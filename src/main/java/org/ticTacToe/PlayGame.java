package org.ticTacToe;

import org.ticTacToe.board.Board;
import org.ticTacToe.board.Game;
import org.ticTacToe.exceptions.IllegalMoveException;
import org.ticTacToe.pieces.PieceType;
import org.ticTacToe.pieces.PlayingPiece;
import org.ticTacToe.players.Player;

import java.util.LinkedList;
import java.util.Queue;

public class PlayGame {

    public static void main(String[] args) {

        Board board = new Board(4);


        Player player1 = new Player("player 1", new PlayingPiece(PieceType.X));
        Player player2 = new Player("player 2", new PlayingPiece(PieceType.O));
        Player player3 = new Player("player 3", new PlayingPiece(PieceType.$));
        Queue<Player> players = new LinkedList<Player>();
        players.add(player1);
        players.add(player2);
        players.add(player3);


        Game game = new Game(players, board);

        try {
            game.StartGame();
        } catch (IllegalMoveException e) {
            System.out.println(e.getMessage());
        }

    }
}
