package de.javakurs.faehre;

import de.javakurs.faehre.Faehre;

import java.util.Random;

//Autor: Alisa Futlik
//Erstellungsdatum: 10.04.2020
//Teilaufgabe(c)
public class FaehreUI {

	private static Faehre faehre = new Faehre();

	public static void main(String arg[]) {
		int anzahlPkw = 0;
		int anzahlLkw = 0;
		int anzahlFahrrad = 0;
		int anzahlMotorrad = 0;

// Fl�che und Gewicht auf der F�hre die noch beladen werden k�nnen
		double verbliebenFlaeche = faehre.getNutzflaeche();
		double verbliebenesGewicht = faehre.getNutzgewicht();

//	Anzahl von FZ die auf die F�hre beladen werden sollen wird generiert
		int anzahlFahrzeuge = (int) erzeugeZufallszahl(0.0, 100.0);

//		in der Schleife wird ein Fahrzeug (Fahrzeugtyp ist dabei zuf�llig) generiert
		for (int i = 0; i < anzahlFahrzeuge; i++) {
			Fahrzeug einFahrzeug = generiereFahrzeug();
			String fahrzeugTyp = einFahrzeug.getTyp();

//		die Fahrzeuge werden nach dem fahrzeugTyp gez�hlt
			switch (fahrzeugTyp) {

			case "PKW":
				anzahlPkw++;
				break;
			case "LKW":
				anzahlLkw++;
				break;
			case "Fahrrad":
				anzahlFahrrad++;
				break;
			case "Motorrad":
				anzahlMotorrad++;
				break;
			default:
				System.out.println("Ein Fehler ist aufgetreten");

			}

//		der Fahrzeug wird auf die Faehre beladen
			faehre.getBeladeneFahrzeuge().add(einFahrzeug);
			double benoetigteFlaeche = faehre.pruefeVerbrauchteFlaecheGewicht().get("verbrauchteFlaeche");
			double benoetigtesGewicht = faehre.pruefeVerbrauchteFlaecheGewicht().get("verbrauchtesGewicht");

//		es wird �berpr�ft ob der Fahrzeug die Ladekapazit�t der F�hre nicht �berschreitet, falls ja, der Fahrzeug wird entfernt
			if (benoetigteFlaeche > verbliebenFlaeche) {
				faehre.getBeladeneFahrzeuge().remove(einFahrzeug);
				break;
				
			} else if (benoetigtesGewicht > verbliebenesGewicht) {
				faehre.getBeladeneFahrzeuge().remove(einFahrzeug);
				break;
			}
			verbliebenFlaeche = verbliebenFlaeche - benoetigteFlaeche;
			verbliebenesGewicht = verbliebenesGewicht - benoetigtesGewicht;

//		Ausgabe
			System.out.println("Beladene Fahrzeuge: " + anzahlLkw + "x Lkw / " + anzahlPkw + "x Pkw / "
					+ anzahlMotorrad + "x Motorrad / " + anzahlFahrrad + "x Fahrrad");
			faehre.ausgabeTechnischeDaten();
		}
	}

//	Methode die zuf�llig einen von vier m�glichen Fahrzeugtypen ausw�hlt, und einen Fahrzeug mit vorgegebenen Parametern dazu generiert
	private static Fahrzeug generiereFahrzeug() {
		Random fahrzeugTyp = new Random();
//		Zufallszahl zwischen 1 und 4 wird generiert
		int zufallszahl = 1 + fahrzeugTyp.nextInt(4);
		double gewichtAlleBeifahrer;// einschlie�lich Fahrer
		double gewichtGepaeck;
		double gewichtFahrzeug;
		double gewichtFahrer = erzeugeZufallszahl(40, 120);
		
		Fahrzeug fahrzeug = null;
		switch (zufallszahl) {
//	falls zufallszahl = 1 ->ein PKW wird erzeugt       
		case 1:
			gewichtAlleBeifahrer = initialisiereAnzahlUndGewichtBeifahrer(0, 3) + gewichtFahrer;// einschlie�lich Fahrer
			gewichtGepaeck =  initialisiereGepaeck(100.0, 300.0);
			gewichtFahrzeug = erzeugeZufallszahl(1000, 2800);

			Pkw einPkw = new Pkw(gewichtAlleBeifahrer + gewichtFahrzeug + gewichtGepaeck);
			fahrzeug = einPkw;
			break;
//			falls zufallszahl = 2 ->ein LKW wird erzeugt       
		case 2:
			gewichtAlleBeifahrer = initialisiereAnzahlUndGewichtBeifahrer(0, 2) + gewichtFahrer;// einschlie�lich Fahrer
			gewichtGepaeck = initialisiereGepaeck(500.0, 2000.0);
			gewichtFahrzeug = erzeugeZufallszahl(7500.0, 20000.0);
			
			Lkw einLkw = new Lkw(gewichtAlleBeifahrer + gewichtFahrzeug + gewichtGepaeck);
			fahrzeug = einLkw;
			break;
//			falls zufallszahl = 3 ->ein Motorrad wird erzeugt   
		case 3:
			gewichtAlleBeifahrer = initialisiereAnzahlUndGewichtBeifahrer(0, 1) + gewichtFahrer;// einschlie�lich Fahrer
			gewichtGepaeck =  initialisiereGepaeck(10.0, 50.0);
			gewichtFahrzeug = erzeugeZufallszahl(150.0, 400.0);
			
			Motorrad einMotorrad = new Motorrad(gewichtAlleBeifahrer + gewichtFahrzeug + gewichtGepaeck);
			fahrzeug = einMotorrad;
			break;
//			falls zufallszahl = 4 ->ein Fahrrad wird erzeugt
		case 4:
			gewichtAlleBeifahrer = gewichtFahrer;// einschlie�lich Fahrer
			gewichtGepaeck = (double) initialisiereGepaeck(1.0, 30.0);
			gewichtFahrzeug = erzeugeZufallszahl(5.0, 20.0);
			
			Fahrrad einFahrrad = new Fahrrad(gewichtAlleBeifahrer + gewichtFahrzeug + gewichtGepaeck);
			fahrzeug = einFahrrad;
			break;

		default:
			System.out.println("Ein Fahrzeug konnte nicht erzeugt werden");
		}

		return fahrzeug;
	}

	// Gepaeckstueck wird initialisiert
	public static double initialisiereGepaeck(double min, double max) {
		Gepaeck gepaeckstueck = new Gepaeck(min, max);
		return gepaeckstueck.getGewicht();
	}

//		eine zuf�llige Anzahl an beifahrern wird generiert und gesamtgewicht wird ermittelt
	public static double initialisiereAnzahlUndGewichtBeifahrer(int min, int max) {
		int anzahl = (int) erzeugeZufallszahl(min, max);
		double gewichtAlleBeifahrer = 0;
		int counter = 0;
		for (int i = 0; i <= anzahl; i++) {
			counter++;
			Person beifahrer = new Person();
			gewichtAlleBeifahrer = gewichtAlleBeifahrer + beifahrer.getGewicht();
		}
		return gewichtAlleBeifahrer;
	}

	// Methode, die zu einem �bergebenen Bereich (min, max) einen zuf�lligen
	// double-Wert liefert
	public static double erzeugeZufallszahl(double min, double max) {
		double wert;

		wert = min + (Math.random() * ((max - min) + 1));
		return wert;
	}
}
