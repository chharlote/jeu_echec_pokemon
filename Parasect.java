class Parasect extends Pokemon{


public Parasect(){
super(47,"Parasect","Parasect","INSECTE","PLANTE",60,95,80,30);
}


public Parasect(String nomPoke){
super(47,"Parasect",nomPoke,"INSECTE","PLANTE",60,95,80,30);
}


public String getEspece(){
return this.especePokemon;
}
}


