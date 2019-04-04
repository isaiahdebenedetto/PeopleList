package com.example.peoplelist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    Button btn_add, btn_abc, btn_age;

    ListView lv_friendsList;

    PersonAdapter adapter;

    MyFriends myFriends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.btn_add);
        btn_abc = findViewById(R.id.btn_abc);
        btn_age = findViewById(R.id.btn_Age);
        lv_friendsList = findViewById(R.id.lv_listofnames);

        myFriends = ((MyApplication) this.getApplication()).getMyFriends();

        adapter = new PersonAdapter(MainActivity.this, myFriends);
        lv_friendsList.setAdapter(adapter);

        // listen for incoming messages
        Bundle incomingMessages = getIntent().getExtras();

        if (incomingMessages != null) {
            String name = incomingMessages.getString("name");
            int age = Integer.parseInt( incomingMessages.getString("age"));
            int pictureNumber = Integer.parseInt(incomingMessages.getString("pictureNumber"));
            int positionEdited = incomingMessages.getInt("edit");

            // create new persons object

            Person p = new Person(name, age, pictureNumber);

            //add person to the list and update adapter

            if(positionEdited > -1) {
                myFriends.getMyfriendsList().remove(positionEdited);
            }
            myFriends.getMyfriendsList().add(p);

            adapter.notifyDataSetChanged();

        }

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toNewPerson = new Intent( v.getContext(), NewPersonForm.class );
                startActivity(toNewPerson);
            }
        });

        btn_age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(myFriends.getMyfriendsList(), new Comparator<Person>() {
                    @Override
                    public int compare(Person p1, Person p2) {
                        return p1.getAge() - p2.getAge();
                    }
                });

                adapter.notifyDataSetChanged();
            }
        });

        btn_abc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(myFriends.getMyfriendsList());
                adapter.notifyDataSetChanged();
            }
        });

        lv_friendsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                editPerson(position);
            }
        });
    }

    public void editPerson(int position) {
        Intent i = new Intent(getApplicationContext(), NewPersonForm.class);

        Person p = myFriends.getMyfriendsList().get(position);

        i.putExtra("edit", position);
        i.putExtra("name", p.getName());
        i.putExtra("age", p.getAge());
        i.putExtra("pictureNumnber", p.getPictureNumber());

        startActivity(i);
    }
}
