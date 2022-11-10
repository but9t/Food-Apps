package com.example.food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    TextView welcome;
    RecyclerView daftarmenu;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<DaftarMenu> listMenu;

    void dataDummy(){
        listMenu = new ArrayList<>();
        listMenu.add(new DaftarMenu(R.drawable.menu1,"Mie Ayam", "Mie dengan ayam tiren terbaru"));
        listMenu.add(new DaftarMenu(R.drawable.menu2,"Burger", "Burger dengan daging babi BBQ"));
        listMenu.add(new DaftarMenu(R.drawable.menu3,"Pizza Hot", "Pizza Panas dengan berbagai toping"));
        listMenu.add(new DaftarMenu(R.drawable.menu4,"Hot Dick", "Hot Dick dengan mayonaise putih"));
    }
    void data(){
        daftarmenu = findViewById(R.id.list);
        adapter = new Adapter(this, listMenu);
        layoutManager = new LinearLayoutManager(this);
        daftarmenu.setLayoutManager(layoutManager);
        daftarmenu.setAdapter(adapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        welcome = findViewById(R.id.welcome);
        dataDummy();data();
        Bundle data = getIntent().getExtras();
        if (data == null){
            return;
        }
        String user = data.getString("Username");
        welcome.setText("Halo, " +user);
    }
}