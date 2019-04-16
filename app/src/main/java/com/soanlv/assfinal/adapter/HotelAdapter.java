package com.soanlv.assfinal.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.soanlv.assfinal.ClickListener;
import com.soanlv.assfinal.R;
import com.soanlv.assfinal.Room;
import com.soanlv.assfinal.model.Hotel;
import com.soanlv.assfinal.model.RoomMD;

import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder> {
    private List<Hotel> hotels;
    private Context context;
    private List<RoomMD> arrrooms;


    public HotelAdapter(List<Hotel> hotels, Context context) {
        this.hotels = hotels;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        final Hotel lichThiDau = hotels.get(i);
        viewHolder.tv_name.setText("Tên Khách sạn : " + lichThiDau.getName());
        viewHolder.tv_address.setText("Địa Chỉ : " + lichThiDau.getAddress());
        viewHolder.tv_total_floor.setText("Số Tầng : " + lichThiDau.getTotal_floor());
        viewHolder.tv_owner.setText("Chủ Sở Hữu : " + lichThiDau.getOwner());
        viewHolder.tv_city.setText("Thành Phố : " + lichThiDau.getCity());
        viewHolder.tv_license_number.setText("Số Giấy Phép : " + lichThiDau.getLicense_number());
        Glide.with(context).load(lichThiDau.getImage()).into(viewHolder.img_hotel);
        viewHolder.setOnclick(new ClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (isLongClick) {
                    Toast.makeText(context, "uh", Toast.LENGTH_SHORT).show();

                } else {

                    String idHt = lichThiDau.get_id();
                    String name = lichThiDau.getName();
                    Intent intent = new Intent(context, Room.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("id", idHt);
                    bundle.putString("name",name );
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                    Toast.makeText(context, "" + idHt, Toast.LENGTH_SHORT).show();


                }


            }

        });
    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    public void setData(List<Hotel> data) {
        this.hotels = data;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {
        ImageView img_hotel;
        LinearLayout layout;
        TextView tv_name, tv_license_number, tv_total_floor, tv_city, tv_address, tv_owner;
        ClickListener clickListener;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_hotel = itemView.findViewById(R.id.img_image);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_address = itemView.findViewById(R.id.tv_address);
            tv_city = itemView.findViewById(R.id.tv_city);
            tv_license_number = itemView.findViewById(R.id.tv_license_number);
            tv_owner = itemView.findViewById(R.id.tv_owner);
            tv_total_floor = itemView.findViewById(R.id.tv_total_floor);
            layout = itemView.findViewById(R.id.ln_item);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setOnclick(ClickListener clickListener) {
            this.clickListener = clickListener;
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onClick(v, getAdapterPosition(), true);
            return true;
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getAdapterPosition(), false);
        }
    }
}
