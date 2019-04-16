package com.soanlv.assfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.soanlv.assfinal.adapter.HotelAdapter;
import com.soanlv.assfinal.adapter.RoomAdapter;
import com.soanlv.assfinal.api.HotelServices;
import com.soanlv.assfinal.api.RoomServices;
import com.soanlv.assfinal.model.Hotel;
import com.soanlv.assfinal.model.RoomMD;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Room extends AppCompatActivity {
    private TextView textViewResult;
    private RoomAdapter roomAdapter;
    private List<RoomMD> arrData;
    private RecyclerView rvRooom;
    private TextView tv_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        rvRooom = findViewById(R.id.rv_room);
        tv_name = findViewById(R.id.tv_name_khachsan);
//        textViewResult = findViewById(R.id.text_view_result);
        arrData = new ArrayList<>();

        roomAdapter = new RoomAdapter(arrData, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvRooom.setLayoutManager(manager);
        rvRooom.setAdapter(roomAdapter);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.9:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RoomServices roomServices = retrofit.create(RoomServices.class);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("name", "");
        final String idht = bundle.getString("id", "");
//            textViewResult.setText("Code: " + idht);
        tv_name.setText("Khách sạn : " + name);


        Call<List<RoomMD>> call = roomServices.getRoom();
        call.enqueue(new Callback<List<RoomMD>>() {
            @Override
            public void onResponse(Call<List<RoomMD>> call, Response<List<RoomMD>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<RoomMD> posts = response.body();
                for (int i = 0; i < posts.size(); i++) {
                    RoomMD roomMD = posts.get(i);
                    String hotelid = roomMD.getHotelid();
                    if (idht.equals(hotelid)) {
                        String room_number = roomMD.getRoom_number();
                        String status = roomMD.getStatus();
                        String detal = roomMD.getDetail();
                        String Hotelid = roomMD.getHotelid();
                        String single_room = roomMD.getSingle_room();
                        String price = roomMD.getPrice();
                        String image = roomMD.getImage();
                        String Floor = roomMD.getFloor();
                        String id = roomMD.get_id();
                        roomMD = new RoomMD();
                        roomMD.set_id(id);
                        roomMD.setDetail(detal);
                        roomMD.setFloor(Floor);
                        roomMD.setHotelid(Hotelid);
                        roomMD.setImage(image);
                        roomMD.setPrice(price);
                        roomMD.setSingle_room(single_room);
                        roomMD.setRoom_number(room_number);
                        roomMD.setStatus(status);
                        arrData.add(roomMD);
                        roomAdapter.setData(arrData);
                    }

                }
            }

            @Override
            public void onFailure(Call<List<RoomMD>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}
