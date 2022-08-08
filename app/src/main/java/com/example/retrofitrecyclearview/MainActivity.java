package com.example.retrofitrecyclearview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.MockView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Movie;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Model.Entry> entrylist;
    RecyclerView recyclerView;
    List<Model.Entry> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        entrylist= new ArrayList<>();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Model> call=apiService.getData();
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                list.addAll(response.body().getEntries());

                RecyclearViewAdapter recyclearViewAdapter = new RecyclearViewAdapter(getApplicationContext(), list);

                recyclerView.setAdapter(recyclearViewAdapter);

            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
Log.d("Log",t.toString());
            }
        });

    }
}