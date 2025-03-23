class Mystherbe extends Pokemon{


public Mystherbe(){
super(43,"Mystherbe","Mystherbe","PLANTE","POISON",45,50,55,30);
}


public Mystherbe(String nomPoke){
super(43,"Mystherbe",nomPoke,"PLANTE","POISON",45,50,55,30);
}


public String getEspece(){
return this.especePokemon;
}
}


