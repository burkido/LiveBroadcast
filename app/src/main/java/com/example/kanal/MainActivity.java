package com.example.kanal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.SearchView;

import com.example.kanal.adapter.ChanelAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Chanel> chanelArrayList;
    RecyclerView recyclerView;
    ChanelAdapter chanelAdapter;
    private ChanelAdapter.OnChannelListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.channels_recycler_view);
        recyclerView.setHasFixedSize(true);

        setOnClickListener();
        setChannelInfo();

        chanelAdapter = new ChanelAdapter(MainActivity.this,Chanel.getData(),listener);
        recyclerView.setAdapter(chanelAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);


    }

    private void setOnClickListener() {
        listener = new ChanelAdapter.OnChannelListener(){

            @Override
            public void onClick(View v, int position) {

                Intent intent = new Intent(getApplicationContext(),WebPage.class);
                intent.putExtra("link",chanelArrayList.get(position).getLinkName());
                startActivity(intent);
            }
        };
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.search_bar);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                chanelAdapter.getFilter().filter(newText);
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

    private  void setChannelInfo(){
        chanelArrayList = new ArrayList<>();

        for(int i=0;i<6;i++){

            chanelArrayList.add(new Chanel("Kanal D", R.drawable.kanal_d,"https://www.kanald.com.tr/canli-yayin"));
            chanelArrayList.add(new Chanel("Show TV", R.drawable.show_tv,"https://www.showtv.com.tr/canli-yayin/"));
            chanelArrayList.add(new Chanel("Atv", R.drawable.atv,"https://www.atv.com.tr/webtv/canli-yayin"));
            chanelArrayList.add(new Chanel("FOX", R.drawable.fox, "https://www.fox.com.tr/canli-yayin"));
            chanelArrayList.add(new Chanel("Star", R.drawable.star_tv,"https://www.startv.com.tr/canli-yayin"));
            chanelArrayList.add(new Chanel("Tv8", R.drawable.tv8,"https://www.startv.com.tr/canli-yayin"));
            chanelArrayList.add(new Chanel("NBA", R.drawable.nba,"http://nbastreams.xyz/schedules/"));

        }

        }
}