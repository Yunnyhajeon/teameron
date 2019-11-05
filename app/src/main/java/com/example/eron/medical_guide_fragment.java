package com.example.eron;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class medical_guide_fragment extends Fragment {
    Button home_btn, bld_pressure_btn, child_temp_btn, breast_exam_btn, medication_btn  ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.medical_guide_fragment, container, false);
        home_btn = view.findViewById(R.id.home_btn_from_medicalguide);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new home_screen_fragment()).commit();

            }
        });

        bld_pressure_btn = view.findViewById(R.id.bld_pressure_btn);
        child_temp_btn = view.findViewById(R.id.child_temp_btn);
        breast_exam_btn = view.findViewById(R.id.breast_exam_btn);
        medication_btn = view.findViewById(R.id.medication_btn);
        return view;

    }
}
