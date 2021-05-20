package com.example.foodrescuemobileapp4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class myListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);
        Spinner mySpinner1 = findViewById(R.id.mySpinner1);
        RecyclerView foodRecyclerView1 = findViewById(R.id.foodRecyclerView1);
        ImageButton addButton1 = findViewById(R.id.addButton1);
        com.example.foodrescuemobileapp4.foodAdapter foodadapter;
        List<com.example.foodrescuemobileapp4.Food> foodList = new ArrayList<>();

        String[] menu ={"Home","Account","My list"};
        Integer[] myfoodImageList = {R.drawable.grape, R.drawable.leaf, R.drawable.strawberry, R.drawable.tomato};
        String[] mytitleList = {"grape","leaf","strawberry","tomato"};

        ArrayAdapter<String> menuAdapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu);
        mySpinner1.setAdapter(menuAdapter);

        foodadapter = new com.example.foodrescuemobileapp4.foodAdapter(foodList,this);
        foodRecyclerView1.setAdapter(foodadapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        foodRecyclerView1.setLayoutManager(layoutManager);

        for(int i=0;i<myfoodImageList.length;i++)
        {
            com.example.foodrescuemobileapp4.Food food = new com.example.foodrescuemobileapp4.Food(i,myfoodImageList[i],mytitleList[i]);
            foodList.add(food);
        }

        mySpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String choice = menu[position];
                if(choice == "Account")
                {
                    Intent aIntent = new Intent(myListActivity.this, MainActivity.class);
                    startActivity(aIntent);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        addButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addIntent = new Intent(myListActivity.this, com.example.foodrescuemobileapp4.addAcitivity.class);
                startActivity(addIntent);
            }
        });

    }
}