package project;

import java.util.ArrayList;
import java.util.List;

import spreadsheet_project.Terminal;

public class Image {
	
	// Déclaration et initialisation des attributs de la classe
	private String firstLine;
	private int width;
	private int height;
	private int colorScale;
	private String comment;
	private List<Segment> segmentTab; // Array list of segment which define the image 
	
	// Constructeur de la classe
	public Image() {
		setWidth(0);
		setHeight(0);
		setColorScale(0);
	}

	// Méthodes getter et setter permettant d'avoir accès aux attributs privés de la classe
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getColorScale() {
		return colorScale;
	}

	public void setColorScale(int colorScale) {
		this.colorScale = colorScale;
	}

	public String getFirstLine() {
		return firstLine;
	}

	public void setFirstLine(String firstLine) {
		this.firstLine = firstLine;
	}

	public List<Segment> getSegmentTab() {
		return segmentTab;
	}

	public void setSegmentTab(List<Segment> segmentTab) {
		this.segmentTab = segmentTab;
	}
	
	// Méthode pour assombrir les couleurs l'image par rapport à une couleur primaire choisie
	public void darken() {
		String color;
		Terminal.ecrireString("Choisissez la couleur primaire que vous voulez assombrir dans l'image rouge, vert ou bleu :"); 
		color = Terminal.lireString();
		//color = color.replace("\\r", "\r");
		//color = color.replace("\n", "");
		//System.out.println(color);
		//System.out.println(color.getClass());
    	if(color.charAt(0) == "rouge".charAt(0)) {
    		//System.out.println("in red");
			for(int i = 0; i < segmentTab.size(); i++) {
		    	Segment seg = new Segment();
		    	seg = segmentTab.get(i);
		    	if (seg.getRed()>seg.getGreen() && seg.getRed()>seg.getBlue()) {
		    		int newVal = this.colorScale - seg.getRed();
		    		seg.setRed(newVal + seg.getRed());
		    		seg.setGreen(newVal + seg.getGreen());
		    		seg.setBlue(newVal + seg.getBlue());
		    	}	    		
	    	}
		}
    	if(color.charAt(0) == "vert".charAt(0)) {
			for(int i = 0; i < segmentTab.size(); i++) {
		    	Segment seg = new Segment();
		    	seg = segmentTab.get(i);
		    	if (seg.getGreen()>seg.getRed() && seg.getGreen()>seg.getBlue()) {
		    		int newVal = this.colorScale - seg.getGreen();
		    		seg.setRed(newVal + seg.getRed());
		    		seg.setGreen(newVal + seg.getGreen());
		    		seg.setBlue(newVal + seg.getBlue());
		    	}	    		
	    	}
		}
    	if(color.charAt(0) == "bleu".charAt(0)) {
			for(int i = 0; i < segmentTab.size(); i++) {
		    	Segment seg = new Segment();
		    	seg = segmentTab.get(i);
		    	if (seg.getBlue()>seg.getRed() && seg.getBlue()>seg.getGreen()) {
		    		int newVal = this.colorScale - seg.getRed();
		    		seg.setRed(newVal + seg.getRed());
		    		seg.setGreen(newVal + seg.getGreen());
		    		seg.setBlue(newVal + seg.getBlue());
		    	}	    		
	    	}
		}
	}
	
	// Méthode pour éclaircir les couleurs l'image par rapport à une couleur primaire choisie
	public void lighten() {
			String color;
			Terminal.ecrireString("Choisissez la couleur primaire que vous voulez assombrir dans l'image rouge, vert ou bleu :"); 
			color = Terminal.lireString();
			//color = color.replace("\\r", "\r");
			//color = color.replace("\n", "");
			//System.out.println(color);
			//System.out.println(color.getClass());
	    	if(color.charAt(0) == "rouge".charAt(0)) {
	    		//System.out.println("in red");
				for(int i = 0; i < segmentTab.size(); i++) {
			    	Segment seg = new Segment();
			    	seg = segmentTab.get(i);
			    	if (seg.getRed()>seg.getGreen() && seg.getRed()>seg.getBlue()) {
			    		int newVal = this.colorScale - seg.getRed();
			    		seg.setRed(newVal + seg.getRed());
			    		seg.setGreen(newVal + seg.getGreen());
			    		seg.setBlue(newVal + seg.getBlue());
			    	}	    		
		    	}
			}
	    	if(color.charAt(0) == "vert".charAt(0)) {
				for(int i = 0; i < segmentTab.size(); i++) {
			    	Segment seg = new Segment();
			    	seg = segmentTab.get(i);
			    	if (seg.getGreen()>seg.getRed() && seg.getGreen()>seg.getBlue()) {
			    		int newVal = this.colorScale - seg.getGreen();
			    		seg.setRed(newVal + seg.getRed());
			    		seg.setGreen(newVal + seg.getGreen());
			    		seg.setBlue(newVal + seg.getBlue());
			    	}	    		
		    	}
			}
	    	if(color.charAt(0) == "bleu".charAt(0)) {
				for(int i = 0; i < segmentTab.size(); i++) {
			    	Segment seg = new Segment();
			    	seg = segmentTab.get(i);
			    	if (seg.getBlue()>seg.getRed() && seg.getBlue()>seg.getGreen()) {
			    		int newVal = this.colorScale - seg.getRed();
			    		seg.setRed(newVal + seg.getRed());
			    		seg.setGreen(newVal + seg.getGreen());
			    		seg.setBlue(newVal + seg.getBlue());
			    	}	    		
		    	}
			}
		}
	
	// Méthode pour transformer en noir et blanc les couleurs l'image par rapport à une couleur primaire choisie
	public void black_n_white() {
		for(int i = 0; i < segmentTab.size(); i++) {
	    	Segment seg = new Segment();
	    	seg = segmentTab.get(i);
    		int newVal = (seg.getRed()+seg.getGreen()+seg.getBlue())/3;
    		seg.setRed(newVal);
    		seg.setGreen(newVal);
    		seg.setBlue(newVal);		
    	}
	}
	
	// Méthode pour afficher la taille de l'image en nombre de pixels
	public void display_size() {
		System.out.println("la taille de l'image est : "+this.width+ " x "+this.height+ " pixels");
	}	
	
	// Méthode pour transformer les couleurs de l'image en son négatif
	public void negative() {
		for(int i = 0; i < segmentTab.size(); i++) {
	    	Segment seg = new Segment();
	    	seg = segmentTab.get(i);
    		int newVal = this.colorScale;
    		seg.setRed(newVal - seg.getRed());
    		seg.setGreen(newVal - seg.getGreen());
    		seg.setBlue(newVal - seg.getBlue());		
    	}
	}	
	
	// Méthode pour couper une partie de l'image entre ces 4 points l1, l2, c1, c2 
	public void cut_image() {
		String l1, l2, c1, c2;
		int l1_num, l2_num, c1_num, c2_num;
		Terminal.ecrireString("choisissez la valeur des lignes et des colonnes entre lesquels vous voulez découper l'image :"); 
		Terminal.ecrireString("l1 :");
		l1 = Terminal.lireString();
		l1_num = Integer.parseInt(l1); 
		Terminal.ecrireString("l2 :");
		l2 = Terminal.lireString();
		l2_num = Integer.parseInt(l2); 
		Terminal.ecrireString("c1 :");
		c1 = Terminal.lireString();
		c1_num = Integer.parseInt(c1); 
		Terminal.ecrireString("c2 :");
		c2 = Terminal.lireString();
		c2_num = Integer.parseInt(c2); 
		int colCount = 0;
		int rowCount = 0;
		int count = 0;
		boolean init = true;
		int redLast = 0;
		int greenLast = 0;
		int blueLast = 0;
		List<Segment> NewSegmentTab = new ArrayList<>();
		// Initialisation des variables last sur la première valeur de pixels entre les bornes
		for(int i = 0; i < segmentTab.size(); i++) {
			for(int j = 0; i < segmentTab.get(i).getCount(); i++) {
				if (c1_num<=colCount && colCount<=c2_num && l1_num<=rowCount && rowCount<=l2_num && init) {
					redLast = segmentTab.get(i).getRed();
					greenLast = segmentTab.get(i).getGreen();
					blueLast = segmentTab.get(i).getBlue();
					init = false;
					break;
				}
			}
		}	
		// On filtre les pixels qui sont entre les bornes demandées par l'utilisateur
		for(int i = 0; i < segmentTab.size(); i++) {
			for(int j = 0; i < segmentTab.get(i).getCount(); i++) {
				if (c1_num<=colCount && colCount<=c2_num && l1_num<=rowCount && rowCount<=l2_num) {
			    	Segment seg = new Segment();
			    	Segment segNew = new Segment();
			    	seg = segmentTab.get(i);
			    	count += 1;
			    	if(seg.getRed() != redLast || seg.getGreen() != greenLast || seg.getBlue() != blueLast) {
			    		segNew.setRed(redLast);
			    		segNew.setGreen(greenLast);
			    		segNew.setBlue(blueLast);
			    		NewSegmentTab.add(segNew);
			    		redLast = seg.getRed();
			    		greenLast = seg.getGreen();
			    		blueLast = seg.getBlue();
			    		count = 1;
			    	}
		    		
				}
				colCount += 1;
	    		if(colCount == this.getWidth()) {
	    			colCount = 0;
	    			rowCount +=1;
	    		}
			}
    	}
		this.segmentTab = NewSegmentTab;
	}

}
