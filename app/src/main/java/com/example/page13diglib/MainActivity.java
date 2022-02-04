package com.example.page13diglib;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.page13diglib.LectureNotes.LectureNotes;
import com.example.page13diglib.QuestionBank.FragmentQuestionBank;
import com.example.page13diglib.LectureNotes.FragmentLectureNotes;
import com.example.page13diglib.Videos.FragmentVideos;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Filterable {
    TabLayout tabLayout;
    ViewPager viewPager;
    Toolbar toolbar;
    ArrayList<LectureNotes> returned;
    ArrayList<LectureNotes> returns;
    com.example.page13diglib.CardMain12Adapter cardMain12Adapter;
    ArrayList<com.example.page13diglib.CardMain12> cardMain12;
    RecyclerView recyclerView1;
    RecyclerView.LayoutManager layoutManager1;

    com.example.page13diglib.ViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.customToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLayout=(TabLayout)findViewById(R.id.tablayout);
        viewPager=(ViewPager) findViewById(R.id.viewPager);
        adapter=new com.example.page13diglib.ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new FragmentLectureNotes(),"LECTURE NOTES(10)");
        adapter.AddFragment(new FragmentVideos(),"VIDEOS(12)");
        adapter.AddFragment(new FragmentQuestionBank(),"QUESTION BANK(24)");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        createCard();
        buildRecyclerView();




    }

    public void createCard() {
        cardMain12=new ArrayList<>();
        cardMain12.add(new CardMain12(R.drawable.notes,"24","Lecture Notes"));
        cardMain12.add(new CardMain12(R.drawable.videos,"58","Videos"));
        cardMain12.add(new CardMain12(R.drawable.quebank,"54","Question banks"));


    }


    public void buildRecyclerView() {

        recyclerView1 = findViewById(R.id.recy1);
        recyclerView1.setHasFixedSize(true);
        layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(layoutManager1);
        cardMain12Adapter = new CardMain12Adapter(cardMain12);
        recyclerView1.setAdapter(cardMain12Adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
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
                for (LectureNotes title : returns
                ) {
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
            adapter.notifyDataSetChanged();

        }
    };
}