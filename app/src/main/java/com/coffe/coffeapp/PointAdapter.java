package com.coffe.coffeapp;

import android.graphics.Point;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PointAdapter extends RecyclerView.Adapter<PointAdapter.HolderData> {

    List<PointProductModel> list;

    public PointAdapter(List<PointProductModel> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public PointAdapter.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_point_layout, parent, false);
        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PointAdapter.HolderData holder, int position) {
        holder.txtTitle.setText(list.get(position).getProductTitle());
        holder.txtPoint.setText(Integer.toString(list.get(position).getProductPoint()) + " " + "Points");
        Picasso.get()
                .load(list.get(position).getProductImg())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HolderData extends  RecyclerView.ViewHolder {

        TextView txtTitle, txtPoint;
        ImageView img;
        public HolderData(@NonNull View itemView) {
            super(itemView);

            this.txtTitle = itemView.findViewById(R.id.productTitlefromPoint);
            this.txtPoint = itemView.findViewById(R.id.productPointfromPoint);
            this.img = itemView.findViewById(R.id.card_image_point);

        }
    }
}
