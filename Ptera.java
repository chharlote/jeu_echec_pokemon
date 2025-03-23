class Ptera extends Pokemon{


public Ptera(){
super(142,"Ptéra","Ptera","ROCHE","VOL",80,105,65,130);
}


public Ptera(String nomPoke){
super(142,"Ptéra",nomPoke,"ROCHE","VOL",80,105,65,130);
}


public String getEspece(){
return this.especePokemon;
}
}


