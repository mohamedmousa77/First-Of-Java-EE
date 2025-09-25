package it.its.demo.service;

import it.its.demo.exceptions.MovieNotFound;
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

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    public Movie createOrUpdateMovie(Movie film) {
        Optional<Movie> existingMovieOptional = movieRepository.findById(film.getId());

        if(existingMovieOptional.isPresent()) {
            Movie existingMovie = existingMovieOptional.get();
            existingMovie.setTitle(film.getTitle());
            existingMovie.setGenre(film.getGenre());
            existingMovie.setDuration(film.getDuration());
            existingMovie.setPublishingYear(film.getPublishingYear());

            return movieRepository.save(existingMovie);
        }
        else {
            return movieRepository.save(film);
        }
//        Movie newMovie = new Movie();
//        List<Movie> movies = getAll();
//        for (int i =0; i< movies.size(); i++) {
//            if(movies.get(i).getId() == film.getId()) {
//                movies.get(i).setTitle(film.getTitle());
//                movies.get(i).setGenre(film.getGenre());
//                movies.get(i).setDuration(film.getDuration());
//                movies.get(i).setPublishingYear(film.getPublishingYear());
//                movieRepository.save(film);
//                updateMovie(film);
//
//            }else {
//                newMovie = movieRepository.save(film);
//                return newMovie;
//            }
//        }
//        return newMovie;
    }

    public Movie updateMovie(Movie film) throws MovieNotFound{
        return movieRepository.findById(film.getId())
                .map(existingMovie -> {
                    existingMovie.setTitle(film.getTitle());
                    existingMovie.setGenre(film.getGenre());
                    existingMovie.setDuration(film.getDuration());
                    existingMovie.setPublishingYear(film.getPublishingYear());
                    return movieRepository.save(existingMovie);
                })
                .orElseThrow(() -> new MovieNotFound("Movie with id " + film.getId() + " not found."));
    }

    public Optional<Movie> getMovieById(int id) {
        return movieRepository.findById(id);
    }

    public Optional<Movie> findMovieByTitle(String name) {
//        List<Movie> movies = getAll();
//        Movie movieFound = new Movie();
//        for (Movie movie : movies) {
//            if (movie.getTitle().equalsIgnoreCase(name)) {
//                return movieRepository.findById(movie.getId());
//            } else {
//            }
//        }

        return movieRepository.findByTitleIgnoreCase(name);
    }

    public int generaIdUnique() {
        return 0;
    }
}
