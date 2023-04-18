package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Custom_Adapter extends BaseAdapter {
    private Context context;
    private ArrayList<employee> employees;

    public Custom_Adapter(Context context, ArrayList<employee> emp){
        this.context = context;
        this.employees = emp;
    }
    @Override
    public int getCount() {
        return employees.size();
    }

    @Override
    public Object getItem(int i) {
        return employees.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.customlistview, null);
        TextView textView = (TextView) view.findViewById(R.id.text_result);
        textView.setText(employees.get(i).getFullName() + " - Net Salary: "+ String.format("%.0f",employees.get(i).calculateNet()));
        return view;
    }
}
