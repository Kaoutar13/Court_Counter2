package com.example.android.court_counter2;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final int HEALTH = 1000;
    int harryHealth = HEALTH, voldemortHealth = HEALTH, harryScore = 0, voldemortScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForHarry(harryScore, harryHealth);
        displayForVoldemort(voldemortScore, voldemortHealth);
    }

    /**
     * Display Harry's score and his health
     * @param score, health
     */
    public void displayForHarry(int score, int health) {
        TextView scoreView = (TextView) findViewById(R.id.harry_score);
        scoreView.setText(String.valueOf(score));

        TextView HealthView = (TextView) findViewById(R.id.harry_health);
        HealthView.setText(String.valueOf(harryHealth));
    }


    /**
     * Display Voledemort's score
     * @param score, health
     */
    public void displayForVoldemort(int score, int health) {
        TextView scoreView = (TextView) findViewById(R.id.voledemort_score);
        scoreView.setText(String.valueOf(score));

        TextView HealthView = (TextView) findViewById(R.id.voledemort_health);
        HealthView.setText(String.valueOf(voldemortHealth));
    }

    /**
     *
     * @param v
     */
    public void stupefy(View v) {
        // the button is clickable only when both opponents have are not dead !

        if(voldemortHealth > 0 && harryHealth > 0){
            harryScore += 10;
            voldemortHealth -= 5;

            if(voldemortHealth > 0)   {
                displayForHarry(harryScore, harryHealth);
                displayForVoldemort(voldemortScore, voldemortHealth);
            }
            else
            {
                //if the voldemort's health is negative, its value is set to 0 to avoid displaying a negative number

                voldemortHealth = 0;
                displayForHarry(harryScore, harryHealth);
                displayForVoldemort(voldemortScore,voldemortHealth);


                //display the winning message

                TextView scoreView = (TextView) findViewById(R.id.da_won);
                scoreView.setText("Dumbledore's\nArmy Won\nʘ‿ʘ !");

            }
        }




    }

    /**
     *
     * @param v
     */
    public void sectumsempra(View v) {

       if(voldemortHealth > 0 && harryHealth > 0) {
           harryScore += 30;
           voldemortHealth -= 15;

           if(voldemortHealth > 0)   {
               displayForHarry(harryScore, harryHealth);
               displayForVoldemort(voldemortScore, voldemortHealth);
           }
           else
           {
               voldemortHealth = 0;
               displayForHarry(harryScore, harryHealth);
               displayForVoldemort(voldemortScore,voldemortHealth);

               TextView scoreView = (TextView) findViewById(R.id.da_won);
               scoreView.setText("Dumbledore's\nArmy Won\nʘ‿ʘ !");
           }

       }

    }

    /**
     * Harry wins
     * @param v
     */
    public void expelliarmus(View v) {
        if(voldemortHealth > 0 && harryHealth > 0 ){

            voldemortHealth = 0;
            harryScore += 100;

            displayForVoldemort(voldemortScore, voldemortHealth);
            displayForHarry(harryScore,harryHealth);

            TextView scoreView = (TextView) findViewById(R.id.da_won);
            scoreView.setText("Dumbledore's\nArmy Won\nʘ‿ʘ !");
        }


    }

    /**
     *
     * @param v
     */
    public void crucio(View v) {
        if (harryHealth > 0 && voldemortHealth > 0){
            voldemortScore += 30;
            harryHealth -= 30;

            if(harryHealth > 0)   {
                displayForHarry(harryScore, harryHealth);
                displayForVoldemort(voldemortScore, voldemortHealth);
            }
            else
            {
                harryHealth = 0;
                displayForHarry(harryScore, harryHealth);
                displayForVoldemort(voldemortScore,voldemortHealth);

                TextView scoreView = (TextView) findViewById(R.id.death_eater_won);
                scoreView.setText("Death\nEaters Won\nಠ_ಠ !");
            }

        }


    }

    /**
     *
     * @param v
     */
    public void imperio(View v) {
        if (harryHealth > 0 && voldemortHealth > 0){
            voldemortScore += 50;
            harryHealth -= 50;

            if(harryHealth > 0)   {
                displayForHarry(harryScore, harryHealth);
                displayForVoldemort(voldemortScore, voldemortHealth);
            }
            else
            {
                harryHealth = 0;
                displayForHarry(harryScore, harryHealth);
                displayForVoldemort(voldemortScore,voldemortHealth);

                TextView scoreView = (TextView) findViewById(R.id.death_eater_won);
                scoreView.setText("Death\nEaters Won\nಠ_ಠ !");
            }
        }



    }


    /**
     *Voldemort wins
     * @param v
     */
    public void avadaKedavra(View v) {
        if(harryHealth > 0 && voldemortHealth > 0){

            harryHealth = 0;
            voldemortScore += 100;

            displayForHarry(harryScore, harryHealth);
            displayForVoldemort(voldemortScore, voldemortHealth);


            TextView scoreView = (TextView) findViewById(R.id.death_eater_won);
            scoreView.setText("Death\nEaters Won\nಠ_ಠ !");
        }


    }

    /**
     *Reset the score and health
     * @param v
     */
    public void reset(View v) {
        harryHealth = HEALTH;
        harryScore = 0;
        voldemortHealth = HEALTH;
        voldemortScore = 0;
        displayForHarry(harryScore, harryHealth);
        displayForVoldemort(voldemortScore, voldemortHealth);

        //clearing the TextViews for the winning messages

        TextView voldemortScoreView = (TextView) findViewById(R.id.death_eater_won);
        voldemortScoreView.setText("");

        TextView harryScoreView = (TextView) findViewById(R.id.da_won);
        harryScoreView.setText("");


    }



}

