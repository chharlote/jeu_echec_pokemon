// GERME Charlotte TPA

class Nidoqueen extends Pokemon{


    // Constructeur par défaut de Nidoqueen
    public Nidoqueen(){

        super(23,"Nidoqueen", "Nidoqueen", "POISON", "SOL", 90,82,87,75);
    }


    // Constructeur de Nidoqueen
    // Paramètre : nompoke = nom du pokemon
    public Nidoqueen(String nomPoke){

        super(23,"Nidoqueen", nomPoke, "POISON", "SOL", 90,82,87,75);
    }


    // retourne l'espèce du pokemon
    public String getEspece(){

        return this.especePokemon;
    }
    
}




