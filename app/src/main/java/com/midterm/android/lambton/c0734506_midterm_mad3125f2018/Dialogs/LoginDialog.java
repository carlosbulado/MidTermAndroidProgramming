package com.midterm.android.lambton.c0734506_midterm_mad3125f2018.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class LoginDialog extends DialogFragment
{
    @Override
    public Dialog onCreateDialog (Bundle savedInstanceState)
    {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Invalid Login")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener()
                {
                    public void onClick (DialogInterface dialog, int id)
                    {
                        // FIRE ZE MISSILES!
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener()
                {
                    public void onClick (DialogInterface dialog, int id)
                    {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}