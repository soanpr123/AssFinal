package com.soanlv.assfinal.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RoomMD {
    @SerializedName("_id")
    @Expose
    private String _id;
    @SerializedName("room_number")
    @Expose
    private String room_number;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("floor")
    @Expose
    private String floor;
    @SerializedName("single_room")
    @Expose
    private String single_room;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("hotelid")
    @Expose
    private String hotelid;
    @SerializedName("detail")
    @Expose
    private String detail;
    @SerializedName("status")
    @Expose
    private String status;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getSingle_room() {
        return single_room;
    }

    public void setSingle_room(String single_room) {
        this.single_room = single_room;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getHotelid() {
        return hotelid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
