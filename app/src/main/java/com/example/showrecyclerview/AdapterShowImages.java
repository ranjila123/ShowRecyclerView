package com.example.showrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.time.Instant;
import java.util.ArrayList;

public class AdapterShowImages extends RecyclerView.Adapter<MyViewHolder> {   //alt+enter to implement
    private Context context;
    private ArrayList<String> arrayList;

    public AdapterShowImages(Context context,ArrayList<String> arrayList) {   // fun+alt+ins
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.img_res,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context)
                .load(arrayList.get(position))
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public void updateList(String imagePath){
        arrayList.add(imagePath);
        notifyDataSetChanged();
    }

}

class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imgAdapter);
    }


}