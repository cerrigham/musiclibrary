package it.fulcri.musiclibrary.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Canzone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titolo;

    @OneToMany(mappedBy = "canzone")
    private List<CanzoneAlbum> canzoneAlbum = new ArrayList<>();

    @OneToMany(mappedBy = "canzone")
    private List<CanzoneArtista> canzoneArtista = new ArrayList<>();
}
