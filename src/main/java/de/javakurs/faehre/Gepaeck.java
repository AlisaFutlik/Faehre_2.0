package de.javakurs.faehre;

public class Gepaeck {
//	gibt an ob gepaeck mitgenommen oder nicht mitgenommen wird
	private boolean gepaeckMitgenommen = Math.random() < 0.5;

	private double gewicht;

//	falls gep�ck mitgenommen wird, wird die Menge durch zufall festgelegt, falls nicht wird das Gewicht auf null gesetzt
//	da im Gegensatz zur Person, sich hier die Min und Max in Abh�ngigikeit des Fahrzeugtyps unterscheiden -
//	 sollen sie beim Initialisieren des Objektes mitgeliefert werden   
	public Gepaeck(double minGewicht, double maxGewicht) {
		if (gepaeckMitgenommen) {
			this.gewicht =  FaehreUI.erzeugeZufallszahl(minGewicht, maxGewicht);
		} else {
			this.gewicht = 0;
		}
	}

	public boolean wirdGepaeckMitgrnommen() {
		return gepaeckMitgenommen;
	}

	public double getGewicht() {
		return gewicht;
	}
}
