package de.javakurs.faehre;

public class Lkw extends Fahrzeug{
	
	private String typ = "LKW";
	private double breite; 
	private double laenge;

	//	 laenge und breite liegen f�r alle Lkws in dem selben Wertebereich -> deswegen k�nnen sie direkt im Konstruktor erzeugt werden
	public Lkw(double gewichtLkw) {
		super(gewichtLkw);
		this.breite = Math.round(FaehreUI.erzeugeZufallszahl(3.0, 4.5));
		this.laenge = Math.round(FaehreUI.erzeugeZufallszahl(8.0, 40.0)); 
	}

	@Override
	public String getTyp() {
		return typ;
	}

	@Override
	public double getLaenge() {
		return laenge;
	}

	@Override
	public double getBreite() {
		return breite;
	}
	
	
	
}
