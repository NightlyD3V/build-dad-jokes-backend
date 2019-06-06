package com.dad.jokes.controller;

import com.dad.jokes.model.RandomJoke;
import com.dad.jokes.service.RandomJokeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomJokeController
{
    @Autowired
    private RandomJokeService randomJokeService;

    @ApiOperation(value= "Get random dad joke", response = RandomJoke.class)
    @GetMapping(value = "/randomJoke")
    public ResponseEntity<?> getRandomJoke()
    {
        return new ResponseEntity<>(randomJokeService.findAll(), HttpStatus.OK);
    }
}
