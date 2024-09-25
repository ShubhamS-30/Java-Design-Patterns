package org.ticTacToe.exceptions;

public class IllegalMoveException extends Exception {
    public IllegalMoveException(String msg) {
        super("Illegal move: " + msg);
    }
}
