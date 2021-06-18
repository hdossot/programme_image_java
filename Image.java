package project;

import java.util.List;

import spreadsheet_project.Terminal;

public class Image {
	
	// Initialize attributs 
	private String firstLine;
	private int width;
	private int height;
	private int colorScale;
	private String comment;
	private List<Segment> segmentTab; // Array list of segment which define the image 
	
	// Constructor 
	public Image() {
		setWidth(0);
		setHeight(0);
		setColorScale(0);
	}

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

	public void setFirstSegment(Segment seg) {
		// TODO Auto-generated method stub
		
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
	
	// Create show_size method
	public void size() {
		System.out.println(width + "x" + height);
	}
	
	// Darken_image method
	public void darken() {
		String color;
		Terminal.ecrireString("Choisissez la couleur primaire que vous voulez assombrir : rouge, vert ou bleu"); 
		color = Terminal.lireString();
		//color = color.replace("\\r", "\r");
		//color = color.replace("\n", "");
		System.out.println(color);
		System.out.println(color.getClass());
    	if(color.charAt(0) == "rouge".charAt(0)) {
    		System.out.println("in red");
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
	
	// Lighten_image method
		public void lighten(String color) {
	    	if(color == "red") {
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
	    	if(color == "green") {
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
	    	if(color == "blue") {
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
	
	// Create black_n_white method
	
	// Create negative_image method
	
	// Create crop_image method respect inputs : l1, l2, c1, c2

}
