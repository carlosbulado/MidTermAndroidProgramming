package com.midterm.android.lambton.c0734506_midterm_mad3125f2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.midterm.android.lambton.c0734506_midterm_mad3125f2018.Adapters.BillAdapter;

import java.util.ArrayList;

public class ListBillActivity extends AppCompatActivity
{

    private ListView lstBills;
    private BillAdapter billAdapter;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_bill);

        //lstBills = findViewById(R.id.lba_listBills);

        billAdapter = new BillAdapter(this);

        //lstBills.setAdapter(billAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_bill_details_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
        Intent mainIntent;
        switch (item.getItemId())
        {
            case R.id.menu_bda_add:
                mainIntent = new Intent(ListBillActivity.this, ElectricityBillActivity.class);
                ListBillActivity.this.startActivity(mainIntent);
                ListBillActivity.this.finish();
                break;
            case R.id.menu_bda_logout:
                mainIntent = new Intent(ListBillActivity.this, LoginActivity.class);
                ListBillActivity.this.startActivity(mainIntent);
                ListBillActivity.this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
