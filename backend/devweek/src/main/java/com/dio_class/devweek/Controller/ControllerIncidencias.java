package com.dio_class.devweek.Controller;

import com.dio_class.devweek.Entity.IncidenciaExame;
import com.dio_class.devweek.Repository.IncidenciaRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerIncidencias {
//    (1) Attributes
    private final IncidenciaRepo incRepository;

//    (2) Constructor
    public ControllerIncidencias(IncidenciaRepo incRepository) {
        this.incRepository = incRepository;
    }

//    (3) Methods

//    part A - GET
    @GetMapping("/incidencias")
    public ResponseEntity<List<IncidenciaExame>> findAllIncidencias() {
        List<IncidenciaExame> listaIncidencia = incRepository.findAll();
        if (listaIncidencia.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        return new ResponseEntity<>(listaIncidencia, HttpStatus.OK);
    }

    @GetMapping("/incidencias/{id}")
    public ResponseEntity<IncidenciaExame> findIncidenciasById(@PathVariable Long id){
        Optional<IncidenciaExame> incidenciaOptional = incRepository.findById(id);
        if (incidenciaOptional.isPresent()){
            IncidenciaExame incidenciaUnid = incidenciaOptional.get();
            return new ResponseEntity<>(incidenciaUnid, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    part B - POST
    @PostMapping("/incidencias/novo")
    public IncidenciaExame newIncidencia(@RequestBody IncidenciaExame newIncidencia) {
        return incRepository.save(newIncidencia);
    }

//    part C - DELETE
    @DeleteMapping("/incidencias/delete/{id}")
    public void deleteIncidencia(@PathVariable Long id) {
        incRepository.deleteById(id);
    }

}
