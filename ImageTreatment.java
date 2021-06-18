package project;

import java.util.ArrayList;
import java.util.List;

import spreadsheet_project.Terminal;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//import java.io.DataInputStream;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.awt.Dimension;
//import java.awt.Image;
//import java.awt.Toolkit;
//import java.awt.image.BufferedImage;
//import java.awt.image.MemoryImageSource;
//import java.io.BufferedInputStream;
//import java.io.PrintWriter;
//import java.util.Scanner;
//import javax.imageio.ImageIO;
//import javax.swing.JFrame;

public class ImageTreatment {
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public static Image loadImage () {
    	// Variable initialization

		String nomFichier ;
		FileInputStream fichier ;
		String imagePath = "/Users/henry/Desktop/_NFA032/_projet/"; 
		int c;
		
        String[] stringTab;
        String[] newStringTab;
        List<Segment> segmentTab = new ArrayList<>();
        String line = "";
        Image image = new Image();

        int red=0;
        int green=0;
        int blue=0;
        int redLast =0;
        int greenLast=0;
        int blueLast=0;
		int count=0;
		
		
		Terminal.ecrireString ("Entrez le nom du chemin absolue vers le répertoire + le nom du fichier à enregister \n"
								+ "exemple /Users/XXX/Desktop/_NFA032/_projet/truc.ppm :");
		nomFichier = Terminal.lireString();
		try{
			fichier = new FileInputStream(imagePath+nomFichier);
			c = fichier.read(); 
			while ( c != -1){
				Terminal . ecrireChar((char)c);
				c = fichier.read();
			}
			fichier.close(); 
		}catch(FileNotFoundException ex){
			Terminal.ecrireStringln("Ce fichier n’existe pas"); 
		}catch(IOException exc){
			Terminal.ecrireStringln("Erreur d’entree−sortie"); 
		}
		
        try (	InputStream inputStream = new FileInputStream(imagePath+nomFichier);
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
           	
           	System.out.println("le fichier a été trouvé");
           	image.setFirstLine("P3");
           	// Read file by line and for each line clean from special char
               while ((line = bufferedReader.readLine()) != null) {
                   line = line.replaceAll("\\R", "");
                   line = line.replaceAll("^\\s+|\\s+$", "");
                   line = line.replace("\n", "");
                   
                   // Split the line in different parts separated by a space
                   stringTab = line.split("\\s+");
                   newStringTab = line.split("\\s+");
                   //System.out.println("longueur de la ligne : " + line.length());
                   
                   // For each line, check : 
                   
                   // if it's a comment line 
                   if (stringTab[0].charAt(0) == '#') {
                       System.out.println(" ligne commentaire : "+line);
                       image.setComment(line);
                   }
                   
                   // or if it's the line with dimension information
                   else if (stringTab[0].charAt(0) != '#' && stringTab.length == 2) {
                   	System.out.println("ligne avec Width : "+stringTab[0]);
                   	System.out.println("ligne avec Height : "+stringTab[1]);
                       image.setWidth(Integer.parseInt(stringTab[0]));
                       image.setHeight(Integer.parseInt(stringTab[1]));
                   }
                   
                   // or if it's the color scale information
                   else if (stringTab[0].charAt(0) != '#' && stringTab.length == 1 && isNumeric(stringTab[0])) {
                   	System.out.println("ligne avec échelle de couleur : "+stringTab[0]);
                   	   image.setColorScale(Integer.parseInt(stringTab[0]));
                       //break;
                   }
                   // or if it's the pixels information
                   else if (isNumeric(stringTab[0])){
                	   stringTab = line.split("  ");
                	   newStringTab = stringTab[0].split(" ");
                	   //redLast = Integer.parseInt(newStringTab[0]);
                	   //greenLast = Integer.parseInt(newStringTab[1]);
                	   //blueLast = Integer.parseInt(newStringTab[2]);
                       //seg.setRed(redLast);
                       //seg.setGreen(greenLast);
                       //seg.setBlue(blueLast);
	                   for (int i = 0; i < stringTab.length; i++) {	
	                	   if (stringTab[i] != "") {
	                		   //System.out.println(stringTab[i]);
	                		   newStringTab = stringTab[i].split(" ");
	                           red = Integer.parseInt(newStringTab[0]);
	                           green = Integer.parseInt(newStringTab[1]);
	                           blue = Integer.parseInt(newStringTab[2]);
	                           if(redLast == red && greenLast == green && blueLast == blue) {
	                        	   count+=1;
	                           }
	                           else {
	                        	   //System.out.println("change pixel color");
	                        	   //System.out.println(redLast);
	                        	   //System.out.println(greenLast);
	                        	   //System.out.println(blueLast);
	                        	   //System.out.println(count);
	                        	   if (count!=0) {
	                        		   Segment seg = new Segment();
	                        		   seg.setRed(redLast);
	                        		   seg.setGreen(greenLast);
	                        		   seg.setBlue(blueLast);
	                        		   seg.setCount(count);
	                        		   System.out.println(seg.getRed());
		                        	   System.out.println(seg.getGreen());
		                        	   System.out.println(seg.getBlue());
		                        	   System.out.println(seg.getCount());
		                        	   segmentTab.add(seg);
		                               redLast = red;
		                               greenLast = green;
		                               blueLast = blue;
		                               count = 1;
		                           }
	                        	   }
	                           }
	                       }
                   	
                   }
               }
               //System.out.println("change pixel color");
               Segment seg = new Segment();
        	   System.out.println(redLast);
        	   System.out.println(greenLast);
        	   System.out.println(blueLast);
        	   System.out.println(count);
        	   seg.setRed(redLast);
    		   seg.setGreen(greenLast);
    		   seg.setBlue(blueLast);
    		   seg.setCount(count);
    		   System.out.println(seg.getRed());
        	   System.out.println(seg.getGreen());
        	   System.out.println(seg.getBlue());
        	   System.out.println(seg.getCount());
        	   segmentTab.add(seg);
        	   image.setSegmentTab(segmentTab);
		}catch(FileNotFoundException ex){
			Terminal.ecrireStringln("Ce fichier n’existe pas"); 
		}catch(IOException exc){
			Terminal.ecrireStringln("Erreur d’ ́entree−sortie"); 
		}
		return image;
	}
	
	public static void saveImage (Image image) {
		String nomFichier;
		FileOutputStream fichier ;
		String aEcrire="";
		int count=0;
		String imagePath="/Users/henry/Desktop/_NFA032/_projet/";
		Terminal.ecrireString("Entrez le nom du chemin absolue vers le répertoire + le nom du fichier à enregister \n"
				+ "exemple /Users/XXX/Desktop/_NFA032/_projet/truc_2.ppm :"); 
		nomFichier = Terminal.lireString(); 
		try{
			aEcrire += image.getFirstLine()+"\n";
			aEcrire += image.getComment()+"\n";
			aEcrire += image.getWidth() + " " + image.getHeight()+"\n";
			aEcrire += image.getColorScale()+"\n";
			List<Segment> segmentTab = new ArrayList<>();
			segmentTab = image.getSegmentTab();
			fichier = new FileOutputStream(imagePath+nomFichier ); 
			System.out.println(segmentTab.size());
		    for(int i = 0; i < segmentTab.size(); i++) {
		    	Segment seg = new Segment();
		    	seg = segmentTab.get(i);
		    	//System.out.println(segmentTab.get(0).getRed());
		    	//System.out.println(segmentTab.get(1).getRed());
		    	//System.out.println(segmentTab.get(2).getRed());
		    	//System.out.println(seg.getRed());
	        	//System.out.println(seg.getGreen());
	        	//System.out.println(seg.getBlue());
		        for(int j = 0; j < seg.getCount(); j++){
		        	//System.out.println(seg.getRed());
		        	//System.out.println(seg.getGreen());
		        	//System.out.println(seg.getBlue());
		            aEcrire += seg.getRed()+" ";
		            aEcrire += seg.getGreen()+" ";
		            aEcrire += seg.getBlue()+"  ";
		            count+=1;
			        if(count == 4) {
			        	aEcrire += "\n";
			        	count=0;
			        }
		        }
		        if(count == 4) {
		        	aEcrire += "\n";
		        	count=0;
		        }
		    }
		    System.out.println("L'image a bien été enregistré dans le fichier "+nomFichier);
			//aEcrire = Terminal.lireString();
			for (int i = 0; i<aEcrire.length();i++){ 
				fichier.write(aEcrire.charAt(i));
			}
			fichier.write('\r'); fichier.write('\n'); 
			aEcrire = Terminal . lireString ();
			fichier.close(); 
		}catch(IOException exc){
			Terminal.ecrireStringln("Erreur d'entree−sortie"); 
		}
		
	}

    public static void main(String[] args){  
    	Image image = new Image();  	       
		image = loadImage();
		//System.out.println(image.getComment());
		image.darken("red");
		//image.darken("green");
		saveImage(image);
    }    
}
