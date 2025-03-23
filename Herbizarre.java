class Herbizarre extends Pokemon{


public Herbizarre(){
super(2,"Herbizarre","Herbizarre","PLANTE","POISON",60,62,63,60);
}


public Herbizarre(String nomPoke){
super(2,"Herbizarre",nomPoke,"PLANTE","POISON",60,62,63,60);
}


public String getEspece(){
return this.especePokemon;
}
}


