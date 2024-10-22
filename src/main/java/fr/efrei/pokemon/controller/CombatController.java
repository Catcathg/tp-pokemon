package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.models.Combat;
import fr.efrei.pokemon.services.CombatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/combats")
public class CombatController {

    private final CombatService combatService;

    @Autowired
    public CombatController(CombatService combatService) {
        this.combatService = combatService;
    }

    // Démarrer un combat entre deux dresseurs
    @PostMapping("/demarrer")
    public ResponseEntity<String> demarrerCombat(@RequestBody CombatRequest combatRequest) {
        String result = combatService.demarrerCombat(combatRequest.getTrainer1Name(), combatRequest.getTrainer2Name());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Combat>> findAll() {
        List<Combat> combats = combatService.findAll();
        return new ResponseEntity<>(combats, HttpStatus.OK);
    }

    public static class CombatRequest {
        private String trainer1Name;
        private String trainer2Name;

        public String getTrainer1Name() {
            return trainer1Name;
        }

        public void setTrainer1Name(String trainer1Name) {
            this.trainer1Name = trainer1Name;
        }

        public String getTrainer2Name() {
            return trainer2Name;
        }

        public void setTrainer2Name(String trainer2Name) {
            this.trainer2Name = trainer2Name;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Combat combat = combatService.findById(id);
        if (combat == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        combatService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}