package it.its.demo.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Movie {
    private int id;
    private String title;
    private int publishingYear;
    private String genre;
}
