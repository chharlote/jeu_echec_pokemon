# Jeu d'Échecs Pokémon

Ce projet est un jeu d'échecs revisité utilisant l'univers des Pokémon. Il a été conçu en Java dans le cadre d'un projet de cours. 

Deux joueurs s'affrontent sur un plateau quadrillé (9x9) en contrôlant des équipes composées de Pokémon de la première génération (Dracaufeu, Tortank, Florizarre, Mewtwo, etc.).

## Fonctionnalités Principales

* **Combats et Points de Vie (PV)** : Contrairement aux échecs classiques, les pièces ont des points de vie (affichés directement sur le plateau). Lorsqu'un Pokémon attaque, les PV sont déduits en fonction du combat, et la pièce est retirée du plateau si ses PV tombent à 0.
* **Mouvements simplifiés** : Tous les Pokémon peuvent se déplacer ou attaquer d'une case dans n'importe quelle direction (haut, bas, gauche, droite, et diagonales), de manière similaire au Roi dans les échecs traditionnels.
* **Génération automatique du Pokédex** : Un script Bash (`genere_classes.sh`) permet de générer automatiquement les classes Java de tous les Pokémon à partir du fichier `pokedex_gen1.csv`, en extrayant leurs statistiques (PV, force, défense, vitesse et types).
* **Interface Graphique Personnalisée** : Le jeu utilise une bibliothèque graphique 2D (`MG2D`) pour gérer l'affichage de la fenêtre, des textures des Pokémon, et des actions de la souris.

## Comment jouer ?

### Lancement du jeu
Pour lancer une partie, vous devez compiler et exécuter la classe principale `MainGraphique`.

### Contrôles
* **Clic Gauche** : Permet de sélectionner un de vos Pokémon. Des cercles apparaîtront pour vous indiquer les déplacements (cercles noirs) et les attaques possibles (cercles rouges). Cliquez ensuite sur la case de destination pour valider votre action.
* **Clic Droit** : Une fois la partie terminée (lorsqu'un joueur n'a plus de Pokémon), faites un clic droit n'importe où sur le plateau pour fermer le jeu proprement.

## Architecture du Code

* `MainGraphique.java` : Le point d'entrée du jeu. Il gère la boucle principale du jeu, l'affichage de la grille, le tour par tour et les clics de la souris.
* `Plateau.java` : Initialise le plateau de jeu et place les équipes de chaque joueur sur les cases de départ.
* `Piece.java` : Gère la logique des pièces individuelles, y compris le calcul de leurs déplacements et attaques possibles sur la grille de 9x9.
* `genere_classes.sh` : Script de génération des classes des créatures à partir de la base de données CSV.
