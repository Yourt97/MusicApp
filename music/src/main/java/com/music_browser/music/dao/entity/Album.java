package com.music_browser.music.dao.entity;

import com.music_browser.music.Country;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "album")
public class Album {

    @Id
    @Column(name = "id_album")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "album_name")
    private String name;

    @Column(name = "album_size")
    private int album_size;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "sales")
    private int sales;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "country")
    private Country country;

    @Column(name = "id_artist")
    private int id_artist;

//    @OneToOne
//    @JoinColumn(name = "id_artist")
//    public Artist artist;

//    @OneToMany
//    @JoinColumn(name = "id_music")
//    public List<Music> music;


}
