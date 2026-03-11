#!/bin/bash
#! GERME Charlotte TPA

fichierALire="pokedex_gen1.csv"

#!mkdir -p pokemon

while read line
do
  numero=`echo $line | cut -d ";" -f 1`
  nom_original=`echo $line | cut -d ";" -f 2`
  nom=`echo $line | cut -d ";" -f 2`
  nom=`echo $nom | sed 's/é/e/g'`
  nom=`echo $nom | sed 's/è/e/g'`
  nom=`echo $nom | sed 's/É/E/g'`
  nom=`echo $nom | sed 's/ê/e/g'`
  nom=`echo $nom | sed 's/É/E/g'`
  nom=`echo $nom | sed 's/♀/F/g'`
  nom=`echo $nom | sed 's/♂/M/g'`
  nom=`echo $nom | sed 's/\. /_/g'`
  type1=`echo $line | cut -d ";" -f 3`
  type2=`echo $line | cut -d ";" -f 4`
  pv=`echo $line | cut -d ";" -f 5`
  force=`echo $line | cut -d ";" -f 6`
  defense=`echo $line | cut -d ";" -f 7`
  vitesse=`echo $line | cut -d ";" -f 8`

  echo "Traitement de "$nom_original". Création du fichier "$nom".java"
  
  #!fichierAEcrire="pokemon/$nom.java"
  fichierAEcrire="$nom.java"

  
  touch $fichierAEcrire  

  #! Si le pokemon n'a pas de type2 alors on met sans.
  if [ -z "$type2" ]; then

    type2="SANS"
  fi


  
  #! écriture de la classe de chaque pokemon
  echo 'class '$nom' extends Pokemon{' >> $fichierAEcrire

  echo '' >> $fichierAEcrire
  echo '' >> $fichierAEcrire
  echo 'public '$nom'(){' >> $fichierAEcrire
  echo 'super('$numero',"'$nom_original'","'$nom'","'${type1^^}'","'${type2^^}'",'$pv','$force','$defense','$vitesse');'>> $fichierAEcrire

  echo '}' >> $fichierAEcrire
  echo '' >> $fichierAEcrire
  echo '' >> $fichierAEcrire
  echo 'public '$nom'(String nomPoke){' >> $fichierAEcrire
  echo 'super('$numero',"'$nom_original'",nomPoke,"'${type1^^}'","'${type2^^}'",'$pv','$force','$defense','$vitesse');'>> $fichierAEcrire
  echo '}' >> $fichierAEcrire
  echo '' >> $fichierAEcrire
  echo '' >> $fichierAEcrire
  echo 'public String getEspece(){' >> $fichierAEcrire
  echo 'return this.especePokemon;' >> $fichierAEcrire
  echo '}' >> $fichierAEcrire

  echo '}' >> $fichierAEcrire
  echo '' >> $fichierAEcrire
  echo '' >> $fichierAEcrire
 


  

done < $fichierALire;
