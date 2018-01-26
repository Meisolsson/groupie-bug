package com.meisolsson.test;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.xwray.groupie.GroupAdapter;
import com.xwray.groupie.Item;
import com.xwray.groupie.OnItemClickListener;
import com.xwray.groupie.Section;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Section section;
    private GroupAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        adapter = new GroupAdapter();
        section = new Section();

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull Item item, @NonNull View view) {
                if (adapter.getAdapterPosition(item) == -1) {
                    Toast.makeText(MainActivity.this, "Problem", Toast.LENGTH_SHORT).show();
                } else {
                    addSameItems();
                }
            }
        });
        adapter.add(section);

        RecyclerView recyclerView = findViewById(android.R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        addSameItems();
    }

    private void addSameItems() {
        List<BasicItem> items = new ArrayList<>();
        items.add(new BasicItem(1, "Test!"));

        section.update(items);
    }
}