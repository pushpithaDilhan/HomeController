package tk.hackeytech.pushpitha.homecontroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ac extends AppCompatActivity {

    private Boolean learn_status = false;
    Button power,tempdown, tempup;
    String number = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac);

        Intent temp = getIntent();
        learn_status = temp.getBooleanExtra(MainActivity.LEARN,false);

        if(learn_status){
            number+="1";   // for learning mode
        }else{
            number+="0";
        }

        number+="0";   // for ac

        power = (Button) findViewById(R.id.button_power);
        tempdown = (Button) findViewById(R.id.button_tempdown);
        tempup = (Button) findViewById(R.id.button_tempup);

    }

    public void onClick(View v){
        if(v.getId()==power.getId()){
            number+="00";
        }else if(v.getId()==tempdown.getId()){
            number+="01";
        }else if(v.getId()==tempup.getId()){
            number+="02";
        }

        System.out.println(number); //testing code
        //emit signal
        MainActivity.signalHandler.sendRequest(number,getApplicationContext());

        number = number.substring(0,2);  // remove last 2 digits for next incrementing
    }
}
