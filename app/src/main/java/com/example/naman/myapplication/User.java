package com.example.naman.myapplication;

/**
 * Created by Vikas on 27-01-2017.
 */

public class User {

    String NameAuth;
    String EmailAddress;

    public User() {

    }

    public User(String Name, String Email){
        this.NameAuth = Name;
        this.EmailAddress = Email;
    }

    private String getName(){
        return this.NameAuth;
    }
    public String getemail(){
        return this.EmailAddress;
    }
}
