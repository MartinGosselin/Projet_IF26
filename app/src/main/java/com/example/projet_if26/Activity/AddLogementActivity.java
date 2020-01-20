package com.example.projet_if26.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.projet_if26.R;

public class AddLogementActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextVille;
    private EditText editTextZipCode;
    private EditText editTextAdresse;
    private Toolbar toolbarAddLogement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_logement);
        editTextAdresse = findViewById(R.id.edit_logement_adresse);
        editTextName = findViewById(R.id.edit_logement_name);
        editTextZipCode = findViewById(R.id.edit_logement_zipCode);
        editTextVille = findViewById(R.id.edit_logement_ville);
        toolbarAddLogement = findViewById(R.id.toolbar_add_logement);

        setSupportActionBar(toolbarAddLogement);
        getSupportActionBar().setTitle("Ajouter un nouveau logement");


        Button fab = findViewById(R.id.button_save_new_logement);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(editTextAdresse.getText())|| TextUtils.isEmpty(editTextName.getText())|| TextUtils.isEmpty(editTextZipCode.getText())|| TextUtils.isEmpty(editTextVille.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    replyIntent.putExtra("name", editTextName.getText().toString());
                    replyIntent.putExtra("zipCode", editTextZipCode.getText().toString());
                    replyIntent.putExtra("ville", editTextVille.getText().toString());
                    replyIntent.putExtra("adresse", editTextAdresse.getText().toString());
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }

}
