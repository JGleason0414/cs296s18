package edu.moravian.mathcs.tic_tac_toe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void symbolChosen(View view) {
    }

    void firstMoveChosen(View view) {
    }

    void playGame(View view) {
        String playerName = ((EditText) findViewById(R.id.playersName)).getText().toString();
        char playerSymbol = TicTacToe.NOUGHT_SYMBOL;
        if (((RadioButton)findViewById(R.id.rbSymbolCrosses)).isChecked())
            playerSymbol = TicTacToe.CROSS_SYMBOL;
        boolean firstMove = true;
        if (((RadioButton)findViewById(R.id.rbFirstMoveNo)).isChecked())
            firstMove = false;
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("playerName", playerName);
        intent.putExtra("playerSymbol", playerSymbol);
        intent.putExtra("firstMove", firstMove);
        startActivity(intent);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String playerName = ((EditText) findViewById(R.id.playersName)).getText().toString();
        char playerSymbol = TicTacToe.NOUGHT_SYMBOL;
        if (((RadioButton)findViewById(R.id.rbSymbolCrosses)).isChecked())
            playerSymbol = TicTacToe.CROSS_SYMBOL;
        boolean firstMove = true;
        if (((RadioButton)findViewById(R.id.rbFirstMoveNo)).isChecked())
            firstMove = false;
        outState.putString("playerName", playerName);
        outState.putChar("playerSymbol", playerSymbol);
        outState.putBoolean("firstMove", firstMove);
    }

    @Override
    public void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);
        if (inState != null) {
            String playerName = inState.getString("playerName");
            ((EditText) findViewById(R.id.playersName)).setText(playerName);
            char playerSymbol = inState.getChar("playerSymbol");
            if (playerSymbol == TicTacToe.CROSS_SYMBOL)
                ((RadioButton) findViewById(R.id.rbSymbolCrosses)).setChecked(true);
            else
                ((RadioButton) findViewById(R.id.rbSymbolNoughts)).setChecked(true);
            boolean firstMove = inState.getBoolean("firstMove");
            if (firstMove)
                ((RadioButton) findViewById(R.id.rbFirstMoveNo)).setChecked(true);
            else
                ((RadioButton) findViewById(R.id.rbFirstMoveYes)).setChecked(true);
        }
    }
}

