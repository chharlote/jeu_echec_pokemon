// GERME Charlotte TPA

import MG2D.*;
import MG2D.geometrie.*;
import java.util.ArrayList;
import java.awt.Font;



public class MainGraphique{



    public static void main(String[] args) {


        Fenetre fenetre;
        Rectangle entete;
        Souris souris, souris2;

        Plateau plateau;

        Ligne ligneVerticale, ligneHorizontale;

        Piece pieceChoisie;
        Piece piecesPlateau;

        Position  caseClic;

        int i,j,x1,y1, x2, y2;
        int tourJoueur, gagnant;
  
        ArrayList<Position> deplacementPossible, attaquePossible;
        Cercle cercleDeplacement, cercleAttaque;

        Texte  affichageTour, texteFin, quitterPlateau;
 
        Boolean partieFini, tourFini, clicDroit;

        Couleur couleurFin;

        
        fenetre = new Fenetre("Plateau", 900, 1100);
        entete = new Rectangle(Couleur.BLEU, new Point(0, 900), new Point(900, 1100), true);
        fenetre.ajouter(entete);

        souris = fenetre.getSouris();

        plateau = new Plateau();

        pieceChoisie =new Piece();

        tourJoueur = 2;
        gagnant =0;

        deplacementPossible = new ArrayList<Position>();
        attaquePossible = new ArrayList<Position>();

        affichageTour = new Texte();
        texteFin = new Texte();
        quitterPlateau = new Texte(Couleur.NOIR, "Clic droit pour quitter le plateau.", new Font("Calibri", Font.TYPE1_FONT, 20), new Point(200, 920));

        partieFini = false;
        tourFini = false;
        clicDroit = false;


        couleurFin = new Couleur();





        x1=0;
        x2=0;
            // création des lignes verticales du plateau
        for ( i = 0; i < 9; i++) {


            x1=x1+100;
            x2=x2+100;
            y1=0;
            y2=900;

            ligneVerticale = new Ligne(Couleur.NOIR, new Point(x1,y1), new Point(x2,y2));

            fenetre.ajouter(ligneVerticale);

                
        }

        y1=0;
        y2=0;

        // création des lignes horizontales du plateau
        for ( i = 0; i < 9; i++) {

            x1 = 0;
            x2 = 900;
            y1 = y1 + 100;
            y2 = y2 + 100;
        
            ligneHorizontale = new Ligne(Couleur.NOIR, new Point(x1,y1), new Point(x2,y2));
        
            fenetre.ajouter(ligneHorizontale);
        
        }


        // Affichage des pokemons et des pvs des pokemons du joueur 1
        for ( i = 0; i < plateau.getPiecesJoueur1().size(); i++) {
                    

            piecesPlateau = plateau.getPiecesJoueur1().get(i);


            affichagePV(plateau, fenetre, piecesPlateau,piecesPlateau.getPosition());
            fenetre.ajouter(piecesPlateau.getTexture()); 
 
            fenetre.rafraichir();

        }


        // Affichage des pokemons et des pvs des pokemons du joueur 2
        for ( i = 0; i < plateau.getPiecesJoueur2().size(); i++) {
            
            piecesPlateau = plateau.getPiecesJoueur2().get(i);

            affichagePV(plateau, fenetre, piecesPlateau,piecesPlateau.getPosition());
            fenetre.ajouter(piecesPlateau.getTexture()); 

            fenetre.rafraichir();


        }
        

        // la partie commence
        while (partieFini == false) {


            // met à jour le tour des joueurs
            if (tourJoueur ==1) {

                tourJoueur =2;
                
            }else{
                tourJoueur =1;
            }



            // mets à jour l'affichage du tour des joueurs
            if (tourJoueur == 1) {

                fenetre.supprimer(affichageTour);
                affichageTour = new Texte(Couleur.ROUGE, "Au joueur 1 de jouer", new Font("Calibri", Font.TYPE1_FONT, 50), new Point(450, 1000));
                
            }
            else{

                fenetre.supprimer(affichageTour);

                affichageTour = new Texte(Couleur.VERT, "Au joueur 2 de jouer", new Font("Calibri", Font.TYPE1_FONT, 50), new Point(450, 1000));

            }

            fenetre.ajouter(affichageTour);

            fenetre.rafraichir();




            tourFini = false;


            // tant que le tour d'un joueur n'est pas fini
            while ( tourFini == false ){
                // pause de 40ms
                try {
                    Thread.sleep(40);
                    }
                    catch (Exception e){}

                // quand clique gauche est cliqué, la couleur de la voiture se change en rouge
                if (souris.getClicGauche()) {

                    caseClic = clic(souris);


                    // pour supprimer les cercles du plateau quand il y a un clic gauche
                    suppressionCercle(plateau, fenetre, deplacementPossible, attaquePossible);

                
                    // quand un joueur fait un clique gauche sur une case avec un pokemon
                    if (plateau.getCase(caseClic) != null && plateau.getCase(caseClic).getJoueur() == tourJoueur){


                        pieceChoisie = new Piece(plateau.getCase(caseClic));

                        // récupération des déplacements possibles de la pièce cliquée
                        deplacementPossible= pieceChoisie.getDeplacementPossible(plateau);

                         // ajout des cercles de déplacement
                        for ( i = 0; i < deplacementPossible.size(); i++) {

                            cercleDeplacement = new Cercle(new Point(50+deplacementPossible.get(i).getX()*100,50+deplacementPossible.get(i).getY()*100), 50, false);
                            fenetre.ajouter(cercleDeplacement);

                        }

                        // récuépration des attaques possibles de la pièce cliquée
                        attaquePossible= pieceChoisie.getAttaquePossible(plateau);
                        
                        // ajout des cercles d'attauqe
                        for ( i = 0; i < attaquePossible.size(); i++) {

                            cercleAttaque = new Cercle(Couleur.ROUGE,new Point(50+attaquePossible.get(i).getX()*100,50+attaquePossible.get(i).getY()*100), 50, false);
                            fenetre.ajouter(cercleAttaque);

                        }
                        fenetre.rafraichir();
                       
                    

                        int choix =0;

                        while (choix !=1){
               
                            try {
                            Thread.sleep(1);
                            }
                            catch ( Exception e ){}
                        

                            // récupération du nouveau clic du joueur
                            caseClic = clic(souris);

                            // si le clic est un clic gauche
                            if(souris.getClicGauche()){


                                // si la case cliqué est vide 
                                if (plateau.getCase(caseClic) == null){

                                    // si la case cliqué se trouve parmis les déplacements possibles de la pièce
                                    for ( i = 0; i < deplacementPossible.size(); i++) {

                                        if(caseClic.equals(deplacementPossible.get(i))){


                                            // suppression des pvs sur la case actuelle
                                            suppressionPV(plateau, fenetre,pieceChoisie, pieceChoisie.getPosition());

                                            // déplacement de la pièce sur la case cliqué
                                            deplacementPokemon(pieceChoisie, caseClic);;
    
                                            // Affichage des PV du Pokémon sur sa nouvelle position
                                            affichagePV(plateau, fenetre,pieceChoisie, pieceChoisie.getPosition());
                                   
                                            tourFini =true;
                                        }

                                    }

                                }


                                // si la case cliqué contient une pièce
                                else if (plateau.getCase(caseClic) != null){

                                    // et si la case cliqué se trouve parmis les attaques possibles, il y a attaque
                                    for ( i = 0; i < attaquePossible.size(); i++) {

                                        if(caseClic.equals(attaquePossible.get(i))){


                                            // suppression de l'affichage des PVs des 2 Pokemons en combat
                                            suppressionPV(plateau, fenetre, pieceChoisie,pieceChoisie.getPosition());
                                            suppressionPV(plateau, fenetre, plateau.getCase(caseClic),plateau.getCase(caseClic).getPosition());
                                          
                                            // attaque de la pièce attaquante sur le pièce attaqué
                                            pieceChoisie.getPokemon().attaque(plateau.getCase(caseClic).getPokemon());

                                            // Affichage des PVs des 2 Pokemons en combat
                                            affichagePV(plateau, fenetre,pieceChoisie, pieceChoisie.getPosition());
                                            affichagePV(plateau, fenetre, plateau.getCase(caseClic),plateau.getCase(caseClic).getPosition());


                                            // la contre attaques est déjà dans la méthode attaque
                                            // exemple si ce n'était pas le cas :
                                            /*// si la pièce attaqué à toujours de la vie alors elle attaque aussi
                                            if (pieceChoisie.getPokemon().getPv() !=0 && plateau.getCase(caseClic).getPokemon().getPv()!=0){

                                                // suppression de l'affichage des PVs des 2 Pokemons en combat
                                                suppressionPV(plateau, fenetre, pieceChoisie,pieceChoisie.getPosition());                                    
                                                suppressionPV(plateau, fenetre, plateau.getCase(caseClic),plateau.getCase(caseClic).getPosition());

                                                // attaque de la pièce attaqué sur le pièce attaquante                                               
                                                plateau.getCase(caseClic).getPokemon().attaque(pieceChoisie.getPokemon());

                                                // Affichage des PVs des 2 Pokemons en combat
                                                affichagePV(plateau, fenetre,pieceChoisie, pieceChoisie.getPosition());
                                                affichagePV(plateau, fenetre, plateau.getCase(caseClic),plateau.getCase(caseClic).getPosition());

                                                tourFini =true;
                                            
                                            }*/

                                           
                                            // si l'un des pokémons n'a plus de pv, sa pièce est retiré du plateau        
                                            if(pieceChoisie.getPokemon().getPv() ==0 && plateau.getCase(caseClic).getPokemon().getPv()==0){

                                                // suppression des 2 pokemons
                                                suppressionPV(plateau, fenetre, pieceChoisie,pieceChoisie.getPosition());
                                                supprimerPiece(pieceChoisie, plateau, fenetre);

                                                suppressionPV(plateau, fenetre,plateau.getCase(caseClic), plateau.getCase(caseClic).getPosition());
                                                supprimerPiece(plateau.getCase(caseClic), plateau, fenetre);

                                                tourFini =true;
                                            }
                                            else if (pieceChoisie.getPokemon().getPv() ==0){

                                                // suppression du pokemon attaquant
                                                suppressionPV(plateau, fenetre, pieceChoisie,pieceChoisie.getPosition());
                                                supprimerPiece(pieceChoisie, plateau, fenetre);
                                                tourFini =true;



                                            }
                                            else if(plateau.getCase(caseClic).getPokemon().getPv()==0){

                                                // suppression du pokemon attaqué
                                                suppressionPV(plateau, fenetre,plateau.getCase(caseClic), plateau.getCase(caseClic).getPosition());
                                                supprimerPiece(plateau.getCase(caseClic), plateau, fenetre);

                                                // suppression de l'affichage des PVs du pokemon attaquant
                                                suppressionPV(plateau, fenetre, pieceChoisie,pieceChoisie.getPosition());

                                                deplacementPokemon(pieceChoisie, caseClic); // si la pièce attaquante bat la pièce attaqué alors elle prend sa place sur le plateau

                                                // Affichage des PVs du pokemon attaquant après déplacement
                                                affichagePV(plateau, fenetre,pieceChoisie, pieceChoisie.getPosition());

                                                tourFini =true;
                                            }else{
                                                tourFini =true;

                                            }
                                            

                                        }

                                    }

                                }
                        
                               
                                // suppression des divers cercles de déplacements et d'attaques
                                suppressionCercle(plateau, fenetre, deplacementPossible, attaquePossible);
                    
                                fenetre.rafraichir();
                                choix =1;



                    
                            }
                        }
                    
                    


 
                    }

                }   

            }

            
            
             /* Texte texteBloquée = new Texte(Couleur.NOIR, "Les 2 derniers pokemons ne pouront jamais se battre. Les 2 joueurs sont ex aequo !", new Font("Calibri", Font.TYPE1_FONT, 18), new Point(450, 1000));

                Boolean partieBloquée = false;

             if (plateau.getPiecesJoueur1().size()==1 && plateau.getPiecesJoueur2().size()==1) {
                
                System.out.println("non");
                Piece pieceTestJr1, pieceTestJr2;

                pieceTestJr1 = plateau.getPiecesJoueur1().get(0);
                pieceTestJr2 = plateau.getPiecesJoueur2().get(0);

                int pvAvant1, pvAvant2, pvApres1, pvApres2;
                pvAvant1 = pieceTestJr1.getPokemon().getPv();
                pvAvant2 = pieceTestJr2.getPokemon().getPv();

                pieceTestJr1.getPokemon().attaque(pieceTestJr2.getPokemon());
                //pieceTestJr2.getPokemon().attaque(pieceTestJr1.getPokemon());

                pvApres1 = pieceTestJr1.getPokemon().getPv();
                pvApres2 = pieceTestJr2.getPokemon().getPv();

                if (pvAvant1 == pvApres1 && pvAvant2 == pvApres2 && pvApres1 != 0 && pvApres2 != 0) {
                    
                    System.out.println("coucou");

                    partieBloquée =true;
                    partieFini=true;
                    fenetre.supprimer(affichageTour);

                    fenetre.ajouter(quitterPlateau);
                    fenetre.ajouter(texteBloquée);
                }



            }*/
          
            // si l'un des joueurs n'a plus de pièce alors la partie est finie
            if (plateau.getPiecesJoueur1().isEmpty()) {
                                    
    
                fenetre.supprimer(affichageTour);

                couleurFin = new Couleur(Couleur.VERT);

                gagnant = 2;
                partieFini=true;



            }
            else if(plateau.getPiecesJoueur2().isEmpty()){
            
                fenetre.supprimer(affichageTour);

                gagnant = 1;
                couleurFin = new Couleur(Couleur.ROUGE);
                partieFini=true;

            }


            texteFin = new Texte(couleurFin, "C'est le joueur "+gagnant+" qui remporte la partie !", new Font("Calibri", Font.TYPE1_FONT, 38), new Point(450, 1000));        
    
       
        }








        fenetre.supprimer(affichageTour);

        fenetre.ajouter(texteFin);
        fenetre.ajouter(quitterPlateau);
        


        // possibilité de quitter le plateau en faisant un clic droit
        if (partieFini == true) {

            souris2 = fenetre.getSouris();

            while ( clicDroit == false ){
                // pause de 40ms
                try {
                    Thread.sleep(40);
                    }
                    catch (Exception e){}
                

                    if (souris2.getClicDroit()) {
                        fenetre.fermer();
                        System. exit(0); 

                        clicDroit =true;
            
                    }
            }
            
        }
        
    
    }   
    
    
    




    // suppression d'un pièce du plateau
    // Paramtre : pieceAsupp qui est la pièce à supprimé, plateau qui est la plateau sur lequel se trouve la pièce 
    //et fenetre qui est la fenetre sur laquelle se trouve la plateau
    public static void supprimerPiece(Piece pieceAsupp, Plateau plateau, Fenetre fenetre){

        // suppression de la texture du pokemon
        fenetre.supprimer(pieceAsupp.getTexture());

        // supression de la pièce du plateau
        plateau.removePiece(pieceAsupp.getPosition());

        fenetre.rafraichir();





    }




    // déplacement d'une pièce
    // Paramètre : piece qui est la pièce qui se déplace et caseClic qui est la nouvelle case de la pièce
    public static void deplacementPokemon(Piece piece, Position caseClic){

        int newX, newY, ancienX, ancienY,dx, dy;

        // récuperation de la position avant déplacement
        ancienX = piece.getPosition().getX();
        ancienY = piece.getPosition().getY();

        // récuperation de la position de la case où la pièce est déplacée
        newX = caseClic.getX();
        newY = caseClic.getY();
        

        // calcul de la distance entre l'ancienne position et la nouvelle
        dx = (newX - ancienX)*100;
        dy = (newY - ancienY)*100;

        // mis à jour de la position de la pièce
        piece.getPosition().setX(newX);
        piece.getPosition().setY(newY);



        // affichage de la texture de la piece au nouvel emplacement
        piece.getTexture().translater(dx, dy);


    }



    // suppression pv des pokemons sur le plateau
    // Paramètre : plateau qui est le plateau sur lequel jouent les joueurs, fenetre qui est le fenetre où se trouve le plateau
    // piece qui est la pièce contenant les pvs à supprimer et position qui la position à laquelle sont supprimés les PVs
    public static void suppressionPV(Plateau plateau, Fenetre fenetre, Piece piece, Position position) {
   

        Couleur couleur = new Couleur();

        if (piece.getJoueur()==1) {
            
            couleur= new Couleur(Couleur.ROUGE);
        }
        else{
            couleur= new Couleur(Couleur.VERT);

        }
            int xPv = 85 + position.getX() * 100;
            int yPv = 85 + position.getY() * 100;
            Texte pvPoke = new Texte(couleur, String.valueOf(piece.getPokemon().getPv()), new Font("Calibri", Font.TYPE1_FONT, 20), new Point(xPv, yPv));
            fenetre.supprimer(pvPoke);
            fenetre.rafraichir();
        
    }



    // affichage pv des pokemons sur le plateau
    // Paramètre : plateau qui est le plateau sur lequel jouent les joueurs, fenetre qui est le fenetre où se trouve le plateau
    // piece qui est la pièce contenant les pvs à affciher et position qui la position à laquelle sont placés les PVs
    public static void affichagePV(Plateau plateau, Fenetre fenetre, Piece piece, Position position) {
     

        Couleur couleur = new Couleur();

        // atribution de la couleur du texte en fonction du joueur
        if (piece.getJoueur()==1) {
            
            couleur= new Couleur(Couleur.ROUGE);
        }
        else{
            couleur= new Couleur(Couleur.VERT);

        }

        
        // calcul des coordonnées des PVs
        int xPv = 85 + position.getX() * 100;
        int yPv = 85 + position.getY() * 100;

        // création et ajoutdu texte des PVs
        Texte pvPoke = new Texte(couleur, String.valueOf(piece.getPokemon().getPv()), new Font("Calibri", Font.TYPE1_FONT, 20), new Point(xPv, yPv));
        fenetre.ajouter(pvPoke);

        fenetre.rafraichir();
        
    }



    





    // récupération du clic fait pas un joueur
    // Paramètre : souris qui est la souris avec laquelle clique le joueur
    public static Position clic(Souris souris) {
        Point clicFenetre;
        Position caseClic;

        clicFenetre = new Point(souris.getPosition());

        caseClic = new Position(clicFenetre.getX()/100, clicFenetre.getY()/100);

        return caseClic;
    }


    // affichage des ronds et des cercles de déplacements et d'attaques
    // Paramètre : plateau qui est le plateau sur lequel jouent les joueurs, fenetre qui est le fenetre où se trouve le plateau
    // deplacementPossible qui cotient les déplacements possibles d'un pièce et attaquePossible qui contient les attaques possibles de la pièce.
    public static void affichageCercle(Plateau plateau, Fenetre fenetre, ArrayList<Position> deplacementPossible,ArrayList<Position> attaquePossible) {
        
        Cercle cercleDeplacement, cercleAttaque;
        int i;


        // ajout des cercles de déplacement
        for ( i = 0; i < deplacementPossible.size(); i++) {

            cercleDeplacement = new Cercle(new Point(50+deplacementPossible.get(i).getX()*100,50+deplacementPossible.get(i).getY()*100), 50, false);
            fenetre.ajouter(cercleDeplacement);
        }


        // ajout des cercles d'attauqe
        for ( i = 0; i < attaquePossible.size(); i++) {

            cercleAttaque = new Cercle(Couleur.ROUGE,new Point(50+attaquePossible.get(i).getX()*100,50+attaquePossible.get(i).getY()*100), 50, false);
            fenetre.ajouter(cercleAttaque);
        }
        fenetre.rafraichir();


    }


    // supression des ronds et des cercles de déplacement et d'attaque
    // Paramètre : plateau qui est le plateau sur lequel jouent les joueurs, fenetre qui est le fenetre où se trouve le plateau
    // deplacementPossible qui cotient les déplacements possibles d'un pièce et attaquePossible qui contient les attaques possibles de la pièce.
    public static void suppressionCercle(Plateau plateau, Fenetre fenetre, ArrayList<Position> deplacementPossible, ArrayList<Position> attaquePossible) {
        
        int i;
        Cercle cercleDeplacement, cercleAttaque;

        // suppression des cercles de déplacement
        for ( i = 0; i < deplacementPossible.size(); i++) {

            cercleDeplacement = new Cercle(new Point(50+deplacementPossible.get(i).getX()*100,50+deplacementPossible.get(i).getY()*100), 50, false);
            fenetre.supprimer(cercleDeplacement);
            fenetre.rafraichir();
        }

        // suppression des cercles d'attaque
        for ( i = 0; i < attaquePossible.size(); i++) {

            cercleAttaque = new Cercle(Couleur.ROUGE,new Point(50+attaquePossible.get(i).getX()*100,50+attaquePossible.get(i).getY()*100), 50, false);
            fenetre.supprimer(cercleAttaque);
            fenetre.rafraichir();
        }

    }

    
}

