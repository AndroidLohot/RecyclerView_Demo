package com.example.recyclerviewdemo.CostumeAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewdemo.CostumeClasses.PersonClass;
import com.example.recyclerviewdemo.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<PersonClass> perList;
    private MyRecyclerViewEvent myEvent;

    public MyAdapter(Context context, ArrayList<PersonClass> perList) {
        this.perList = perList;
        this.myEvent=(MyRecyclerViewEvent)context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_recycler_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        PersonClass person = perList.get(position);

        holder.itemView.setTag(perList.get(position));

        holder.tvName.setText(person.getPersonName());
        holder.tvAge.setText(person.getPersonAge());


    }

    @Override
    public int getItemCount() {
        return perList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName, tvAge;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName=itemView.findViewById(R.id.tvName);
            tvAge=itemView.findViewById(R.id.tvAge);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myEvent.setOnItemSelectListener(perList.indexOf((PersonClass)view.getTag()));
                }
            });
        }
    }

    public interface MyRecyclerViewEvent{
        void setOnItemSelectListener(int position);
    }
}
