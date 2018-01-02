package com.assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mLoginBtn;
    private EditText mEmailEt, mPasswordEt;
    private String userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // initialise layout
        setContentView(R.layout.activity_main);
        initViews();
        // Setting actionBar title
        getSupportActionBar().setTitle("Login Screen");
        // add onclick listener to login Button
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // capture username and password
                userName = mEmailEt.getText().toString();
                password = mPasswordEt.getText().toString();

                // check for empty fields
                if (userName.equalsIgnoreCase("")) {
                    mEmailEt.setError("Please Enter Email Id");
                } else if (password.equalsIgnoreCase("")) {
                    mPasswordEt.setError("Please Enter Password");
                } else {
                    checkCredentiolAndLogin(userName, password);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    // This method will initialise view
    private void initViews() {
        mEmailEt = (EditText) findViewById(R.id.editText);
        mPasswordEt = (EditText) findViewById(R.id.editText2);
        mLoginBtn = (Button) findViewById(R.id.button);
    }

    // Check the credential if valid then move to HomeScreen
    private void checkCredentiolAndLogin(String userName, String password) {
        if (userName.equalsIgnoreCase("prabhu@gmail.com") && password.equalsIgnoreCase("password")) {
            Intent intent = new Intent(this, HomeScreenActivity.class);
            startActivity(intent);  // Start HomeScreen Activity
            finish();   // close this Activity
        }
    }
}
