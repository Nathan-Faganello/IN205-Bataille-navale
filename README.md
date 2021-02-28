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
  
## Exercice 5

  Cet exercice a été assez long pour moi. En effet, la modification de tout le code afin que tout colle avec l'ajout de Shipstate et de Boolean a été fastidieux. De plus, dans le Board.print(), l'ordre des tests pour l'affichage du tableau de frappe ne collait pas (true, false puis null) ce qui me faisait une erreur que j'ai mis beaucoup de temps à détecter. 
  C'est également à ce moment que je me suis rendu compte que les méthodes implémentées précédemment provenant de IBoard pouvait générer des erreurs si les indices entrés étaient hors limite. J'ai donc remédié à ce problème en mettant en place des Exceptions.

##Exercice 6

Pas de difficultés particulières à coder cet exercice.
  
##Exercice 7

Il m'a fallu un peu de temps pour comprendre tout ce qu'il y avait dans BattleShipAI. Cependant, je n'ai pas créé l'énum Orientation dans AbstractShip mais dans Orientation.java. J'ai donc hésité entre reprendre tout mon code ou bien modifier BattleShipAI afin que cela marche. J'ai préféré modifié BattleShipAI.

Ensuite, mettre en place le TestGame a été un peu fastidieux mais pas très compliqué. Je me suis heurté cependant à un gros problème : de temps en temps, l'IA ne plaçait pas tous les bateaux sur la grille. Je me suis rendu compte alors seulement à cet instant que les conditions aux limites de Board.putShip() dans les cas NORTH et WEST n'était pas exacte ! Je les ai donc modifiées et tout est rentré dans l'ordre.

##Exercice 8 

  Les quelques lignes de code à ajouter dans Game.java ont été assez rapides à implémenter. Cependant, j'ai passé beaucoup de temps à débugger des petites erreurs de fonctionnement dans le jeu. Des fonctions codées dans les exercices précécents ont donc changé.
  Tout semble fonctionner. Cependant, alors que cela fonctionnait lors de mes tests pendant les exercices précédents, lors du passage au Game.java, mes messages d'erreurs liés au hit loupés ne s'affichent plus. Je n'ai pas réussi à résoudre le problème.


 
