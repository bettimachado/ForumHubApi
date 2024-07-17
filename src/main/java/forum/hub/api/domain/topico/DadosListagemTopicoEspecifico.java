package forum.hub.api.domain.topico;

import java.time.LocalDateTime;

public record DadosListagemTopicoEspecifico(Long id, String titulo, String mensagem, LocalDateTime data_criacao, String status, String autor, String curso, String respostas) {
    public DadosListagemTopicoEspecifico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getData_criacao(), topico.getStatus(), topico.getAutor(), topico.getCurso(), topico.getRespostas());
    }
}
 
