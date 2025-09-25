package it.its.demo.controller;

import it.its.demo.model.Movie;
import it.its.demo.service.MovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieServices movieServices;

    @PostMapping("/createMovie")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieServices.createOrUpdateMovie(movie);
    }

    @GetMapping("/getMovieById/id")
    public Optional<Movie> getMovieById(int id) {
        return movieServices.getMovieById(id);
    }

    @GetMapping("/getMovies")
    public List<Movie> getMovies() {
        return movieServices.getAll();
    }

    @PutMapping("/updateMovie")
    public Movie updateMovie(Movie updatedMovie) {
        return movieServices.updateMovie(updatedMovie);
    }

    @GetMapping("/getMovieByTitle")
    public Optional<Movie> getMovieByTitle(@RequestParam String title){
        return movieServices.findMovieByTitle(title);
    }

}
