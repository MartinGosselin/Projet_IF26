package com.example.projet_if26.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.projet_if26.R;

public class AddPieceActivity extends AppCompatActivity {

    private EditText editPieceName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_piece);

        editPieceName = findViewById(R.id.edit_piece_name);

        final Button button = findViewById(R.id.button_save_piece);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(editPieceName.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String name = editPieceName.getText().toString();
                    replyIntent.putExtra("pieceName", name);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });



    }

}
