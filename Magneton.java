class Magneton extends Pokemon{


public Magneton(){
super(82,"Magnéton","Magneton","ELECTRIK","SANS",50,60,95,70);
}


public Magneton(String nomPoke){
super(82,"Magnéton",nomPoke,"ELECTRIK","SANS",50,60,95,70);
}


public String getEspece(){
return this.especePokemon;
}
}


