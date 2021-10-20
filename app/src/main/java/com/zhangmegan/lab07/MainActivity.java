package com.zhangmegan.lab07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.frame, FragmentB.newInstance(99, "RulerOfTheWorld"), "FragmentB");
        ft.commit();
    }

    public void update(View view) {
        FragmentB fragB = (FragmentB)getSupportFragmentManager().findFragmentByTag("FragmentB");
        ((TextView)(fragB.view.findViewById(R.id.b_textview))).setText(R.string.greeting2);
    }
}