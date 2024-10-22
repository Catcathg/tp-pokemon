package fr.efrei.pokemon.services;

import fr.efrei.pokemon.models.Combat;
import fr.efrei.pokemon.models.Pokemon;
import fr.efrei.pokemon.models.Trainer;
import fr.efrei.pokemon.repository.CombatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CombatService {

    private final TrainerService trainerService;
    private final CombatRepository combatRepository;

    @Autowired
    public CombatService(TrainerService trainerService, CombatRepository combatRepository) {
        this.trainerService = trainerService;
        this.combatRepository = combatRepository;
    }

    // Démarrer un combat entre deux dresseurs
    public String demarrerCombat(String trainer1Name, String trainer2Name) {
        Trainer trainer1 = trainerService.findByName(trainer1Name);
        Trainer trainer2 = trainerService.findByName(trainer2Name);


        if (trainer1 == null || trainer2 == null) {
            throw new RuntimeException("Un ou plusieurs dresseurs non trouvés");
        }

        int xpTotalTrainer1 = calculerXpTotal(trainer1);
        int xpTotalTrainer2 = calculerXpTotal(trainer2);

        String result = determineWinner(xpTotalTrainer1, xpTotalTrainer2, trainer1Name, trainer2Name);

        Combat combat = new Combat();
        combat.setTrainer1Name(trainer1Name);
        combat.setTrainer2Name(trainer2Name);
        combat.setXpTotalTrainer1(xpTotalTrainer1);
        combat.setXpTotalTrainer2(xpTotalTrainer2);
        combat.setResult(result);

        combatRepository.save(combat);

        return result;
    }

    private int calculerXpTotal(Trainer trainer) {
        return trainer.getTeam().stream()
                .mapToInt(Pokemon::getXp)
                .sum();
    }

    private String determineWinner(int xp1, int xp2, String name1, String name2) {
        if (xp1 > xp2) {
            return name1 + " gagne !";
        } else if (xp1 < xp2) {
            return name2 + " gagne !";
        } else {
            return "Match nul !";
        }
    }

    public List<Combat> findAll() {
        return combatRepository.findAll();
    }

    public Combat findById(String id) {
        return combatRepository.findById(id).orElse(null);
    }

    public void delete(String id) {
        combatRepository.deleteById(id);
    }

}
