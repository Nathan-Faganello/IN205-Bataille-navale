# IN205-Bataille-navale

## Exerice 1 

  Je n'ai pas rencontré de difficulté particulière à la réalisation de ce premier exercice. Toutefois, je me suis rendu compte après coup d'un léger décalage entre les noms des colonnes et les cases du tableau. Je l'ai corrigé lors de l'exercice 3.
 
## Exercice 2

  Encore une fois, pas de difficulté particulière à créer les différentes classes et sous-classes. Cependant, j'ai eu des difficultés à comprendre comment marchait le système de package et j'ai donc mis du temps à réussir à bien utiliser l'arborescence que je voulais.
  
## Exercice 3
  
  Tout d'abord, j'ai décidé d'utiliser les entrées x, y de toutes les fonctions de sorte à ce que le x représente les abscisses (colonnes) et y les ordonnées (lignes).
  Pour cette exercice, j'ai rencontré diverses difficultés.
  La première a été de placer correctement les bateaux. En effet, il y avait des décalages entre l'entrée donnée et le placement (exemple : x=4 placait le bateau en E).
  La deuxieme a été l'utilisation des exceptions. En effet, j'ai eu du mal à retrouver mes repères et ne savait plus trop comment ni où les utiliser. 
 
## Exercice 4

  La modification de Player.java vient assez naturellement. Cependant, je me suis rendu compte à ce moment qu'il me fallait une variable pour savoir si un bateau avai été placé ou non lors de l'appel de putShip(). C'est donc à ce moment que j'ai décidé d'ajouter un attribut put à la classe AbstractShip afin d'avoir systèmatiquement cette information. De plus, la prise en compte du décalage des indices étant déja faite par InputHelper, il m'a fallu remodifier putShip() pour ne pas avoir de problème d'indices.
