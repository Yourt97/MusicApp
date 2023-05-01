package com.music_browser.music.service;

import com.music_browser.music.dao.entity.Album;
import com.music_browser.music.dao.repository.AlbumRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public Optional<Album> findById(int id) {
        if (albumRepository.findById(id).isEmpty()) {
            return Optional.empty();
        } else {
            return albumRepository.findById(id);
        }
    }

    public Iterable<Album> findAll() {
        return albumRepository.findAll();
    }

    public Iterable<Album> findByName(String name) {
        return albumRepository.findByName(name);
    }

    public List<String> findMusicByAlbum(int id_album){return  albumRepository.findMusicByAlbum(id_album);}

    public Album save(Album album) {
        return albumRepository.save(album);
    }


//    public Artist createArtist(int id, Artist artist) {
//        Optional<Album> album = albumRepository.findById(id);
//        album.get().setArtist(artist);
//        albumRepository.save(album.get());
//        return artist;
//    }


    public void deleteById(int id) {
        albumRepository.deleteById(id);
    }

    public Optional<Album> update(int id, Album album) {
        Optional<Album> album1 = albumRepository.findById(id);
        if (album1.isPresent()) {
            album1.get().setName(album.getName());
            album1.get().setAlbum_size(album.getAlbum_size());
            album1.get().setCountry(album.getCountry());
            album1.get().setData(album.getData());
            album1.get().setPrice(album.getPrice());
            album1.get().setSales(album.getSales());
            album1.get().setId_artist(album.getId_artist());

            save(album1.get());
            return album1;
        }
        return Optional.empty();
    }
}
