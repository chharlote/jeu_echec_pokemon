// GERME Charlotte TPA

public abstract class Pokemon {

    protected int numPokemon; // numéro du Pokemon dans le pokedex
    protected String especePokemon; 
    protected String nomPokemon;

    protected String type1;
    protected String type2;

    protected int pv;
    protected int attack;
    protected int defense;
    protected int speed;


    // instanciation du Pokemon de base
    public Pokemon() {

        this.numPokemon = 124;
        this.especePokemon = new String(Type.getEspece(this.numPokemon));
        this.nomPokemon = "Lipoupou";
        this.type1 = "GLACE";
        this.type2 = "PSY";
        this.pv = 65;
        this.attack = 50;
        this.defense = 35;
        this.speed = 95;

    }


    // instanciation d'un Pokemon avec des caractèristiques
    // Arguments : int numePokemon est le numéro du pokemon, String nomPokemon est le nom du Pokemon, int type1 est le type du pokemon, int type2 est le deuxième type du Pokemon, int pv est le nombre de pv, int attack est le nombre en attacque, int defense et le nombre de défence et int speed est la vitesse du Pokemon 
    public Pokemon(int numPokemon, String especePokemon, String nomPokemon, String type1, String type2, int pv, int attack, int defense, int speed) {

        this.numPokemon = numPokemon;
        this.especePokemon = especePokemon;
        this.nomPokemon = nomPokemon;
        this.type1 = type1;
        this.type2 = type2;
        this.pv = pv;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;

    }


    // permet de récupérer l'espèce du Pokemon
    public abstract String getEspece();

    // permet de récupérer le numéro du pokemon
    public int getNumPokemon() {

        return this.numPokemon;
    }

    // permet de récupérer l'espèce du pokemon
    public String getEspecePokemon() {

        return this.especePokemon;
    }

    // permet de récupérer le nom du pokemon
    public String getNomPokemon() {

        return this.nomPokemon;
    }

    // permet de récupérer le premier type du pokemon
    public String getType1() {

        return this.type1;
    }

    // permet de récupérer le deuxième type du pokemon
    public String getType2() {

        return this.type2;
    }

    // permet de récupérer le nombre de pv du pokemon
    public int getPv() {

        return this.pv;
    }

    // permet de récuperer le nombre d'attaque du pokemon
    public int getAttack() {

        return this.attack;
    }

    public int getDefense() {

        return this.defense;
    }

    // permet de récuperer le nombre de défense du pokemon
    public int getSpeed() {

        return this.speed;
    }

    // permet de mettre à jour le numéro du Pokemon
    // Paramètre : numPokemon qui est le numéro du Pokemon
    public void setNumPokemon(int numPokemon) {

        this.numPokemon = numPokemon;
    }

    // permet de mettre à jour l'espèce du Pokemon
    // Paramètre : especePokemon qui est l'espèce du Pokemon
    public void setEspecePokemon(String especePokemon) {

        this.especePokemon = especePokemon;
    }

    // permet de mettre à jour le nom du Pokemon
    // Paramètre : nomPokemon qui est le nom du Pokemon
    public void setNomPokemon(String nomPokemon) {

        this.nomPokemon = nomPokemon;

    }

    // permet de mettre à jour le premier type du Pokemon
    // Paramètre : type1 qui est le premier type du Pokemon
    public void setType1(String type1) {

        this.type1 = type1;

    }

    // permet de mettre à jour le deuxième type du Pokemon
    // Paramètre : type2 qui est le deuxième type du Pokemon
    public void setType2(String type2) {

        this.type2 = type2;
    }

    // permet de mettre à jour le nombre de pv du Pokemon
    // Paramètre : pv qui sont les pv du Pokemon
    public void setPv(int pv) {

        this.pv = pv;
    }

    // permet de mettre à jour le nom d'attaque du Pokemon
    // Paramètre : attack qui est le nombre d'attaque du Pokemon
    public void setAttack(int attack) {

        this.attack = attack;
    }

    // permet de mettre à jour le nom de defense du Pokemon
    // Paramètre : defense qui est le nombre de defense du Pokemon
    public void setDefense(int defense) {

        this.defense = defense;
    }

    // permet de mettre à jour le nom de defense du Pokemon
    // Paramètre : speed qui est le nombre de vitesse du Pokemon
    public void setSpeed(int speed) {

        this.speed = speed;

    }


    // méthode equals, comparaison de 2 Pokemon
    // Paramètre : PokeTest qui est le Pokemon a comparé
    // Retour : boolean : renvoit True si Pokemon ont le même état ou sinon False si états différents
    public boolean equals(Pokemon pokeTest) {

        if (this.numPokemon != pokeTest.numPokemon) {

            return false;
        }
        if (this.especePokemon.equalsIgnoreCase(pokeTest.especePokemon) == false) {
            return false;
        }
        if (this.nomPokemon.equalsIgnoreCase(pokeTest.nomPokemon) == false) {
            return false;
        }
        if (this.type1.equalsIgnoreCase(pokeTest.type1) == false) {
            return false;
        }
        if (this.type2.equalsIgnoreCase(pokeTest.type2) == false) {
            return false;
        }
        if (this.pv != pokeTest.pv) {
            return false;
        }
        if (this.attack != pokeTest.attack) {
            return false;
        }
        if (this.defense != pokeTest.defense) {
            return false;
        }
        if (this.speed!= pokeTest.speed){
            return false;
            
        }

        return true;

    }

    // Méthode To String
    public String toString() {

        return new String("Numéro : " + this.getNumPokemon() + "\nNom : " + this.getNomPokemon() + "\nEspèce : " + this.getEspece()+ "\nType 1 : " + this.getType1()
                + "\nType 2 : " + this.getType2() + "\nPV : " + this.getPv() + "\nAttaque :  " + this.getAttack() + "\nDéfense : " + this.getDefense() +"\nVitesse : " + this.getSpeed()+"\n");
    }



    // Permet de connaitre l'efficacité total de l'attaque d'un pokemon
    // Paramètre : adversaire, pokemon en défense 
    // Retourne : double = efficacité totale 
    public double attackEfficacite(Pokemon adversaire){

        double efficacite;

        efficacite=0;

        efficacite = Type.getEfficacite(Type.getIndiceType(this.type1), Type.getIndiceType(adversaire.type1));

        if (Type.getIndiceType(adversaire.type2) != 15) {

            efficacite = efficacite * (Type.getEfficacite(Type.getIndiceType(this.type1), Type.getIndiceType(adversaire.type2)));
        }

        return efficacite;
    }



    // Méthode Attaque, représente un tour de combat entre deux Pokémon, où le plus rapide attaque en premier.
    // Paramètre : adversaire - Pokémon adversaire à attaquer
    public void attaque(Pokemon adversaire){

        int damage;
        double efficacite;
    

        damage = 0;
        efficacite =0;


        if (this.speed >= adversaire.speed){

          



            // va chercher l'efficacité
            efficacite= this.attackEfficacite(adversaire);


            damage = (int) Math.round(this.getAttack()*efficacite-adversaire.getDefense());
        
            // si dommage inférieur à 0 alors on les mets à 0 pour ne pas avoir de problème
            if (damage<0) {
                damage=0;    
            }



            // met à jour les PVs du défenseur
            adversaire.setPv(adversaire.getPv() - damage);


            if (adversaire.getPv() >0) {




                efficacite= adversaire.attackEfficacite(this);

                damage = (int) Math.round(adversaire.getAttack()*efficacite-this.getDefense());

                if (damage<0) {
                    damage=0;    
                }

                this.setPv(this.getPv()-damage); 
                
            }
                   

        }
        else{
           
           
            efficacite= adversaire.attackEfficacite(this);


            damage = (int) Math.round(adversaire.getAttack()*efficacite-this.getDefense());


            if (damage<0) {
                damage=0;    
            }
     
            this.setPv(this.getPv()-damage);



            if (this.getPv() >0) {

                efficacite= this.attackEfficacite(adversaire);

                damage = (int) Math.round(this.getAttack()*efficacite-adversaire.getDefense());
                
                if (damage<0) {
                    damage=0;    
                }
                
                adversaire.setPv(adversaire.getPv() - damage);
                
            }
            
        }


        // si les PVs sont inférieur à 0, ils sont mis à 0 pour plus de logique
        if (this.getPv()<0) {
            this.setPv(0);
            }
        
        if (adversaire.getPv()<0){
            adversaire.setPv(0);
        }

    }


}


