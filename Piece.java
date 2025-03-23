// GERME Charlotte TPA

import MG2D.*;
import MG2D.geometrie.*;
import java.util.ArrayList;
import java.awt.Font;


public class Piece {
    

    private Pokemon pokemon;
    private int joueur;
    private Position position;
    private Texture texture;
    //private Texte affichagePV;



    // Constructeir par défaut de Piece
    public Piece(){

        this.pokemon = new Nidoqueen();
        this.joueur = 1;
        this.position = new Position("A1");
        this.texture = new Texture("img/" + this.getPokemon().getNumPokemon() + ".png", new Point(5+this.getPosition().getX()*100, 5+this.getPosition().getY()*100), 90, 90);
        //this.affichagePV = new Texte(Couleur.NOIR, String.valueOf(this.getPokemon().getPv()), new Font("Calibri", Font.TYPE1_FONT, 20), new Point(85+this.getPosition().getX()*100, 85+this.getPosition().getY()*100));
    }

    // Constructeur par copie qui va copier une
    // Piece passee en parametre.
    public Piece(Piece p){

        this.pokemon=p.pokemon;
        this.joueur=p.joueur;
        this.position=p.position;
        this.texture = p.texture;

    }


    // Constructeur de Piece avec en paramètre le pokemon, le joueur et la position avec x et y
    public Piece(Pokemon poke, int joueur, int x, int y){
        this.pokemon=poke;
        this.joueur=joueur;
        this.position= new Position(x,y);
        this.texture = new Texture("img/" + this.getPokemon().getNumPokemon() + ".png", new Point(5+this.getPosition().getX()*100, 5+this.getPosition().getY()*100), 90, 90);

    }


    // Constructeur de Piece avec en paramètre le pokemon, le joueur et la position
    public Piece(Pokemon poke, int joueur, Position p){
        this.pokemon=poke;
        this.joueur=joueur;
        this.position= p;
        this.texture = new Texture("img/" + this.getPokemon().getNumPokemon() + ".png", new Point(5+this.getPosition().getX()*100, 5+this.getPosition().getY()*100), 90, 90);

    }


    // Constructeur de Piece avec en paramètre le pokemon, le joueur et la position
    public Piece(Pokemon poke, int joueur, String p){
        this.pokemon=poke;
        this.joueur=joueur;
        this.position= new Position(p);
        this.texture = new Texture("img/" + this.getPokemon().getNumPokemon() + ".png", new Point(5+this.getPosition().getX()*100, 5+this.getPosition().getY()*100), 90, 90);

    }


    // renvoie le nombre du joueur
    public int getJoueur(){

        return this.joueur;
    }
    
    // renvoie le Pokmeon
    public Pokemon getPokemon(){

        return this.pokemon;
    }


    // renvoie la Position
    public Position getPosition(){

        return this.position;
    }


    public Texture getTexture(){

        return this.texture;

    }

    /*public Texte getAffichagePV(){

        return this.affichagePV;
    }*/


    // met à jour le nombre du joueur
    public void setJoueur(int j){

        this.joueur =j;
    }

    // met à jour le pokemon de la piece
    public void setPokemon(Pokemon poke){

        this.pokemon = poke;
  
    }


    // met à jour la position de la piece
    public void setPosition(Position p){

        this.position=new Position(p);
    }


    // méthode equals
    public boolean equals(Object obj){

        if (obj == this){
            return true;
        }

        if (!(obj instanceof Piece)){
            return false;
        }

        Piece p = (Piece)obj;

        return(this.pokemon.equals(p.pokemon) && this.joueur ==p.joueur && this.position.equals(p.position));
    }


    // méthode toString
    public String toString(){

        return new String(this.pokemon.getEspece()+" du joueur "+this.getJoueur()+" en " + this.getPosition());
    }


    // Renvoie les déplacement possibles d'un pokemon.
    // Paramètre : plateau qui est le plateau sur lequel jouent les joueurs
    // Retout : ArrayListe "positionPossbles" qui contient tous les déplacements possibles
    public ArrayList<Position> getDeplacementPossible(Plateau plateau){



        ArrayList<Position> positionPossible = new ArrayList<Position>();

        int[] tabX = {-1,0,1,-1,1,-1,0,1}; // tableau contenant les X possibles
        int[] tabY = {1,1,1,0,0,-1,-1,-1}; // tableau contenant les Y possibles
         
        int testX;
        int testY;

        testX=0;
        testY=0;


        // pour toutes les posistions des tableaux
        for (int i = 0; i < tabX.length; i++) {

            testX = this.getPosition().getX()+ tabX[i]; // prend la nouvelle valeur de X
            testY = this.getPosition().getY()+ tabY[i]; // prend la nouvelle valeur de Y

            // Vérification si les nouveaux X et Y sont dans le plateau
            if (testX >= 0 && testX <=8 && testY >=0 && testY <=8) {

                // vérification si la case est bien vide
                if (plateau.getCase(testX, testY) == null){
    
                  // ajout dans le tebleau de la position possible
                  positionPossible.add(new Position(testX, testY));
        
                }
                
            }
            
        }


        return positionPossible;
    }



    // Renvoie les attaques possibles d'un pokemon.
    // Paramètre : plateau qui est le plateau sur lequel jouent les joueurs
    // Retout : ArrayListe "attaquePossbles" qui contient toutes les attaques possibles
    public ArrayList<Position> getAttaquePossible(Plateau plateau){

        ArrayList<Position> attaquePossible = new ArrayList<Position>();


        int[] tabX = {-1,0,1,-1,1,-1,0,1}; // tableau contenant les X possibles
        int[] tabY = {1,1,1,0,0,-1,-1,-1}; // tableau contenant les Y possibles
         
        int testX;
        int testY;

        testX=0;
        testY=0;


        // pour toutes les posistions des tableaux
        for (int i = 0; i < tabX.length; i++) {

            testX = this.getPosition().getX()+ tabX[i]; // prend la nouvelle valeur de X
            testY = this.getPosition().getY()+ tabY[i]; // prend la nouvelle valeur de Y

            // Vérification si les nouveaux X et Y sont dans le plateau
            if (testX >= 0 && testX <=8 && testY >=0 && testY <=8) {


                // vérification si la case n'est pas vide
                if (plateau.getCase(testX, testY) != null){

                // vérification si le pokemon appartient au joueur adversaire
                if (plateau.getCase(testX, testY).getJoueur() != this.getJoueur()){
    
                  // ajout dans le tebleau de la position possible
                  attaquePossible.add(new Position(testX, testY));
        
                }}
                
            }
            
        }


        return attaquePossible;
    }

      
}
