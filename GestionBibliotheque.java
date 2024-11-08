import java.util.ArrayList;
import java.util.Scanner;

class Livre {
    private String titre;
    private String auteur;
    private String isbn;

    // Constructeur
    public Livre(String titre, String auteur, String isbn) {
        this.titre = titre;
        this.auteur = auteur;
        this.isbn = isbn;
    }

    // Getters
    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getIsbn() {
        return isbn;
    }

    // Affichage du livre
    public void afficherDetails() {
        System.out.println("Titre: " + titre);
        System.out.println("Auteur: " + auteur);
        System.out.println("ISBN: " + isbn);
    }
}

class Bibliotheque {
    private ArrayList<Livre> livres;

    // Constructeur
    public Bibliotheque() {
        livres = new ArrayList<>();
    }

    // Ajouter un livre
    public void ajouterLivre(Livre livre) {
        livres.add(livre);
        System.out.println("Livre ajouté avec succès.");
    }

    // Supprimer un livre par ISBN
    public void supprimerLivre(String isbn) {
        for (int i = 0; i < livres.size(); i++) {
            if (livres.get(i).getIsbn().equals(isbn)) {
                livres.remove(i);
                System.out.println("Livre supprimé avec succès.");
                return;
            }
        }
        System.out.println("Livre non trouvé.");
    }

    // Afficher tous les livres
    public void afficherLivres() {
        if (livres.isEmpty()) {
            System.out.println("Aucun livre disponible.");
            return;
        }
        for (Livre livre : livres) {
            livre.afficherDetails();
            System.out.println("--------------");
        }
    }

    // Recherche par titre
    public void rechercherParTitre(String titre) {
        boolean trouve = false;
        for (Livre livre : livres) {
            if (livre.getTitre().toLowerCase().contains(titre.toLowerCase())) {
                livre.afficherDetails();
                System.out.println("--------------");
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Aucun livre trouvé avec ce titre.");
        }
    }

    // Recherche par auteur
    public void rechercherParAuteur(String auteur) {
        boolean trouve = false;
        for (Livre livre : livres) {
            if (livre.getAuteur().toLowerCase().contains(auteur.toLowerCase())) {
                livre.afficherDetails();
                System.out.println("--------------");
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Aucun livre trouvé de cet auteur.");
        }
    }
}

public class GestionBibliotheque {
    private static Scanner scanner = new Scanner(System.in);
    private static Bibliotheque bibliotheque = new Bibliotheque();

    public static void afficherMenu() {
        System.out.println("1. Ajouter un livre");
        System.out.println("2. Supprimer un livre");
        System.out.println("3. Afficher tous les livres");
        System.out.println("4. Rechercher un livre par titre");
        System.out.println("5. Rechercher un livre par auteur");
        System.out.println("6. Quitter");
    }

    public static void main(String[] args) {
        while (true) {
            afficherMenu();
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour à la ligne

            switch (choix) {
                case 1:
                    System.out.print("Entrez le titre du livre: ");
                    String titre = scanner.nextLine();
                    System.out.print("Entrez l'auteur du livre: ");
                    String auteur = scanner.nextLine();
                    System.out.print("Entrez l'ISBN du livre: ");
                    String isbn = scanner.nextLine();
                    Livre livre = new Livre(titre, auteur, isbn);
                    bibliotheque.ajouterLivre(livre);
                    break;

                case 2:
                    System.out.print("Entrez l'ISBN du livre à supprimer: ");
                    String isbnASupprimer = scanner.nextLine();
                    bibliotheque.supprimerLivre(isbnASupprimer);
                    break;

                case 3:
                    bibliotheque.afficherLivres();
                    break;

                case 4:
                    System.out.print("Entrez le titre à rechercher: ");
                    String titreRecherche = scanner.nextLine();
                    bibliotheque.rechercherParTitre(titreRecherche);
                    break;

                case 5:
                    System.out.print("Entrez l'auteur à rechercher: ");
                    String auteurRecherche = scanner.nextLine();
                    bibliotheque.rechercherParAuteur(auteurRecherche);
                    break;

                case 6:
                    System.out.println("Au revoir!");
                    return;

                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }
}
