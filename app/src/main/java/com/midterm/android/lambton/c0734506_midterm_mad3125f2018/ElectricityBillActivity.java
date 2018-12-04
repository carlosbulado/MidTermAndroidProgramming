package com.midterm.android.lambton.c0734506_midterm_mad3125f2018;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.midterm.android.lambton.c0734506_midterm_mad3125f2018.Domain.ElectricityBill;

import java.util.Calendar;
import java.util.Date;

public class ElectricityBillActivity extends AppCompatActivity
{

    private EditText customerId;
    private EditText customerName;
    private EditText customerEmail;
    private RadioGroup gender;
    private EditText billDate;
    private EditText unitConsumed;
    private DatePicker datePicker;
    private TextView dateView;
    private int year, month, day;
    private Calendar calendar;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricity_bill);

        customerId = findViewById(R.id.eba_customerId1);
        customerName = findViewById(R.id.eba_customerName);
        customerEmail = findViewById(R.id.eba_customerEmail);
        gender = findViewById(R.id.eba_rg_gender);
        //billDate = findViewById(R.id.eba_date);
        unitConsumed = findViewById(R.id.eba_unitConsumed);
        dateView = (TextView) findViewById(R.id.textView5);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(month).append("/")
                .append(day).append("/").append(year));
    }

    private boolean allFieldsOk()
    {
        return
                customerId.getText().toString().isEmpty()
                || customerName.getText().toString().isEmpty()
                || customerEmail.getText().toString().isEmpty()
                || unitConsumed.getText().toString().isEmpty()
                || gender.getCheckedRadioButtonId() == 0
                || dateView.getText().toString().isEmpty();
    }

    public void onCalculateClick(View view)
    {
        if (this.allFieldsOk())
        {
            Toast.makeText(this, "All fields are mandatory!", Toast.LENGTH_LONG).show();
        }
        else
        {
            ElectricityBill bill = new ElectricityBill();
            bill.setCustomerId(customerId.getText().toString());
            bill.setCustomerName(customerName.getText().toString());
            bill.setCustomerEmail(customerEmail.getText().toString());
            bill.setUnitConsumed(Double.parseDouble(unitConsumed.getText().toString()));
            switch (gender.getCheckedRadioButtonId())
            {
                case R.id.eba_rb_male:
                    bill.setGender('M');
                    break;
                case R.id.eba_rb_female:
                    bill.setGender('F');
                    break;
                default:
                    bill.setGender('O');
                    break;
            }
            //bill.setBillDate(new Date(billDate.getText().toString()));
            bill.setBillDate(new Date(dateView.getText().toString()));

            Intent mainIntent = new Intent(ElectricityBillActivity.this, BillDetailsActivity.class);
            mainIntent.putExtra("bill", bill);
            ElectricityBillActivity.this.startActivity(mainIntent);
            ElectricityBillActivity.this.finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_electricity_bill_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
        Intent mainIntent;
        switch (item.getItemId())
        {
            case R.id.menu_eba_myBills:
                mainIntent = new Intent(ElectricityBillActivity.this, ListBillActivity.class);
                ElectricityBillActivity.this.startActivity(mainIntent);
                ElectricityBillActivity.this.finish();
                break;
            case R.id.menu_eba_logout:
                mainIntent = new Intent(ElectricityBillActivity.this, LoginActivity.class);
                ElectricityBillActivity.this.startActivity(mainIntent);
                ElectricityBillActivity.this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
