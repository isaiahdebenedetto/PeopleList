package com.example.peoplelist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewPersonForm extends AppCompatActivity {

    Button btn_ok, btn_cancel;
    EditText et_name, et_age, et_pictureNumber;

    int positionToEdit = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_person_form);

        btn_ok = findViewById(R.id.btn_ok);
        btn_cancel = findViewById(R.id.btn_cancel);

        et_age = findViewById(R.id.et_age);
        et_name = findViewById(R.id.et_name);
        et_pictureNumber = findViewById(R.id.et_pictureNumber);

        Bundle incomingIntent = getIntent().getExtras();

        if (incomingIntent != null) {
            String name = incomingIntent.getString("name");
            int age = incomingIntent.getInt("age");
            int pictureNumber = incomingIntent.getInt("pictureNumber");
            positionToEdit = incomingIntent.getInt("edit");

            // fill in the form
            et_name.setText(name);
            et_age.setText(Integer.toString(age));
            et_pictureNumber.setText(Integer.toString(pictureNumber));


        }

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get strngs from et_ view objects
                String newName = et_name.getText().toString();
                String newAge = et_age.getText().toString();
                String newPictureNumber = et_pictureNumber.getText().toString();

                // put the strings into a message for MainActivity

                // start MainActivity again

                Intent toMain = new Intent( v.getContext(), MainActivity.class );

                toMain.putExtra("edit", positionToEdit);
                toMain.putExtra("name", newName);
                toMain.putExtra("age", newAge);
                toMain.putExtra("pictureNumber", newPictureNumber);

                startActivity(toMain);
            }
        });
    }
}
