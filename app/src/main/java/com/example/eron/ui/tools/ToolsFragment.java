package com.example.eron.ui.tools;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.eron.R;

public class ToolsFragment extends Fragment {

    private ToolsViewModel toolsViewModel;
    private WebView webView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);

        webView = root.findViewById(R.id.webview_head_headache);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("file:///android_asset/part1_bodyparts/Head_1_Headache.html");

        /*
        webView = root.findViewById(R.id.webview_head_injury);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("file:///android_asset/part1_bodyparts/Head_2_HeadInjury.html");

        webView = root.findViewById(R.id.webview_head_psychological);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("file:///android_asset/part1_bodyparts/Head_3_PsychologicalProblems.html");

         */



        //        final TextView textView = root.findViewById(R.id.text_tools);
//        toolsViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
////                textView.setText(s);
////                textView.setMovementMethod(new ScrollingMovementMethod());
//            }
//        });
        return root;
    }
}