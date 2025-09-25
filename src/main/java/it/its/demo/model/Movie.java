    package it.its.demo.model;
    import jakarta.persistence.Entity;
    import jakarta.persistence.Id;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor

    public class Movie {
        @Id
        private int id;
        private String title;
        private int publishingYear;
        private int duration;
        private String genre;
    }
