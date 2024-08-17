package br.com.gpaiva.animalservice.repositorios;

import br.com.gpaiva.animalservice.entidades.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * Repositório JPA para a entidade Funcionario.
 */
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    /**
     * Conta o número de animais resgatados por cada funcionário em um intervalo de datas.
     *
     * @param startDate data de início do intervalo
     * @param endDate data de fim do intervalo
     * @return lista de objetos contendo o nome do funcionário e a contagem de animais resgatados
     */
    @Query("SELECT a.nomeRecebedor, COUNT(a) FROM Animal a WHERE a.dataEntrada BETWEEN :startDate AND :endDate GROUP BY a.nomeRecebedor")
    List<Object[]> countAnimalsRescuedByEmployee(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}