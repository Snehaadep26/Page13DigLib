package com.example.page13diglib.QuestionBank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.page13diglib.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.util.ArrayList;
import java.util.List;

public class QuestionBankAdapter extends RecyclerView.Adapter<QuestionBankAdapter.CardViewHolder> implements Filterable {

    ArrayList<QuestionBank> returned;
    ArrayList<QuestionBank> returns;
    Context context;

    public QuestionBankAdapter(ArrayList<QuestionBank> returned)
    {
        this.returned = returned;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_questionbank,parent,false);
        CardViewHolder cvh = new CardViewHolder(view);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        QuestionBank currentCards = this.returned.get(position);
        holder.imageForCard.setImageResource(currentCards.getImageView());
        holder.infoText.setText(currentCards.getInfoText());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.BottomSheetTheme);
                bottomSheetDialog.setContentView(R.layout.bottom_sheetp21);
                bottomSheetDialog.show();
            }
        });

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

            List<QuestionBank> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(returns);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (QuestionBank title : returns) {
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
        ImageButton button;



        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imageForCard=itemView.findViewById(R.id.imageQue);
            infoText=itemView.findViewById(R.id.textQue);
            button=itemView.findViewById(R.id.moreIcQUe);
        }
    }
}

