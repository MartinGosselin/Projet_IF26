package com.example.projet_if26.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.projet_if26.AppLogic.AppViewModel;
import com.example.projet_if26.Model.Logement;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projet_if26.R;

import java.util.List;

public class SingleEtatActivity extends AppCompatActivity {

    private AppViewModel appViewModel;

    private TextView nameTextView;
    private TextView cityTextView;
    private TextView zipCodeTextView;
    private TextView adresseTextView;
    private Button consultEtatButton;
    private Toolbar toolbarSingleLogement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_etat);

        nameTextView = findViewById(R.id.textView_single_logement_name);
        adresseTextView = findViewById(R.id.textView_single_logement_adresse);
        cityTextView = findViewById(R.id.textView_single_logement_ville);
        zipCodeTextView = findViewById(R.id.textView_single_logement_zip_code);
        consultEtatButton = findViewById(R.id.button_consulter_etat);
        toolbarSingleLogement = findViewById(R.id.toolbar_single_logement);

        setSupportActionBar(toolbarSingleLogement);
        getSupportActionBar().setTitle("Information sur le logement");


        Intent startingIntent = getIntent();
        String logementId = startingIntent.getStringExtra("logementId");

        appViewModel = ViewModelProviders.of(this).get(AppViewModel.class);
        List<Logement> listLogement = appViewModel.getLogementById(Integer.parseInt(logementId));

        Logement logement = listLogement.get(0);
        nameTextView.setText(logement.getLocataire());
        adresseTextView.setText(logement.getAdresse());
        cityTextView.setText(logement.getCity());
        zipCodeTextView.setText(logement.getZip_code());

        consultEtatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SingleEtatActivity.this, ListPieceActivity.class);
                intent.putExtra("logementId", logementId);
                SingleEtatActivity.this.startActivity(intent);
            }
        });






    }

}
