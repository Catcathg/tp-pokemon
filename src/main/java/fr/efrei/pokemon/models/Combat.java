package fr.efrei.pokemon.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Combat {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String trainer1Name;
    private String trainer2Name;

    @OneToMany
    private List<Pokemon> trainer1Team;

    @OneToMany
    private List<Pokemon> trainer2Team;

    private int xpTotalTrainer1;
    private int xpTotalTrainer2;
    private String result;

    // Getters et Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public List<Pokemon> getTrainer1Team() {
        return trainer1Team;
    }

    public void setTrainer1Team(List<Pokemon> trainer1Team) {
        this.trainer1Team = trainer1Team;
    }

    public List<Pokemon> getTrainer2Team() {
        return trainer2Team;
    }

    public void setTrainer2Team(List<Pokemon> trainer2Team) {
        this.trainer2Team = trainer2Team;
    }

    public int getXpTotalTrainer1() {
        return xpTotalTrainer1;
    }

    public void setXpTotalTrainer1(int xpTotalTrainer1) {
        this.xpTotalTrainer1 = xpTotalTrainer1;
    }

    public int getXpTotalTrainer2() {
        return xpTotalTrainer2;
    }

    public void setXpTotalTrainer2(int xpTotalTrainer2) {
        this.xpTotalTrainer2 = xpTotalTrainer2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
