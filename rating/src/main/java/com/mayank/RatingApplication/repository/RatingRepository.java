package com.mayank.RatingApplication.repository;

import com.mayank.RatingApplication.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface RatingRepository extends JpaRepository<Rating, String> {
    // custome finder method

    List<Rating> findByUserId(String userId);

    List<Rating> findByHotelId(String hotelId);
}
