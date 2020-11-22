package hr.ferit.orwimadz2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NameClickListener{

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private Button btnAdd;
    private EditText etName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupRecycler();
        initializeUI();
    }

    private void setupRecycler() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter(this);
        recyclerView.setAdapter(adapter);

        List<String> names = new ArrayList<>();
    }

    private void initializeUI(){
        btnAdd = findViewById(R.id.btnAdd);
        etName = findViewById(R.id.etName);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                if(!name.isEmpty()){
                    adapter.addNewNameCard(name, adapter.getItemCount());

                    etName.setText("");
                }
            }
        });

    }

    @Override
    public void onNameClick(int position) {
        adapter.removeNameCard(position);
    }
}