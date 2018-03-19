package edu.moravian.mathcs.tic_tac_toe;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity {

    private TicTacToe ticTacToe;
    private Button btn[][];
    private static final String TAG = "PlayActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // get intent parameters
        Intent intent = getIntent();
        String playerName = intent.getStringExtra("playerName");
        char playerSymbol = intent.getCharExtra("playerSymbol", TicTacToe.NOUGHT_SYMBOL);
        boolean firstMove = intent.getBooleanExtra("firstMove", true);
        ticTacToe = new TicTacToe(playerName, playerSymbol);
        if (!firstMove)
            Log.d(TAG, ticTacToe.computerPlay() + "");

        // grid layout
        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(TicTacToe.SIZE);
        gridLayout.setRowCount(TicTacToe.SIZE);

        // 3x3 buttons of the GUI
        this.btn = new Button[TicTacToe.SIZE][TicTacToe.SIZE];
        for (int i = 0; i < TicTacToe.SIZE; i++)
            for (int j = 0; j < TicTacToe.SIZE; j++) {
                this.btn[i][j] = new Button(this);
                GridLayout.LayoutParams param = new GridLayout.LayoutParams(GridLayout.spec(GridLayout.UNDEFINED, 1f), GridLayout.spec(GridLayout.UNDEFINED, 1f));
                btn[i][j].setLayoutParams(param);
                btn[i][j].setTypeface(Typeface.MONOSPACE);
                btn[i][j].setTextSize(TypedValue.COMPLEX_UNIT_SP, 32);
                btn[i][j].setId(TicTacToe.SIZE * i + j);
                Log.d(TAG, ticTacToe.getSymbolAt(i, j) + "");
                btn[i][j].setText(ticTacToe.getSymbolAt(i, j) + "");
                btn[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Button clickedButton = (Button) view;
                        int i, j;
                        switch(clickedButton.getId()) {
                            case 0:
                                i = 0; j = 0;
                                break;
                            case 1:
                                i = 0; j = 1;
                                break;
                            case 2:
                                i = 0; j = 2;
                                break;
                            case 3:
                                i = 1; j = 0;
                                break;
                            case 4:
                                i = 1; j = 1;
                                break;
                            case 5:
                                i = 1; j = 2;
                                break;
                            case 6:
                                i = 2; j = 0;
                                break;
                            case 7:
                                i = 2; j = 1;
                                break;
                            default:
                                i = 2; j = 2;
                                break;
                        }
                        if (ticTacToe.playerPlay(i, j)) {
                            clickedButton.setText(ticTacToe.getSymbolAt(i, j) + "");
                            if (!isGameOver()) {
                                ticTacToe.computerPlay();
                                updateScreen();
                                isGameOver(); // check if it's game over after computer played
                            }
                        }
                    }

                    boolean isGameOver() {
                        char winner = ticTacToe.getWinner();
                        AlertDialog.Builder builder = new AlertDialog.Builder(PlayActivity.this);
                        builder.setTitle("TicTacToe play is over");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                finish();
                            }
                        });
                        if (winner == ticTacToe.getPlayerSymbol()) {
                            builder.setMessage("Congratulations " + ticTacToe.getPlayerName() + ", you won!");
                            AlertDialog dialog = builder.create();
                            dialog.show();
                            return true;
                        }
                        else if (winner == ticTacToe.getComputerSymbol()) {
                            builder.setMessage("Sorry " + ticTacToe.getPlayerName() + ", but I won!");
                            AlertDialog dialog = builder.create();
                            dialog.show();
                            return true;
                        }
                        else if (!ticTacToe.canMove()) {
                            builder.setMessage("Draw!!!");
                            AlertDialog dialog = builder.create();
                            dialog.show();
                            return true;
                        }
                        return false;
                    }
                });
                gridLayout.addView(btn[i][j]);
            }

        // set content view of the activity
        setContentView(gridLayout);
    }

    void updateScreen() {
        for (int i = 0; i < TicTacToe.SIZE; i++)
            for (int j = 0; j < TicTacToe.SIZE; j++)
                btn[i][j].setText(ticTacToe.getSymbolAt(i, j) + "");

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("tictactoe", ticTacToe);
    }

    @Override
    public void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);
        if (inState != null) {
            this.ticTacToe = (TicTacToe) inState.getSerializable("tictactoe");
            updateScreen();
        }
    }
}
