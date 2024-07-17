package forum.hub.api.domain.topico;//package forum.hub.api.topico;

import java.time.LocalDateTime;

public record DadosListagemTopico(Long id, String titulo, String mensagem, LocalDateTime data_criacao){

    public DadosListagemTopico(Topico topico) {
        this(topico.getId(),topico.getTitulo(), topico.getMensagem(), topico.getData_criacao());
    }

}

//campos que quero devolver no front end
//public record DadosListagemTopico(Long id, String titulo, String mensagem, LocalDateTime data_criacao,  String status, String autor, String curso, String respostas){
//
//    public DadosListagemTopico(Topico topico) {
//        this(topico.getId(),topico.getTitulo(), topico.getMensagem(), topico.getData_criacao(), topico.getStatus(), topico.getAutor(), topico.getCurso(), topico.getRespostas());
//    }
//
// }