package com.music_browser.music.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "music")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_music")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "rating")
    private int rating;

    @Column (name = "id_album")
    private int id_album;


//    @ManyToOne
//    @JoinColumn(name="id_album")
//    private Album album;

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", name='" + title + '\'' +
                ", author='" + author + '\'' +
                ",rating=" + rating +
                '}';
    }
}
