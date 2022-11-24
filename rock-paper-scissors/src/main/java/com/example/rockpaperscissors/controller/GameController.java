package com.example.rockpaperscissors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rockpaperscissors.service.GameService;

@RestController
public class GameController {
    @Autowired
    private GameService gameService; 

    @PostMapping("/api/play")
    public String Play(@RequestBody String myMove){

        return gameService.Play(myMove);
    }
}
