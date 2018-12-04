package com.midterm.android.lambton.c0734506_midterm_mad3125f2018;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.midterm.android.lambton.c0734506_midterm_mad3125f2018.Data.DbHelper;
import com.midterm.android.lambton.c0734506_midterm_mad3125f2018.Domain.ElectricityBill;

public class BillDetailsActivity extends AppCompatActivity
{

    private TextView customerId;
    private TextView customerName;
    private TextView customerEmail;
    private TextView gender;
    private TextView billDate;
    private TextView unitConsumed;
    private TextView totalAmount;

    private ElectricityBill bill;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_details);

        customerId = findViewById(R.id.dba_customerId);
        customerName = findViewById(R.id.dba_customerName);
        customerEmail = findViewById(R.id.dba_customerEmail);
        gender = findViewById(R.id.dba_gender);
        billDate = findViewById(R.id.dba_bill_date);
        unitConsumed = findViewById(R.id.dba_unit_consumed);
        totalAmount = findViewById(R.id.dba_total_bill);

        Intent previousPage = getIntent();
        Bundle mBundle = previousPage.getExtras();
        bill = (ElectricityBill) mBundle.getSerializable("bill");

        customerId.setText(bill.getCustomerId());
        customerName.setText(bill.getCustomerName());
        customerEmail.setText(bill.getCustomerEmail());
        gender.setText(bill.getGenderString());
        billDate.setText(bill.getBillDate().toString());
        unitConsumed.setText(String.format("%.2f Kw/h", bill.getUnitConsumed()));
        totalAmount.setText(String.format("$ %.2f", bill.getTotalBillAmount()));
    }

    public void onSaveClick(View view)
    {
        DbHelper mDbHelper = new DbHelper(this.getApplicationContext());
        if (bill.saveElectricityBill(mDbHelper))
        {
            Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();
            Intent mainIntent = new Intent(BillDetailsActivity.this, ElectricityBillActivity.class);
            BillDetailsActivity.this.startActivity(mainIntent);
            BillDetailsActivity.this.finish();
        }
        else
        {
            Toast.makeText(this, "NOT Saved!", Toast.LENGTH_SHORT).show();
        }
    }
}
