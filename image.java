package Project;


import java.io.BufferedReader;
import java.io.FileInputStream;
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

class Segment{
	private int red=0;
	private int green=0;
	private int blue=0;
	private int [] dimension;

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}

	public void changeColor() {
		// Do operations in order to change pixel color
	}

	public void blackAndWhite() {
		// Do operations in order to transform image to black and white
	}

	public int[] getDimension() {
		// Do operations in order to display the dimension
		return dimension;
	}

	public int[] cutImage(int l1, int l2, int c1, int c2) {
		// Do operations in order to display the dimension
		return dimension;
	}
}

public class image {

    public static void main(String[] args){

    	// Variable initialization
        String path = "/Users/henry/Desktop/_NFA032/_projet/truc.ppm"; // fill path of the PPM image
        String[] stringTab;
        String[] newStringTab;
        String line = "";
        int red=0;
        int green=0;
        int blue=0;
		    String rgb="";

        // Read file
        try (InputStream inputStream = new FileInputStream(path);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

        	System.out.println("le fichier a été trouvé");

        	// Read file by line and for each line clean from special char
            while ((line = bufferedReader.readLine()) != null) {
                line = line.replaceAll("\\R", "");
                line = line.replaceAll("^\\s+|\\s+$", "");
                line = line.replace("\n", "");

                // Split the line in different parts separated by a space
                stringTab = line.split("\\s+");
                newStringTab = line.split("\\s+");
                System.out.println("longueur de la ligne : " + line.length());

                // For each line, check :

                // if it's a comment line
                if (stringTab[0].charAt(0) == '#') {
                    System.out.println(" ligne commentaire : "+line);
                    //this.comment = data;
                }

                // or if it's the line with dimension information
                else if (stringTab[0].charAt(0) != '#' && stringTab.length == 2) {
                	System.out.println("ligne avec Width : "+stringTab[0]);
                	System.out.println("ligne avec Height : "+stringTab[1]);
                    //this.width = Integer.parseInt(stringTab[0]);
                    //this.heigth = Integer.parseInt(stringTab[1]);
                }

                // or if it's the color scale information
                else if (stringTab[0].charAt(0) != '#' && stringTab.length == 1) {
                	System.out.println("ligne avec échelle de couleur : "+stringTab[0]);
                	//this.colorDepth = Integer.parseInt(stringTab[0]);
                    //break;
                }

                // or if it's the pixels information
                else {
                	for (int i = 0; i < stringTab.length; i++) {

                        if (stringTab[i] != "") {
                        	Segment seg = new Segment();
                        	rgb = stringTab[i];
                        	System.out.println(rgb);
                        	red = Character.getNumericValue(rgb.charAt(0));
                        	System.out.println(red);
                        	green = Character.getNumericValue(rgb.charAt(1));
                        	System.out.println(green);
                        	blue = Character.getNumericValue(rgb.charAt(2));
                        	System.out.println(blue);
                        	seg.setRed(red);
                            seg.setGreen(green);
                            seg.setBlue(blue);
                            red=seg.getRed();
                            green=seg.getGreen();
                            blue=seg.getBlue();
                            newStringTab[i] = ""+red+green+blue;
                            System.out.println(i + " : "+newStringTab[i]);
                        }
                    }

                }
            }
	    } catch (IOException e) {
	        System.out.println("Erreur : le fichier n'a pas été trouvé");
	    }

    }
}
