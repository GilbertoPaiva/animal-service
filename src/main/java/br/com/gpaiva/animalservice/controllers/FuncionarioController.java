package br.com.gpaiva.animalservice.controllers;

import br.com.gpaiva.animalservice.repositorios.FuncionarioRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Controlador REST para gerenciar funcionários.
 */
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    private FuncionarioRepository funcionarioRepository;

    /**
     * Construtor que injeta o repositório de funcionários.
     *
     * @param funcionarioRepository repositório de funcionários
     */
    public FuncionarioController(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    /**
     * Endpoint para contar o número de animais resgatados por cada funcionário em um intervalo de datas.
     *
     * @param startDate data de início do intervalo
     * @param endDate data de fim do intervalo
     * @return mapa com o nome do funcionário e a contagem de animais resgatados
     */
    @GetMapping("/rescue-count")
    private Map<String, Long> countAnimalsRescuedByEmployee(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate){
        List<Object[]> results = funcionarioRepository.countAnimalsRescuedByEmployee(startDate, endDate);
        return results.stream().collect(Collectors.toMap(
            result -> (String) result[0],
            result -> (Long) result[1]
        ));
    }
}