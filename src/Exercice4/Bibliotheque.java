package Exercice4;

public class Bibliotheque {
    private int capacite;
    private Document[] documents;
    private int nb; // nombre de documents actuellement dans la bibliothèque

    public Bibliotheque(int capacite) {
        this.capacite = capacite;
        this.documents = new Document[capacite];
        this.nb = 0;
    }

    public void afficherDocuments() {
        if (nb == 0) {
            System.out.println("La bibliothèque est vide.");
        } else {
            for (int i = 0; i < nb; i++) {
                System.out.println(documents[i]);
            }
        }
    }

    public boolean ajouter(Document doc) {
        if (nb < capacite) {
            documents[nb] = doc;
            nb++;
            return true;
        }
        return false;
    }

    public boolean supprimer(Document doc) {
        for (int i = 0; i < nb; i++) {
            if (documents[i] == doc) {
                // on décale les documents vers la gauche
                for (int j = i; j < nb - 1; j++) {
                    documents[j] = documents[j + 1];
                }
                documents[nb - 1] = null;
                nb--;
                return true;
            }
        }
        return false;
    }

    public Document document(int numEnrg) {
        for (int i = 0; i < nb; i++) {
            if (documents[i].getNumEnreg() == numEnrg) {
                return documents[i];
            }
        }
        return null;
    }

    public void afficherAuteurs() {
        for (int i = 0; i < nb; i++) {
            if (documents[i] instanceof Livre) {
                Livre l = (Livre) documents[i];
                System.out.println(l.getAuteur());
            }
        }
    }
}
