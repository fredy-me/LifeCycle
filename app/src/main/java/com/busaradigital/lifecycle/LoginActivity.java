package com.busaradigital.lifecycle;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    Button btnRegister;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_login);

        showLifecycleMessage("OnStart");
        //open register activity
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view){
                Intent openRegister = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(openRegister);
                finish();
            }
        });

        //open home activity
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openHome = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(openHome);
                finish();
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        showLifecycleMessage("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showLifecycleMessage("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showLifecycleMessage("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showLifecycleMessage("onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showLifecycleMessage("onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showLifecycleMessage("onDestroy");
    }

    private void showLifecycleMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Log.d(TAG, message);
    }
}