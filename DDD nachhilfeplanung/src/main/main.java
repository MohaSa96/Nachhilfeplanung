package main;

import java.util.Scanner;

public class main {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Hauptmenü\n");		
		System.out.println("1-Anmeldung, Registrierung oder Daten ändern?" + "\n" + "2-Nachhilfeangebot und Nachhilfegesuch machen,aufgeben,sehen,matchen" + "\n3-Ende");

		int auswahl = Integer.parseInt(sc.nextLine());
		switch(auswahl) {
		
		case 1 : AnmeldungOderRegistrieurngOderDatenAenderung aor = new  AnmeldungOderRegistrieurngOderDatenAenderung(); aor.startDialog(); break;

		case 2 : NachhilfePlanungsDialog npd = new NachhilfePlanungsDialog(); npd.startDialog(); break;
		
		case 3 : System.out.println("Das Programme wurde beendet."); break;
	
	}
}
}
