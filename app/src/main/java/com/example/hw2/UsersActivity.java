package com.example.hw2;


import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hw2.databinding.ActivityMainBinding;
import com.example.hw2.databinding.UsersActivityBinding;

public class UsersActivity extends AppCompatActivity {

    UsersActivityBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = UsersActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(
                new LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        );
    }
}
