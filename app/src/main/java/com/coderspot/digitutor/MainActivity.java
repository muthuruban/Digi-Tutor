package com.coderspot.digitutor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity implements VideoAdapter.OnTrackClickListener {

    private VideoAdapter adapter;
    private RecyclerView recyclerView;
    private int scrollposition;
    private Field[] fields;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleList);
        adapter = new VideoAdapter(this, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                scrollposition = linearLayoutManager.findFirstVisibleItemPosition();
            }
        });
    }

    @Override
    public void onTrackClick(int position) {
        Log.i("Position :", "Position printed");
    }


    public class GetAudioAsyncTest extends AsyncTask<Void, Void, Boolean> {
        private Context context;
        private ProgressDialog progressDialog;

        public GetAudioAsyncTest(Context context) {
            this.context = context;
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            return null;
        }

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Progressing....");
            progressDialog.show();
            super.onPreExecute();
        }

        public void display() {
            adapter = new VideoAdapter(MainActivity.this, MainActivity.this);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            progressDialog.dismiss();
            display();
            super.onPostExecute(aBoolean);
        }
    }

}