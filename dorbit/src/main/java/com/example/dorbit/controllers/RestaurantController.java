package com.example.dorbit.controllers;

import com.example.dorbit.models.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.dorbit.services.RestaurantService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<Restaurant> saveOrUpdate(@RequestBody Restaurant rest) {
        return new ResponseEntity<Restaurant>(restaurantService.saveOrUpdate(rest), HttpStatus.ACCEPTED);
    }

    // TODO : How to change the default url from / to get_all
    @GetMapping
    public ResponseEntity<List<Restaurant>> findAll() {
        return new ResponseEntity<List<Restaurant>>(restaurantService.findAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Restaurant>> sort() {
        return new ResponseEntity<List<Restaurant>>(restaurantService.findAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Restaurant>> sort(@RequestParam(required = false) String sortBy) {
        try {
            List<Restaurant> restaurants = restaurantService.findAll();

            // Check if the sortBy parameter is provided and sort accordingly
            if (sortBy != null) {
                switch (sortBy) {
                    case "name":
                        Collections.sort(restaurants, Comparator.comparing(Restaurant::getName));
                        break;
                    // Add more cases for other sorting criteria if needed
                    default:
                        // If the provided sortBy value is not recognized, sort by name by default
                        Collections.sort(restaurants, Comparator.comparing(Restaurant::getName));
                }
            }

            return new ResponseEntity<>(restaurants, HttpStatus.OK);
        } catch (Exception e) {
            // Handle any exceptions that occur during the sorting process
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody Restaurant rest){
        restaurantService.delete(rest);
        return new ResponseEntity<String>("Record deleted", HttpStatus.ACCEPTED);
    }

    // TODO : Change this to URL for specific restarunt and get the ID parameter from the client
    @PutMapping("/restaurants/{id}")
    public ResponseEntity<Restaurant> findById(@PathVariable String id) {
        try {
            // Use the extracted ID parameter (id) to find the specific restaurant
            return restaurantService.findById(id)
                    .map(restaurant -> new ResponseEntity<>(restaurant, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            // Handle any exceptions that occur during the process of finding the restaurant
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
}
