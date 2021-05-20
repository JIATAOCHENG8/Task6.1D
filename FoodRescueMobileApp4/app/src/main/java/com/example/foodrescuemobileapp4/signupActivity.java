package com.example.foodrescuemobileapp4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foodrescuemobileapp4.data.DatabaseHelper;
import com.example.foodrescuemobileapp4.model.User;

public class signupActivity extends AppCompatActivity {
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        EditText nameEditText = findViewById(R.id.nameEditText);
        EditText emailEditText = findViewById(R.id.emailEditText);
        EditText phoneEditText = findViewById(R.id.phoneEditText);
        EditText addressEditText = findViewById(R.id.addressEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        EditText confirmPEditText = findViewById(R.id.confirmPEditText);
        Button saveButton = findViewById(R.id.saveButton);
        db = new DatabaseHelper(this);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                String address = addressEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String confirmP = confirmPEditText.getText().toString();

                if(password.equals(confirmP))
                {
                    long result = db.insertUser(new User(name,email,phone,address,password));
                   // if(result>0)
                  //  {
                        Toast.makeText(signupActivity.this,"Registered successfully!",Toast.LENGTH_LONG).show();
                    }
                //    else
                 //   {
                 //       Toast.makeText(signupActivity.this,"Registration error! ",Toast.LENGTH_LONG).show();
                 //   }
              //  }
                else
                {
                    Toast.makeText(signupActivity.this,"Two password do not match!",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}