package com.kate.notflixapp.repositories.Mysql;

import com.kate.notflixapp.domainClasses.Mysql.MovieM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieMRepository extends JpaRepository<MovieM, Long> {

    MovieM findByTitle(String title);





}
