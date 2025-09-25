package it.its.demo.repository;

import it.its.demo.model.Movie;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Registered
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Optional<Movie> findByTitleIgnoreCase(String title);
}
