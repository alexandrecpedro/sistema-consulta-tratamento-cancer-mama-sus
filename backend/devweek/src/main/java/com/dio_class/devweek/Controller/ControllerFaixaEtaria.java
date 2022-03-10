package com.dio_class.devweek.Controller;

import com.dio_class.devweek.Entity.FaixaEtaria;
import com.dio_class.devweek.Repository.FaixaEtariaRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControllerFaixaEtaria {
//    (1) Attributes
    private final FaixaEtariaRepo frepository;

//    (2) Constructor
    public ControllerFaixaEtaria(FaixaEtariaRepo frepository) {
        this.frepository = frepository;
    }

//    (3) Methods

//    part A - GET
    @GetMapping("/faixaetaria")
    public ResponseEntity<?> findAllFaixaEtaria() {
        try{
            List<FaixaEtaria> lista = frepository.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/faixaetaria/{id}")
    public ResponseEntity<FaixaEtaria> findByIdFaixaEtaria(@PathVariable Long id){
        try{
            Optional<FaixaEtaria> unidOptional = frepository.findById(id);
            if (unidOptional.isPresent()){
                FaixaEtaria faixaEtariaUnid = unidOptional.get();
                return new ResponseEntity<>(faixaEtariaUnid, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    part B - POST
    @PostMapping("/faixaetaria/novo")
    public FaixaEtaria newFaixaEtaria(@RequestBody FaixaEtaria newFaixa) {
        return frepository.save(newFaixa);
    }

//    part C - DELETE
    @DeleteMapping("/faixaetaria/delete/{id}")
    public void deleteFaixaEtaria(@PathVariable Long id) {
        frepository.deleteById(id);
    }

}
