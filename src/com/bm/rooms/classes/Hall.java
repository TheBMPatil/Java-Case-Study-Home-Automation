package com.bm.rooms.classes;

import com.bm.devices.DeviceOperatons;

import java.util.ArrayList;
import java.util.List;

public class Hall extends Rooms {

    List<DeviceOperatons> devices = new ArrayList<>();

    public Hall(int roomID) {
        super(roomID);
    }

    public List getAllDevices() {
        return this.devices;
    }

    public void addDevice(DeviceOperatons newDevice) {
        this.devices.add(newDevice);
    }

    public void removeDevice(DeviceOperatons oldDevice) {
        devices.remove(oldDevice);
    }
}
