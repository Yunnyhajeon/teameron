package com.example.eron;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new home_screen_fragment()).commit();


    }


   /* @Override
    public void onBackPressed() {
        Fragment currentFragment = fragmentManager.findFragmentById(R.id.fragment_container);
        fragmentManager.beginTransaction().remove(currentFragment).add(R.id.fragment_container, home_screen_fragment).addToBackStack(null).commit();


        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new home_screen_fragment()).commit();

        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new home_screen_fragment()).commit();
        Fragment currentFragment = getSupportFragmentManager().getFragments().get(getSupportFragmentManager().getBackStackEntryCount() - 1);
        if (currentFragment instanceof OnBackPressed) {
            ((OnBackPressed) currentFragment).onBackPressed();
        }
        super.onBackPressed();
    }*/

}
