package com.example.Notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.Notes.databinding.ActivityMainBinding;
import com.example.Notes.models.NotesViewModel;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        NotesViewModel viewModel = new ViewModelProvider(this).get(NotesViewModel.class);
        setContentView(view);

        binding.fabAdd.setOnClickListener(view1 -> {
            Intent intent = new Intent(this, AddActivity.class);
            startActivity(intent);
        });

        viewModel.getAllNotes().observe(this, notes -> {
            binding.rvNotes.setAdapter(new NotesListAdapter(notes));
        });

    }
}