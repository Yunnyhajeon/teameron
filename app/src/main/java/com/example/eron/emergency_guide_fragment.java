package com.example.eron;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class emergency_guide_fragment extends Fragment {
    Button home_btn, CPR_btn, choking_btn, passing_out_btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.emergency_guide_fragment, container, false);

        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new home_screen_fragment()).commit();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), callback);

        home_btn = view.findViewById(R.id.home_btn_from_emergency);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new home_screen_fragment()).commit();

            }
        });

        //On X button click, pass that corresponding url and guide type to the Guide Content Fragment

        CPR_btn = view.findViewById(R.id.CPR_btn);
        CPR_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fr=new GuideContentFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                Bundle args = new Bundle();
                args.putString("url", "file:///android_asset/EmergencyGuides/CPR.html");
                args.putString("guideType", "Emergency");
                args.putString("title", "How to Perform CPR");
                fr.setArguments(args);
                ft.replace(R.id.fragment_container, fr);
                ft.commit();
            }
        });

        choking_btn = view.findViewById(R.id.choking_btn);
        choking_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fr=new GuideContentFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                Bundle args = new Bundle();
                args.putString("url", "file:///android_asset/EmergencyGuides/Choking.html");
                args.putString("guideType", "Emergency");
                args.putString("title", "Choking");

                fr.setArguments(args);
                ft.replace(R.id.fragment_container, fr);
                ft.commit();
            }
        });

        passing_out_btn = view.findViewById(R.id.passing_out_btn);
        passing_out_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fr=new GuideContentFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                Bundle args = new Bundle();
                args.putString("url", "file:///android_asset/EmergencyGuides/LossOfConsciousness.html");
                args.putString("guideType", "Emergency");
                args.putString("title", "Loss of Consciousness");

                fr.setArguments(args);
                ft.replace(R.id.fragment_container, fr);
                ft.commit();
            }
        });

        return view;

    }
}
