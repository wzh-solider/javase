package com.hspedu.houserent.service;

import com.hspedu.houserent.domain.House;

public class HouseService {
    private House[] house;
    private int houseNum;
    private int idCount;
    private boolean loop = true;
    public HouseService(int Size) {
        house = new House[Size];
        // house[0] = new House(0, "jack", "118", "海定区", 3000, "未出租");
    }

    public boolean add(House newHouse) {
        House[] houses = new House[house.length + 1];
        house[houseNum++] = newHouse;
        for (int i = 0; i < house.length; i++) {
            houses[i] = house[i];
        }
        house = houses;
        newHouse.setId(++idCount);
        return true;
    }

    public boolean search(int id) {
        int count = 0;
        for (int i = 0; i < house.length; i++) {
            if (house[i].getId() == id) {
                System.out.println(house[i]);
                count++;
                return true;
            }
        }
        if (count == 0) System.out.println("================没有该房屋================");
        return true;
    }

    public boolean delete(int index) {
        if (index == -1) return false;
        for (int i = index - 1; i < house.length - 1; i++) {
            house[i] = house[i + 1];
        }
        return true;
    }

    public boolean revise(House newhouse, int id) {
        int index = 0;
        if (id == -1) return false;
        for (int i = 0; i < house.length; i++) {
            if (id == house[i].getId()) {
                index = i;
                break;
            }
        }
        house[index] = newhouse; return true;
    }
    public House[] list() {
        return house;
    }
}
