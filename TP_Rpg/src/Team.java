import java.util.List;

public class Team {
    List<Battler> battlers;
    //constructeur
    public Team(List<Battler> battlers) {
        this.battlers = battlers;
    }

    //fonction pour verifier si tous les gens d'une équipe sont morts
    public Boolean isLoose() {
        for (Battler b : battlers) {
            if (b.hp > 0) {
                return false;
            }
        }
        return true;
    }
    public List<Battler> getBattlers() {
        return battlers;
    }

}
