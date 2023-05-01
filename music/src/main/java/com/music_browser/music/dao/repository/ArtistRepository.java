package com.music_browser.music.dao.repository;

import com.music_browser.music.dao.entity.Artist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Integer> {
    Iterable<Artist> findByName(String name);

    List<Artist> findAllByAlias(String alias);

    @Query(value = "SELECT *  FROM Artist WHERE lastname = :lastname", nativeQuery = true)
    List<Artist> findAllByLastname(@Param("lastname") String lastname);

    @Query("SELECT e from Artist e WHERE e.name like CONCAT(:letter,'%')")
    List<Artist> findAllByNameStartsWith(@Param("letter") String letter);


    @Query("SELECT u FROM Artist u WHERE u.dateOfBirth < '1993-01-01' ")
    List<Artist> findAllArtistOver40();


    @Query(value = "SELECT name  FROM Artist WHERE lastname = :lastname", nativeQuery = true)
    Optional<Artist> findAllByLast(@Param("lastname") String lastname);





}
