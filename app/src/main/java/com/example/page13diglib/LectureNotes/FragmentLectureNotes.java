package com.example.page13diglib.LectureNotes;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.page13diglib.CardMain12Adapter;
import com.example.page13diglib.R;

import java.util.ArrayList;


public class FragmentLectureNotes extends Fragment {
    ImageButton imageButton;
    Dialog dialog;
    RecyclerView recyclerView1;
    RecyclerView.LayoutManager layoutManager1;

    View v;
    ArrayList<LectureNotes> maths ;
    ImageButton button;
    LectureNotesAdapter adapter1;



    public FragmentLectureNotes() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_lecturenotes, container, false);
        createCard();
        buildRecyclerView();
        buildRecyclerView1();
        buildRecyclerView2();
        buildRecyclerView3();

        return v;


        
    }

    public void createCard() {
        maths=new ArrayList<>();
        maths.add(new LectureNotes(R.drawable.ic_notes,"Developments Leading to the Bohr’s Model of Atom Developments Leading to"));
        maths.add(new LectureNotes(R.drawable.ic_notes,"Developments Leading to the Bohr’s Model of Atom Developments Leading to"));

    }

    public void buildRecyclerView() {
        recyclerView1 = (RecyclerView) v.findViewById(R.id.recy11);
        layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView1.setLayoutManager(layoutManager1);
        adapter1 = new LectureNotesAdapter(maths);
        recyclerView1.setAdapter(adapter1);
    }
    public void buildRecyclerView1() {
        recyclerView1 = (RecyclerView) v.findViewById(R.id.recy2);
        layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView1.setLayoutManager(layoutManager1);
        adapter1 = new LectureNotesAdapter(maths);
        recyclerView1.setAdapter(adapter1);
    }
    public void buildRecyclerView2() {
        recyclerView1 = (RecyclerView) v.findViewById(R.id.recy3);
        layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView1.setLayoutManager(layoutManager1);
        adapter1 = new LectureNotesAdapter(maths);
        recyclerView1.setAdapter(adapter1);
    }
    public void buildRecyclerView3() {
        recyclerView1 = (RecyclerView) v.findViewById(R.id.recy4);
        layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView1.setLayoutManager(layoutManager1);
        adapter1 = new LectureNotesAdapter(maths);
        recyclerView1.setAdapter(adapter1);
    }


}