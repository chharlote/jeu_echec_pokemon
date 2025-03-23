#!/bin/bash

fichierALire="pokedex_gen1.csv"

while read line
do
  nom_original=`echo $line | cut -d ";" -f 2`
  nom=`echo $line | cut -d ";" -f 2`
  nom=`echo $nom | sed 's/é/e/g'`
  nom=`echo $nom | sed 's/è/e/g'`
  nom=`echo $nom | sed 's/É/E/g'`
  nom=`echo $nom | sed 's/ê/e/g'`
  nom=`echo $nom | sed 's/É/E/g'`
  nom=`echo $nom | sed 's/♀/F/g'`
  nom=`echo $nom | sed 's/♂/M/g'`
  nom=`echo $nom | sed 's/\. /-/g'`

  echo "Suppression de "$nom_original". Suppression du fichier "$nom".java"
  
  fichierAEcrire=$nom".java"

  rm $fichierAEcrire
  
done < $fichierALire;
