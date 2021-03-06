package com.dio_class.devweek.Controller;

import com.dio_class.devweek.Entity.Regiao;
import com.dio_class.devweek.Repository.RegiaoRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerRegiao {
    // (1) Attributes
    private final RegiaoRepo repository;

    // (2) Constructor
    public ControllerRegiao(RegiaoRepo repository) {
        this.repository = repository;
    }

    // (3) Methods

    // part A - GET
    @GetMapping("/regiao")
    public ResponseEntity<?> findAllRegioes() {
        try {
            List<Regiao> allRegioes = repository.findAll();
            if (allRegioes.isEmpty())
                System.out.println("Vazia");
            else
                System.out.println("Achou");
            return new ResponseEntity<>(allRegioes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/regiao/{id}")
    public ResponseEntity<?> getRegiaoById(@PathVariable Long id) {
        Optional<Regiao> regiaoEscolhidaOptional = repository.findById(id);
        if (regiaoEscolhidaOptional.isPresent()) {
            Regiao regiaoEscolhida = regiaoEscolhidaOptional.get();
            return new ResponseEntity<>(regiaoEscolhida, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // part B - POST
    @PostMapping("/regiao/add")
    public Regiao postRegiao(@RequestBody Regiao newRegiao) {
        return repository.save(newRegiao);
    }

    // part C - DELETE
    @DeleteMapping("/regiao/delete/{id}")
    public void deleteRegiao(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
