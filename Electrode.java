class Electrode extends Pokemon{


public Electrode(){
super(101,"Électrode","Electrode","ELECTRIK","SANS",60,50,70,140);
}


public Electrode(String nomPoke){
super(101,"Électrode",nomPoke,"ELECTRIK","SANS",60,50,70,140);
}


public String getEspece(){
return this.especePokemon;
}
}


