package com.music_browser.music.service;

import com.music_browser.music.dao.entity.Music;
import com.music_browser.music.dao.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;


    public Optional<Music> findById(int id) {

        if (musicRepository.findById(id).isEmpty()) {
            return Optional.empty();
        }
        return musicRepository.findById(id);
    }

    public Iterable<Music> findAll() {
        return musicRepository.findAll();
    }

    public Iterable<Music> findByTitle(String title) {
        return musicRepository.findByTitle(title);
    }


    public Music save(Music music) {
        return musicRepository.save(music);
    }

    public void deleteById(int id) {
        musicRepository.deleteById(id);
    }

    public Optional<Music> update(int id, Music music) {
        Optional<Music> music1 = musicRepository.findById(id);
        if (music1.isPresent()) {
            music1.get().setTitle(music.getTitle());
            music1.get().setAuthor(music.getAuthor());
            music1.get().setRating(music.getRating());
            music1.get().setId_album(music.getId_album());

            save(music1.get());
            return music1;
        }
        return Optional.empty();
    }


    public List<String> findAllByRatingHigherThan(int rating){return musicRepository.findAllByRatingHigherThan(rating);}

    public List<Music> findAllByAuthor(String author) {
        return musicRepository.findAllByAuthor(author);
    }

    public List<String> findAllByRating(String author, int rating) {return musicRepository.findAllByRating(author, rating);}

}
