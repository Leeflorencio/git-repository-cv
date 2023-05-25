package med.voll.api.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.DoubleStream;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    //Utilizamos dois parametros: o primeiro é a entidade trabalhada pelo repository > Medico
    // e a segunda é o tipo de do atributo chave primária da entidade > Long -id
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);
}
