package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * A simple page indicating what the application does and how to use it.
 */
public class AboutActivity extends AppCompatActivity {
    private TextView text;
    /**
     * Shows the menu bar as well as the text.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        text = findViewById(R.id.pt1);
        text.setText(Html.fromHtml(" About StaySafe Toolkit Application" +"<br><br>"
                +" This app contains a smorgasbord of communication tools for the delivery driver and beyond. It features a countdown timer for taking deliveries, GPS location, a Google Map with your location, and an instant message sender." + "<br><br>"+
                " 1. To begin using the app, set the timer in the menu bar to a time reasonable for a standard delivery in minutes. The goal is to pause the timer and reset it before it gets to 00:00, or else it will notify your employer of your location in case you cannot get back to your vehicle." + "<br><br>" +
                " 2. Set your contact information. Navigate to the contact info page from the menu. Here you will set who you want to receive your info (ip address), a simple instant messenger to send quick info to that location, and your username that the receiver will see for identification." + "<br><br>" +
                " 3. If all goes well, you have a successful run. If, however, you cannot make it back to your phone, this app will send your location and name to the receiver so they can call emergency services and give them your location" + "<br><br>" +
                " 4. The map can be used when calling emergency services to tell them where you are" + "<br><br>" +
                " Hopefully all goes well, but take comfort in that, even without a phone, communication is still available."));

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     * Just for the menu bar to make sure it works.
     * @param item menu items
     * @return the selected item
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
