package fr.efrei.pokemon.constants;

public enum Type {
    FEU(100), // XP de base pour le type Feu
    EAU(120), // XP de base pour le type Eau
    TERRE(110); // XP de base pour le type Terre

    private final int xp;

    Type(int xp) {
        this.xp = xp;
    }

    public int getXp() {
        return xp;
    }
}
