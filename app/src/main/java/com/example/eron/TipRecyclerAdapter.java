package com.example.eron;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.cardview.widget.CardView;
import android.widget.TextView;
import android.widget.ImageView;
import java.util.List;
import java.util.ArrayList;


public class TipRecyclerAdapter extends RecyclerView.Adapter<TipRecyclerAdapter.ViewHolder> {

    List<Tip> tipList;

    public TipRecyclerAdapter(List<Tip> tipList) {
        this.tipList = tipList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.tip_row_item1, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tags.setText("Symptoms: " + tipList.get(position).getTags());
        holder.number.setText(tipList.get(position).getNumber());
        holder.tip.setText(tipList.get(position).getTip());
        holder.body.setText(tipList.get(position).getBody());

        boolean isExpand = tipList.get(position).isExpand();
        holder.expandableLayout.setVisibility(isExpand ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return tipList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tags, number, tip, body;
        ConstraintLayout expandableLayout;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            tags = itemView.findViewById(R.id.tags);
            number = itemView.findViewById(R.id.number);
            tip = itemView.findViewById(R.id.tip);
            body = itemView.findViewById(R.id.body);

            expandableLayout = itemView.findViewById(R.id.expandableLayout);
            cardView = itemView.findViewById(R.id.cardView);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Tip tip = tipList.get(getAdapterPosition());
                    tip.setExpand(!tip.isExpand());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
