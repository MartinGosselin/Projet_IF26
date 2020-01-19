package com.example.projet_if26.Activity;

import android.os.Bundle;

import com.example.projet_if26.AppLogic.AppViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                String inputLogin = LoginActivity.this.loginEditText.getText().toString();
                LiveData<List<User>> userLiveList = LoginActivity.this.appViewModel.getUserByName(inputLogin);
                List<User> userList = userLiveList.getValue();

                /*
                if(userList.size()>0){
                    User user = userList.get(0);
                    if(user.getPassword().equals(LoginActivity.this.passwordEditText.getText().toString())){
                        //reussi -> message + redirection intent + set connection
                        Toast.makeText(
                                getApplicationContext(),
                                R.string.login_success,
                                Toast.LENGTH_LONG).show();
                        LoginActivity.this.loginEditText.setText("");
                    }
                    else{
                        Toast.makeText(
                                getApplicationContext(),
                                R.string.login_failed,
                                Toast.LENGTH_LONG).show();
                        LoginActivity.this.loginEditText.setText("");
                    }
                }
                else{
                    Toast.makeText(
                            getApplicationContext(),
                            R.string.login_failed,
                            Toast.LENGTH_LONG).show();
                    LoginActivity.this.loginEditText.setText("");
                }
                */

            }
        });
    }

}
