package com.soanlv.assfinal.api;

import com.soanlv.assfinal.model.Hotel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HotelServices {
    @GET("api/hotels")
    Call<List<Hotel>> getHotel();

}
