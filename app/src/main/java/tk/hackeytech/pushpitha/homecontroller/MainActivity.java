package tk.hackeytech.pushpitha.homecontroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Boolean learn_status = false;
    public static final String LEARN = "LEARN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_connect = (Button)findViewById(R.id.button_connect);
        Button btn_ac = (Button) findViewById(R.id.button_ac);
        Button btn_tv = (Button) findViewById(R.id.button_tv);
        CheckBox check_learn = (CheckBox)findViewById(R.id.learn_checkbox);

        final EditText ipText = (EditText) findViewById(R.id.ip_Text);
        final EditText portnum = (EditText) findViewById(R.id.port_Text);

        btn_connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // connect to the wifi network
                String ip = ipText.getText().toString();
                String port = portnum.getText().toString();
                if(ip.isEmpty() || port.isEmpty()){
                    Toast.makeText(getApplicationContext(),"IP or port is invalid.", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "IP and port number saved", Toast.LENGTH_SHORT).show();
                }
            }
        });

        check_learn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    learn_status = true;
                }else{
                    learn_status = false;
                }
            }
        });

        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_ac = new Intent(getApplication(),ac.class);
                // send the learning signal
                intent_ac.putExtra(LEARN,learn_status);
                startActivity(intent_ac);
            }
        });

        btn_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_tv = new Intent(getApplication(),tv.class);
                // send the learning signal
                intent_tv.putExtra(LEARN,learn_status);
                startActivity(intent_tv);
            }
        });


    }
}
