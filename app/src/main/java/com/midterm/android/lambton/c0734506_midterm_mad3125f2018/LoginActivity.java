package com.midterm.android.lambton.c0734506_midterm_mad3125f2018;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.midterm.android.lambton.c0734506_midterm_mad3125f2018.Dialogs.LoginDialog;
import com.midterm.android.lambton.c0734506_midterm_mad3125f2018.Domain.ElectricityBill;

public class LoginActivity extends AppCompatActivity
{

    private EditText login;
    private EditText pass;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.la_login);
        pass = findViewById(R.id.la_pass);
    }

    public void onLoginClick(View view)
    {
        if(login.getText().toString().equals("admin")
                && pass.getText().toString().equals("admin@123"))
        {
            Intent mainIntent = new Intent(LoginActivity.this, ElectricityBillActivity.class);
            LoginActivity.this.startActivity(mainIntent);
            LoginActivity.this.finish();
        }
        else
        {
            LoginDialog ld = new LoginDialog();
            Toast.makeText(this, "Invalid id or password", Toast.LENGTH_SHORT).show();
            //ld.onCreateDialog(null);
        }
    }
}
