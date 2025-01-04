package com.bm.homeautomation;

import com.bm.rooms.classes.Rooms;

import java.util.ArrayList;
import java.util.List;

public class House {
    int houseNo;
    String houseName;
    List<Rooms> rooms = new ArrayList<>();

    public House() {
        this.houseNo = 0;
        this.houseName = "UnNamed";
    }

    public House(int houseNo) {
        this.houseName = "No Name";
        this.houseNo = houseNo;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public List<Rooms> getRooms() {
        return rooms;
    }

    public void setRooms(List<Rooms> rooms) {
        this.rooms = rooms;
    }
}
