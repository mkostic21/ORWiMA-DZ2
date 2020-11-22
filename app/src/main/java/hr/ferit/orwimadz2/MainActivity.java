package hr.ferit.orwimadz2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements NameClickListener{

    private RecyclerAdapter adapter;
    private EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupRecycler();
        initializeUI();
    }

    //Initializes RecyclerView and RecyclerAdapter
    private void setupRecycler() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    //Initializes Bottom Group items and defines OnClick method for ADD button
    private void initializeUI(){
        Button btnAdd = findViewById(R.id.btnAdd);
        etName = findViewById(R.id.etName);

        btnAdd.setOnClickListener(v -> {
            String name = etName.getText().toString();
            if(!name.isEmpty()){ //prevents empty string inputs
                adapter.addNewNameCard(name, adapter.getItemCount());

                //clear EditText successful input
                etName.setText("");
            }
        });
    }

    @Override
    public void onNameClick(int position) {
        adapter.removeNameCard(position);
    }
}