package com.example.moviestore.model;

public class Movie {
    private Integer id;
    private String name;
    private Integer year;
    private Genre genre;
    private Author author;

    public Movie(Integer id, String name, Integer year, Genre genre, Author author) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.author = author;
    }

    public Movie(String name, Integer year, Genre genre, Author author) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.author = author;
    }

    public Movie() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
