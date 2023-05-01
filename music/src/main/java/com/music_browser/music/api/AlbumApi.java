package com.music_browser.music.api;

import com.music_browser.music.dao.entity.Album;
import com.music_browser.music.service.AlbumService;
import com.music_browser.music.service.ArtistService;
import com.music_browser.music.service.MusicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/albums")
public class AlbumApi {

    private final AlbumService albumService;
    private final ArtistService artistService;
    private final MusicService musicService;

    public AlbumApi(AlbumService albumService, ArtistService artistService, MusicService musicService) {
        this.albumService = albumService;
        this.artistService = artistService;
        this.musicService = musicService;
    }

    @GetMapping("/all")
    public Iterable<Album> getAll() {
        return albumService.findAll();
    }

    @GetMapping()
    public Optional<Album> getById(@RequestParam int id) {
        return albumService.findById(id);
    }

    @GetMapping("/name")
    public Iterable<Album> getAlbumByName(@RequestParam String name) {
        return albumService.findByName(name);
    }

    @GetMapping("/album/{id_album}")
    public List<String> findMusicByAlbum(@PathVariable int id_album){return  albumService.findMusicByAlbum(id_album);}

    @PostMapping()
    public Album addAlbum(@RequestBody Album album) {
        return albumService.save(album);
    }

    @PutMapping
    public Album updateAlbum(@RequestBody Album album) {return albumService.save(album);}

    @DeleteMapping()
    public void deleteAlbum(@RequestParam int id) {
        albumService.deleteById(id);
    }

    @PutMapping("/{id}/update")
    public Optional<Album> updateAlbum(@PathVariable int id, @RequestBody Album album) {
        return albumService.update(id, album);
    }
}