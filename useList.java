package project;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class ElementListe{
	private int valeur; 
	private ElementListe suivant;
	
	public ElementListe(int valeur, ElementListe suivant){ 
		this.valeur = valeur;
		this.suivant = suivant;
	} 
	/**
	*Crée un élément de liste sans successeur. *@param v
	*/
	public ElementListe(int v) { 
		this.valeur = v;
		this.suivant = null;
	}
	public int getValeur() { 
		return valeur;
	}
	public void setValeur(int valeur) { 
		this.valeur = valeur;
	}
	public ElementListe getSuivant() { 
		return suivant;
	}
	public void setSuivant(ElementListe suivant) { 
		this.suivant = suivant;
	}
}

class Liste { 
	ElementListe premier;
	ElementListe suivant;
	public boolean estVide() {
		return premier == null;
	}
	public ElementListe getPremier() {
		return premier;
	}
	public void ajouterAuDebut(int v) {
		ElementListe ancienPremier= premier; 
		premier= new ElementListe(v,ancienPremier);
	}
	
	public int getLongueur() {
		int longueur= 0;
		ElementListe ref= getPremier(); 
		while (ref != null) {
			longueur++;
			ref= ref.getSuivant(); 
		}
		return longueur;
		
	}
	
	public boolean contient(int v) {
		boolean trouve= false; ElementListe ref= getPremier(); 
		while (! trouve && ref != null) {
			if (ref.getValeur() ==v ) { 
				trouve= true;
			} else {
				ref= ref.getSuivant();
			} }
			// trouve est vrai implique donc ref.getValeur() ==v
			// autre test possible pour la boucle
			// while (ref != null && ref.getValeur() != v)
			// expliquer l’ordre des test dans ce cas.
			return trouve;
	}
	
	public void concatener(Liste l) { 
		if (this.estVide()) {
		this.premier= l.getPremier(); 
		} else {
			// On parcourt la liste jusqu’à être sur
			// le dernier élément, celui dont le suivant est null.
			ElementListe dernier= this.getPremier(); 
			while (dernier.getSuivant() != null) {
				dernier= dernier.getSuivant(); 
			}
			// Nous y sommes. dernier correspond au dernier élément
			// de la liste, qui existe car celle-ci n’est pas vide.
			// On fixe donc le suivant de ‘‘dernier’’ au premier
			// élément de la liste l.
			dernier.setSuivant(l.getPremier()); 
			}
	}
	
	public void ajouterALaFin(int v) { 
		if (estVide()) {
			premier= new ElementListe(v); 
		} else {
			// Il y a un dernier élément.
			// On le cherche et on ajoute après lui.
			ElementListe dernier = getDernierElement();
			// nous savons que
			// dernier.getSuivant() == null => dernier est bien le dernier élément. dernier.setSuivant(new ElementListe(v));
			} }
			/**
			*Trouve le dernier élément d’une liste non vide.
			*Lance une {@link NullPointerException} pour une liste vide. *@return le dernier élément d’une liste
			*@throws une NullPointerException si la liste est vide
			*/
		private ElementListe getDernierElement() {
			ElementListe dernier= premier; 
			while (dernier.getSuivant() != null) {
				dernier= dernier.getSuivant(); 
				}
			return dernier; 
			}
	
	public void retirerPremiereOccurrence(int v) {
		// On élimine le problème de la liste vide
		if (estVide()) {
			return;
		// Le but est de trouver l’élément qui précède v... // qui n’existe pas si v est la première valeur=> if (premier.getValeur() == v) {
		premier= premier.getSuivant(); 
		} else {
			ElementListe precedent= premier; 
			ElementListe elt= premier.getSuivant();
			while (elt != null && elt.getValeur() != v) {
				precedent= elt;
				elt= elt.getSuivant(); 
				}
			if (elt != null) {
			// L’élément a été trouvé
			// Plomberie: precedent.setSuivant(elt.getSuivant());
			}
		} 
		
}

public class useList {
	
    public static void main(String[] args){
        //Liste ListeChaine = new Liste();       
        //ListeChaine.entree("Test 1");
        //ListeChaine.entree("Test 22");
        //ListeChaine.entree("Test 33");
        //ListeChaine.entree("Test 4");
        //System.out.println(ListeChaine);
    	//Image image = new Image();
    	//image = loadImage();
    	//saveImage(image);
        try{
        	ElementListe element_1 = new ElementListe();
        	ElementListe element_2 = new ElementListe();
        	Liste listeChaine = new Liste();
        	int i;
        	for (i=0; i < 5; i++) {
        		element_1.setValeur(i);
        		element_1.setSuivant(element_2);
        	}
        	//ListeChaine.sortir();
        	//ListeChaine.sortir();
        }
        catch (Exception e)
        {
            //System.out.println(e.getMessage());
        }
        //System.out.println(ListeChaine);
    }

}
