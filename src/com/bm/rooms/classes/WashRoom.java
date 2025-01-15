package com.bm.rooms.classes;

import com.bm.rooms.interfaces.WashRoomMIF;

import java.util.ArrayList;
import java.util.List;

public class WashRoom extends Rooms {
    List<WashRoomMIF> devices = new ArrayList<WashRoomMIF>();

    public WashRoom(int roomID) {
        super(roomID);
    }
    public void addDevice(WashRoomMIF newDevice) {
        this.devices.add(newDevice);
    }

    public void removeDevice(WashRoomMIF oldDevice) {
        devices.remove(oldDevice);
    }
}
