package com.example.projet_if26.AppLogic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import com.example.projet_if26.Model.Piece;
import com.example.projet_if26.R;

import java.util.List;

public class PieceListAdapter extends RecyclerView.Adapter<PieceListAdapter.PieceViewHolder> {

    class PieceViewHolder extends RecyclerView.ViewHolder {

        private Button buttonRecyclerPiece;

        private PieceViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

        }
    }

    private Context context;
    private final LayoutInflater mInflater;
    private List<Piece> mPieces; // Cached copy of words

    public PieceListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public PieceListAdapter.PieceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_piece, parent, false);
        return new PieceListAdapter.PieceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PieceListAdapter.PieceViewHolder holder, int position) {
        if (mPieces != null) {
            Piece current = mPieces.get(position);
            holder.buttonRecyclerPiece.setText(current.getName());

        } else {
            // Covers the case of data not being ready yet.
            holder.buttonRecyclerPiece.setText("No Piece");
        }
    }

    public void setPieces(List<Piece> pieces){
        mPieces = pieces;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mPieces != null)
            return mPieces.size();
        else return 0;
    }
}
