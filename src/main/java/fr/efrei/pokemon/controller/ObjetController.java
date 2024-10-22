package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.models.Objet;
import fr.efrei.pokemon.services.ObjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/objets")
public class ObjetController {

    private final ObjetService objetService;

    @Autowired
    public ObjetController(ObjetService objetService) {
        this.objetService = objetService;
    }

    @GetMapping
    public ResponseEntity<List<Objet>> findAll() {
        List<Objet> objets = objetService.findAll();
        return new ResponseEntity<>(objets, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Objet> findById(@PathVariable String id) {
        Objet objet = objetService.findById(id);
        if (objet == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(objet, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Objet> create(@RequestBody Objet objet) {
        Objet createdObjet = objetService.create(objet);
        return new ResponseEntity<>(createdObjet, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        Objet objet = objetService.findById(id);
        if (objet == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        objetService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
