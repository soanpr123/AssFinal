package com.soanlv.assfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.soanlv.assfinal.adapter.HotelAdapter;
import com.soanlv.assfinal.api.HotelServices;
import com.soanlv.assfinal.model.Hotel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private HotelAdapter hotelAdapter;
    private List<Hotel> arrData;
    private RecyclerView rvMatch;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        textViewResult = findViewById(R.id.text_view_result);
        rvMatch = findViewById(R.id.rv_match);
        arrData = new ArrayList<>();

        hotelAdapter = new HotelAdapter(arrData, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMatch.setLayoutManager(manager);
        rvMatch.setAdapter(hotelAdapter);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.9:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HotelServices hotelServices = retrofit.create(HotelServices.class);

        Call<List<Hotel>> call = hotelServices.getHotel();
        call.enqueue(new Callback<List<Hotel>>() {
            @Override
            public void onResponse(Call<List<Hotel>> call, Response<List<Hotel>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                List<Hotel> posts = response.body();
                hotelAdapter.setData(posts);

//
                for (Hotel post : posts) {
                    String content = "";
                    content += "ID: " + post.get_id() + "\n";


                    Toast.makeText(MainActivity.this, "id:" + content, Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<List<Hotel>> call, Throwable t) {
//                textViewResult.setText(t.getMessage());
                t.printStackTrace();
            }
        });


    }


}
