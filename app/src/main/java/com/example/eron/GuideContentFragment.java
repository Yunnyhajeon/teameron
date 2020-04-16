package com.example.eron;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.webkit.WebView;
import androidx.appcompat.widget.Toolbar;

public class GuideContentFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.guide_content, container, false);

        WebView webView = view.findViewById(R.id.guideWebView);
        webView.loadUrl(getArguments().getString("url"));

        /*
        home_btn = view.findViewById(R.id.homeBtn);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new home_screen_fragment()).commit();

            }
        });

         */

        Toolbar toolbar = view.findViewById(R.id.toolbar2);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getArguments().getString("guideType").equals("Emergency")) {
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new emergency_guide_fragment()).commit();
                } else { //guideType="Medical"
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, new medical_guide_fragment()).commit();
                }
            }
        });

        toolbar.setTitle(getArguments().getString("title"));

        return view;

    }
}
