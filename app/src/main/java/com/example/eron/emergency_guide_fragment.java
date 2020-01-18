package com.example.eron;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class emergency_guide_fragment extends Fragment {
    Button home_btn, CPR_btn, choking_btn, bleeding_btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.emergency_guide_fragment, container, false);
        home_btn = view.findViewById(R.id.home_btn_from_emergency);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new home_screen_fragment()).commit();

            }
        });

        CPR_btn = view.findViewById(R.id.CPR_btn);
        choking_btn = view.findViewById(R.id.choking_btn);
        bleeding_btn = view.findViewById(R.id.bleeding_btn);

        return view;

    }
}