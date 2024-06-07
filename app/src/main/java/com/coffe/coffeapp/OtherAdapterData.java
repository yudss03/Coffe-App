package com.coffe.coffeapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OtherAdapterData extends RecyclerView.Adapter<OtherAdapterData.HolderData> {

    private List<OtherProducts> list;

    public OtherAdapterData(List<OtherProducts> list) {
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
        holder.txtTitle.setText(list.get(position).getOtherProductTitle());
        holder.txtPrice.setText(Integer.toString(list.get(position).getOtherProductPrice()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {

        TextView txtTitle, txtPrice;
        public HolderData(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.otherProductTitle);
            txtPrice = itemView.findViewById(R.id.otherProductsPrice);
        }
    }
}


