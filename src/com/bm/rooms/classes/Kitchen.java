package com.bm.rooms.classes;

import com.bm.rooms.interfaces.KitchenMIF;

import java.util.ArrayList;
import java.util.List;

public class Kitchen extends Rooms {
    List<KitchenMIF> devices = new ArrayList<KitchenMIF>();

    public Kitchen(int roomID) {
        super(roomID);
    }

    public void addDevice(KitchenMIF newDevice) {
        this.devices.add(newDevice);
    }

    public void removeDevice(KitchenMIF oldDevice) {
        devices.remove(oldDevice);
    }
}
