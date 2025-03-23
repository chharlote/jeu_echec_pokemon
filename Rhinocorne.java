class Rhinocorne extends Pokemon{


public Rhinocorne(){
super(111,"Rhinocorne","Rhinocorne","SOL","ROCHE",80,85,95,25);
}


public Rhinocorne(String nomPoke){
super(111,"Rhinocorne",nomPoke,"SOL","ROCHE",80,85,95,25);
}


public String getEspece(){
return this.especePokemon;
}
}


