package com.zhangmegan.lab07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    FragmentTransaction ft, d;
    FragmentB a, b;
    Button button;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ft = getSupportFragmentManager().beginTransaction();
//        ft.add(R.id.frame, FragmentB.newInstance(99, "RulerOfTheWorld"), "FragmentB");
        //ft.commit();

        a = FragmentB.newInstance(1, "Stayc", R.drawable.daisies);
        b = FragmentB.newInstance(3, "Jessica", R.drawable.hydrangea);
        ft.add(R.id.frame, b, "b");
        ft.add(R.id.frame, a, "a");
        ft.commit();

    }

    public void update(View view) {
        //FragmentB fragB = (FragmentB)getSupportFragmentManager().findFragmentByTag("FragmentB");
        FragmentB frag2 = (FragmentB)getSupportFragmentManager().findFragmentByTag("a");
        FragmentB frag3 = (FragmentB)getSupportFragmentManager().findFragmentByTag("b");
        //((TextView)(fragB.view.findViewById(R.id.b_textview))).setText(R.string.greeting2);
        FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
        ft2.setCustomAnimations(R.anim.slide_in, R.anim.slide_out);
        if(frag2 != null && frag2.isHidden())
            ft2.show(frag2);
        else if(frag2 != null && frag2.isAdded())
            ft2.hide(frag2);
        ft2.commit();
    }

    public void click(View view) {
        FragmentB frag2 = (FragmentB)getSupportFragmentManager().findFragmentByTag("a");
        FragmentB frag3 = (FragmentB)getSupportFragmentManager().findFragmentByTag("b");
        FragmentB frag4 = FragmentB.newInstance(101, "???", R.drawable.bluejay);
        FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
        ft2.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        if(frag2 != null && frag2.isAdded())
            ft2.remove(frag2);
        if(frag3 != null && frag3.isAdded())
            ft2.remove(frag3);
        else if(frag2 == null)
            ft2.add(R.id.frame, frag4, "c");
        ft2.commit();
    }
}