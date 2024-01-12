package com.example.moviestore.repository;

import com.example.moviestore.model.Genre;
import com.example.moviestore.repository.mapper.GenreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Genre> getGenres(){
        return jdbcTemplate.query(
                "select * from genres order by id",
                new GenreMapper()
        );
    }

    public Genre getGenre(int id){
        return jdbcTemplate.queryForObject(
                "select * from genres where id = ?",
                new Object[]{id},
                new GenreMapper()
        );
    }

    public boolean addGenre(Genre genre){
        jdbcTemplate.update(
                "insert into genres(name) values (?)",
                genre.getName()
        );
        return true;
    }

    public boolean updateGenre(int id, Genre genre){
        jdbcTemplate.update(
                "update genres set name = ? where id = ?",
                genre.getName(),
                id
        );
        return true;
    }

    public boolean deleteGenre(int id){
        jdbcTemplate.update(
                "delete from genres where id = ?",
                id
        );
        return true;
    }
}
