package com.bm.rooms.classes;

import com.bm.devices.DeviceOperatons;
import com.bm.rooms.interfaces.HallMIF;

import java.util.ArrayList;
import java.util.List;

public class Hall extends Rooms {

    List<HallMIF> devices = new ArrayList<HallMIF>();

    public Hall(int roomID) {
        super(roomID);
    }

    public void addDevice(HallMIF newDevice) {
        this.devices.add(newDevice);
    }

    public void removeDevice(HallMIF oldDevice) {
        devices.remove(oldDevice);
    }
}
