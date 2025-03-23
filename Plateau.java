// GERME Charlotte TPA

import java.util.ArrayList;

public class Plateau {
    



    private ArrayList<Piece> tabp;


    // constructeur par défaut (c'était pas rigolo à faire)
    public Plateau(){
        tabp = new ArrayList<Piece>();

        // pokemon du joueur 1
        tabp.add(new Piece(new Salameche(), 1, "A1"));
        tabp.add(new Piece(new Salameche(), 1, "I1"));
        tabp.add(new Piece(new Carapuce(), 1, "B1"));
        tabp.add(new Piece(new Carapuce(), 1, "H1"));
        tabp.add(new Piece(new Bulbizarre(), 1, "C1"));
        tabp.add(new Piece(new Bulbizarre(), 1, "G1"));
        tabp.add(new Piece(new Nidoqueen(), 1, "D1"));
        tabp.add(new Piece(new Mewtwo(), 1, "E1"));
        tabp.add(new Piece(new Electhor(), 1, "F1"));
        tabp.add(new Piece(new Reptincel(), 1, "A2"));
        tabp.add(new Piece(new Reptincel(), 1, "I2"));
        tabp.add(new Piece(new Carabaffe(), 1, "B2"));
        tabp.add(new Piece(new Carabaffe(), 1, "H2"));
        tabp.add(new Piece(new Herbizarre(), 1, "C2"));
        tabp.add(new Piece(new Herbizarre(), 1, "G2"));
        tabp.add(new Piece(new Dracolosse(), 1, "D2"));
        tabp.add(new Piece(new Dracolosse(), 1, "F2"));
        tabp.add(new Piece(new Artikodin(), 1, "E2"));
        tabp.add(new Piece(new Dracaufeu(), 1, "D3"));
        tabp.add(new Piece(new Tortank(), 1, "E3"));
        tabp.add(new Piece(new Florizarre(), 1, "F3")); //20


        // pokemon du joueur2
        tabp.add(new Piece(new Salameche(), 2, "A9"));
        tabp.add(new Piece(new Salameche(), 2, "I9"));
        tabp.add(new Piece(new Carapuce(), 2, "B9"));
        tabp.add(new Piece(new Carapuce(), 2, "H9"));       
        tabp.add(new Piece(new Bulbizarre(), 2, "C9"));
        tabp.add(new Piece(new Bulbizarre(), 2, "G9"));
        tabp.add(new Piece(new Nidoqueen(), 2, "D9"));
        tabp.add(new Piece(new Mewtwo(), 2, "E9"));
        tabp.add(new Piece(new Electhor(), 2, "F9"));
        tabp.add(new Piece(new Reptincel(), 2, "A8"));
        tabp.add(new Piece(new Reptincel(), 2, "I8"));     
        tabp.add(new Piece(new Carabaffe(), 2, "B8"));
        tabp.add(new Piece(new Carabaffe(), 2, "H8"));
        tabp.add(new Piece(new Herbizarre(), 2, "C8"));
        tabp.add(new Piece(new Herbizarre(), 2, "G8"));      
        tabp.add(new Piece(new Dracolosse(), 2, "D8"));
        tabp.add(new Piece(new Dracolosse(), 2, "F8"));
        tabp.add(new Piece(new Artikodin(), 2, "E8"));
        tabp.add(new Piece(new Dracaufeu(), 2, "D7"));
        tabp.add(new Piece(new Tortank(), 2, "E7"));
        tabp.add(new Piece(new Florizarre(), 2, "F7"));


    }



    // Vérifie si une pièce est à une position donnée
    // Paramètre x et y qui forme la position de la piece sur le plateau
    // Retour : Une Piece si une piece est présente
    public Piece getCase(int x, int y ){


        for (Piece piece : tabp) {
            
            if (piece.getPosition().getX()==x && piece.getPosition().getY()==y){
                return piece;
            }
        }
        return null;

    }


    // Vérifie si une pièce est à une position donnée
    // Paramètre : Position qui est la position de la piece sur le plateau
    // Retour : Une Piece si une piece est présente
    public Piece getCase(Position p){

       return getCase(p.getX(),p.getY());
    }


    // Vérifie si une pièce est à une position donnée
    // Paramètre : Un string qui est la position de la piece sur le plateau
    // Retour : Une Piece si une piece est présente
    public Piece getCase(String pos){

        return getCase(new Position(pos));
    }



    // Liste des pokemons du joueur 1
    // Rrtour : un tableau dynamique avec les pièces du joueur 1
    public ArrayList<Piece> getPiecesJoueur1() {
        ArrayList<Piece> piecesjoueur1 = new ArrayList<Piece>();
    
        for (Piece piece : tabp) {
            if (piece.getJoueur() == 1) {
                piecesjoueur1.add(piece);
            }
        }
        return piecesjoueur1;
    }


     // Liste des pokemons du joueur 1
    // Rrtour : un tableau dynamique avec les pièces du joueur 2
    public ArrayList<Piece> getPiecesJoueur2(){

        ArrayList<Piece> piecesjoueur2 = new ArrayList<Piece>();

        for (Piece piece : tabp) {

            if (piece.getJoueur()==2){
                piecesjoueur2.add(piece);
            }
            
        }
        return piecesjoueur2;

    }


    // suppression d'un pièce du plateau
    // paramètre : position de la pièce
    public void removePiece(Position p){
        int i;

        for (i = tabp.size() - 1; i >= 0; i--) {

           // Piece piece = tabp.get(i);

            if (tabp.get(i).getPosition().equals(p)) {
                
                tabp.remove(i);
            }

        }



    }

    // Affichage des pièces sur le plateau
    public String toString(){

        String affichage = new String("");

        for (Piece piece : tabp) {
            affichage = affichage + (piece.getPokemon().getEspecePokemon()+ " du joueur " + piece.getJoueur()+ " en " + piece.getPosition());
        }

        return affichage;

    }



}
