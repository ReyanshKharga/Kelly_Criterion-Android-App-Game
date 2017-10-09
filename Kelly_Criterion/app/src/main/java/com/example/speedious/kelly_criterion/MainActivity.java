package com.example.speedious.kelly_criterion;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

import static com.example.speedious.kelly_criterion.R.id.IVdice;
import static java.util.logging.Logger.global;

public class MainActivity extends AppCompatActivity {
    double net_amt = 250, input, net_odds_received = 3.0, kelly_fraction = 0.106, kelly_net = 250.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button Broll, Breset;
        final TextView TVcurrent_amt, TVpayout, TVkellyPayout, TVerror_msg;
        final EditText TFinput;
        final ImageView IVdice;

        Broll = (Button) findViewById(R.id.Broll);
        Breset = (Button) findViewById(R.id.Breset);
        TVcurrent_amt = (TextView) findViewById(R.id.TVcurrent_amt);
        TVpayout = (TextView) findViewById(R.id.TVpayout);
        TVkellyPayout = (TextView) findViewById(R.id.TVkellyPayout);
        TVerror_msg = (TextView) findViewById(R.id.TVerror_msg);
        TFinput = (EditText) findViewById(R.id.TFinput);
        IVdice = (ImageView) findViewById(R.id.IVdice);

        TVerror_msg.setBackgroundColor(Color.parseColor("#922b21"));
        TVerror_msg.setText("   INSTRUCTION\nYou are provided with $250. The outcomes 2,5 means you won the bet and will be provided with 3 times the " +
                "bet amount else you will lose the amount bet.");

        TVerror_msg.postDelayed(new Runnable() {
            public void run() {
                TVerror_msg.setVisibility(View.INVISIBLE);
            }
        }, 5000);

        TVcurrent_amt.setText("$"+ 250);
        TVpayout.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        TVpayout.setText("Let's Bet Mr. kelly!");
        TVkellyPayout.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        TVkellyPayout.setText("Be Smart though!");

        Breset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());
            }
        });


        Broll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                input = Double.parseDouble(TFinput.getText().toString());
                double kelly_input = kelly_net * kelly_fraction;

                if(input > net_amt){
                    TVerror_msg.setBackgroundColor(Color.parseColor("#6c3483"));
                    TVerror_msg.setText("    Error!\n Bet amount must be less than net amount");
                    TVerror_msg.setVisibility(View.VISIBLE);

                    TVerror_msg.postDelayed(new Runnable() {
                        public void run() {
                            TVerror_msg.setVisibility(View.INVISIBLE);
                        }
                    }, 3000);
                }

                Random r = new Random();
                int roll_value = r.nextInt(6) + 1;

                if(net_amt > 0.0 && net_amt < 1000.0 && (input < net_amt || kelly_input < kelly_net )){
                    switch(roll_value){
                        case 1:{
                            IVdice.setImageResource(R.drawable.die_face_1);
                            if(input <= net_amt){
                                net_amt -= input;
                                TVcurrent_amt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                                TVcurrent_amt.setText("$"+ (int)net_amt);
                                TVpayout.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                                TVpayout.setText("$"+ (int)net_amt);
                            }
                            if(kelly_input <= kelly_net){
                                kelly_net -= kelly_input;
                                TVkellyPayout.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                                TVkellyPayout.setText("$"+ (int)kelly_net);
                            }
                            break;
                        }
                        case 2:{
                            IVdice.setImageResource(R.drawable.die_face_2);
                            if(input <= net_amt){
                                net_amt += net_odds_received*input;
                                TVcurrent_amt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                                TVcurrent_amt.setText("$"+ (int)net_amt);
                                TVpayout.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                                TVpayout.setText("$"+ (int)net_amt);
                            }
                            if(kelly_input <= kelly_net){
                                kelly_net += net_odds_received*kelly_input;
                                TVkellyPayout.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                                TVkellyPayout.setText("$"+ (int)kelly_net);
                            }
                            break;
                        }
                        case 3:{
                            IVdice.setImageResource(R.drawable.die_face_3);
                            if(input <= net_amt){
                                net_amt -= input;
                                TVcurrent_amt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                                TVcurrent_amt.setText("$"+ (int)net_amt);
                                TVpayout.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                                TVpayout.setText("$"+ (int)net_amt);
                            }
                            if(kelly_input <= kelly_net){
                                kelly_net -= kelly_input;
                                TVkellyPayout.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                                TVkellyPayout.setText("$"+ (int)kelly_net);
                            }
                            break;
                        }
                        case 4:{
                            IVdice.setImageResource(R.drawable.die_face_4);
                            if(input <= net_amt){
                                net_amt -= input;
                                TVcurrent_amt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                                TVcurrent_amt.setText("$"+ (int)net_amt);
                                TVpayout.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                                TVpayout.setText("$"+ (int)net_amt);
                            }
                            if(kelly_input <= kelly_net){
                                kelly_net -= kelly_input;
                                TVkellyPayout.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                                TVkellyPayout.setText("$"+ (int)kelly_net);
                            }
                            break;
                        }
                        case 5:{
                            IVdice.setImageResource(R.drawable.die_face_5);
                            if(input <= net_amt){
                                net_amt += net_odds_received*input;
                                TVcurrent_amt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                                TVcurrent_amt.setText("$"+ (int)net_amt);
                                TVpayout.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                                TVpayout.setText("$"+ (int)net_amt);
                            }
                            if(kelly_input <= kelly_net){
                                kelly_net += net_odds_received*kelly_input;
                                TVkellyPayout.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                                TVkellyPayout.setText("$"+ (int)kelly_net);
                            }
                            break;
                        }
                        case 6:{
                            IVdice.setImageResource(R.drawable.die_face_6);
                            if(input <= net_amt){
                                net_amt -= input;
                                TVcurrent_amt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                                TVcurrent_amt.setText("$"+ (int)net_amt);
                                TVpayout.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                                TVpayout.setText("$"+ (int)net_amt);
                            }
                            if(kelly_input <= kelly_net){
                                kelly_net -= kelly_input;
                                TVkellyPayout.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                                TVkellyPayout.setText("$"+ (int)kelly_net);
                            }
                            break;
                        }
                }

                }
            }
        });

    }

}
