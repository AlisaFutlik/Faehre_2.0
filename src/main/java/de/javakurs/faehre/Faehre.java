package de.javakurs.faehre;//Autor: Alisa Futlik
//Erstellungsdatum: 10.04.2020
//Teilaufgabe(b)

import java.util.ArrayList;
import java.util.HashMap;
import static java.lang.Math.*;

public class Faehre {

	// Nutzflaeche: (A=1 + F=6)*1000 = 7000
	private double nutzflaeche;

	// Nutzgewicht (1+6)*100000 = 700.000
	private double nutzgewicht;

	// Verwaltung Assoziationen
	private ArrayList<Fahrzeug> beladeneFahrzeuge = new ArrayList<>();

	// Konstruktor: eine Faehre mit festvorgegebenen Parametern wird erzeugt
	public Faehre() {
		this.nutzflaeche = 7000.0;
		this.nutzgewicht = 700000.0;
	}

	// Assoziationsoperationen
	public ArrayList<Fahrzeug> getBeladeneFahrzeuge() {
		return beladeneFahrzeuge;
	}

	// Operation zum Pruefen und Ausgabe von Flaeche und Gewicht der Faehre
	public HashMap<String, Double> pruefeVerbrauchteFlaecheGewicht() {
		double verbrauchteFlaeche = 0.0;
		double standFlaecheFahrzeug = 0.0;
		double verbrauchtesGewicht = 0.0;
		HashMap<String, Double> technischeDaten = new HashMap<String, Double>();

		for (Fahrzeug einFahrzeug : beladeneFahrzeuge) {

			standFlaecheFahrzeug = (einFahrzeug.getBreite() * einFahrzeug.getLaenge() * 1.5);
			verbrauchteFlaeche = verbrauchteFlaeche + standFlaecheFahrzeug;
			verbrauchtesGewicht = verbrauchtesGewicht + einFahrzeug.getGewicht();
		}
		technischeDaten.put("verbrauchteFlaeche", verbrauchteFlaeche);
		technischeDaten.put("verbrauchtesGewicht", verbrauchtesGewicht);
		return technischeDaten;
	}

	protected void ausgabeTechnischeDaten() {
		double verbrauchteFlaeche = round(pruefeVerbrauchteFlaecheGewicht().get("verbrauchteFlaeche"));
		double verbrauchtesGewicht = round(pruefeVerbrauchteFlaecheGewicht().get("verbrauchtesGewicht"));
		double durchschnittFlaeche = round(verbrauchteFlaeche / beladeneFahrzeuge.size());
		double durchschnittGewicht = round(verbrauchtesGewicht / beladeneFahrzeuge.size());
		double prognose = round((nutzflaeche - verbrauchteFlaeche) / durchschnittFlaeche);
//		 Ausgabe
		System.out.println(
				"Aktuelle Nutzflaeche: " + String.valueOf(verbrauchteFlaeche) + " m2\n"
						+ "Aktuelles Nutzgewicht: " + String.valueOf((int)verbrauchtesGewicht)
						+ " kg\n" + "Durchschnittliche Nutzflaeche: " + String.valueOf((int)durchschnittFlaeche) + " m2\n"
						+ "Durchschnittliches Nutzgewicht: " + String.valueOf((int)durchschnittGewicht) + " kg\n"
						+ "Anzahl Fahrzeuge (Prognose): " + String.valueOf((int)prognose) + "\n");
	}

//	getter fuer nutzflaeche und nutzgewicht, diese Parameter sind immer gleich
	public double getNutzflaeche() {
		return nutzflaeche;
	}
	
	public double getNutzgewicht() {
		return nutzgewicht;
	}

}