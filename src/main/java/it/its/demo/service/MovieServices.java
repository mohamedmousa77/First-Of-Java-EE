package it.its.demo.service;

import it.its.demo.model.Movie;
import it.its.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServices {
    @Autowired
    private MovieRepository movieRepository;

    public Movie saveMovie(Movie film) {
        Movie newMovie = new Movie();
        newMovie = movieRepository.save(film);
        return newMovie;
    }

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(int id) {
        return movieRepository.findById(id);
    }
}
