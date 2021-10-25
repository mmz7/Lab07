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
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
            }
        });

        ft = getSupportFragmentManager().beginTransaction();
//        ft.add(R.id.frame, FragmentB.newInstance(99, "RulerOfTheWorld"), "FragmentB");
        //ft.commit();

        a = FragmentB.newInstance(1, "Stayc");
        b = FragmentB.newInstance(3, "Jessica");
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
        if(frag2.isHidden())
            ft2.setCustomAnimations(R.anim.slide_in, R.anim.slide_in).show(frag2);
        else if(frag2.isAdded())
            ft2.hide(frag2);
//        if(frag2.isVisible() && frag3.isAdded()) {
//            ft2.remove(frag3);
//            count++;
//        }
//        if(count == 1) {
//            ft2.replace(R.id.frame, FragmentB.newInstance(931, "Goblin"));
//            count--;
//        }
        ft2.commit();
    }

    public void click(View view) {
        FragmentB frag2 = (FragmentB)getSupportFragmentManager().findFragmentByTag("a");
        FragmentB frag3 = (FragmentB)getSupportFragmentManager().findFragmentByTag("b");
        FragmentTransaction ftrans = getSupportFragmentManager().beginTransaction();
        if(frag2.isAdded())
            ftrans.remove(frag2);
        ftrans.commit();
    }
}