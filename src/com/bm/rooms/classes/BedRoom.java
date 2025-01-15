package com.bm.rooms.classes;

import com.bm.rooms.interfaces.BedRoomMIF;

import java.util.ArrayList;
import java.util.List;

public class BedRoom extends Rooms {
    List<BedRoomMIF> devices = new ArrayList<BedRoomMIF>();

    public BedRoom(int roomID) {
        super(roomID);
    }

    public void addDevice(BedRoomMIF newDevice) {
        this.devices.add(newDevice);
    }

    public void removeDevice(BedRoomMIF oldDevice) {
        devices.remove(oldDevice);
    }
}
