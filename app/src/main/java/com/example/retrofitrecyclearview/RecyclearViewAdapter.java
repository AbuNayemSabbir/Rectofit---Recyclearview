package com.example.retrofitrecyclearview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclearViewAdapter extends RecyclerView.Adapter<RecyclearViewAdapter.MyviewHolder> {

    Context context;
    List<Model.Entry> entryList;

    public RecyclearViewAdapter(Context context, List<Model.Entry> entryList) {
        this.context = context;
        this.entryList = entryList;
    }

    @Override
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recyclear_view,parent,false);
        return new MyviewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull RecyclearViewAdapter.MyviewHolder holder, int position) {
//holder.tvMovieName.setText(movieList.get(position).getDescription().toString());
        holder.discription.setText(entryList.get(position).getDescription().toString());

    }

    @Override
    public int getItemCount() {
        if(entryList != null){
        return entryList.size();
    }
        return 0;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView discription;
        public MyviewHolder(View itemView) {
            super(itemView);
            discription=itemView.findViewById(R.id.discription);
        }
    }
}
