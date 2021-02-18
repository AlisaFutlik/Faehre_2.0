package de.javakurs.faehre;

public abstract class Fahrzeug {

	// Attribute
	protected double gewichtFahrzeug;

	public Fahrzeug(double gewicht) {
		this.gewichtFahrzeug = gewicht;
	}

//	getter
	public double getGewicht() {
		return gewichtFahrzeug;
	}

//	abstrakte methoden werden in der subklasse �berschrieben
	public abstract double getLaenge();

	public abstract double getBreite();

	public abstract String getTyp();

}
