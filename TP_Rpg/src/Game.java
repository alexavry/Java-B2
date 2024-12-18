public class Game {
    private Team playerTeam;
    private Team enemyTeam;

    // Constructeur
    public Game(Team playerTeam, Team enemyTeam) {
        this.playerTeam = playerTeam;
        this.enemyTeam = enemyTeam;
    }

    // Méthode pour jouer le combat
    public void play() {
        System.out.println("Début du combat !");
        while (!playerTeam.isLoose() && !enemyTeam.isLoose()) {
            for (Battler player : playerTeam.getBattlers()) {
                for (Battler enemy : enemyTeam.getBattlers()) {
                    if (!player.ilemort() && !enemy.ilemort()) {
                        player.attack(enemy);
                        if (enemy.ilemort()) break; // Si l'ennemi est KO, passer au suivant
                    }
                }
            }

            // Échange des rôles : l'ennemi attaque aussi
            for (Battler enemy : enemyTeam.getBattlers()) {
                for (Battler player : playerTeam.getBattlers()) {
                    if (!enemy.ilemort() && !player.ilemort()) {
                        enemy.attack(player);
                        if (player.ilemort()) break;
                    }
                }
            }
        }
    }

    // Méthode pour obtenir l'équipe gagnante
    public Team getWinnerTeam() {
        if (playerTeam.isLoose()) {
            System.out.println("L'équipe ennemie a gagné !");
            return enemyTeam;
        } else {
            System.out.println("L'équipe du joueur a gagné !");
            return playerTeam;
        }
    }
}