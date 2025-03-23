class Insecateur extends Pokemon{


public Insecateur(){
super(123,"Insécateur","Insecateur","INSECTE","VOL",70,110,80,105);
}


public Insecateur(String nomPoke){
super(123,"Insécateur",nomPoke,"INSECTE","VOL",70,110,80,105);
}


public String getEspece(){
return this.especePokemon;
}
}


