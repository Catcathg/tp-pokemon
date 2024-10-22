package fr.efrei.pokemon.services;

import fr.efrei.pokemon.models.Objet;
import fr.efrei.pokemon.repository.ObjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjetService {

    private final ObjetRepository objetRepository;

    @Autowired
    public ObjetService(ObjetRepository objetRepository) {
        this.objetRepository = objetRepository;
    }

    public List<Objet> findAll() {
        return objetRepository.findAll();
    }

    public Objet findById(String id) {
        return objetRepository.findById(id).orElse(null);
    }

    public Objet create(Objet objet) {
        return objetRepository.save(objet);
    }

    public void delete(String id) {
        objetRepository.deleteById(id);
    }
}
