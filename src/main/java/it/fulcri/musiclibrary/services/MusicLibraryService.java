package it.fulcri.musiclibrary.services;

import it.fulcri.musiclibrary.dto.AlbumDTO;
import it.fulcri.musiclibrary.dto.ArtistaDTO;
import it.fulcri.musiclibrary.models.*;
import it.fulcri.musiclibrary.repositories.AlbumRepository;
import it.fulcri.musiclibrary.repositories.ArtistaRepository;
import it.fulcri.musiclibrary.repositories.CanzoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MusicLibraryService {
    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    ArtistaRepository artistaRepository;

    @Autowired
    CanzoneRepository canzoneRepository;

    public void aggiungiCanzone(String titolo, String album, String artista) {
        Canzone canzone = new Canzone();
        canzone.setTitolo(titolo);

        Album alb = findAlbumByTitolo(album);
        if(alb == null) {
            Album nuovoAlbum = new Album();
            nuovoAlbum.setTitolo(album);
            albumRepository.save(nuovoAlbum);
            alb = nuovoAlbum;
        }

        Artista art = findArtistaByNome(artista);
        if(art == null) {
            Artista nuovoArtista = new Artista();
            nuovoArtista.setNome(artista);
            artistaRepository.save(nuovoArtista);
            art = nuovoArtista;
        }

        CanzoneAlbum canzoneAlbum = new CanzoneAlbum();
        canzoneAlbum.setCanzone(canzone);
        canzoneAlbum.setAlbum(alb);

        CanzoneArtista canzoneArtista = new CanzoneArtista();
        canzoneArtista.setCanzone(canzone);
        canzoneArtista.setArtista(art);

        canzone.getCanzoneAlbum().add(canzoneAlbum);
        canzone.getCanzoneArtista().add(canzoneArtista);

        canzoneRepository.save(canzone);
    }

    public Album findAlbumByTitolo(String titolo) {
        return albumRepository.findByTitolo(titolo);
    }

    public Artista findArtistaByNome(String nome) {
        return artistaRepository.findByNome(nome);
    }

    public List<AlbumDTO> getListaAlbum() {
        final Iterable<Album> all = albumRepository.findAll();
        return generateAlbumDTOList(all);
    }

    public List<ArtistaDTO> getListaArtisti() {
        final Iterable<Artista> all = artistaRepository.findAll();
        return generateArtistaDTPOist(all);
    }

    private List<AlbumDTO> generateAlbumDTOList(Iterable<Album> all) {
        List<AlbumDTO> result = StreamSupport.stream(
                all.spliterator(), false)
                .map(x -> transformAlbum(x))
                .collect(Collectors.toList());
        return result;
    }

    private List<ArtistaDTO> generateArtistaDTPOist(Iterable<Artista> all) {
        List<ArtistaDTO> result = StreamSupport.stream(
                all.spliterator(), false)
                .map(x -> transformArtista(x))
                .collect(Collectors.toList());
        return result;
    }

    private AlbumDTO transformAlbum(Album a) {
        AlbumDTO dto = new AlbumDTO();
        dto.setId(a.getId());
        dto.setTitolo(a.getTitolo());

        return dto;
    }

    private ArtistaDTO transformArtista(Artista a) {
        ArtistaDTO dto = new ArtistaDTO();
        dto.setId(a.getId());
        dto.setNome(a.getNome());

        return dto;
    }
}
