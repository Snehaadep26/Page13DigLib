package com.example.page13diglib.QuestionBank;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.page13diglib.R;
import java.util.ArrayList;


public class FragmentQuestionBank extends Fragment {
    RecyclerView recyclerView1;
    RecyclerView.LayoutManager layoutManager1;
    View v;
    ArrayList<QuestionBank> maths ;
    QuestionBankAdapter adapter1;

    public FragmentQuestionBank()
    {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_questionbank, container, false);
        createCard();
        buildRecyclerView();
        buildRecyclerView1();
        buildRecyclerView2();
        buildRecyclerView3();
        return v;
    }
    public void createCard() {
        maths=new ArrayList<>();
        maths.add(new QuestionBank(R.drawable.quebank,"Developments Leading to the Bohr’s Model of Atom Developments Leading to"));
        maths.add(new QuestionBank(R.drawable.quebank,"Developments Leading to the Bohr’s Model of Atom Developments Leading to"));

    }

    public void buildRecyclerView() {
        recyclerView1 = (RecyclerView) v.findViewById(R.id.recyQ11);
        layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView1.setLayoutManager(layoutManager1);
        adapter1 = new QuestionBankAdapter(maths);
        recyclerView1.setAdapter(adapter1);
    }
    public void buildRecyclerView1() {
        recyclerView1 = (RecyclerView) v.findViewById(R.id.recyQ2);
        layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView1.setLayoutManager(layoutManager1);
        adapter1 = new QuestionBankAdapter(maths);
        recyclerView1.setAdapter(adapter1);
    }
    public void buildRecyclerView2() {
        recyclerView1 = (RecyclerView) v.findViewById(R.id.recyQ3);
        layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView1.setLayoutManager(layoutManager1);
        adapter1 = new QuestionBankAdapter(maths);
        recyclerView1.setAdapter(adapter1);
    }
    public void buildRecyclerView3() {
        recyclerView1 = (RecyclerView) v.findViewById(R.id.recyQ4);
        layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView1.setLayoutManager(layoutManager1);
        adapter1 = new QuestionBankAdapter(maths);
        recyclerView1.setAdapter(adapter1);
    }
}