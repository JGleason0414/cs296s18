package edu.moravian.mathcs.tic_tac_toe;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * Created by meotm01 on 2/10/18.
 */

public class TicTacToe implements Serializable {

    char board[][];
    char playerSymbol, computerSymbol;
    String playerName;
    static final int SIZE = 3;
    static final char NOUGHT_SYMBOL = 'X';
    static final char CROSS_SYMBOL  = 'O';
    static final char EMPTY         = ' ';
    Random rnd;

    TicTacToe(final String playerName, char playerSymbol) {
        this.playerName = playerName;
        board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                board[i][j] = EMPTY;
        if (playerSymbol != NOUGHT_SYMBOL && playerSymbol != CROSS_SYMBOL)
            this.playerSymbol = NOUGHT_SYMBOL;
        else
            this.playerSymbol = playerSymbol;
        if (this.playerSymbol == NOUGHT_SYMBOL)
            this.computerSymbol = CROSS_SYMBOL;
        else
            this.computerSymbol = NOUGHT_SYMBOL;
        this.rnd = new Random();
    }

    private char rowWin() {
        for (int i = 0; i < SIZE; i++)
            if (board[i][0] != EMPTY && board[i][0] == board[i][1] && board[i][0] == board[i][2])
                return board[i][0];
        return EMPTY;
    }

    private char colWin() {
        for (int j = 0; j < SIZE; j++)
            if ((board[0][j] != EMPTY && board[0][j] == board[1][j] && board[0][j] == board[2][j]))
                return board[0][j];
        return EMPTY;
    }

    private char diagonalWin() {
        if ((board[0][0] != EMPTY && board[0][0] == board[1][1] && board[0][0] == board[2][2]))
            return board[0][0];
        if ((board[0][2] != EMPTY && board[0][2] == board[1][1] && board[0][2] == board[2][0]))
            return board[0][2];
        return EMPTY;
    }

    char getWinner() {
        char winner;
        winner = rowWin();
        if (winner != EMPTY)
            return winner;
        winner = colWin();
        if (winner != EMPTY)
            return winner;
        winner = diagonalWin();
        if (winner != EMPTY)
            return winner;
        return EMPTY;
    }

    boolean canMove() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] == EMPTY)
                    return true;
        return false;
    }

    boolean computerPlay() {
        if (canMove() && getWinner() == EMPTY) {
            int i = rnd.nextInt(3);
            int j = rnd.nextInt(3);
            while (board[i][j] != EMPTY) {
                j++;
                if (j == SIZE) {
                    i++;
                    if (i == SIZE)
                        i = 0;
                    j = 0;
                }
            }
            board[i][j] = computerSymbol;
            return true;
        }
        return false;
    }

    boolean playerPlay(int i, int j) {
        if (canMove() && getWinner() == EMPTY && board[i][j] == EMPTY) {
            board[i][j] = playerSymbol;
            return true;
        }
        return false;
    }

    String getPlayerName() {
        return playerName;
    }

    char getSymbolAt(int i, int j) {
        return board[i][j];
    }

    char getPlayerSymbol() {
        return playerSymbol;
    }

    char getComputerSymbol() {
        return computerSymbol;
    }
}
