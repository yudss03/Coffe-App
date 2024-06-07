package com.coffe.coffeapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PointAdapter extends RecyclerView.Adapter<PointAdapter.HolderData> {

    private List<PointModel> listProduct;

    public PointAdapter(List<PointModel> listProduct){
        this.listProduct=listProduct;
    }
    @NonNull
    @Override
    public PointAdapter.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_card_view,parent,false);
        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PointAdapter.HolderData holder, int position) {
        holder.txtTitle.setText(listProduct.get(position).getProductTitle());
        holder.txtPoint.setText(listProduct.get(position).getProductPoint());
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView txtTitle;
        TextView txtPoint;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.productTitle);
            txtPoint = itemView.findViewById(R.id.productPoint);
        }
    }
}
