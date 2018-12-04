package com.midterm.android.lambton.c0734506_midterm_mad3125f2018.Domain;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.midterm.android.lambton.c0734506_midterm_mad3125f2018.Data.DbHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ElectricityBill implements Serializable
{
    public static List<ElectricityBill> allBills = new ArrayList<>();

    private String customerId;
    private String customerName;
    private String customerEmail;
    private char gender;
    private Date billDate;
    private Double unitConsumed;

    public String getCustomerId ()
    {
        return customerId;
    }

    public void setCustomerId (String customerId)
    {
        this.customerId = customerId;
    }

    public String getCustomerName ()
    {
        return customerName;
    }

    public void setCustomerName (String customerName)
    {
        this.customerName = customerName;
    }

    public String getCustomerEmail ()
    {
        return customerEmail;
    }

    public void setCustomerEmail (String customerEmail)
    {
        this.customerEmail = customerEmail;
    }

    public char getGender ()
    {
        return gender;
    }

    public String getGenderString()
    {
        switch (this.getGender())
        {
            case 'M': return "Male";
            case 'F': return "Female";
            default: return "Other";
        }
    }

    public void setGender (char gender)
    {
        this.gender = gender;
    }

    public Date getBillDate ()
    {
        return billDate;
    }

    public void setBillDate (Date billDate)
    {
        this.billDate = billDate;
    }

    public Double getUnitConsumed ()
    {
        return unitConsumed;
    }

    public void setUnitConsumed (Double unitConsumed)
    {
        this.unitConsumed = unitConsumed;
    }

    public Double getTotalBillAmount ()
    {
        Double total = 0d;
        Double cons = this.getUnitConsumed();

        if(cons > 100)
        {
            total += 100 * .75;
            cons -= 100;
            if(cons > 150)
            {
                total += 150 * 1.25;
                cons -= 150;
                if(cons > 200)
                {
                    total += 200 * 1.75;
                    cons -= 200;
                    total += cons * 2.25;
                }
                else
                {
                    total += cons * 1.75;
                }
            }
            else
            {
                total += cons * 1.25;
            }
        }
        else
        {
            total += cons * .75;
        }

        return total;
    }

    public boolean saveElectricityBill(DbHelper mDbHelper)
    {
        ElectricityBill.allBills.add(this);
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put("customerId", this.getCustomerId());
        values.put("customerName", this.getCustomerName());
        values.put("customerEmail", this.getCustomerEmail());
        values.put("gender", String.valueOf(this.getGender()));
        values.put("billDate", this.getBillDate().getTime());
        values.put("unitConsumed", this.getUnitConsumed());

        // Insert the new row, returning the primary key value of the new row
        db.insert("electricity_bill", null, values);

        return true;
    }
}
