package de.javakurs.faehre;

public class Motorrad extends Fahrzeug {

	private String typ = "Motorrad";
	private double breite;
	private double laenge;

	public Motorrad(double gewichtMotorrad) {
		super(gewichtMotorrad);
		this.breite = Math.round(FaehreUI.erzeugeZufallszahl(1.0, 3.0));
		this.laenge = Math.round(FaehreUI.erzeugeZufallszahl(1.5, 4.0));
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
