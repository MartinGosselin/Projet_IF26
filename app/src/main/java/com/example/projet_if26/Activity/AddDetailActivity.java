package com.example.projet_if26.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.projet_if26.R;

public class AddDetailActivity extends AppCompatActivity {

    private EditText editNewDetailName;
    private EditText editNewDetailEtat;
    private Toolbar toolbarAddDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_detail);
        editNewDetailName = findViewById(R.id.edit_name_new_detail);
        editNewDetailEtat = findViewById(R.id.edit_etat_new_detail);
        toolbarAddDetail = findViewById(R.id.toolbar_add_detail);

        setSupportActionBar(toolbarAddDetail);
        getSupportActionBar().setTitle("Ajouter un objet à la pièce");

        final Button button = findViewById(R.id.button_enregister_new_detail);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(editNewDetailName.getText())&&TextUtils.isEmpty(editNewDetailEtat.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    replyIntent.putExtra("name",editNewDetailName.getText().toString());
                    replyIntent.putExtra("etat",editNewDetailEtat.getText().toString());
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
