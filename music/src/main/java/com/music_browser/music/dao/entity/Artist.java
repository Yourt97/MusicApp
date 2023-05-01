package com.music_browser.music.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "artist")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_artist")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "alias")
    private String alias;

    @Column(name = "age")
    private LocalDate dateOfBirth;

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", alias='" + alias + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    //    @OneToMany
//    @JoinColumn(name = "id_album")
//    private List<Album> album;

//    @Column(name="id_album")
//    private int id_album;


}
