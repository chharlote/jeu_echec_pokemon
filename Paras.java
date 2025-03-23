class Paras extends Pokemon{


public Paras(){
super(46,"Paras","Paras","INSECTE","PLANTE",35,70,55,25);
}


public Paras(String nomPoke){
super(46,"Paras",nomPoke,"INSECTE","PLANTE",35,70,55,25);
}


public String getEspece(){
return this.especePokemon;
}
}


