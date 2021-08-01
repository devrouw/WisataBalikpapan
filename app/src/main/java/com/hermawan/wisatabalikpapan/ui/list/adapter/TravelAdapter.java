package com.hermawan.wisatabalikpapan.ui.list.adapter;

import android.content.Intent;
import android.os.Parcelable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hermawan.wisatabalikpapan.R;
import com.hermawan.wisatabalikpapan.databinding.RvItemBinding;
import com.hermawan.wisatabalikpapan.model.Travel;
import com.hermawan.wisatabalikpapan.ui.list.DetailActivity;
import com.hermawan.wisatabalikpapan.util.Constant;

import java.util.ArrayList;
import java.util.List;
/*
 *
 * Adapter untuk menampilkan list Travel ke RecyclerView
 *
 * */
public class TravelAdapter extends RecyclerView.Adapter<TravelAdapter.ListViewHolder> {
    private final ArrayList<Travel> listData = new ArrayList<>();
    public static String _type;

    public void setListData(List<Travel> newListData) {
        this.listData.clear();
        this.listData.addAll(newListData);
        notifyDataSetChanged();
    }

    public void setType(String type){
        this._type = type;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TravelAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        return new ListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TravelAdapter.ListViewHolder holder, int position) {
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
        public void bind(Travel data) {
            switch (_type){
                case "Travel":
                case "Accommodation":
                    Glide.with(itemView.getContext())
                            .load(Constant.IMAGE_TRAVEL + data.getGambar())
                            .into(binding.ivImage);
                    break;
                case "Hotel":
                    Glide.with(itemView.getContext())
                            .load(Constant.IMAGE_HOTEL + data.getGambar())
                            .into(binding.ivImage);
                    break;
                case "Food":
                    Glide.with(itemView.getContext())
                            .load(Constant.IMAGE_FOOD + data.getGambar())
                            .into(binding.ivImage);
                    break;
                case "Event":
                    Glide.with(itemView.getContext())
                            .load(Constant.IMAGE_EVENT + data.getGambar())
                            .into(binding.ivImage);
                    break;
            }
            if(_type.equals("Event")){
                binding.tvTitle.setText(Html.fromHtml(data.getJudul()));
            }else{
                binding.tvTitle.setText(Html.fromHtml(data.getNama()));
            }

            binding.tvDesc.setText(Html.fromHtml(data.getDeskripsi()));

            //Fungsi ketika klik data pada list dan ditampilkan ke menu detail
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_TYPE, _type);
                intent.putExtra(DetailActivity.EXTRA_DATA, data);
                itemView.getContext().startActivity(intent);
            });
        }
    }
}
