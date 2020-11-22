package hr.ferit.orwimadz2;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private final TextView tvName;
    private final NameClickListener clickListener;

    public ViewHolder(@NonNull View itemView, NameClickListener clickListener) {
        super(itemView);
        this.clickListener = clickListener;

        ImageButton btnDelete = itemView.findViewById(R.id.btnDelete);
        tvName = itemView.findViewById(R.id.tvName);
        btnDelete.setOnClickListener(this);
    }

    //passed string --> TextView
    public void setName(String name){
        tvName.setText(name);
    }

    @Override
    public void onClick(View v) {
        clickListener.onNameClick(getAdapterPosition());
    }
}
