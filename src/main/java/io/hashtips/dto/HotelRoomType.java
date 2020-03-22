package io.hashtips.dto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hotel_room_type")
public class HotelRoomType {
    @EmbeddedId
    @Column(name = "hotel_id")
    private Hotel hotelId;
    @EmbeddedId
    @Column(name = "room_type_id")
    private RoomType roomTypeId;
    @Column(name = "room_count")
    private int roomCount;

    public Hotel getHotelId() {
        return hotelId;
    }

    public void setHotelId(Hotel hotelId) {
        this.hotelId = hotelId;
    }

    public RoomType getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(RoomType roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }
}
