package cl.uv.ici.arq.spotify.demo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.uv.ici.arq.spotify.demo.controller.entities.AuthorEntity;

@Repository("authorRepository")
public interface AuthorRepository extends JpaRepository<AuthorEntity, UUID> {

    @Query(value = "SELECT * FROM AUTHOR", nativeQuery=true)
    public List<AuthorEntity> getAll();
}
