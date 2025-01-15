package com.bm.rooms.classes;

import com.bm.rooms.interfaces.BedRoomMIF;
import com.bm.rooms.interfaces.CorridorsMIF;

import java.util.ArrayList;
import java.util.List;

public class Corridors extends Rooms {
    List<CorridorsMIF> devices = new ArrayList<CorridorsMIF>();

    public Corridors(int roomID) {
        super(roomID);
    }

    public void addDevice(CorridorsMIF newDevice) {
        this.devices.add(newDevice);
    }

    public void removeDevice(CorridorsMIF oldDevice) {
        devices.remove(oldDevice);
    }
}
