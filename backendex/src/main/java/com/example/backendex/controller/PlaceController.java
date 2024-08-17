package com.example.backendex.controller;
import com.example.backendex.model.Place;
import com.example.backendex.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlaceController {
    @Autowired
    private PlaceRepository placeRepository;

    @GetMapping("/getAllPlace")
    public List<Place> getAllPlace() {
        return placeRepository.findAll();
    }
}