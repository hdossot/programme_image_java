package project;

public class Segment{
	// Déclaration et initialisation des attributs de la classe
	private int red;
	private int green;
	private int blue;
	private int count;

	// Méthodes getter et setter permettant d'avoir accès aux attributs privés de la classe
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

	public int getCount() {
		return count;
	}

	public void setCount(int pixelNum) {
		this.count = pixelNum;
	}
}

