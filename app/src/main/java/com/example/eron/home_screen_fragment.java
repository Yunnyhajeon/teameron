package com.example.eron;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class home_screen_fragment extends Fragment {
    Button ebook_btn, finder_btn, medical_guide_btn, emergency_guide_btn, disclaimer_btn, moreinfo_btn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_screen_frag, container, false);
        ebook_btn = (Button)view.findViewById(R.id.book_btn);
        finder_btn = view.findViewById(R.id.finder_btn);
        medical_guide_btn = view.findViewById(R.id.medical_guide_btn);
        emergency_guide_btn= view.findViewById(R.id.emergency_guide_btn);
        disclaimer_btn = view.findViewById(R.id.disclaimer_btn);
        moreinfo_btn = view.findViewById(R.id.more_info_btn);

        ebook_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new ebook_fragment()).commit();

            }
        });
        finder_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new finder_fragment()).commit();

            }
        });
        medical_guide_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new medical_guide_fragment()).commit();

            }
        });
        emergency_guide_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new emergency_guide_fragment()).commit();

            }
        });
        disclaimer_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new disclaimer_fragment()).commit();

            }
        });
        moreinfo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new moreinfo_fragment()).commit();

            }
        });



        return view;
    }
}
