package com.example.naman.myapplication;

/**
 * Created by Vikas on 27-01-2017.
 */

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class QuestionViewHolder extends RecyclerView.ViewHolder {

    public TextView titleView;
    public TextView authorView;
    public TextView bodyView;


    public QuestionViewHolder(View itemView) {
        super(itemView);


        titleView = (TextView) itemView.findViewById(R.id.post_title);
        authorView = (TextView) itemView.findViewById(R.id.post_author);
        bodyView = (TextView) itemView.findViewById(R.id.post_body);
    }

    public void bindToPost(Question post) {
        titleView.setText(post.title);
        authorView.setText(post.author);
        bodyView.setText(post.body);
        bodyView.setMaxLines(6);
        bodyView.setEllipsize(TextUtils.TruncateAt.END);
    }
}
