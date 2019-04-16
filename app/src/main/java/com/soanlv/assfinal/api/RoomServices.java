package com.soanlv.assfinal.api;

import com.soanlv.assfinal.model.Hotel;
import com.soanlv.assfinal.model.RoomMD;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RoomServices {
    @GET("api/rooms")
    Call<List<RoomMD>> getRoom();
}
