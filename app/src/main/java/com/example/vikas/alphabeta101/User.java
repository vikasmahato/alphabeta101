package com.example.vikas.alphabeta101;

/**
 * Created by Vikas on 27-01-2017.
 */

public class User {

    String Name;
    String Email;

    public User() {

    }

    public User(String Name, String Email){
        this.Name = Name;
        this.Email = Email;
    }

    public String getName(){
        return this.Name;
    }
    public String getEmail(){
        return this.Email;
    }
}
