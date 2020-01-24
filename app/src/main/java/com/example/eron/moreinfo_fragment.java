package com.example.eron;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class moreinfo_fragment extends Fragment {
    Button home_btn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.moreinfo_frag, container, false);
        TextView moreInfoText = (TextView) view.findViewById(R.id.more_info_textview);
        moreInfoText.setMovementMethod(new ScrollingMovementMethod());
        home_btn = view.findViewById(R.id.home_btn_from_moreinfo);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new home_screen_fragment()).commit();

            }
        });
        return view;


    }
}
