package it.fulcri.musiclibrary.repositories;

import it.fulcri.musiclibrary.models.Canzone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanzoneRepository extends CrudRepository<Canzone, Long> {
}
