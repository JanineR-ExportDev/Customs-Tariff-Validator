import java.util.HashMap;
import java.util.Scanner;

public class CustomsTariffValidator {
	
	private static HashMap<String, String> kapitelVerzeichnis = new HashMap<>();
	

	public static void main(String[] args) {
		initialisiereKapitel();
		
		Scanner meinScanner = new Scanner(System.in);
		System.out.println("Bitte geben Sie eine 8-stellige Warentarifnummer ein: ");
		
		String eingabe = meinScanner.nextLine();
		
			if (validateTariffNumber(eingabe)) {
			System.out.println("Gültiges Format.");
			String kapitelCode = eingabe.substring(0, 2);
			if(kapitelVerzeichnis.containsKey(kapitelCode)) {
				System.out.println("Kapitel : " + kapitelVerzeichnis.get(kapitelCode));
			
		} else {
			System.out.println("Kapitel " + kapitelCode + " ist im System noch nicht hinterlegt.");
		}
			} else {
				System.out.println("Fehler: Ungültiges Format (muss 8 Ziffern sein).");
		}
			meinScanner.close();
		}
	
	public static boolean validateTariffNumber(String number) {
		return number != null && number.length() == 8 && number.matches("[0-9]+");
	}

	
	private static void initialisiereKapitel() {
		kapitelVerzeichnis.put("01", "Lebende Tiere");
		kapitelVerzeichnis.put("84", "Kernreaktoren, Kessel, Maschinen und mechanische Geräte; Teile davon");
		kapitelVerzeichnis.put("85", "Elektrische Maschinen, Apparate und Elektrotechnik, Teile davon");
		kapitelVerzeichnis.put("90", "Optische, fotografische oder medizinische Instrumente");
	}

}

## 🛠 Geplante Verbesserungen (Roadmap)
Um das Tool noch praxistauglicher zu machen, sind folgende Erweiterungen geplant:

- [ ] **Grafische Oberfläche:** Umstieg von der Konsole auf eine benutzerfreundliche JavaFX-Oberfläche.
- [ ] **Externe Datenquelle:** Einlesen der Warenkapitel aus einer CSV-Datei oder Datenbank statt einer internen HashMap.
- [ ] **Erweiterte Validierung:** Prüfung auf 11-stellige Codenummern für den Import-Bereich.
- [ ] **API-Anbindung:** Testweise Anbindung an eine Zoll-Datenbank zur Live-Abfrage von Zollsätzen.
