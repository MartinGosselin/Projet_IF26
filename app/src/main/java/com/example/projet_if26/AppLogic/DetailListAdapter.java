package com.example.projet_if26.AppLogic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.projet_if26.Model.Detail;
import com.example.projet_if26.R;

import java.util.List;

public class DetailListAdapter extends RecyclerView.Adapter<DetailListAdapter.DetailViewHolder> {

    class DetailViewHolder extends RecyclerView.ViewHolder {
        private final TextView detailNameItemView;

        private DetailViewHolder(View itemView) {
            super(itemView);
            detailNameItemView = itemView.findViewById(R.id.textView_detail_name);
        }
    }

    private final LayoutInflater mInflater;
    private List<Detail> details; // Cached copy of words

    public DetailListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public DetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_detail, parent, false);
        return new DetailViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DetailViewHolder holder, int position) {
        if (details != null) {
            Detail current = details.get(position);
            holder.detailNameItemView.setText("Nom de l'objet : "+current.getName()+" Etat de l'objet : "+current.getIn_state());
        } else {
            // Covers the case of data not being ready yet.
            holder.detailNameItemView.setText("No Name");
        }
    }

    public void setDetails(List<Detail> details){
        this.details = details;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (this.details != null)
            return this.details.size();
        else return 0;
    }
}
