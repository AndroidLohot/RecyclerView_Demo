package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.recyclerviewdemo.CostumeAdapter.MyAdapter;
import com.example.recyclerviewdemo.CostumeClasses.PersonClass;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyAdapter.MyRecyclerViewEvent {

    private RecyclerView rvList;
    private ArrayList<PersonClass> personList = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvList = findViewById(R.id.rvList);

        personList.add(new PersonClass("Yogesh", "38"));
        personList.add(new PersonClass("Vikram", "30"));

        myAdapter = new MyAdapter(this, personList);

        rvList.setLayoutManager(new LinearLayoutManager(this));

        rvList.setAdapter(myAdapter);
    }

    @Override
    public void setOnItemSelectListener(int position) {
        PersonClass perClass = personList.get(position);

        Toast.makeText(this, "Name : " + perClass.getPersonName() + "\n" + "Age : " + perClass.getPersonAge(), Toast.LENGTH_SHORT).show();
    }
}