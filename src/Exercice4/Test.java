package Exercice4;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Capacité de la bibliothèque : ");
        int n = Integer.parseInt(sc.nextLine());
        Bibliotheque b = new Bibliotheque(n);

        // deux documents au départ
        b.ajouter(new Roman("Les Miserables", "Victor Hugo", 1488, 120));
        b.ajouter(new Revue("Science et Vie", "Mars", 2024));

        int choix;
        do {
            System.out.println();
            System.out.println("1. Ajouter un document");
            System.out.println("2. Afficher les documents");
            System.out.println("3. Supprimer un document");
            System.out.println("4. Chercher un document");
            System.out.println("5. Afficher les auteurs");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = Integer.parseInt(sc.nextLine());

            if (choix == 1) {
                System.out.println("1. Roman  2. Manuel  3. Revue  4. Dictionnaire");
                System.out.print("Type : ");
                int type = Integer.parseInt(sc.nextLine());

                System.out.print("Titre : ");
                String titre = sc.nextLine();
                Document d = null;

                if (type == 1) {
                    System.out.print("Auteur : ");
                    String auteur = sc.nextLine();
                    System.out.print("Nombre de pages : ");
                    int pages = Integer.parseInt(sc.nextLine());
                    System.out.print("Prix : ");
                    double prix = Double.parseDouble(sc.nextLine());
                    d = new Roman(titre, auteur, pages, prix);
                } else if (type == 2) {
                    System.out.print("Auteur : ");
                    String auteur = sc.nextLine();
                    System.out.print("Nombre de pages : ");
                    int pages = Integer.parseInt(sc.nextLine());
                    System.out.print("Niveau : ");
                    String niveau = sc.nextLine();
                    d = new Manuel(titre, auteur, pages, niveau);
                } else if (type == 3) {
                    System.out.print("Mois : ");
                    String mois = sc.nextLine();
                    System.out.print("Année : ");
                    int annee = Integer.parseInt(sc.nextLine());
                    d = new Revue(titre, mois, annee);
                } else if (type == 4) {
                    System.out.print("Langue : ");
                    String langue = sc.nextLine();
                    d = new Dictionnaire(titre, langue);
                } else {
                    System.out.println("Type invalide");
                }

                if (d != null) {
                    if (b.ajouter(d)) {
                        System.out.println("Document ajouté.");
                    } else {
                        System.out.println("Bibliothèque pleine !");
                    }
                }

            } else if (choix == 2) {
                b.afficherDocuments();

            } else if (choix == 3) {
                System.out.print("Numéro d'enregistrement : ");
                int num = Integer.parseInt(sc.nextLine());
                Document d = b.document(num);
                if (d != null && b.supprimer(d)) {
                    System.out.println("Document supprimé.");
                } else {
                    System.out.println("Document introuvable.");
                }

            } else if (choix == 4) {
                System.out.print("Numéro d'enregistrement : ");
                int num = Integer.parseInt(sc.nextLine());
                Document d = b.document(num);
                if (d != null) {
                    System.out.println(d);
                } else {
                    System.out.println("Document introuvable.");
                }

            } else if (choix == 5) {
                b.afficherAuteurs();

            } else if (choix == 0) {
                System.out.println("Au revoir !");

            } else {
                System.out.println("Choix invalide.");
            }

        } while (choix != 0);
    }
}
