package com.bm.devices.classes;

import com.bm.rooms.classes.Rooms;
import com.bm.rooms.interfaces.BedRoomMIF;
import com.bm.rooms.interfaces.HallMIF;
import com.bm.rooms.interfaces.LivingAreaMIF;

public class AC extends Rooms implements BedRoomMIF, HallMIF, LivingAreaMIF {

    public AC(int roomID) {
        super(roomID);
    }

    @Override
    public void deviceTurnOnOff() {

    }

    @Override
    public int getCurrentStateTime() {
        return 0;
    }

    @Override
    public boolean isOn() {
        return false;
    }

    @Override
    public int getDeviceId() {
        return 0;
    }

    @Override
    public void specialOperations() {

    }
}
