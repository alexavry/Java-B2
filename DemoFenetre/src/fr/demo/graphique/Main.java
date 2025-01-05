package fr.demo.graphique;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        //creer une fenetre
        JFrame frame = new JFrame("Demo Graphique");
        //taille de la fenetre
        frame.setSize(800, 600);
        //le bouton fermer
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //contenu
        //on fait un panneau sous forme de grille
        JPanel panel = new JPanel(new GridLayout(2,1));
        frame.add(panel);

        JButton button = new JButton("Je veux devenir riche");

        //pour ajouter des éléments dans la fenetre, il faut que la fenetre ai au moins un layout pour gerer les positions
        frame.setLayout(new java.awt.FlowLayout());
        //ajouter le bouton dans le layout de la fenetre
        frame.add(button);
        //afficher la fenetre
        frame.setVisible(true);
    }
}