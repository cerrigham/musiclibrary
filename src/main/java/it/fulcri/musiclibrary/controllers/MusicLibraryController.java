package it.fulcri.musiclibrary.controllers;

import it.fulcri.musiclibrary.dto.AlbumDTO;
import it.fulcri.musiclibrary.dto.ArtistaDTO;
import it.fulcri.musiclibrary.services.MusicLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MusicLibraryController {
    @Autowired
    MusicLibraryService service;

    @RequestMapping("/aggiungicanzone")
    public String aggiungiCanzone(
            @RequestParam(value = "titolo", required = true) String titolo,
            @RequestParam(value = "artista", required = true) String artista,
            @RequestParam(value = "album", required = true) String album
    ) {
        service.aggiungiCanzone(titolo, album, artista);
        return "templates/index.html";
    }

    @RequestMapping("/listaalbum")
    public List<AlbumDTO> listaAlbum(){
        return service.getListaAlbum();
    }

    @RequestMapping("/listaartisti")
    public List<ArtistaDTO> listaArtisti(){
        return service.getListaArtisti();
    }
}
