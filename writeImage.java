package project;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class writeImage {
	public static void main( String [] args ){
		String nomFichier;
		FileOutputStream fichier ;
		String aEcrire;
		Terminal.ecrireString("Entrez le nom du fichier"); 
		nomFichier = Terminal.lireString(); 
		Terminal.ecrireStringln("Entrez des lignes à enregistrer."); 
		Terminal.ecrireStringln("Tapez FIN lorsque vous avez fini."); 
		try{
			fichier = new FileOutputStream(nomFichier ); 
			aEcrire = Terminal.lireString();
			while (!aEcrire.equals("FIN")){
				for (int i = 0; i<aEcrire.length();i++){ 
					fichier.write(aEcrire.charAt(i));
				}
				fichier.write('\r'); fichier.write('\n'); 
				aEcrire = Terminal . lireString ();
			}
			fichier.close(); 
		}catch(IOException exc){
			Terminal.ecrireStringln("Erreur d'entree−sortie"); 
		}
	}
}
