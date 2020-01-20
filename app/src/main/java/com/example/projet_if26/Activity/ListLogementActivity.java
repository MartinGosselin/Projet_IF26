package com.example.projet_if26.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.projet_if26.AppLogic.AppViewModel;
import com.example.projet_if26.AppLogic.LogementListAdapter;
import com.example.projet_if26.Model.Detail;
import com.example.projet_if26.Model.Logement;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.projet_if26.R;

import java.util.List;

public class ListLogementActivity extends AppCompatActivity {

    private AppViewModel appViewModel;
    public static final int NEW_LOGEMENT_ACTIVITY_REQUEST_CODE = 1;
    public Toolbar toolbarLogementListe;
    private Button buttonAddLogement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_logement);

        RecyclerView recyclerView = findViewById(R.id.recyclerview_logement);
        final LogementListAdapter adapter = new LogementListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        toolbarLogementListe = findViewById(R.id.toolbar_list_logement);
        setSupportActionBar(toolbarLogementListe);
        getSupportActionBar().setTitle("Liste des logements");


        appViewModel = ViewModelProviders.of(this).get(AppViewModel.class);

        appViewModel.getAllLogements().observe(this, new Observer<List<Logement>>() {
            @Override
            public void onChanged(@Nullable final List<Logement> logements) {
                adapter.setLogements(logements);
            }
        });





        buttonAddLogement = findViewById(R.id.button_add_logement);
        buttonAddLogement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListLogementActivity.this, AddLogementActivity.class);
                startActivityForResult(intent, NEW_LOGEMENT_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_LOGEMENT_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Logement logement = new Logement(data.getStringExtra("name"), data.getStringExtra("zipCode"), data.getStringExtra("adresse"),data.getStringExtra("ville"),"","",1);
            appViewModel.insertLogement(logement);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "Logement invalide, enregistrement annulé",
                    Toast.LENGTH_LONG).show();
        }
    }

}
