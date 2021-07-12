package project;

import project.Liste.Liste_2.Maillon;

public class Liste_2 { /*Création de la classe liste chainée dynamique*/
    class Maillon{
        Object info; /*Information d'une donnée*/
        Maillon suiv; /*Information vers la donnée suivante*/
         
        /* Constructeur de la classe Maillon*/
        Maillon(Object i, Maillon s){
        info = i;
        suiv = s;
        }
    }
    protected Maillon premier;
    protected Maillon dernier;
    /* Constructeur de la classe Liste*/
    public  Liste_2(){
    	premier = null; /*On a pasencore créé de référence*/
    }
    
    /*Méthode qui teste si la liste est vide*/
    public boolean vide(){
    	return premier == null;
    }
    
    public void entree(Object i){
    	/*On créé un nouveau maillon maillon*/
    	Maillon p = new Maillon(i,null);
    	if (premier==null){
    		premier = p;
    	}
    	else{
    		dernier.suiv=p; /*On fait pointer l'ancien dernier maillon  sur le nouveau nouveau maillon*/
    	}
    	dernier=p; /*On change la référence de dernier sur le dernier maillon*/
    }
     
    public Object sortir()throws Exception{
    	if(vide()){
    		throw new Exception("Liste vide");
    	}
    	Maillon res = premier;
    	premier = premier.suiv;
    	return res;
    }
    
    public String toString(){
        String chaine="Ma chaîne est : ";
        for (Maillon p = premier; p!=null ; p=p.suiv){
            chaine=chaine +String.valueOf(p.info)+"|";
        }
        return  chaine;
    }
}

