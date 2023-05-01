package com.music_browser.music.dao.repository;

import com.music_browser.music.dao.entity.Music;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MusicRepository extends CrudRepository<Music, Integer> {

    Iterable<Music> findByTitle(String title);

    @Query(value = "SELECT * from Music  WHERE author= :author ", nativeQuery = true)
    List<Music> findAllByAuthor(@Param("author") String author);

    @Query(value = "SELECT Music.title , Music.rating FROM Music WHERE author=:author AND rating=:rating ", nativeQuery = true)
    List<String> findAllByRating(@Param("author") String author, @Param("rating") int rating);

    @Query(value = "SELECT Music.title , Artist.name, Music.rating FROM Artist  JOIN Album ON Artist.id_artist = Album.id_artist Join Music On Album.id_album = Music.id_album WHERE Music.rating > :rating  ", nativeQuery = true)
    List<String> findAllByRatingHigherThan(@Param("rating") int rating);

}
