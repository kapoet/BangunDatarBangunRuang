package com.ervin.bangundatarbangunruang.ui.bangunruang;

import android.app.Activity;
import android.content.Intent;
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

import java.util.List;

public class BangunRuangAdapter extends RecyclerView.Adapter<BangunRuangAdapter.ViewHolder>{

    Activity activity;
    List<Bangun> bangunRuang;

    public BangunRuangAdapter(Activity activity) {
        this.activity = activity;
    }

    public void setbangunRuang(List<Bangun> bangunRuang) {
        this.bangunRuang = bangunRuang;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bangun, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tvBangunName.setText(bangunRuang.get(position).getBangunName());
        String path = "@drawable/" + bangunRuang.get(position).getBnagunPic();
        Glide.with(holder.itemView.getContext())
                .load(activity.getResources().getIdentifier(path, null, activity.getPackageName()))
                .into(holder.ivBangunPic);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, DetailBangunActivity.class);
                intent.putExtra("bangun", bangunRuang.get(position));
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bangunRuang.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvBangunName;
        ImageView ivBangunPic;
        public ViewHolder(@NonNull View view) {
            super(view);
            tvBangunName = view.findViewById(R.id.tv_bangun_Item);
            ivBangunPic = view.findViewById(R.id.iv_bangun_item);
        }
    }
}
