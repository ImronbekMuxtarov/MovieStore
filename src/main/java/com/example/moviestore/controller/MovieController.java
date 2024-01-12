package com.example.moviestore.controller;

import com.example.moviestore.model.Movie;
import com.example.moviestore.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieRepo movieRepo;

    @GetMapping
    public List<Movie> getMovies(){
        return movieRepo.getMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable int id){
        return movieRepo.getMovie(id);
    }

    @PostMapping
    public String addMovie(@RequestBody Movie movie){
        movieRepo.addMovie(movie);
        return "Added";
    }

    @PutMapping("/{id}")
    public String updateMovie(@PathVariable int id, @RequestBody Movie movie){
        movieRepo.updateMovie(id, movie);
        return "Updated";
    }

    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable int id){
        movieRepo.deleteMovie(id);
        return "Deleted";
    }
}
