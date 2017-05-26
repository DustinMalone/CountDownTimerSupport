package com.dyhdyh.support.countdowntimer.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * author  dengyuhan
 * created 2017/5/25 21:18
 */
public class DownTimerListActivity extends AppCompatActivity {
    RecyclerView rv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_list);
        rv = (RecyclerView) findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new DownTimerAdapter(testData()));
    }

    private List<DownTimerEntity> testData() {
        List<DownTimerEntity> entities=new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            entities.add(new DownTimerEntity(random.nextInt(100000)+10000,1000));
        }
        return entities;
    }

}
