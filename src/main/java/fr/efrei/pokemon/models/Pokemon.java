package fr.efrei.pokemon.models;

import fr.efrei.pokemon.constants.Type;
import jakarta.persistence.*;

@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private int xp;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    public Pokemon() {

    }

    public Pokemon(String name, Type type) {
        this.name = name;
        this.type = type;
        this.xp = type.getXp();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
        this.xp = type.getXp();
    }

}
