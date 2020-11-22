package hr.ferit.orwimadz2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final List<String> names = new ArrayList<>();
    private final NameClickListener clickListener;

    public RecyclerAdapter(NameClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View nameView = LayoutInflater.from(parent.getContext()).inflate(R.layout.name_card, parent, false);
        return new ViewHolder(nameView, clickListener);
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

    public void addNewNameCard(String name, int position){
        if(names.size()>=position){
            names.add(position, name);
            notifyItemInserted(position);
        }
    }

    public void removeNameCard(int position){
        if(names.size()>position){
            names.remove(position);
            notifyItemRemoved(position);
        }
    }
}
