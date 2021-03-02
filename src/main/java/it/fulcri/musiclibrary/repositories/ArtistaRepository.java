package it.fulcri.musiclibrary.repositories;

import it.fulcri.musiclibrary.models.Artista;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistaRepository extends CrudRepository<Artista, Long> {

    Artista findByNome(String nome);
}
