package com.zhangmegan.lab07;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.transition.Transition;
import androidx.transition.TransitionInflater;

public class FragmentB extends Fragment {
    View view;
    public static FragmentB newInstance(int x, String s) {
        FragmentB fragmentB = new FragmentB();
        Bundle args = new Bundle();
        args.putInt("MyAge", x);
        args.putString("MyName", s);
        fragmentB.setArguments(args);
        return fragmentB;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TransitionInflater inflater = android.transition.TransitionInflater.from(requireContext());
        setExitTransition(inflater.inflateTransition(R.transition.slide_in));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
        int age = getArguments().getInt("MyAge", 2000);
        String name = getArguments().getString("MyName", "Blegh");
        TextView tv = view.findViewById(R.id.b_textview);
        String t = getString(R.string.greeting, name);
        tv.setText(t);
        Button button = view.findViewById(R.id.b_button);
        String b = getString(R.string.click_greet, age);
        button.setText(b);
    }
}
