package com.example.testeandroidv2.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testeandroidv2.R;
import com.example.testeandroidv2.adapter.ListAdapter;

public class CurrencyActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);



        //Teste do Adapter e do RecyclerView
        String[] date = new String[10];
        String[] accountType = new String[10];
        String[] price = new String[10];
        ListAdapter listAdapter = new ListAdapter(CurrencyActivity.this, date, accountType, price);
        RecyclerView rv = findViewById(R.id.recycle_main);
        rv.setAdapter(listAdapter);
    }
}