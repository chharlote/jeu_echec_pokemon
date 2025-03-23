class Aeromite extends Pokemon{


public Aeromite(){
super(49,"Aéromite","Aeromite","INSECTE","POISON",70,65,60,90);
}


public Aeromite(String nomPoke){
super(49,"Aéromite",nomPoke,"INSECTE","POISON",70,65,60,90);
}


public String getEspece(){
return this.especePokemon;
}
}


