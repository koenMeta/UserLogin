package com.example.userlogin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.userlogin.api.AbstractAPIListener;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText emailField = findViewById(R.id.txtEmail);
        final EditText passwordField = findViewById(R.id.txtPwd);
        Button loginBtn = findViewById(R.id.btnLogin);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailField.getText().toString();
                String password = passwordField.getText().toString();

                final Model model = Model.getInstance(LoginActivity.this.getApplication());
                model.login(email, password, new AbstractAPIListener() {
                    @Override
                    public void onLogin(User user) {
                        model.setUser(user);
                        Toast.makeText(LoginActivity.this, "User " + user.getName() + " has loggend on!", Toast.LENGTH_LONG).show();
                    };
                });
            }
        });
    }
}
