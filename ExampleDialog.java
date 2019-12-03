package com.example.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

/**
 * This class is for the menu item "Change Time" and interacts with the main activity to change
 * the time of the timer.
 */
public class ExampleDialog extends AppCompatDialogFragment {
    private EditText input;
    private dialogListener listener;

    /**
     * When opened, this method actually creates the interface that the user will interact with.
     * After the user inputs a number (and it can only be a number) and clicks OK, it updates
     * the timer. Anything else cancels the operation and does not affect anything.
     * @param savedInstanceState the last instance
     * @return creates the box
     */
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
                String username = input.getText().toString();
                listener.applyTexts(username);
            }
        });

        //Quite proud of this part- this makes the keyboard only a set of numbers, nothing else
        input = view.findViewById(R.id.edit_text);
        input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        input.setTransformationMethod(new NumericKeyBoardTransformationMethod());

        return builder.create();
    }

    /**
     * Checks if this activity has the required listener.
     * @param context this activity
     */
    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        try {
            listener = (dialogListener) context;
        } catch (ClassCastException e) {
           throw new ClassCastException(context.toString() +
                   "Some error happened");
        }
    }

    /**
     * Implements the applyTexts method from the mainActivity.
     */
    public interface dialogListener{
        void applyTexts(String time);
    }

    /**
     * Makes the keyboard only numbers and can still show the numbers (keyboard was intended
     * for a password, therefore it created little black circles instead of numbers. This helps
     * prevent that).
     */
    private class NumericKeyBoardTransformationMethod extends PasswordTransformationMethod {
        @Override
        public CharSequence getTransformation(CharSequence source, View view) {
            return source;
        }
    }
}
