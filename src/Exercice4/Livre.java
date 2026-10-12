package Exercice4;


public class Livre extends Document {
    protected String auteur;
    protected int nbrPages;

    public Livre(String titre, String auteur, int nbrPages) {
        super(titre);
        this.auteur = auteur;
        this.nbrPages = nbrPages;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getNbrPages() {
        return nbrPages;
    }

    public void setNbrPages(int nbrPages) {
        this.nbrPages = nbrPages;
    }

    @Override
    public String toString() {
        return super.toString() + " Livre [auteur=" + auteur + ", nbrPages=" + nbrPages + "]";
    }
}