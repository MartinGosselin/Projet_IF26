package com.example.projet_if26.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.projet_if26.AppLogic.AppViewModel;
import com.example.projet_if26.AppLogic.PieceListAdapter;
import com.example.projet_if26.Model.Logement;
import com.example.projet_if26.Model.Piece;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.projet_if26.R;

import java.util.List;

public class ListPieceActivity extends AppCompatActivity {

    private AppViewModel appViewModel;

    public static final int NEW_PIECE_ACTIVITY_REQUEST_CODE = 3;

    private int logementId;

    private Button buttonNewPiece;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_piece);

        Intent launchingIntent = getIntent();
        logementId = Integer.parseInt(launchingIntent.getStringExtra("logementId"));

        RecyclerView recyclerView = findViewById(R.id.recyclerview_piece);
        final PieceListAdapter adapter = new PieceListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        buttonNewPiece = findViewById(R.id.button_new_piece);
        buttonNewPiece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListPieceActivity.this, AddPieceActivity.class);
                startActivityForResult(intent, NEW_PIECE_ACTIVITY_REQUEST_CODE);
            }
        });

        appViewModel = ViewModelProviders.of(this).get(AppViewModel.class);

        appViewModel.getAllPieceByLogementId(logementId).observe(this, new Observer<List<Piece>>() {
            @Override
            public void onChanged(@Nullable final List<Piece> pieces) {

                adapter.setPieces(pieces);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_PIECE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Piece piece = new Piece(data.getStringExtra("pieceName"),"",logementId);
            appViewModel.insertPiece(piece);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "Piece invalide, enregistrement annulé",
                    Toast.LENGTH_LONG).show();
        }
    }

}
