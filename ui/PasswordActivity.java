package com.example.test01.ui;

import static com.example.test01.R.layout.activity_password;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PasswordActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(activity_password);
    }

    public void login(View view){
        startActivity(new Intent(PasswordActivity.this, LoginActivity.class));
    }

    public void confirm_email(View view){
        Toast.makeText(this, "Confirm button clicked", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(PasswordActivity.this, OTPActivity.class));
    }
}
