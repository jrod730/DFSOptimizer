package com.example.jrod730.dfsoptimizer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jrod730 on 9/19/17.
 */

public class PlayerDisplay extends AppCompatActivity  {

        private String[] mPlayerPosition = {"QB", "RB", "WR", "TE"};
        public static int index;
        public static boolean cashGame;
        private TextView player1;
        private TextView player2;
        private TextView player3;
        private TextView player4;
        private TextView player5;



        private List<PlayerData> playerData = new ArrayList<>();
        private List<PlayerData> playerPFF = new ArrayList<>();


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_playerdisplay);

            System.out.println("THIS IS THE VALUE AT INDEX:" + index);

            readPlayerData();
        }


        private void readPlayerData(){

            InputStream is = getResources().openRawResource(R.raw.data);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));


            String line = "";
            try {
                while((line = reader.readLine()) != null){
                    String[] token = line.split(",");

                    PlayerData sample = new PlayerData();
                    sample.setPosition(token[0]);
                    sample.setName(token[1]);
                    sample.setCost(Double.parseDouble(token[2]));
                    sample.setFpg(Double.parseDouble(token[3]));

                    playerData.add(sample);

                    Log.d("MyActivity", "Just created: " + sample);


                }
            } catch (IOException e) {
                Log.wtf("MyActivity", "Error reading data file line: " + line, e);
                e.printStackTrace();
            }

            is = getResources().openRawResource(R.raw.pffdata);
            reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));


            String secondLine = "";
            try {

                while((secondLine = reader.readLine()) != null){
                    String[] token = secondLine.split(",");

                    PlayerData sample = new PlayerData();
                    sample.setName(token[0]);
                    sample.setFpg(Double.parseDouble(token[1]));

                    playerPFF.add(sample);

                    Log.d("MyActivity", "Just created: " + sample);


                }
            } catch (IOException e) {
                Log.wtf("MyActivity", "Error reading data file line: " + line, e);
                e.printStackTrace();
            }

            valuation();
        }

        private void valuation() {
            int j = 0;

            String[] mPlayer = new String[5];
            PlayerData x;

            for (int i = 0; i < playerData.size(); i++) {

                x = playerData.get(i);

                if (x.getPosition().equals(mPlayerPosition[index])) {

                    if (cashGame)
                    {
                        if ((x.getFpg() / x.getCost()) * 1000 > 3.0) {

                            mPlayer[j] = x.getName();
                            j++;



                        } else {

                            for (int k = 0; k < playerPFF.size(); k++)
                            {
                                if (j == 5)
                                    break;
                                PlayerData y = playerPFF.get(k);
                                if (x.getName().contains(y.getName()) && (y.getFpg() / x.getCost()) * 1000 > 3.0)
                                {
                                    mPlayer[j] = x.getName();
                                    j++;


                                }
                                if (j == 5)
                                    break;

                            }


                        }
                    }
                    else
                    {
                            if ((x.getFpg() / x.getCost()) * 1000 > 3.5)
                            {
                                mPlayer[j] = x.getName();
                                j++;


                            } else {

                                for (int k = 0; k < playerPFF.size(); k++) {
                                    PlayerData y = playerPFF.get(k);
                                    if (x.getName().contains(y.getName()) && (y.getFpg() / x.getCost()) * 1000 > 3.5) {
                                        mPlayer[j] = x.getName();
                                        j++;



                                    }
                                    if (j == 5)
                                        break;

                                }


                            }
                        }
                    }//end first condtional statement comparing positions

                     if (j == 5)
                        break;
                }//end for loop through main data array list

            player1 = (TextView) findViewById(R.id.player1);
            player2 = (TextView) findViewById(R.id.player2);
            player3 = (TextView) findViewById(R.id.player3);
            player4 = (TextView) findViewById(R.id.player4);
            player5 = (TextView) findViewById(R.id.player5);


            player1.setText(mPlayer[0]);
            player2.setText(mPlayer[1]);
            player3.setText(mPlayer[2]);
            player4.setText(mPlayer[3]);
            player5.setText(mPlayer[4]);
            }//end method



        }




