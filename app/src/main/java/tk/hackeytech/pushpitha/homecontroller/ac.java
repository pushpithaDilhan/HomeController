package tk.hackeytech.pushpitha.homecontroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ac extends AppCompatActivity {

    private Boolean learn_status = false;
    Button power,tempdown, tempup;
    SignalHandler sh;
    String number = "",ip,port;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac);

        sh = MainActivity.sh;

        Intent temp = getIntent();
        learn_status = temp.getBooleanExtra(MainActivity.LEARN,false);

        power = (Button) findViewById(R.id.button_power);
        tempdown = (Button) findViewById(R.id.button_tempdown);
        tempup = (Button) findViewById(R.id.button_tempup);

    }

    public void onClick(View v){
        if(v.getId()==power.getId()){
            if(learn_status){
                number="121";   // for learning mode
            }else{
                number="-4";
            }
        }else if(v.getId()==tempdown.getId()){
            if(learn_status){
                number="123";   // for learning mode
            }else{
                number="-6";
            }
        }else if(v.getId()==tempup.getId()){
            if(learn_status){
                number="122";   // for learning mode
            }else{
                number="-5";
            }
        }

        //emit signal
        sh.sendSignal(number);

    }
}
