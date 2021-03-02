package it.fulcri.musiclibrary.repositories;

import it.fulcri.musiclibrary.models.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long>  {

    Album findByTitolo(String titolo);
}
