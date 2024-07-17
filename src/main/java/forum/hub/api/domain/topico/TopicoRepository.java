package forum.hub.api.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico,Long> {

        Optional<Object> findByTituloAndAutorAndMensagem(String titulo, String autor, String mensagem);
}
