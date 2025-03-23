class Bulbizarre extends Pokemon{


public Bulbizarre(){
super(1,"Bulbizarre","Bulbizarre","PLANTE","POISON",45,49,49,45);
}


public Bulbizarre(String nomPoke){
super(1,"Bulbizarre",nomPoke,"PLANTE","POISON",45,49,49,45);
}


public String getEspece(){
return this.especePokemon;
}
}


