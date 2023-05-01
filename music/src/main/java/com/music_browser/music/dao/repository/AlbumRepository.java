package com.music_browser.music.dao.repository;

import com.music_browser.music.dao.entity.Album;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Integer> {

    Iterable<Album> findByName(String name);

    @Query(value = "SELECT Music.title FROM Music WHERE id_album =:id_album", nativeQuery = true)
    List<String> findMusicByAlbum(@Param("id_album") int id_album);

}
