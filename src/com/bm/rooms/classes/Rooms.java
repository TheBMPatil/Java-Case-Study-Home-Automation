package com.bm.rooms.classes;

public abstract class Rooms {
    int roomID;

    public Rooms() {
    }

    public Rooms(int roomID) {
        this.roomID = roomID;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }
}
