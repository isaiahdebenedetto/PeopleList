package com.example.peoplelist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyFriends {

    List<Person> myfriendsList;

    public MyFriends(List<Person> myfriendsList) {
        this.myfriendsList = myfriendsList;
    }

    public MyFriends() {
        String[] startingNames = { "Isaiah", "Elijah", "Jacob" };
        this.myfriendsList = new ArrayList<>();
        Random rng = new Random();
        for (int i = 0; i<startingNames.length; i++){
            Person p = new Person(startingNames[i], rng.nextInt(50) + 15, rng.nextInt(10));
            myfriendsList.add(p);
        }
    }

    public List<Person> getMyfriendsList() {
        return myfriendsList;
    }

    public void setMyfriendsList(List<Person> myfriendsList) {
        this.myfriendsList = myfriendsList;
    }
}
