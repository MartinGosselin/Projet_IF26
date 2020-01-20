package com.example.projet_if26.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.projet_if26.AppLogic.AppViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projet_if26.Model.User;
import com.example.projet_if26.R;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private AppViewModel appViewModel;

    private EditText loginEditText;
    private EditText passwordEditText;
    private Button submitLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.appViewModel = ViewModelProviders.of(this).get(AppViewModel.class);

        this.loginEditText = findViewById(R.id.editText_input_login);
        this.passwordEditText = findViewById(R.id.editText_input_password);
        this.submitLoginButton = findViewById(R.id.button_submit_login);

        submitLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputLogin = loginEditText.getText().toString();
                List<User> userList = appViewModel.getUserByName(inputLogin);

                if(userList.size()>0){
                    User user = userList.get(0);
                    if(user.getPassword().equals(LoginActivity.this.passwordEditText.getText().toString())){
                         Toast.makeText(
                                getApplicationContext(),
                                R.string.login_success,
                                Toast.LENGTH_LONG).show();
                         Intent intent = new Intent(LoginActivity.this, ListLogementActivity.class);
                         LoginActivity.this.startActivity(intent);
                    }
                    else{
                        Toast.makeText(
                                getApplicationContext(),
                                R.string.login_failed,
                                Toast.LENGTH_LONG).show();
                        LoginActivity.this.passwordEditText.setText("");
                    }
                }
                else{
                    Toast.makeText(
                            getApplicationContext(),
                            R.string.login_failed,
                            Toast.LENGTH_LONG).show();
                    LoginActivity.this.passwordEditText.setText("");
                }
            }
        });
    }

}
