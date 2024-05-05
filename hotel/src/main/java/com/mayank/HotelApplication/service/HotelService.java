package com.mayank.HotelApplication.service;

import com.mayank.HotelApplication.entities.Hotel;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);

    List<Hotel> getAll();

    Hotel get(String id);
}
