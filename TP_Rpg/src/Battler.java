public class Battler {
    public String name;
    public int hp;
    public int power;

    //constructeur
    public Battler(String name, int hp, int power) {
        this.name = name;
        this.hp = hp;
        this.power = power;
    }

    //fonction pour attaquer
    public void attack(Battler opponent) {
        System.out.println(this.name + " attaque " + opponent.name + " avec une puissance de " + this.power);
        opponent.looseHP(this.power);
    }
    //fonction qui fait perdre des hps
    public void looseHP(int amount) {
        this.hp += amount;
        System.out.println(this.name + " possede maintenat " + this.hp + " HP ");
    }
}
