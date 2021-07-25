package com.hermawan.wisatabalikpapan.ui.list.adapter;

import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hermawan.wisatabalikpapan.R;
import com.hermawan.wisatabalikpapan.data.entity.Food;
import com.hermawan.wisatabalikpapan.databinding.RvItemBinding;
import com.hermawan.wisatabalikpapan.ui.list.DetailActivity;

import java.util.ArrayList;
import java.util.List;
/*
 *
 * Adapter untuk menampilkan list Food ke RecyclerView
 *
 * */
public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ListViewHolder> {
    private final ArrayList<Food> listData = new ArrayList<>();

    public void setListData(List<Food> newListData) {
        this.listData.clear();
        this.listData.addAll(newListData);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FoodAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        return new ListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.ListViewHolder holder, int position) {
        holder.bind(listData.get(position));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    static class ListViewHolder extends RecyclerView.ViewHolder {
        RvItemBinding binding = RvItemBinding.bind(itemView);

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        //Fungsi untuk menampilkan setiap data ke list
        public void bind(Food data) {
            Glide.with(itemView.getContext())
                    .load(itemView.getContext().getResources().getIdentifier(data.getImageFood(), "drawable", itemView.getContext().getPackageName()))
                    .into(binding.ivImage);
            binding.tvTitle.setText(data.getTitleFood());
            binding.tvDesc.setText(data.getDescFood());

            //Fungsi ketika data di klik dan ditampilkan ke menu detail
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_TYPE, "Food");
                intent.putExtra(DetailActivity.EXTRA_DATA, data);
                itemView.getContext().startActivity(intent);
            });
        }
    }
}
