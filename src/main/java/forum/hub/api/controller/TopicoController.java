package forum.hub.api.controller;

import forum.hub.api.domain.topico.*;
import forum.hub.api.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("topico")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional

    public ResponseEntity<String> cadastrar(@RequestBody @Valid DadosCadastroTopico dados){
        // Verificar se um tópico com o mesmo título e autor já existe
        if (repository.findByTituloAndAutorAndMensagem(dados.titulo(), dados.autor(), dados.mensagem()).isPresent()) {
            return ResponseEntity.status(409).body("Tópico com o mesmo título, autor e mensagem já existe.");
        }

        repository.save(new Topico(dados));
        return ResponseEntity.status(201).body("Tópico criado com sucesso.");
    }



    @GetMapping
    public List<DadosListagemTopico> listar() {
        return repository.findAll().stream().map(DadosListagemTopico::new).toList();
    }

    //listar um tópico específico
    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemTopicoEspecifico> listarPorId(@PathVariable Long id) {
        var topico = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico não encontrado"));

        return ResponseEntity.ok(new DadosListagemTopicoEspecifico(topico));
    }


    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoTopico dados){
        var topico = repository.getReferenceById(dados.id());
        topico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID não encontrado");
        }
                  repository.deleteById(id);
    }
}
