package hr.ferit.orwimadz2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<String> names = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View nameView = LayoutInflater.from(parent.getContext()).inflate(R.layout.name_card, parent, false);
        return new ViewHolder(nameView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setName(names.get(position));
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public void addNames(List<String> names){
        this.names.addAll(names);
        notifyDataSetChanged();
    }
}
