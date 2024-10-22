package fr.efrei.pokemon.repository;

import fr.efrei.pokemon.models.Combat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CombatRepository extends JpaRepository<Combat, String> {
}
