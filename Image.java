package project;

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
	
	// Create negative_image method
	
	// Create crop_image method respect inputs : l1, l2, c1, c2 

}
