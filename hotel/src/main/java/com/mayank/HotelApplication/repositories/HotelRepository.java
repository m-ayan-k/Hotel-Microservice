package com.mayank.HotelApplication.repositories;

import com.mayank.HotelApplication.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String> {
}
