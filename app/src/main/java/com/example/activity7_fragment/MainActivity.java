package com.example.activity7_fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private Button btnfrgA, btnfrgB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Part 1
        btnfrgA = findViewById(R.id.btnfrg1);
        btnfrgB = findViewById(R.id.btnfrg2);

        //Part 3
        btnfrgA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new FragmentA());
            }
        });

        //Part 4 including the if cdt then FragmentB.java
        btnfrgB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new FragmentB());
            }
        });
        if(savedInstanceState ==null) {
            loadFragment(new FragmentA()); //Load fragment A by default
        }
    }

    //Part 2
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    //Part 5 after Fragment B
    public void passNameToFragmentB(String name) {
        FragmentB fragmentB = FragmentB.newInstance(name);
        loadFragment(fragmentB);
    }
}