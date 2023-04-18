package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    employee e;
    ListView lv;
    ArrayList<employee> listEmp = new ArrayList();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextInputLayout text = findViewById(R.id.edittext1);
        TextInputLayout number = findViewById(R.id.edittext2);
        lv  = findViewById(R.id.listResult);
        Button btn = findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = (text.getEditText().getText().toString());
                double num = Double.parseDouble(number.getEditText().getText().toString());
                e = new employee(txt, num);
                listEmp.add(e);
                Custom_Adapter custom_adapter = new Custom_Adapter(getApplicationContext(), listEmp);
                lv.setAdapter(custom_adapter);
            }
        });
    }
}