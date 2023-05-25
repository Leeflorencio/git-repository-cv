package med.voll.api.controller;

import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
        //salvamos uma entidade do tipo medico com os parametros que estão vindo do Json no construtor do Medico
    }

    @GetMapping //metodo de leitura. não precisa do Transactional
    public Page<DadosListagemMedico> listar(Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new); //convertendo do medico para dadoslistagemmedico
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id()); //pegando os dados pela referencia do id
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}") //parametro dinamico dentro das chaves
    @Transactional
    public void excluir(@PathVariable Long id){ //variavel do caminho PathVariable
        var medico = repository.getReferenceById(id);
        medico.excluir(); //exclusao logica
    }
}
