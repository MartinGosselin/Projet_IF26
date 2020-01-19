package com.example.projet_if26.AppLogic;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.projet_if26.Activity.ListLogementActivity;
import com.example.projet_if26.Activity.SingleEtatActivity;
import com.example.projet_if26.Model.Logement;
import com.example.projet_if26.R;

import java.util.List;

public class LogementListAdapter extends RecyclerView.Adapter<LogementListAdapter.LogementViewHolder> {

    class LogementViewHolder extends RecyclerView.ViewHolder {
        private Button logementNameItemView;
        private TextView logementAdresseItemView;
        private TextView logementZipCodeItemView;
        private TextView logementVilleItemView;

        private LogementViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            logementNameItemView = itemView.findViewById(R.id.textView_logement_name);
            logementNameItemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent intent = new Intent(context, SingleEtatActivity.class);
                    intent.putExtra("logementId", ""+logementNameItemView.getTag());
                    context.startActivity(intent);
                }
            });
            /*
            logementAdresseItemView = itemView.findViewById(R.id.textView_logement_adresse);
            logementZipCodeItemView = itemView.findViewById(R.id.textView_logement_zip_code);
            logementVilleItemView = itemView.findViewById(R.id.textView_logement_ville);

             */
        }
    }

    private Context context;
    private final LayoutInflater mInflater;
    private List<Logement> mLogements; // Cached copy of words

    public LogementListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public LogementViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_logement, parent, false);
        return new LogementViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LogementViewHolder holder, int position) {
        if (mLogements != null) {
            Logement current = mLogements.get(position);
            holder.logementNameItemView.setText(current.getLocataire()+" "+current.getAdresse()+" "+current.getZip_code()+" "+current.getCity());
            holder.logementNameItemView.setTag(current.getId());

        } else {
            // Covers the case of data not being ready yet.
            holder.logementNameItemView.setText("No Logement");
        }
    }

    public void setLogements(List<Logement> logements){
        mLogements = logements;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mLogements != null)
            return mLogements.size();
        else return 0;
    }
}
