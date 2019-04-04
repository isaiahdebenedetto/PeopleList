package com.example.peoplelist;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PersonAdapter extends BaseAdapter {

    Activity mActivity;
    MyFriends myfriends;

    public PersonAdapter(Activity mActivity, MyFriends myfriends) {
        this.mActivity = mActivity;
        this.myfriends = myfriends;
    }

    @Override
    public int getCount() {
        return myfriends.getMyfriendsList().size();
    }

    @Override
    public Person getItem(int position) {
        return myfriends.getMyfriendsList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View onePersonLine;

        LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        onePersonLine = inflater.inflate(R.layout.person_one_line, parent, false);

        TextView tv_name = onePersonLine.findViewById(R.id.tv_name);
        TextView tv_age = onePersonLine.findViewById(R.id.tv_ageValue);
        ImageView iv_icon = onePersonLine.findViewById(R.id.iv_icon);

        Person p = this.getItem(position);

        tv_name.setText(p.getName());
        tv_age.setText(Integer.toString(p.getAge()));

        int icon_resource_numbers [] = {
                R.drawable.icon1,
                R.drawable.icon2,
                R.drawable.icon3,
                R.drawable.icon4,
                R.drawable.icon5,
                R.drawable.icon6,
                R.drawable.icon7,
                R.drawable.icon8,
                R.drawable.icon9,
                R.drawable.icon10
        };

        iv_icon.setImageResource(icon_resource_numbers[position]);

        return onePersonLine;
    }
}
