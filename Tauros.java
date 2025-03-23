class Tauros extends Pokemon{


public Tauros(){
super(128,"Tauros","Tauros","NORMAL","SANS",75,100,95,110);
}


public Tauros(String nomPoke){
super(128,"Tauros",nomPoke,"NORMAL","SANS",75,100,95,110);
}


public String getEspece(){
return this.especePokemon;
}
}


