package br.com.gpaiva.animalservice.controllers;

import br.com.gpaiva.animalservice.entidades.Animal;
import br.com.gpaiva.animalservice.repositorios.AnimalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gerenciar animais.
 */
@RestController
@RequestMapping("/animais")
public class AnimalController {
    private AnimalRepository animalRepository;

    /**
     * Construtor que injeta o repositório de animais.
     *
     * @param animalRepository repositório de animais
     */
    public AnimalController(AnimalRepository animalRepository){
        this.animalRepository = animalRepository;
    }

    /**
     * Endpoint para buscar todos os animais, com filtro opcional por espécie.
     *
     * @param especie espécie do animal (opcional)
     * @return lista de animais
     */
    @GetMapping
    private List<Animal> findAll(@RequestParam(required = false) String especie){
        return animalRepository.findAll(especie);
    }

    /**
     * Endpoint para criar um novo animal.
     *
     * @param animal objeto Animal a ser criado
     * @return animal criado
     */
    @PostMapping
    private Animal create(@RequestBody Animal animal){
        return animalRepository.save(animal);
    }

    /**
     * Endpoint para buscar animais não adotados, com filtro opcional por espécie.
     *
     * @param especie espécie do animal (opcional)
     * @return lista de animais não adotados
     */
    @GetMapping("/not-adopted")
    private List<Animal> findNotAdopted(@RequestParam(required = false) String especie){
        return animalRepository.findNotAdopted(especie);
    }

    /**
     * Endpoint para buscar animais adotados, com filtro opcional por espécie.
     *
     * @param especie espécie do animal (opcional)
     * @return lista de animais adotados
     */
    @GetMapping("/adopted")
    private List<Animal> findAdopted(@RequestParam(required = false) String especie){
        return animalRepository.findAdopted(especie);
    }
}