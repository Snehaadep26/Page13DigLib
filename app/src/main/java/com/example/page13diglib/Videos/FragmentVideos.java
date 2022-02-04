package com.example.page13diglib.Videos;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.page13diglib.LectureNotes.LectureNotes;
import com.example.page13diglib.LectureNotes.LectureNotesAdapter;
import com.example.page13diglib.R;

import java.util.ArrayList;


public class FragmentVideos extends Fragment {
    ImageButton imageButton;
    Dialog dialog;
    RecyclerView recyclerView1;
    RecyclerView.LayoutManager layoutManager1;

    View v;
    ArrayList<Videos> vid ;
    ImageButton button;
    VideosAdapter adapter1;



    public FragmentVideos() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_videos, container, false);
        createCard();
        buildRecyclerView();
        buildRecyclerView1();
        buildRecyclerView2();
        buildRecyclerView3();

        return v;



    }

    public void createCard() {
        vid=new ArrayList<>();
        vid.add(new Videos(R.drawable.mapchem,"Towards Quantum Mechanical Model of the Atom"));
        vid.add(new Videos(R.drawable.mapchem,"Towards Quantum Mechanical Model of the Atom"));

    }

    public void buildRecyclerView() {
        recyclerView1 = (RecyclerView) v.findViewById(R.id.recyv11);
        layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView1.setLayoutManager(layoutManager1);
        adapter1 = new VideosAdapter(vid);
        recyclerView1.setAdapter(adapter1);
    }
    public void buildRecyclerView1() {
        recyclerView1 = (RecyclerView) v.findViewById(R.id.recyv2);
        layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView1.setLayoutManager(layoutManager1);
        adapter1 = new VideosAdapter(vid);
        recyclerView1.setAdapter(adapter1);
    }
    public void buildRecyclerView2() {
        recyclerView1 = (RecyclerView) v.findViewById(R.id.recyv3);
        layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView1.setLayoutManager(layoutManager1);
        adapter1 = new VideosAdapter(vid);
        recyclerView1.setAdapter(adapter1);
    }
    public void buildRecyclerView3() {
        recyclerView1 = (RecyclerView) v.findViewById(R.id.recyv4);
        layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView1.setLayoutManager(layoutManager1);
        adapter1 = new VideosAdapter(vid);
        recyclerView1.setAdapter(adapter1);
    }


}