package com.example.eron;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.fragment.app.Fragment;

import java.util.List;
import java.util.ArrayList;


public class tip_symptom_finder_fragment extends Fragment {
    RecyclerView tip_recycler_view;


    List<Tip> tipList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tip_symptom_finder1, container, false);

        tip_recycler_view = view.findViewById(R.id.tipView);
        initData();
        initRecyclerView();

        return view;

    }

    private void initRecyclerView() {
        TipRecyclerAdapter recyclerAdapter = new TipRecyclerAdapter(tipList);
        tip_recycler_view.setAdapter(recyclerAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        tip_recycler_view.addItemDecoration(dividerItemDecoration);
    }
    private void initData() {
        tipList = new ArrayList<>();
        tipList.add(new Tip(255, "nausea, headache, fatigue", "blahblahblah", "lsdkjf;asf"));
        tipList.add(new Tip(153, "back pain, headache, fatigue", "blahblahblah", "lsdkjf;asf"));
        tipList.add(new Tip(5, "back pain, leg pain, fatigue", "blahblahblah", "lsdkjf;asf"));
        tipList.add(new Tip(25, "hair loss, back pain, stomachache", "blahblahblah", "lsdkjf;asf"));
        tipList.add(new Tip(15, "diarrhea, foot pain, hair loss", "blahblahblah", "lsdkjf;asf"));
        tipList.add(new Tip(51, "irritation, fever, fainting", "blahblahblah", "lsdkjf;asf"));
    }
}
