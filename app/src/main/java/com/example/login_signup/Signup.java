package com.example.login_signup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Signup extends AppCompatActivity {

    TextInputLayout edit1, edit2, edit3, edit4;
    Button btnsignup;
    TextView txtlogin;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    private boolean validateData() {
        String fullname = edit1.getEditText().getText().toString().trim();
        String phone = edit2.getEditText().getText().toString().trim();
        String username = edit3.getEditText().getText().toString().trim();
        if (fullname.isEmpty()  ) {
            edit1.setError("Field can't be empty");
            return false;
        } else if(phone.isEmpty()){
            edit1.setError(null);
            edit2.setError("Field can't be empty");
            return false;
        } else if (username.isEmpty() ){
            edit1.setError(null);
            edit2.setError(null);
            edit3.setError("Field can't be empty");
            return false;

        } else if(username.length() < 6) {
            edit3.setError("at least 6 characters");
            return false;
        }
        else return true;
    }
    private boolean validatePassword(){
        String password = edit4.getEditText().getText().toString().trim();
        if (password.isEmpty()  ) {
            edit4.setError("Field can't be empty");
            return false;
        } else if(password.length() < 6 ){
            edit4.setError("at least 6 characters");
            return false;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        edit1 = findViewById(R.id.editfullname);
        edit2 = findViewById(R.id.editphone);
        edit3 = findViewById(R.id.editusername);
        edit4 = findViewById(R.id.editpassword);
        btnsignup = findViewById(R.id.btnSignup);
        txtlogin = findViewById(R.id.textViewLogin);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get data from edittext into String variable
                final String txtfullname = edit1.getEditText().getText().toString();
                final String txtphone = edit2.getEditText().getText().toString();
                final String txtusername = edit3.getEditText().getText().toString();
                final String txtpass = edit4.getEditText().getText().toString();


                // Check validate
                if (!validateData() | !validatePassword()) {
                    return;
                }
                else {
                    database.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            //Check phone
//                            if(snapshot)
                            User user = new User(txtfullname, txtphone, txtpass);
                            database.child("users").child(txtusername).setValue(user);

                            //show success message  then finish

                            CustomToast.makeText(Signup.this,"Register Successfully!",CustomToast.LENGTH_LONG,CustomToast.SUCCESS,true).show();

                            finish();


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            //sending data to firebase

                        }
                    });

                }
                startActivity(new Intent(Signup.this, MainActivity.class));


            }
        });
        txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Signup.this, Login.class));
            }
        });

    }
}