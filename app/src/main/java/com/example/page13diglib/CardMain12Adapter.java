package com.example.page13diglib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CardMain12Adapter extends RecyclerView.Adapter<CardMain12Adapter.CardViewHolder> {

        ArrayList<CardMain12> returned;
        Context context;

        public CardMain12Adapter(ArrayList<CardMain12> returned) {
            this.returned = returned;
        }


        @NonNull
        @Override
        public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card12,parent,false);
            CardViewHolder cvh = new CardViewHolder(view);
            return cvh;
        }

        @Override
        public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CardMain12 currentCards = this.returned.get(position);
            holder.imageForCard.setImageResource(currentCards.getImageForCard());
            holder.zeroText.setText(currentCards.getZeroText());
            holder.subjectText.setText(currentCards.getSubjectText());

        }

        @Override
        public int getItemCount() {
            return returned.size();
        }

        public class CardViewHolder extends RecyclerView.ViewHolder {

            ImageView imageForCard;
            TextView zeroText,subjectText;



            public CardViewHolder(@NonNull View itemView) {
                super(itemView);
                imageForCard=itemView.findViewById(R.id.imageForCard);
                zeroText=itemView.findViewById(R.id.zeroText);
                subjectText=itemView.findViewById(R.id.subjectText);

            }
        }
    }





