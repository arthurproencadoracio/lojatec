package br.com.tecloja.api.repository;

import br.com.tecloja.api.model.Papel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PapelRepository extends JpaRepository<Papel, Long> {
    Optional<Papel> findByNome(String nome);
}
