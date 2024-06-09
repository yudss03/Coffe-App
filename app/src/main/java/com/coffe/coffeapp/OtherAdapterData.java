package com.coffe.coffeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class OtherAdapterData extends RecyclerView.Adapter<OtherAdapterData.HolderData> {

    private List<OtherProductsModel> list;

    public OtherAdapterData(List<OtherProductsModel> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public OtherAdapterData.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.products_layout, parent, false);
        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OtherAdapterData.HolderData holder, int position) {
        holder.txtTitle.setText(list.get(position).getProductTitle());
        holder.txtPrice.setText(Integer.toString(list.get(position).getProductPrice()));
        Picasso.get().invalidate(list.get(position).getProductImg());
        Picasso.get()
                .load(list.get(position).getProductImg())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {

        TextView txtTitle, txtPrice;
        ImageView img;
        public HolderData(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.otherProductTitle);
            txtPrice = itemView.findViewById(R.id.otherProductsPrice);
            img = itemView.findViewById(R.id.card_image);
        }
    }
}


