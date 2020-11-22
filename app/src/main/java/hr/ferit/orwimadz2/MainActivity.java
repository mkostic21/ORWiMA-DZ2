package hr.ferit.orwimadz2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnAdd;
    private EditText etName;
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupRecycler();
        setupRecyclerData();
    }

    private void setupRecycler() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void setupRecyclerData() {
        List<String> names = new ArrayList<>();
        names.add("Ezio");
        names.add("Conor");
        names.add("Eivor");

        adapter.addNames(names);
    }

}