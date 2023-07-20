package com.example.dorbit.services;

import com.example.dorbit.models.Restaurant;
import com.example.dorbit.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant saveOrUpdate(Restaurant rest) {
        return restaurantRepository.save(rest);
    }

    public List<Restaurant> findAll() {
        List<Restaurant> response = restaurantRepository.findAll();
        return response;
    }

    public Optional<Restaurant> findById(String id) {
        return restaurantRepository.findById(id);
    }

    public void delete(Restaurant rest){
        restaurantRepository.delete(rest);
    }
}
