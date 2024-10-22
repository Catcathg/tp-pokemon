package fr.efrei.pokemon.repository;

import fr.efrei.pokemon.models.Objet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjetRepository extends JpaRepository<Objet,String> {

}