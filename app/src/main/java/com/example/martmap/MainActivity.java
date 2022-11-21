package com.example.martmap;


import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    SearchView searchView;
    ListView listView;

    ArrayList arrayList;
    ArrayAdapter adapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView=findViewById(R.id.search);
        listView=findViewById(R.id.listView);

        arrayList=new ArrayList<>();

        arrayList.add("사과");
        arrayList.add("고등어");
        arrayList.add("삼겹살");
        arrayList.add("신라면");
        arrayList.add("칠성사이다");
        arrayList.add("코카콜라");
        arrayList.add("햇반");
        arrayList.add("두부");
        arrayList.add("당근");

        adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                adapter.getFilter().filter(query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);


                return false;
            }
        });
    }
}