package com.example.moviestore.repository;

import com.example.moviestore.model.Movie;
import com.example.moviestore.repository.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Movie> getMovies(){
        return jdbcTemplate.query(
                "select m.id, m.name, m.year, g.id, g.name, a.id, a.name " +
                        "from movies m " +
                        "join genres g on m.genre_id = g.id " +
                        "join authors a on m.author_id = a.id " +
                        "order by m.id",
                new MovieMapper()
        );
    }

    public Movie getMovie(int id){
        return jdbcTemplate.queryForObject(
                "select m.id, m.name, m.year, g.id, g.name, a.id, a.name " +
                        "from movies m " +
                        "join genres g on m.genre_id = g.id " +
                        "join authors a on m.author_id = a.id " +
                        "where m.id = ? ",
                new Object[]{id},
                new MovieMapper()
        );
    }

    public boolean addMovie(Movie movie){
        jdbcTemplate.update(
                "insert into movies(name, year, genre_id, author_id) values (?, ?, ?, ?)",
                movie.getName(),
                movie.getYear(),
                movie.getGenre().getId(),
                movie.getAuthor().getId()
        );
        return true;
    }

    public boolean updateMovie(int id, Movie movie){
        jdbcTemplate.update(
                "update movies set name = ?, year = ?, genre_id = ?, author_id = ? where id = ?",
                movie.getName(),
                movie.getYear(),
                movie.getGenre().getId(),
                movie.getAuthor().getId(),
                id
        );
        return true;
    }

    public boolean deleteMovie(int id){
        jdbcTemplate.update(
                "delete from movies where id = ?",
                id
        );
        return true;
    }
}
