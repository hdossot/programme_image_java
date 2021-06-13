package project;

//import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;

public class LoadImage {
	public static void main( String [] args ){ 
		String nomFichier ;
		FileInputStream fichier ;
		int c;
		Terminal.ecrireString ("Entrez le nom du fichier à afficher :");
		nomFichier = Terminal.lireString();
		try{
			fichier = new FileInputStream(nomFichier);
			c = fichier.read(); 
			while ( c != -1){
				Terminal . ecrireChar((char)c);
				c = fichier.read();
			}
			fichier.close(); 
		}catch(FileNotFoundException ex){
			Terminal.ecrireStringln("Ce fichier n’existe pas"); 
		}catch(IOException exc){
			Terminal.ecrireStringln("Erreur d’ ́eentre−sortie"); 
		}
	}
}
