package com.midterm.android.lambton.c0734506_midterm_mad3125f2018.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.midterm.android.lambton.c0734506_midterm_mad3125f2018.Domain.ElectricityBill;
import com.midterm.android.lambton.c0734506_midterm_mad3125f2018.R;

import java.util.List;

public class BillAdapter extends ArrayAdapter<ElectricityBill>
{
    private List<ElectricityBill> movieArrayList;
    private Context mContext;

    public BillAdapter(Context context)
    {
        super(context, 0, ElectricityBill.allBills);
        this.movieArrayList = ElectricityBill.allBills;
        this.mContext = context;

    }

    @Override
    public int getCount()
    {
        return movieArrayList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        MovieViewHolder mHolder;

        if(convertView == null)
        {
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.layout_bills_list,
                            parent,
                            false);
            mHolder = new MovieViewHolder(convertView);
            convertView.setTag(mHolder);
        }
        else
        {
            mHolder = (MovieViewHolder)convertView.getTag();
        }

        ElectricityBill currentMovie = movieArrayList.get(position);

        mHolder.name.setText(currentMovie.getCustomerName());
        mHolder.release.setText(currentMovie.getTotalBillAmount().toString());

        return convertView;
    }

    private class MovieViewHolder
    {
        ImageView image;
        TextView name;
        TextView release;

        public MovieViewHolder(View view)
        {
            //image = (ImageView)view.findViewById(R.id.imageView_poster);
            name = (TextView) view.findViewById(R.id.name_list);
            release = (TextView) view.findViewById(R.id.total_list);
        }
    }
}
