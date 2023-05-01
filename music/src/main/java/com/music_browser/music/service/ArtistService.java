package com.music_browser.music.service;

import com.music_browser.music.dao.entity.Artist;
import com.music_browser.music.dao.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArtistService {

    private ArtistRepository artistRepository;

    @Autowired
    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public Optional<Artist> findById(int id) {
        if (!artistRepository.findById(id).isEmpty()) {
            return artistRepository.findById(id);
        }
        return Optional.empty();
    }

    public Iterable<Artist> findAllById() {return artistRepository.findAll();}

    public Iterable<Artist> findByName(String name) {
        return artistRepository.findByName(name);
    }

    public Artist save(Artist artist) {
        return artistRepository.save(artist);
    }

    public void deleteById(int id) {
        artistRepository.deleteById(id);
    }

    public Optional<Artist> update(int id, Artist artist) {
        Optional<Artist> artist1 = artistRepository.findById(id);
        if (artist1.isPresent()) {
            artist1.get().setName(artist.getName());
            artist1.get().setLastname(artist.getLastname());
            artist1.get().setAlias(artist.getAlias());
            artist1.get().setDateOfBirth(artist.getDateOfBirth());

            save(artist1.get());
            return artist1;
        }
        return Optional.empty();
    }

    public List<String> findAllByLastname(String lastname) {
        List<String> collect = artistRepository.findAllByLastname(lastname).stream()
                .map(artist -> artist.getName() + " " + artist.getAlias())
                .collect(Collectors.toList());

        return collect;
    }

    public List<Artist> findByNameStartWith(String letter) {
        return artistRepository.findAllByNameStartsWith(letter);
    }

    public List<Artist> findByAlias(String alias) {
        return artistRepository.findAllByAlias(alias);
    }

    public List<Artist> findAllArtistOver40() {return artistRepository.findAllArtistOver40();}

    public Optional<Artist> findAllByLast(String lastname) {
        return artistRepository.findAllByLast(lastname);
    }



}
