package tk.hackeytech.pushpitha.homecontroller;

import android.content.Context;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Pushpitha on 08-Jul-17.
 */
public class SignalHandler {
    private String ip;
    private String port;
    Socket socket;
    PrintWriter out;

    public String getIp() {
        return ip;
    }

    public String getPort() {
        return port;
    }

    public SignalHandler(String ip, String port){
        this.ip = ip;
        this.port = port;
        try {
            this.socket = new Socket(ip,Integer.parseInt(port));
            out = new PrintWriter(socket.getOutputStream(),true);
        } catch (Exception e) {}
    }

    public void sendSignal(String text){
        out.println(text);
    }

    public void closeSocket(){
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
