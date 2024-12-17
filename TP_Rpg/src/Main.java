import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Créer des combattants pour l'équipe du joueur
        Battler player1 = new Battler("Guerrier", 50, 10);
        Battler player2 = new Battler("Mage", 40, 15);
        Battler player3 = new Battler("Archer", 45, 12);

        // Créer des combattants pour l'équipe ennemie
        Battler enemy1 = new Battler("Orc", 60, 8);
        Battler enemy2 = new Battler("Gobelin", 30, 5);
        Battler enemy3 = new Battler("Troll", 70, 10);

        // Créer les équipes
        Team playerTeam = new Team(Arrays.asList(player1, player2, player3));
        Team enemyTeam = new Team(Arrays.asList(enemy1, enemy2, enemy3));

        // Lancer la partie
        Game game = new Game(playerTeam, enemyTeam);
        game.play();
        game.getWinnerTeam();
    }
}