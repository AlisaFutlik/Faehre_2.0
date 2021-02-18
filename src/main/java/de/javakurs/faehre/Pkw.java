package de.javakurs.faehre;

import java.util.ArrayList;

public class Pkw extends Fahrzeug {
	
	private String typ = "PKW";
	
	private double breite; 
	private double laenge; 
//	 laenge und breite liegen f�r alle Pkws in dem selben Wertebereich -> deswegen k�nnen sie direkt im Konstruktor erzeugt werden
	public Pkw(double gewichtPkw) {
		super(gewichtPkw);
		this.breite = Math.round(FaehreUI.erzeugeZufallszahl(2.0, 4.0));
		this.laenge = Math.round(FaehreUI.erzeugeZufallszahl(3.0, 7.0)); 
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



