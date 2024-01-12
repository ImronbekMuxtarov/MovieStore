package com.example.moviestore.controller;

import com.example.moviestore.model.Genre;
import com.example.moviestore.repository.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    GenreRepo genreRepo;

    @GetMapping
    public List<Genre> getGenres(){
        return genreRepo.getGenres();
    }

    @GetMapping("/{id}")
    public Genre getGenre(@PathVariable int id){
        return genreRepo.getGenre(id);
    }

    @PostMapping
    public String addGenre(@RequestBody Genre genre){
        genreRepo.addGenre(genre);
        return "Added";
    }

    @PutMapping("/{id}")
    public String updateGenre(@PathVariable int id, @RequestBody Genre genre){
        genreRepo.updateGenre(id, genre);
        return "Updated";
    }

    @DeleteMapping("/{id}")
    public String deleteGenre(@PathVariable int id){
        genreRepo.deleteGenre(id);
        return "Deleted";
    }
}
