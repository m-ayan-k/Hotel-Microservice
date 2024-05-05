package com.mayank.UserApplication.service;

import com.mayank.UserApplication.entities.Hotel;
import com.mayank.UserApplication.entities.Rating;
import com.mayank.UserApplication.entities.User;
import com.mayank.UserApplication.exceptions.ResourceNotFoundException;
import com.mayank.UserApplication.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with give id is not found in server"+userId));

        Rating[] ratingsOfUser = restTemplate.getForObject("http://rating-service/api/v1/ratings/users/"+user.getUserId(), Rating[].class);

        assert ratingsOfUser != null;
        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {

            ResponseEntity<Hotel> x = restTemplate.getForEntity("http://hotel-service/api/v1/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotel  = x.getBody();

            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;
    }
}
