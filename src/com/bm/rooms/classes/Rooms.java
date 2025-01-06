package com.bm.rooms.classes;

import com.bm.devices.DeviceOperatons;

import java.util.ArrayList;
import java.util.List;

public abstract class Rooms {
    int roomID;
    List<DeviceOperatons> devices = new ArrayList<>();


    public List<DeviceOperatons> getAllDevices() {
        return this.devices;
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
