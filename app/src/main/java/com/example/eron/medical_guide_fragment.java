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

public class medical_guide_fragment extends Fragment {
    Button home_btn, screenings_btn, child_temp_btn, breast_exam_btn, test_btn, belly_btn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.medical_guide_fragment, container, false);

        home_btn = view.findViewById(R.id.home_btn_from_medical);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new home_screen_fragment()).commit();

            }
        });

        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new home_screen_fragment()).commit();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), callback);



        child_temp_btn = view.findViewById(R.id.child_temp_btn);
        child_temp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fr=new GuideContentFragment();
                FragmentManager fm=getFragmentManager();
                androidx.fragment.app.FragmentTransaction ft=fm.beginTransaction();
                Bundle args = new Bundle();
                args.putString("url", "file:///android_asset/MedicalGuides/ChildsTemperature.html");
                args.putString("guideType", "Medical");
                args.putString("title", "Taking a Child's Temperature");
                fr.setArguments(args);
                ft.replace(R.id.fragment_container, fr);
                ft.commit();
            }
        });

        breast_exam_btn = view.findViewById(R.id.breast_test_btn);
        breast_exam_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fr=new GuideContentFragment();
                FragmentManager fm=getFragmentManager();
                androidx.fragment.app.FragmentTransaction ft=fm.beginTransaction();
                Bundle args = new Bundle();
                args.putString("url", "file:///android_asset/MedicalGuides/BreastExam.html");
                args.putString("guideType", "Medical");
                args.putString("title", "Self Breast Examination");
                fr.setArguments(args);
                ft.replace(R.id.fragment_container, fr);
                ft.commit();
            }
        });

        screenings_btn = view.findViewById(R.id.screenings_btn);
        screenings_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fr=new GuideContentFragment();
                FragmentManager fm=getFragmentManager();
                androidx.fragment.app.FragmentTransaction ft=fm.beginTransaction();
                Bundle args = new Bundle();
                args.putString("url", "file:///android_asset/MedicalGuides/RecommendedScreenings.html");
                args.putString("guideType", "Medical");
                args.putString("title", "List of Recommended Screenings");
                fr.setArguments(args);
                ft.replace(R.id.fragment_container, fr);
                ft.commit();
            }
        });

        test_btn = view.findViewById(R.id.test_btn);
        test_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fr=new GuideContentFragment();
                FragmentManager fm=getFragmentManager();
                androidx.fragment.app.FragmentTransaction ft=fm.beginTransaction();
                Bundle args = new Bundle();
                args.putString("url", "file:///android_asset/MedicalGuides/TesticularExam.html");
                args.putString("guideType", "Medical");
                args.putString("title", "Self Testicular Examination");
                fr.setArguments(args);
                ft.replace(R.id.fragment_container, fr);
                ft.commit();
            }
        });

        belly_btn = view.findViewById(R.id.belly_btn);
        belly_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fr=new GuideContentFragment();
                FragmentManager fm=getFragmentManager();
                androidx.fragment.app.FragmentTransaction ft=fm.beginTransaction();
                Bundle args = new Bundle();
                args.putString("url", "file:///android_asset/MedicalGuides/HowToAssessBellyPain.html");
                args.putString("guideType", "Medical");
                args.putString("title", "How to Assess Belly Pain");
                fr.setArguments(args);
                ft.replace(R.id.fragment_container, fr);
                ft.commit();
            }
        });

        return view;

    }


}
