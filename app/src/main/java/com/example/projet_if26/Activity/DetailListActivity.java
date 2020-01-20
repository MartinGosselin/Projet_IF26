package com.example.projet_if26.Activity;

import android.content.Intent;
import android.os.Bundle;


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

import com.example.projet_if26.AppLogic.AppViewModel;
import com.example.projet_if26.AppLogic.DetailListAdapter;
import com.example.projet_if26.Model.Detail;
import com.example.projet_if26.R;

import java.util.List;

public class DetailListActivity extends AppCompatActivity {

    private AppViewModel appViewModel;
    public static final int NEW_DETAIL_ACTIVITY_REQUEST_CODE = 1;

    private int pieceId;

    private Toolbar toolbarListDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list);

        Intent launchingIntent = getIntent();
        pieceId = Integer.parseInt(launchingIntent.getStringExtra("pieceId"));

        toolbarListDetail = findViewById(R.id.toolbar_list_detail);
        setSupportActionBar(toolbarListDetail);
        getSupportActionBar().setTitle("Liste des objets de la pièce");

        RecyclerView recyclerView = findViewById(R.id.recyclerview_detail);
        final DetailListAdapter adapter = new DetailListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        appViewModel = ViewModelProviders.of(this).get(AppViewModel.class);

        appViewModel.getAllDetailsByPieceId(pieceId).observe(this, new Observer<List<Detail>>() {
            @Override
            public void onChanged(@Nullable final List<Detail> details) {
                adapter.setDetails(details);
            }
        });

        Button fab = findViewById(R.id.fab_add_detail);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), AddDetailActivity.class);
                startActivityForResult(intent, NEW_DETAIL_ACTIVITY_REQUEST_CODE);
            }
        });

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_DETAIL_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Detail detail = new Detail(data.getStringExtra("name"),data.getStringExtra("etat"),"","", pieceId);
            appViewModel.insertDetail(detail);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "Detail invalide, enregistrement annulé",
                    Toast.LENGTH_LONG).show();
        }
    }
}
