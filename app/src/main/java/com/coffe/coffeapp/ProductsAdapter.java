package com.coffe.coffeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.HolderData> {

    List<String> ourProductsTitle, ourProductsPrice;
    LayoutInflater inflater;

    public ProductsAdapter(Context context, List<String> ourProductsTitle, List<String> ourProductsPrice) {
        this.ourProductsTitle = ourProductsTitle;
        this.ourProductsPrice = ourProductsPrice;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ProductsAdapter.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.products_layout, parent, false);
        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsAdapter.HolderData holder, int position) {
        holder.txtProductsTitle.setText(ourProductsTitle.get(position));
        holder.txtProductsPrice.setText(ourProductsPrice.get(position));
    }

    @Override
    public int getItemCount() {
        return ourProductsTitle.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView txtProductsTitle;
        TextView txtProductsPrice;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            txtProductsTitle = itemView.findViewById(R.id.ourProductTitle);
            txtProductsPrice = itemView.findViewById(R.id.ourProductsPrice);
        }
    }
}
