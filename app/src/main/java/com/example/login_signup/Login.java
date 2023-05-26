package com.example.login_signup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    TextInputLayout edit1, edit2;
    Button btnlogin;
    TextView txtsignup;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edit1 = findViewById(R.id.editusername);
        edit2 = findViewById(R.id.editpassword);
        btnlogin = findViewById(R.id.btnlogin);
        txtsignup = findViewById(R.id.textViewSignUp);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edit1.getEditText().getText().toString();
                String pass = edit2.getEditText().getText().toString();
                //check fill
                if(username.isEmpty()){
                    edit1.setError("Field can't be empty");
                }
                else if(pass.isEmpty()){
                    edit2.setError("Field can't be empty");
                }
                else{
                    database.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(username)){
                                final String getpassword = snapshot.child(username).child("password").getValue(String.class);
                                if(getpassword.equals(pass)){
                                    CustomToast.makeText(Login.this,"Successfully Logged in",CustomToast.LENGTH_LONG,CustomToast.SUCCESS,true).show();
                                    String s = snapshot.child(username).child("fullName").getValue(String.class);
                                    Intent i = new Intent();
                                    i.setClass(Login.this, MainActivity.class);
                                    i.putExtra("Fname", s);
                                    startActivity(i);
                                }
                                else{
                                    CustomToast.makeText(Login.this,"Username or Password is incorrect",CustomToast.LENGTH_LONG,CustomToast.ERROR,true).show();

                                }
                            }
                            else{
                                CustomToast.makeText(Login.this,"Username or Password is incorrect",CustomToast.LENGTH_LONG,CustomToast.ERROR,true).show();

                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }


            }
        });

        txtsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Signup.class ));
            }
        });

    }
}