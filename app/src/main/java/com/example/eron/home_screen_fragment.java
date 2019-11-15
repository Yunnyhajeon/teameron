package com.example.eron;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class home_screen_fragment extends Fragment implements View.OnClickListener {
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

//        ebook_btn.setOnClickListener(this);
        ebook_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ebook.class);
                startActivity(i);
            }
        });
        finder_btn.setOnClickListener(this);
        medical_guide_btn.setOnClickListener(this);
        emergency_guide_btn.setOnClickListener(this);
        disclaimer_btn.setOnClickListener(this);
        moreinfo_btn.setOnClickListener(this);
        return view;
    }

    public void onClick(View v) {
        Fragment selected_fragment = null;
        switch (v.getId()) {
//            case  R.id.book_btn: {
//                selected_fragment = new ebook_fragment();
//                break;
//            }
            case R.id.finder_btn: {
                selected_fragment = new finder_fragment();
                break;
            }
            case R.id.medical_guide_btn: {
                selected_fragment = new medical_guide_fragment();
                break;
            }
            case R.id.emergency_guide_btn: {
                selected_fragment = new emergency_guide_fragment();
                break;
            }
            case R.id.disclaimer_btn: {
                selected_fragment = new disclaimer_fragment();
                break;
            }
            case R.id.more_info_btn: {
                selected_fragment = new moreinfo_fragment();
                break;
            }
        }
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, selected_fragment).commit();
    }
}
