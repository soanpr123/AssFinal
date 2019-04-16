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
import com.soanlv.assfinal.ChiTietPhong;
import com.soanlv.assfinal.ClickListener;
import com.soanlv.assfinal.R;
import com.soanlv.assfinal.Room;
import com.soanlv.assfinal.model.Hotel;
import com.soanlv.assfinal.model.RoomMD;

import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.ViewHolder>{
    private List<RoomMD> roomMDS;
    private Context context;


    public RoomAdapter(List<RoomMD> roomMDS, Context context) {
        this.roomMDS = roomMDS;
        this.context = context;
    }

    @NonNull
    @Override
    public RoomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_room, viewGroup, false);
        return new RoomAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RoomAdapter.ViewHolder viewHolder, final int i) {
        final RoomMD roomMD = roomMDS.get(i);
        viewHolder.tv_name.setText("Phòng số : " +roomMD.getRoom_number());
        Glide.with(context).load(roomMD.getImage()).into(viewHolder.img_hotel);
        viewHolder.setOnclick(new ClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (isLongClick) {
                    Toast.makeText(context, "uh", Toast.LENGTH_SHORT).show();

                } else {
                    String romnumber=roomMD.getRoom_number();
                    String floor=roomMD.getFloor();
                    String single=roomMD.getSingle_room();
                    String price=roomMD.getPrice();
                    String detal=roomMD.getDetail();
                    String status=roomMD.getStatus();
                    Intent intent =new Intent(context, ChiTietPhong.class);
                    Bundle bundle=new Bundle();
                    bundle.putString("number",romnumber);
                    bundle.putString("flor",floor);
                    bundle.putString("single",single);
                    bundle.putString("price",price);
                    bundle.putString("detail",detal);
                    bundle.putString("status",status);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                    Toast.makeText(context, "ok", Toast.LENGTH_SHORT).show();


                }


            }

        });
    }

    @Override
    public int getItemCount() {
        return roomMDS.size();
    }

    public void setData(List<RoomMD> data) {
        this.roomMDS = data;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {
        ImageView img_hotel;
        LinearLayout layout;
        TextView tv_name;
        ClickListener clickListener;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_hotel = itemView.findViewById(R.id.img_image);
            tv_name = itemView.findViewById(R.id.tv_number);
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
