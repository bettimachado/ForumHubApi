package forum.hub.api.domain.topico;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name="topico")
@Getter
@NoArgsConstructor
@EqualsAndHashCode (of="id")
public class Topico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime data_criacao;
    private String status;
    private String autor;
    private String curso;
    private String respostas;

    public Topico(DadosCadastroTopico dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.data_criacao = LocalDateTime.now();
        this.status = dados.status();
        this.autor = dados.autor();
        this.curso = dados.curso();
        this.respostas = dados.respostas();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getStatus() {
        return status;
    }

    public String getAutor() {
        return autor;
    }

    public String getCurso() {
        return curso;
    }

    public Long getId() {
        return id;
    }

    public String getRespostas() {
        return respostas;
    }

    public LocalDateTime getData_criacao() {
        return data_criacao;
    }


    public void atualizarInformacoes(DadosAtualizacaoTopico dados) {
        if (dados.status() != null) {
            this.status = dados.status();
        }
        if (dados.respostas() != null)  {
            this.respostas = dados.respostas();
        }
    }
}
