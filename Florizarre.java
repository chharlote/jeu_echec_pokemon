class Florizarre extends Pokemon{


public Florizarre(){
super(3,"Florizarre","Florizarre","PLANTE","POISON",80,82,83,80);
}


public Florizarre(String nomPoke){
super(3,"Florizarre",nomPoke,"PLANTE","POISON",80,82,83,80);
}


public String getEspece(){
return this.especePokemon;
}
}


