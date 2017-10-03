package com.example.jrod730.dfsoptimizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DFS extends AppCompatActivity {

    private Button mcashGame;
    private Button mgpp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dfs);

        mcashGame = (Button) findViewById(R.id.cashgame);
        mgpp = (Button) findViewById(R.id.gpp);

        mcashGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DFS.this, CashGame.class));
            }
        });

        mgpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getBaseContext(), GPP.class));

            }
        });

    }



}
