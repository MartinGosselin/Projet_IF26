package com.example.projet_if26.Activity;

import android.content.Intent;
import android.os.Bundle;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.projet_if26.AppLogic.AppViewModel;
import com.example.projet_if26.AppLogic.DetailListAdapter;
import com.example.projet_if26.Model.Detail;
import com.example.projet_if26.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class DetailListActivity extends AppCompatActivity {

    private AppViewModel appViewModel;
    public static final int NEW_DETAIL_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list);

        RecyclerView recyclerView = findViewById(R.id.recyclerview_detail);
        final DetailListAdapter adapter = new DetailListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        appViewModel = ViewModelProviders.of(this).get(AppViewModel.class);

        appViewModel.getAllDetails().observe(this, new Observer<List<Detail>>() {
            @Override
            public void onChanged(@Nullable final List<Detail> details) {
                adapter.setDetails(details);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab_add_detail);
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
            Detail detail = new Detail(data.getStringExtra("name"),data.getStringExtra("etat"),"","");
            appViewModel.insertDetail(detail);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "Detail invalide, enregistrement annulé",
                    Toast.LENGTH_LONG).show();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
