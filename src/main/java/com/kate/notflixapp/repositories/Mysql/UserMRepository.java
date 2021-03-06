package com.kate.notflixapp.repositories.Mysql;

import com.kate.notflixapp.domainClasses.Mysql.MovieM;
import com.kate.notflixapp.domainClasses.Mysql.UserM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserMRepository extends JpaRepository<UserM, Long> {
    @Query("SELECT u.likedMovies FROM UserM u WHERE u.id = ?1")
    List<MovieM> getLikedMoviesByUserId(Long id);

    UserM findByUsername(String username);
}
