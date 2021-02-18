package de.javakurs.faehre;

public class Fahrrad extends Fahrzeug {
	
	private String typ = "Fahrrad";
	private double breite;
	private double laenge;
	
	public Fahrrad(double gewichtFahrrad) {
		super(gewichtFahrrad);
		this.breite = Math.round(FaehreUI.erzeugeZufallszahl(0.5, 1.5));
		this.laenge = Math.round(FaehreUI.erzeugeZufallszahl(1.0, 3.0)); 
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


