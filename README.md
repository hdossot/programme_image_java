# programme_image_java

Dans le cadre d'un projet, je suis entrain de réaliser un petit programme Java. 

Le but de ce programme est de lire une image PPM, de stocker ses données en mémoire sous forme de liste chainée et de faire des modifications sur la couleur et la taille de l'image. 

Vous trouverez dans ce repository : 
* le fichier "consigne-projet.pdf" qui explique en détail du projet 
* les fichiers de codes : "ImageTreament.java" -> code regroupant les traitements et la fonction main, "Image.java" -> classe permettant de définir l'objet Image (attributs, méthodes),  "Segment.java" -> classe permettant de définir l'objet Segment (attributs, méthodes), "LoadImage" -> classe permettant de charger l'image, "SaveImage" -> classe permettant de sauvegarder l'image, "Terminal.java" -> la classe permettant d'interagir facilement avec le terminal(le code a été réalisé et testé avec Eclipse)
* le fichier , le fichier, la fichier 
* l'image "truc.ppm" qui est utilisée par le programme 
* un dossier "image_ppm" avec des exemples d'autres images pour aller plus loin et faire des transformations dessus avec le programme

Les contraintes à utiliser pour faire ce projet sont les suivantes (les 2 premiers points sont les plus importants) : 

1. Structure de données : 
* Utilisation des listes chainées pour stocker les données en mémoire (liste chainée native pas de linkedlist ou de collection)
* Gestion des exceptions (throw, catch)
* Attention à la visibilité des méthodes et attributs (private à privilégier)
* utilisation des mots clés : @override, this
* utiliser une classe d'interface
* utiliser la récursivité dans une des fonctions du programme

2. Opérations/ fonction que doit réaliser le programme : 
* Foncer ou éclaircir toutes les couleurs ayant une dominante rouge, bleue, verte. La couleur dominante sur un pixel est celle qui a l'entier le plus grand sur le code RGB, exemple 10 5 6 a une dominante de rouge et si l'on veut foncer les couleurs à dominante de rouge, il faut ajouter un un nombre entier à chacun des 3 entiers décrivants la couleur. La couleur deviendra donc, par exemple : 14 9 10. En revanche 2 15 10 restera inchangée parce que cette couleur n'a pas une dominante rouge mais une dominante verte -> fonction à intégrer dans la classe image 
* Passer une image en noir et blanc, en utilisant les niveaux de gris. Les gris sont obtenus en donnant aux 3 nombres la valeur de la moyennne des 3 valeurs d'origine -> fonction à intégrer dans la classe image 
* Afficher la taille courante de l'image : largeur x longueur en nombre de pixels -> fonction à intégrer dans la classe pixel
* Découper et garder seulement une partie de l'image, entre l1 et l2 et les colonnes c1 et c2 (les valeurs l1, l2, c1, c2 sont précisées par l'utilisateur qui peut se baser sur le nombre de pixels en largeur et en longueur). Une variante simplifiée peut être de découper l'image entre les lignes l1 et l2 -> fonction à intégrer dans la classe pixel

3. Autres fonctions (pour aller plus loin) : 
* créer le négatifs d'une image : pour cela on change chaque couleur par son complémentaire
* élargir l'image
* foncer ou éclaircir les couleurs comprises dans une certaine plage de couleurs (caractérisées par des intervalles de couleurs primaires) 
* Agrandir ou rapetisser une image dans les deux dimensions
* Incruster dans l'image des rectangles d'une certaine couleur 
* Incruster une image sur un nouveau fond avec une couleur unie (par exemple blanc)

4. Interface : 
* Faire un menu proposant de lire une image contenue dans un fichier, d'écrire une image transformée dans un fichier et de réaliser différentes opérations
* Utiliser une classe d'interface pour limiter les accès au stricte nécessaire au niveau de ce menu 
