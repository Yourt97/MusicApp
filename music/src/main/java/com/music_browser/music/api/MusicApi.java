package com.music_browser.music.api;

import com.music_browser.music.dao.entity.Music;
import com.music_browser.music.service.MusicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/musics")
public class MusicApi {

    private final MusicService musicService;

    public MusicApi(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping("/all")
    public Iterable<Music> getAll() {return musicService.findAll();}

    @GetMapping("/{id}")
    public Optional<Music> getById(@PathVariable int id) {
        return musicService.findById(id);
    }

    @GetMapping("/name")
    public Iterable<Music> getMusicByTitle(@RequestParam String title) {
        return musicService.findByTitle(title);
    }

    @GetMapping("/author")
    public List<Music> getMusicByAuthor(@RequestParam String author) {
        return musicService.findAllByAuthor(author);
    }

    @GetMapping("/author/{author}/rating/{rating}")
    public List<String> findAllByRanking(@PathVariable String author, @PathVariable int rating) {
        return musicService.findAllByRating(author, rating);
    }

    @GetMapping("/rating/{rating}")
    public List<String> findAllByRatingHigherThan(@PathVariable int rating) {
        return musicService.findAllByRatingHigherThan(rating);
    }

    @PostMapping("/add")
    public Music addMusic(@RequestBody Music music) {
        return musicService.save(music);
    }

    @PutMapping
    public Music updateMusic(@RequestBody Music music) {
        return musicService.save(music);
    }

    @PutMapping("/{id}/update")
    public Optional<Music> updateMusic(@PathVariable int id, @RequestBody Music music) {
        return musicService.update(id, music);
    }

    @DeleteMapping
    public void deleteMusic(@RequestParam int id) {
        musicService.deleteById(id);
    }

}