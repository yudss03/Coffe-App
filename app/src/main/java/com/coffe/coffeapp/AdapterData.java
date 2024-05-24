package com.coffe.coffeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coffe.coffeapp.model.DataProducts;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    ArrayList<DataProducts> list;
    List<String> productTitle, productPrice;
    LayoutInflater inflater;

    public AdapterData(Context context, List<String> productTitle, List<String> productPrice) {
        this.productTitle = productTitle;
        this.productPrice = productPrice;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.product_card_view, parent, false);
        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        holder.txtTitle.setText(productTitle.get(position));
        holder.txtPrice.setText(productPrice.get(position));
    }

    @Override
    public int getItemCount() {
        return productTitle.size();
    }


    public class HolderData extends RecyclerView.ViewHolder {
        TextView txtTitle;
        TextView txtPrice;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.productTitle);
            txtPrice = itemView.findViewById(R.id.productPrice);
        }
    }
}

