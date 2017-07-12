package tk.hackeytech.pushpitha.homecontroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class tv extends AppCompatActivity {

    private Boolean learn_status = false;
    String number="";
    Button button_power,button_1,button_2,button_3,button_4,button_5,button_6,button_7,button_8,button_9,button_0,button_up,button_down,button_volup,button_voldown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv);

        Intent temp = getIntent();
        learn_status = temp.getBooleanExtra(MainActivity.LEARN,false);

        if(learn_status){
            number+="1";   // for learning mode
        }else{
            number+="0";
        }

        number+="1";   // for ac

        button_power = (Button) findViewById(R.id.button_powertv);
        button_0 = (Button) findViewById(R.id.button_0);
        button_1 = (Button) findViewById(R.id.button_1);
        button_2 = (Button) findViewById(R.id.button_2);
        button_3 = (Button) findViewById(R.id.button_3);
        button_4 = (Button) findViewById(R.id.button_4);
        button_5 = (Button) findViewById(R.id.button_5);
        button_6 = (Button) findViewById(R.id.button_6);
        button_7 = (Button) findViewById(R.id.button_7);
        button_8 = (Button) findViewById(R.id.button_8);
        button_9 = (Button) findViewById(R.id.button_9);
        button_up = (Button) findViewById(R.id.button_up);
        button_down = (Button) findViewById(R.id.button_down);
        button_voldown = (Button) findViewById(R.id.button_voldown);
        button_volup = (Button) findViewById(R.id.button_volup);

    }

    public void onClickTV(View v){
        if(v.getId()==button_power.getId()){
            number+="00";
        }else if(v.getId()==button_1.getId()){
            number+="01";
        }else if(v.getId()==button_2.getId()){
            number+="02";
        }else if(v.getId()==button_3.getId()){
            number+="03";
        }else if(v.getId()==button_4.getId()){
            number+="04";
        }else if(v.getId()==button_5.getId()){
            number+="05";
        }else if(v.getId()==button_6.getId()){
            number+="06";
        }else if(v.getId()==button_7.getId()){
            number+="07";
        }else if(v.getId()==button_8.getId()){
            number+="08";
        }else if(v.getId()==button_9.getId()){
            number+="09";
        }else if(v.getId()==button_0.getId()){
            number+="10";
        }else if(v.getId()==button_down.getId()){
            number+="11";
        }else if(v.getId()==button_up.getId()){
            number+="12";
        }else if(v.getId()==button_voldown.getId()){
            number+="13";
        }else if(v.getId()==button_volup.getId()){
            number+="14";
        }

        //emit signal
        MainActivity.signalHandler.sendRequest(number,getApplicationContext());
        System.out.println(number); //testing code
        number = number.substring(0,2);  // remove last 2 digits for next incrementing
    }
}
