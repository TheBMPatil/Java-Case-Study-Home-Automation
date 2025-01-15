package com.bm.rooms.classes;

import com.bm.rooms.interfaces.LivingAreaMIF;

import java.util.ArrayList;
import java.util.List;

public class LivingArea extends Rooms {
    List<LivingAreaMIF> devices = new ArrayList<LivingAreaMIF>();

    public LivingArea(int roomID) {
        super(roomID);
    }
    public void addDevice(LivingAreaMIF newDevice) {
        this.devices.add(newDevice);
    }

    public void removeDevice(LivingAreaMIF oldDevice) {
        devices.remove(oldDevice);
    }
}
