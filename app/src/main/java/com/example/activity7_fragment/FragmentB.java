package com.example.activity7_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment {

    private static final String nameArg = "";
    private TextView tVName;

    public static FragmentB newInstance(String param1){
        FragmentB fragment = new FragmentB();
        Bundle args = new Bundle();
        args.putString(nameArg, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_b, container, false);
        tVName = view.findViewById(R.id.tVfrgB);

        if(getArguments() != null){
            String name = getArguments().getString(nameArg);
            tVName.setText("Hello, " + name + "!");
        }
        return view;

    }

}