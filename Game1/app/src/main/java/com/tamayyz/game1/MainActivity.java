package com.tamayyz.game1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button playButton;
    TextView tvHeartCount, tvWinCount, tvResult;
    EditText  etUserInput;
    int heartCount = 3;
    int winCount = 0 ;

    int userNumber  = 0 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        playButton = (Button) findViewById(R.id.playButton);
        etUserInput = (EditText) findViewById(R.id.etUserInput);
        tvHeartCount = (TextView) findViewById(R.id.tvHeartCount);
        tvWinCount =  (TextView) findViewById(R.id.tvWinCount);
        tvResult =  (TextView) findViewById(R.id.tvResult);
    }


    public void playGame(View v){
        userNumber = Integer.parseInt(etUserInput.getText().toString());
        if(userNumber >=0 && userNumber <=10){
            Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();
            tvResult.setText("Correct");
            winCount++;
            tvWinCount.setText(winCount+"");

        }else{
            heartCount--;
            if(heartCount >0){

                Toast.makeText(MainActivity.this, "InCorrect!!, try again", Toast.LENGTH_SHORT).show();
                tvResult.setText("Incorrect");

                tvHeartCount.setText(heartCount+"");
            }else{
                Toast.makeText(MainActivity.this, "Sorry, You can't play anymore ", Toast.LENGTH_SHORT).show();
                playButton.setEnabled(false);
            }

        }


    }



    public void gameOver(){
        //

    }






}
