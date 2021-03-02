package it.fulcri.musiclibrary.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CanzoneAlbum {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_canzone")
    Canzone canzone;

    @ManyToOne
    @JoinColumn(name = "id_album")
    Album album;
}
