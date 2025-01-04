package com.bm.homeautomation;

import com.bm.devices.DeviceOperatons;
import com.bm.rooms.classes.Rooms;

import java.util.List;

public class DeviceManagement {
    public static void deviceManager(House myHouse) {
        System.out.println("List of all Rooms is here  Choose room : ");
//        for(DeviceOperatons device : )
        List<Rooms> rooms = myHouse.getRooms();
        for (Rooms room : rooms) {
            System.out.println("Room id : " + room.getRoomID());
        }



    }
}
