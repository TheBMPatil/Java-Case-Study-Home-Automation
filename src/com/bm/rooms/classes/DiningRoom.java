package com.bm.rooms.classes;

import com.bm.rooms.interfaces.DiningRoomMIF;
import com.bm.rooms.interfaces.WashRoomMIF;

import java.util.ArrayList;
import java.util.List;

public class DiningRoom extends Rooms {
    List<DiningRoomMIF> devices = new ArrayList<DiningRoomMIF>();

    public DiningRoom(int roomID) {
        super(roomID);
    }

    public void addDevice(DiningRoomMIF newDevice) {
        this.devices.add(newDevice);
    }

    public void removeDevice(DiningRoomMIF oldDevice) {
        devices.remove(oldDevice);
    }
}
