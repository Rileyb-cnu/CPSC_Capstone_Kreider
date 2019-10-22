package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ContactInfo extends AppCompatActivity {
    private Button contact;
    private Button info;

    private EditText contact_text;
    private EditText info_text;

    private TextView contact_view;
    private TextView info_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        contact = findViewById(R.id.set_contact);
        info = findViewById(R.id.set_info);

        contact_text = findViewById(R.id.set_contact_text);
        info_text = findViewById(R.id.set_info_text);

        contact_view = findViewById(R.id.contact_info);
        info_view = findViewById(R.id.sender_info);

        contact.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String input = contact_text.getText().toString();
                contact_view.setText(input);
            }
        });
        info.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String input = info_text.getText().toString();
                info_view.setText(input);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
