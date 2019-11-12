package com.example.myapplication;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MessageSender extends AsyncTask<String,Void,Void> {
    Socket s;
    DataOutputStream outstream;
    PrintWriter printwrite;

    @Override
    protected Void doInBackground(String... voids) {
        String message = voids[0];
        try{
            s = new Socket(ContactInfo.address , 7800);//
            printwrite = new PrintWriter(s.getOutputStream());
            printwrite.write(message);
            printwrite.flush();
            printwrite.close();
            s.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
