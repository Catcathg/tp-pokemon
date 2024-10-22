package fr.efrei.pokemon.repository;

import fr.efrei.pokemon.models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, String> {
}