package com.example.socialmediaproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MediaPage extends AppCompatActivity {

    private TextView addPost, logOut;

    private ImageView profile;
    private RecyclerView postRecView;
    private PostAdapter postAdapter;
    private ArrayList<Event> events = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_page);
        addPost = findViewById(R.id.add_post);
        logOut = findViewById(R.id.log_out);
        postRecView = findViewById(R.id.post_recview);

        addPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MediaPage.this, AddActivity.class));
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MediaPage.this, MainActivity.class));
            }
        });

        fetchEvents();

    }

    private void fetchEvents() {
        FirebaseDatabase.getInstance().getReference("post/").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snapshot1 : snapshot.getChildren()){
                    events.add(snapshot1.getValue(Event.class));
                }

                postAdapter = new PostAdapter(MediaPage.this, events);
                postRecView.setLayoutManager(new LinearLayoutManager(MediaPage.this));
                postRecView.setAdapter(postAdapter);
                postAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //do nothing
            }
        });
    }
}