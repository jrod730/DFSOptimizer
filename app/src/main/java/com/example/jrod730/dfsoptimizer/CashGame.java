package com.example.jrod730.dfsoptimizer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Jrod730 on 9/15/17.
 */

public class CashGame extends AppCompatActivity{

    private Button mQB;
    private Button mRB;
    private Button mWR;
    private Button mTE;
    private Button mgoBack;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashgame);



        mQB = (Button) findViewById(R.id.qb);
        mRB = (Button) findViewById(R.id.rb);
        mWR = (Button) findViewById(R.id.wr);
        mTE = (Button) findViewById(R.id.te);


        mQB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                PlayerDisplay.index = 0;
                PlayerDisplay.cashGame = true;
                startActivity(new Intent(getBaseContext(), PlayerDisplay.class));


            }
        });
        mRB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PlayerDisplay.index = 1;
                PlayerDisplay.cashGame = true;
                startActivity(new Intent(getBaseContext(), PlayerDisplay.class));


            }
        });
        mWR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PlayerDisplay.index = 2;
                PlayerDisplay.cashGame = true;
                startActivity(new Intent(getBaseContext(), PlayerDisplay.class));


            }
        });

        mTE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PlayerDisplay.index = 3;
                PlayerDisplay.cashGame = true;
                startActivity(new Intent(getBaseContext(), PlayerDisplay.class));


            }
        });


    }



}
