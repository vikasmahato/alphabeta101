package com.example.naman.myapplication;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class Discussion extends AppCompatActivity {
    DatabaseReference databaseReference;
    private ProgressBar mProgressBar;
    private DatabaseReference mDatabase;
    private FirebaseRecyclerAdapter<Question, QuestionViewHolder> mAdapter;
    private RecyclerView mRecycler;
    private LinearLayoutManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussion);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Discussion.this, Discussion.class));

            }
        });
        mDatabase = FirebaseDatabase.getInstance().getReference();
        Query recentPostsQuery = mDatabase.child("questions")
                .limitToFirst(1000);

        mRecycler = (RecyclerView) findViewById(R.id.messages_list);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        mManager = new LinearLayoutManager(this);
        mManager.setReverseLayout(true);
        mManager.setStackFromEnd(true);
        mRecycler.setLayoutManager(mManager);
        mRecycler.setHasFixedSize(true);

        mAdapter = new FirebaseRecyclerAdapter<Question, QuestionViewHolder>(Question.class, R.layout.item_post,
                QuestionViewHolder.class, recentPostsQuery) {
            @Override
            protected void populateViewHolder(final QuestionViewHolder viewHolder, final Question model, final int position) {

                mProgressBar.setVisibility(ProgressBar.INVISIBLE);

                final DatabaseReference postRef = getRef(position);

                final String postKey = postRef.getKey();
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(Discussion.this, PostDetailActivity.class);
                        intent.putExtra(PostDetailActivity.EXTRA_POST_KEY, postKey);
                        Toast.makeText(Discussion.this, postKey, Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                });

                viewHolder.bindToPost(model);


            }
        };
        mRecycler.setAdapter(mAdapter);

    }
}
