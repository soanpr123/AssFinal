package com.soanlv.assfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ChiTietPhong extends AppCompatActivity {
private TextView tv_number,tv_Flor,tv_singer,tv_price,tv_detal,tv_status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_phong);
        tv_number=findViewById(R.id.room_number);
        tv_Flor=findViewById(R.id.tv_floor);
        tv_singer=findViewById(R.id.tv_single_room);
        tv_price=findViewById(R.id.tv_price);
        tv_detal=findViewById(R.id.tv_detal);
        tv_status=findViewById(R.id.tv_status);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
         String number = bundle.getString("number", "");
         String flor = bundle.getString("flor", "");
         String single = bundle.getString("single", "");
         String price = bundle.getString("price", "");
         String detail = bundle.getString("detail", "");
         String status = bundle.getString("status", "");
         tv_number.setText("Phòng Số : " + number);
         tv_Flor.setText( "Diện Tích : " + flor);
         tv_detal.setText(detail);
         tv_singer.setText("Phòng Đơn : " + single);
         tv_price.setText( " Giá : " + price);
         if (status.equals(String.valueOf(1))){
             tv_status.setText(" Trạnh Thái : phòng trống");
         } if (status.equals(String.valueOf(2))){
            tv_status.setText(" Trạnh Thái : Đã Đặt");
        } if (status.equals(String.valueOf(3))){
            tv_status.setText("Trạnh Thái : Không sử dụng");
        }
    }
}
