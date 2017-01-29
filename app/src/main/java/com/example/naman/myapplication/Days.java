package com.example.naman.myapplication;

/**
 * Created by Vishal on 27-Jan-17.
 */
public class Days {

    private int _id;
    private  int _work,_perf;

    public Days(int work,int perf){

        this._perf = perf;
        this._work = work;

    }

    public void set_id(int _id){
        this._id = _id;
    }

    public int get_id(){
        return _id;
    }
    public int get_performance(){
        return _perf;
    }
    public int get_workout(){
        return _work;
    }

}
