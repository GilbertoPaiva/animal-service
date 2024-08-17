package br.com.gpaiva.animalservice.repositorios;

import br.com.gpaiva.animalservice.entidades.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repositório JPA para a entidade Animal.
 */
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    /**
     * Busca animais não adotados, com filtro opcional por espécie.
     *
     * @param especie espécie do animal (opcional)
     * @return lista de animais não adotados
     */
    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NULL AND (:especie IS NULL OR a.especie = :especie) ORDER BY a.dataEntrada")
    List<Animal> findNotAdopted(String especie);

    /**
     * Busca animais adotados, com filtro opcional por espécie.
     *
     * @param especie espécie do animal (opcional)
     * @return lista de animais adotados
     */
    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NOT NULL AND (:especie IS NULL OR a.especie = :especie)")
    List<Animal> findAdopted(String especie);

    /**
     * Busca todos os animais, com filtro opcional por espécie.
     *
     * @param especie espécie do animal (opcional)
     * @return lista de todos os animais
     */
    @Query("SELECT a FROM Animal a WHERE :especie IS NULL OR a.especie = :especie")
    List<Animal> findAll(String especie);
}