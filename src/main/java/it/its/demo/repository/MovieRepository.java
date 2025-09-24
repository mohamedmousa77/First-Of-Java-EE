package it.its.demo.repository;

import it.its.demo.model.Movie;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
