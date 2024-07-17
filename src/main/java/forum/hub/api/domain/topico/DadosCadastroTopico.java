package forum.hub.api.domain.topico;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        String status,
        @NotBlank
        String autor,
        @NotBlank
        String curso,
        String respostas) {
}
