package com.example.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class ExampleDialog extends AppCompatDialogFragment {
    private EditText something;
    private dialogListener listener;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inf = getActivity().getLayoutInflater();
        View view = inf.inflate(R.layout.layout_dialog, null);


        builder.setView(view).setTitle("Set Time").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        })
        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String username = something.getText().toString();
                listener.applyTexts(username);
            }
        });
        something = view.findViewById(R.id.edit_text);

        return builder.create();
    }
    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        try {
            listener = (dialogListener) context;
        } catch (ClassCastException e) {
           throw new ClassCastException(context.toString() +
                   "fsdhjk");
        }
    }
    public interface dialogListener{
        void applyTexts(String time);
    }
}
