package it.fulcri.musiclibrary;

import it.fulcri.musiclibrary.repositories.AlbumRepository;
import it.fulcri.musiclibrary.repositories.ArtistaRepository;
import it.fulcri.musiclibrary.repositories.CanzoneRepository;
import it.fulcri.musiclibrary.services.MusicLibraryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MusiclibraryApplicationTests {
	@Autowired
	MusicLibraryService service;
	@Autowired
	CanzoneRepository canzoneRepository;
	@Autowired
	AlbumRepository albumRepository;
	@Autowired
	ArtistaRepository artistaRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testCreaCanzone() {
		service.aggiungiCanzone("titolo 1", "album 1", "artista 1");
		service.aggiungiCanzone("titolo 2", "album 1", "artista 1");
		service.aggiungiCanzone("titolo 1", "album 2", "artista 2");
	}

}
