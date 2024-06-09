package com.coffe.coffeapp;

import android.content.Context;
import android.view.ContextThemeWrapper;
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

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    private List<ProductModel> listProduct;

    public AdapterData(List<ProductModel> listProduct) {
        this.listProduct = listProduct;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_card_view, parent, false);
        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        holder.txtTitle.setText(listProduct.get(position).getProductTitle());
        holder.txtPrice.setText(Integer.toString(listProduct.get(position).getProductPrice()));
        Picasso.get().invalidate(listProduct.get(position).getProductImg());
        Picasso.get()
                .load(listProduct.get(position).getProductImg())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }


    public class HolderData extends RecyclerView.ViewHolder {
        TextView txtTitle, txtPrice;
        ImageView img;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.productTitle);
            txtPrice = itemView.findViewById(R.id.productPrice);
            img = itemView.findViewById(R.id.card_image);
        }
    }
}

