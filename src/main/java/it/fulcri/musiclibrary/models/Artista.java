package it.fulcri.musiclibrary.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "artista")
    private Set<CanzoneArtista> canzoneArtista;
}
