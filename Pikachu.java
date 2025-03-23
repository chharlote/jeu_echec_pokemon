class Pikachu extends Pokemon{


public Pikachu(){
super(25,"Pikachu","Pikachu","ELECTRIK","SANS",35,55,30,90);
}


public Pikachu(String nomPoke){
super(25,"Pikachu",nomPoke,"ELECTRIK","SANS",35,55,30,90);
}


public String getEspece(){
return this.especePokemon;
}
}


