package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * The ContactInfo page is created here.
 */
public class ContactInfo extends AppCompatActivity {
    private Button contact;
    private Button info;
    private Button send;
    private Button user;

    private EditText contact_text;
    private EditText info_text;
    private EditText perm_add;
    private EditText user_text;

    private TextView contact_view;
    private TextView info_view;
    private TextView user_view;

    public static String address;

    private String text;
    private String username;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    public static final String USER = "username";

    /**
     * Initializes everything on this page. Also loads previous information and updates it.
     * @param savedInstanceState the previous saved instance
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        contact = findViewById(R.id.set_contact);
        info = findViewById(R.id.set_info);
        send = findViewById(R.id.send_button);
        user = findViewById(R.id.username_button);

        contact_text = findViewById(R.id.set_contact_text);//CHANGE ME
        info_text = findViewById(R.id.set_info_text);
        perm_add = findViewById(R.id.mainAddress);
        user_text = findViewById(R.id.username_text);

        contact_view = findViewById(R.id.contact_info);
        info_view = findViewById(R.id.sender_info);
        user_view = findViewById(R.id.username_view);

        contact.setOnClickListener(new View.OnClickListener(){ //This information is saved
            @Override
            public void onClick(View v){
                String input = contact_text.getText().toString();
                contact_view.setText(input);
                saveData();
                address = input;
            }
        });
        info.setOnClickListener(new View.OnClickListener(){ //This information is not saved
            @Override
            public void onClick(View v){
                String input = info_text.getText().toString();
                info_view.setText(input);

            }
        });
        send.setOnClickListener(new View.OnClickListener(){ //This button sends the above information
            @Override
            public void onClick(View v){
                send(v);

            }
        });
        user.setOnClickListener(new View.OnClickListener() { //The username is saved
            @Override
            public void onClick(View v) {
                String input = user_text.getText().toString();
                user_view.setText(input);
                saveData();
            }
        });

        loadData();
        updateViews();
    }

    /**
     * Saves the address and username to shared preferences.
     */
    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT, contact_view.getText().toString());
        editor.putString(USER, user_view.getText().toString());

        editor.apply();
    }

    /**
     * Loads the username and address from shared preferences.
     */
    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT, "");
        username = sharedPreferences.getString(USER, "");
    }

    /**
     * Updates both the address and username.
     */
    public void updateViews(){
        contact_view.setText(text);
        user_view.setText(username);
    }

    /**
     * Simply allows the menu to appear on this page.
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Sends the username as well as any text the user defined in the information EditText.
     * @param v the View
     */
    public void send(View v){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        String user = sharedPreferences.getString(USER, "");

        MessageSender messageSender = new MessageSender();
        messageSender.execute("User " + user + ":  " + info_text.getText().toString());

    }
}
