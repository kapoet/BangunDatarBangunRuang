package com.ervin.bangundatarbangunruang.ui.bangundatar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ervin.bangundatarbangunruang.R;
import com.ervin.bangundatarbangunruang.data.Bangun;
import com.ervin.bangundatarbangunruang.ui.detailbangun.DetailBangunActivity;

import java.util.ArrayList;
import java.util.List;

public class BangunDatarAdapter extends RecyclerView.Adapter<BangunDatarAdapter.ViewHolder>{

    Activity activity;
    List<Bangun> bangunDatar;

    public BangunDatarAdapter(Activity activity) {
        this.activity = activity;
    }

    public void setBangunDatar(List<Bangun> bangunDatar) {
        this.bangunDatar = bangunDatar;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bangun, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tvBangunName.setText(bangunDatar.get(position).getBangunName());
        String path = "@drawable/" + bangunDatar.get(position).getBnagunPic();
        Glide.with(holder.itemView.getContext())
                .load(activity.getResources().getIdentifier(path, null, activity.getPackageName()))
                .into(holder.ivBangunPic);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, DetailBangunActivity.class);
                intent.putExtra("bangun", bangunDatar.get(position));
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bangunDatar.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvBangunName;
        ImageView ivBangunPic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBangunName = itemView.findViewById(R.id.tv_bangun_Item);
            ivBangunPic = itemView.findViewById(R.id.iv_bangun_item);
        }
    }
}
