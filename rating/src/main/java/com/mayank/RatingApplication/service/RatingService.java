package com.mayank.RatingApplication.service;

import com.mayank.RatingApplication.entities.Rating;

import java.util.List;

public interface RatingService {

    Rating  create(Rating rating);

    List<Rating> getRating();

    List<Rating> getRatingByUserId(String userId);

    List<Rating> getRatingByHotelId(String hotelId);
}
