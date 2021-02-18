package de.javakurs.faehre;

public class Person {
	
	private final double minGewicht = 40;
	private final double maxGewicht = 120;
	private double gewicht;

//	zuf�lliger Gewicht zwischen 40 und 120 wird direkt im Konstruktor generiert.  
	public Person() {
		double gewicht = FaehreUI.erzeugeZufallszahl(minGewicht, maxGewicht);
		this.gewicht = gewicht;
	}

	public double getGewicht() {
		return gewicht;
	}
}
