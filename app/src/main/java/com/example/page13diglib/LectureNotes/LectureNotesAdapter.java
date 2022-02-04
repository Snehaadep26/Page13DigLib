package com.example.page13diglib.LectureNotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.page13diglib.R;

import java.util.ArrayList;
import java.util.List;

public class LectureNotesAdapter extends RecyclerView.Adapter<LectureNotesAdapter.CardViewHolder> implements Filterable {

        ArrayList<LectureNotes> returned;
    ArrayList<LectureNotes> returns;

    Context context;

        public LectureNotesAdapter(ArrayList<LectureNotes> returned) {
            this.returned = returned;
        }


        @NonNull
        @Override
        public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_lecturenotes,parent,false);
            CardViewHolder cvh = new CardViewHolder(view);
            return cvh;
        }

        @Override
        public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
            LectureNotes currentCards = this.returned.get(position);
            holder.imageForCard.setImageResource(currentCards.getImageView());
            holder.infoText.setText(currentCards.getInfoText());

        }

        @Override
        public int getItemCount() {
            return returned.size();
        }
    public Filter getFilter() {
        return publish;
    }

    private Filter publish = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<LectureNotes> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(returns);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (LectureNotes title : returns) {
                    if (title.getInfoText().toLowerCase().contains(filterPattern)) {
                        filteredList.add(title);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            returned.clear();
            returned.addAll((List) results.values);
            notifyDataSetChanged();

        }
    };

        public class CardViewHolder extends RecyclerView.ViewHolder {

            ImageView imageForCard;
            TextView infoText;



            public CardViewHolder(@NonNull View itemView) {
                super(itemView);
                imageForCard=itemView.findViewById(R.id.imageQue);
                infoText=itemView.findViewById(R.id.textQue);

            }
        }
    }










