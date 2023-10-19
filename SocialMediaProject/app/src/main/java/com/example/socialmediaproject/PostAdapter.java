package com.example.socialmediaproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

    Context context;

    ArrayList<Event> events = new ArrayList<>();

    public PostAdapter(Context context, ArrayList<Event> events) {
        this.context = context;
        this.events = events;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(context).inflate(R.layout.post_holder, parent,false);
        return new PostHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        holder.edtTitle.setText(events.get(position).getTitle());
        holder.edtDescription.setText(events.get(position).getDescription());
    }


    @Override
    public int getItemCount() {
        return events.size();
    }

    class PostHolder extends RecyclerView.ViewHolder{

        private EditText edtTitle, edtDescription;
        public PostHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            edtTitle = itemView.findViewById(R.id.rec_title);
            edtDescription = itemView.findViewById(R.id.rec_description);
        }
    }
}
