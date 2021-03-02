package it.fulcri.musiclibrary.models;

import lombok.Data;

import javax.persistence.*;

import javax.persistence.Id;
import java.util.Set;

@Entity
@Data
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titolo;

    @OneToMany(mappedBy = "album")
    private Set<CanzoneAlbum> canzoneAlbum;
}
