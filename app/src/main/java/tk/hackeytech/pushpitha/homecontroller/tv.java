package tk.hackeytech.pushpitha.homecontroller;

import android.content.Intent;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class tv extends AppCompatActivity {

    private Boolean learn_status = false;
    SignalHandler sh;
    String number="";
    Button button_power,button_1,button_2,button_3,button_4,button_5,button_6,button_7,button_8,button_9,button_0,button_up,button_down,button_volup,button_voldown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv);
        sh = MainActivity.sh;

        Intent temp = getIntent();
        learn_status = temp.getBooleanExtra(MainActivity.LEARN,false);

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
            if(learn_status){
                number="100";   // for learning mode
            }else{
                number="-10";
            }
        }else if(v.getId()==button_1.getId()){
            if(learn_status){
                number="101";   // for learning mode
            }else{
                number="-11";
            }
        }else if(v.getId()==button_2.getId()){
            if(learn_status){
                number="102";   // for learning mode
            }else{
                number="-12";
            }
        }else if(v.getId()==button_3.getId()){
            if(learn_status){
                number="103";   // for learning mode
            }else{
                number="-13";
            }
        }else if(v.getId()==button_4.getId()){
            if(learn_status){
                number="104";   // for learning mode
            }else{
                number="-14";
            }
        }else if(v.getId()==button_5.getId()){
            if(learn_status){
                number="105";   // for learning mode
            }else{
                number="-15";
            }
        }else if(v.getId()==button_6.getId()){
            if(learn_status){
                number="106";   // for learning mode
            }else{
                number="-16";
            }
        }else if(v.getId()==button_7.getId()){
            if(learn_status){
                number="107";   // for learning mode
            }else{
                number="-17";
            }
        }else if(v.getId()==button_8.getId()){
            if(learn_status){
                number="108";   // for learning mode
            }else{
                number="-18";
            }
        }else if(v.getId()==button_9.getId()){
            if(learn_status){
                number="109";   // for learning mode
            }else{
                number="-19";
            }
        }else if(v.getId()==button_0.getId()){
            if(learn_status){
                number="110";   // for learning mode
            }else{
                number="-22";
            }
        }else if(v.getId()==button_down.getId()){
            if(learn_status){
                number="114";   // for learning mode
            }else{
                number="-24";
            }
        }else if(v.getId()==button_up.getId()){
            if(learn_status){
                number="113";   // for learning mode
            }else{
                number="-23";
            }
        }else if(v.getId()==button_voldown.getId()){
            if(learn_status){
                number="112";   // for learning mode
            }else{
                number="-21";
            }
        }else if(v.getId()==button_volup.getId()){
            if(learn_status){
                number="111";   // for learning mode
            }else{
                number="-20";
            }
        }

        sh.sendSignal(number);
    }
}
