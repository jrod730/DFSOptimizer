package com.example.jrod730.dfsoptimizer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by jrod730 on 9/19/17.
 */

public class PlayerDisplay extends AppCompatActivity  {

        private String[] mPlayerPosition = {"QB", "RB", "WR", "TE"};
        public static int index;
        public static boolean cashGame;
        private String[] mPlayer = new String[5];
        private TextView player1;
        private TextView player2;
        private TextView player3;
        private TextView player4;
        private TextView player5;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_playerdisplay);

            System.out.println("THIS IS THE VALUE AT INDEX:" + index);

            try
            {
                    File f = new File("/Users/jrod730/AndroidStudioProjects/DFSOptimizer/app/src/main/res/raw/dksalaries2.csv");
                    Scanner fileReader = new Scanner(f);
                    int i = 0;

                    while(fileReader.hasNext())
                    {
                        String[] playerRows = fileReader.nextLine().split(",");
                        Double salary = Double.parseDouble(playerRows[2]);
                        Double FPG = Double.parseDouble(playerRows[4]);

                        System.out.println("THIS IS THE VALUE AT VALUE FOR THE NEXTLINE  " + fileReader.hasNext());

                        if(playerRows[0].equals(mPlayerPosition[index]))
                        {
                            if(cashGame)
                            {
                               if((FPG / salary) * 1000 > 3.0)
                               {
                                    mPlayer[i] = playerRows[1];
                                   i++;

                                   if(i == 5)
                                       break;
                               }


                            }
                            else
                            {
                                if((FPG / salary) * 1000 > 3.5)
                                {
                                    mPlayer[i] = playerRows[1];
                                    i++;

                                    if(i == 5)
                                        break;
                                }

                            }
                        }




                    }

                    fileReader.close();



                player1 = (TextView)findViewById(R.id.player2);
                player2 = (TextView)findViewById(R.id.player3);
                player3 = (TextView)findViewById(R.id.player4);
                player4 = (TextView)findViewById(R.id.player5);
                player5 = (TextView)findViewById(R.id.player5);

                player1.setText(mPlayer[0]);
                player2.setText(mPlayer[1]);
                player3.setText(mPlayer[2]);
                player4.setText(mPlayer[3]);
                player5.setText(mPlayer[4]);

            }
            catch(Exception e)
            {
                System.out.println("File not found.");

            }



        }
    }

