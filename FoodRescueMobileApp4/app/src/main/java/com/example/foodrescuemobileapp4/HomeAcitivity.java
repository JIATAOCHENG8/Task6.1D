package com.example.foodrescuemobileapp4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class HomeAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home_activity);
        Spinner mySpinner = findViewById(R.id.mySpinner);
        RecyclerView foodRecyclerView = findViewById(R.id.foodRecyclerView1);
        ImageButton addButton = findViewById(R.id.addButton);
        foodAdapter foodadapter;
        List<Food> foodList = new ArrayList<>();

        String[] menu ={"Home","Account","My list"};
        Integer[] foodImageList ={R.drawable.apple, R.drawable.banana, R.drawable.orange, R.drawable.watermelon};
        String[] titleList = {"Apple", "Banana", "Orange", "Watermelon"};

        ArrayAdapter<String> menuAdapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu);
        mySpinner.setAdapter(menuAdapter);

        foodadapter = new foodAdapter(foodList,this);
        foodRecyclerView.setAdapter(foodadapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        foodRecyclerView.setLayoutManager(layoutManager);

        for(int i=0;i<foodImageList.length;i++)
        {
            Food food = new Food(i,foodImageList[i],titleList[i]);
            foodList.add(food);
        }

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String choice = menu[position];
                if(choice == "Account")
                {
                    Intent aIntent = new Intent(HomeAcitivity.this,MainActivity.class);
                    startActivity(aIntent);
                }
                if(choice == "My list")
                {
                    Intent mIntent = new Intent(HomeAcitivity.this,myListActivity.class);
                    startActivity(mIntent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addIntent = new Intent(HomeAcitivity.this,addAcitivity.class);
                startActivity(addIntent);
            }
        });

    }
}