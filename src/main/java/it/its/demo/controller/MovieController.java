package it.its.demo.controller;

import it.its.demo.model.Movie;
import it.its.demo.service.MovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieServices movieServices;

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieServices.saveMovie(movie);
    }
}
