package com.example.page13diglib.Videos;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.page13diglib.LectureNotes.LectureNotes;
import com.example.page13diglib.LectureNotes.LectureNotesAdapter;
import com.example.page13diglib.MainActivity2;
import com.example.page13diglib.R;

import java.util.ArrayList;
import java.util.List;

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.CardViewHolder> implements Filterable
{
    ArrayList<Videos> returned;
    ArrayList<Videos> returns;
    Context context;
    public VideosAdapter(ArrayList<Videos> returned)
    {
        this.returned = returned;
    }

    @NonNull
    @Override
    public VideosAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_video,parent,false);
        VideosAdapter.CardViewHolder cvh = new VideosAdapter.CardViewHolder(view);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull VideosAdapter.CardViewHolder holder, int position) {
        Videos currentCards = this.returned.get(position);
        holder.imageForCard.setImageResource(currentCards.getImageView());
        holder.infoText.setText(currentCards.getInfoText());


    }

    @Override
    public int getItemCount()
    {
        return returned.size();
    }
    public Filter getFilter()
    {
        return publish;
    }

    private Filter publish = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<Videos> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(returns);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Videos title : returns) {
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
            imageForCard=itemView.findViewById(R.id.map_chemistry_imageView);
            infoText=itemView.findViewById(R.id.topic_textview);
        }
    }
}
