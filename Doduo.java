class Doduo extends Pokemon{


public Doduo(){
super(84,"Doduo","Doduo","NORMAL","VOL",35,85,45,75);
}


public Doduo(String nomPoke){
super(84,"Doduo",nomPoke,"NORMAL","VOL",35,85,45,75);
}


public String getEspece(){
return this.especePokemon;
}
}


