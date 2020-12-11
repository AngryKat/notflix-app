package com.kate.notflixapp.service;

import com.kate.notflixapp.domainClasses.Mysql.MovieM;
import com.kate.notflixapp.domainClasses.Neo4j.MovieN;
import com.kate.notflixapp.repositories.Mysql.MovieMRepository;
import com.kate.notflixapp.repositories.Neo4j.MovieNRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService implements IMovieService {
    @Autowired
    private MovieMRepository mMrepo;
    @Autowired
    private MovieNRepository mNrepo;


    @Override
    public MovieN addMovie(MovieN m) {
        return mNrepo.save(m);
    }

    @Override
    public MovieM addMovie(MovieM m) {
        return mMrepo.save(m);
    }

    @Override
    public Iterable<MovieN> getMovieByTitleFromNeo(String title) {
        return mNrepo.findByTitle(title);
    }

    @Override
    public Iterable<MovieM> getMovieByTitleFromMysql(String title) {
        return mMrepo.findByTitle(title);
    }

    @Override
    public void deleteMovie(MovieN m) {
        mNrepo.delete(m);

    }

    @Override
    public void deleteMovie(MovieM m) {
        mMrepo.delete(m);
    }

    @Override
    public Iterable<MovieM> getAllMovies() {
        return mMrepo.findAll();
    }
}
