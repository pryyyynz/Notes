package com.example.Notes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.Notes.database.Note;
import com.example.Notes.databinding.NoteItemBinding;
import java.util.List;

public class NotesListAdapter extends RecyclerView.Adapter<NotesListAdapter.ViewHolder> {

    List<Note> notes;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final NoteItemBinding binding;

        public ViewHolder(NoteItemBinding binding) {
            super(binding.getRoot());
            binding.getRoot().setOnClickListener(view -> {

            });
            this.binding = binding;
        }

        public void bind(Note note){
            binding.tvTitle.setText(note.getTitle());
            binding.tvBody.setText(note.getBody());
        }



    }

    public NotesListAdapter(List<Note> noteList) {
        notes = noteList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NoteItemBinding binding = NoteItemBinding.inflate(LayoutInflater
                .from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.bind(note);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }


}
