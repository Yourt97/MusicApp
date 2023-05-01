package com.music_browser.music.api;

import com.music_browser.music.dao.entity.Artist;
import com.music_browser.music.dao.repository.ArtistRepository;
import com.music_browser.music.service.AlbumService;
import com.music_browser.music.service.ArtistService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/artists")
public class ArtistApi {

    private final ArtistRepository artistRepository;

    private final ArtistService artistService;

    private final AlbumService albumService;

    public ArtistApi(ArtistRepository artistRepository, ArtistService artistService, AlbumService albumService) {
        this.artistRepository = artistRepository;
        this.artistService = artistService;
        this.albumService = albumService;
    }

    @GetMapping("/all")
    public Iterable<Artist> getAll() {
        return artistService.findAllById();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Artist> getById(@PathVariable int id) {return artistService.findById(id);}

    @GetMapping("/alias")
    public List<Artist> getArtistByAlias(@RequestParam String alias) {
        return artistService.findByAlias(alias);
    }

    @PostMapping()
    public Artist addArtist(@RequestBody Artist artist) {
        return artistService.save(artist);
    }

    @GetMapping("/lastname")
    public List<String> findAllByLastName(@RequestParam String lastname) {return artistService.findAllByLastname(lastname);}

    @GetMapping("/letter")
    public List<Artist> findByNameStartWith(@RequestParam String letter) {return artistService.findByNameStartWith(letter);}

    @GetMapping("/over40")
    public List<Artist> findAllArtistOver40() {
        return artistService.findAllArtistOver40();
    }

    @PutMapping("/{id}/update")
    public Optional<Artist> updateArtist(@PathVariable int id, @RequestBody Artist artist) {return artistService.update(id, artist);}

    @GetMapping("/lastN")
    public Optional<Artist> findAllByLast(@RequestParam String lastname) {return artistService.findAllByLast(lastname);}

    @DeleteMapping("/{id}")
    public void deleteArtist(@PathVariable int id) {
        artistService.deleteById(id);
    }


//    @PostMapping("/album/{id}/artist")
//    public Artist addArtist(@PathVariable int id, @RequestBody Artist artist) {
//        return albumService.createArtist(id, artist);
//    }


}
