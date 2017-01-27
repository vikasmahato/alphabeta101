package com.example.vikas.alphabeta101;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vikas on 27-01-2017.
 */

public class Question {

    public String uid;
    public String author;
    public String title;
    public String body;

    public Question() {

    }

    public Question(String uid, String author, String title, String body) {
        this.uid = uid;
        this.author = author;
        this.title = title;
        this.body = body;
    }
    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("author", author);
        result.put("title", title);
        result.put("body", body);

        return result;
    }

}
