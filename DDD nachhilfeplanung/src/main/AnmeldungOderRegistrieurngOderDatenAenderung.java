package main;

import java.util.InputMismatchException;
import java.util.Scanner;
import infrastructure.datastore.anmeldung.AnmeldungInfrastructurFactory;
import services.anmeldung.core.Schueler;
import services.anmeldung.ports.primary.LehrerTO;
import services.anmeldung.ports.primary.SchuelerTO;


public class AnmeldungOderRegistrieurngOderDatenAenderung {
	
	public void startDialog() {
		
		 Scanner sc = new Scanner (System.in);
	
    int auswahl = 0;

do {
	
	
	System.out.println("was möchten Sie tun?");	

	System.out.println("\n1-registrieren"+"\n2-anmelden"+"\n3-Daten ändern" + "\n4-Ende");

	try {
		System.out.println("\nAuswahl: "); 
		auswahl = sc.nextInt(); 
		
		
	}catch(InputMismatchException e) {
		
		auswahl = 0;
		sc.next();
	}
	
switch (auswahl){
	
case 1 :startRegistrierungsDialog(); break;
	
case 2 :startAnmeldungsDialog();break;

case 3 :startDatenAenderungsDialog();break;
	
case 4 :System.out.println("\ndas Progamm wurde beendet");break;

default : System.out.println("\n ungültige Eingabe");break;

}

} while(auswahl!=4);
			
	}
	
	

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	

	
public void startRegistrierungsDialog() {
	
	Scanner sc1 = new Scanner(System.in);
	
	int auswahl;
	
	System.out.println("\nSind Sie Schüler oder Lehrer?");
	
	System.out.println("\n1-Schüler "+"\n"+"2-Lehrer"+"\n"+"3-Zurück");
	
	auswahl = Integer.parseInt(sc1.nextLine());
	
	switch(auswahl) {
	
	
	case 1 : 
		
		Scanner sc2 = new Scanner(System.in);
		
		String abbruch = "x" ;
		
		String schulerbenutzername,schulerpasswort ;
	
		System.out.println("geben Sie Ihre Benutzernamen ein oder x zum abbrechen : ");
		
		schulerbenutzername = sc2.nextLine();
		
		if(schulerbenutzername.equals(abbruch)) {
			break;
		}
		
		
		System.out.println("geben Sie Ihr Passwort ein oder x zum abbrechen : ");

		schulerpasswort = sc2.nextLine();
		
		
		if(schulerpasswort.equals(abbruch)) {
			break;
		}
		
		
		SchuelerTO schulerTO = new SchuelerTO(null,null,null,0,schulerbenutzername,schulerpasswort);
		
		AnmeldungInfrastructurFactory anmeldungfactory = new AnmeldungInfrastructurFactory();
		
		anmeldungfactory.getAnmeldungDAO().benutzerDatenAnlegen(schulerTO);
		
	
	    break;
		
		
		
		
		
	case 2 : 
		
		
		Scanner sc3 = new Scanner(System.in);
		
		
		String abbruch1 ="x";
	
		String lehrerbenutzername,lehrerpasswort;
	
		System.out.println("geben Sie Ihre Benutzernamen ein oder x zum abbrechen : ");
		
		lehrerbenutzername = sc3.nextLine();
		
		if(lehrerbenutzername.equals(abbruch1)) {
			break;
		}
		
		System.out.println("geben Sie Ihr Passwort ein oder x zum abbrechen : ");
		
		lehrerpasswort = sc3.nextLine();
		
		if(lehrerbenutzername.equals(abbruch1)) {
			break;
		}
		
		LehrerTO lehrerTO = new LehrerTO(null,null,0,lehrerbenutzername,lehrerpasswort);

        AnmeldungInfrastructurFactory anmeldungfactory1 = new AnmeldungInfrastructurFactory();
		anmeldungfactory1.getAnmeldungDAO().benutzerDatenAnlegen(lehrerTO);
		
		break;

	}  
	

}





///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
public void startAnmeldungsDialog() {
	
	
Scanner sc1 = new Scanner(System.in);
	
	System.out.println("\nSind Sie Schüler oder Lehrer?");
	System.out.println("1-Schüler "+"\n"+"2-Lehrer"+"\n"+"3-Zurück");
	
	int auswahl = Integer.parseInt(sc1.nextLine());
	
	
	switch(auswahl){
	
	
	
	case 1 :
		
		String schulerbenutzername,schulerpasswort;
		
		System.out.println("geben Sie Ihren Benutzernamen ein : ");
		
		schulerbenutzername = sc1.nextLine();
		
		System.out.println("geben Sie Ihr Passwort ein : ");
		
		schulerpasswort = sc1.nextLine();
		
		
		SchuelerTO schulerTO = new SchuelerTO(null,null,null,0,schulerbenutzername,schulerpasswort);
		
        AnmeldungInfrastructurFactory anmeldungfactory = new AnmeldungInfrastructurFactory();
		anmeldungfactory.getAnmeldungDAO().benutzerAnmelden(schulerTO);
		

		//System.out.println(anmeldungfactory.getAnmeldungDAO().benutzerAnmelden(schulerTO));
		
		
		break;
		
	case 2 :
		 
		String lehrerbenutzername,lehrerpasswort;
		
		System.out.println("geben Sie Ihren Benutzernamen ein : ");
		
		lehrerbenutzername = sc1.nextLine();
		
		System.out.println("geben Sie Ihr Passwort ein : ");
		
		lehrerpasswort = sc1.nextLine();
		
		LehrerTO lehrerTO = new LehrerTO(null,null,0,lehrerbenutzername,lehrerpasswort);
		
        AnmeldungInfrastructurFactory anmeldungfactory1 = new AnmeldungInfrastructurFactory();
		anmeldungfactory1.getAnmeldungDAO().benutzerAnmelden(lehrerTO);
		break;

	
	}
		
	}	



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	
// Daten ändern

public void startDatenAenderungsDialog() {
	
	
	Scanner sc1 = new Scanner(System.in);

	
	System.out.println("\nSind Sie Schüler oder Lehrer?");
	System.out.println("\n1-Schüler "+"\n"+"2-Lehrer"+"\n"+"3-Zurück");
	
	int auswahl = Integer.parseInt(sc1.nextLine());
	
	switch(auswahl) {
	
// SCHULER
	 
	case 1 :
		
		Scanner sc2 = new Scanner(System.in);
		
		String schulerbenutzername,schulerpasswort;
		
		
		System.out.println("Sie müssen sich erst anmelden, um Ihre Daten ändern zu können.");
		System.out.println("geben Sie daher Ihren Benutzernamen ein : ");
		
		schulerbenutzername = sc2.nextLine();
		
		System.out.println("geben Sie Ihr Passwort ein : ");
		
		schulerpasswort = sc2.nextLine();
		
		
		
		SchuelerTO schulerTO = new SchuelerTO(null,null,null,0,schulerbenutzername,schulerpasswort);
        AnmeldungInfrastructurFactory anmeldungfactory = new AnmeldungInfrastructurFactory();
		anmeldungfactory.getAnmeldungDAO().benutzerAnmelden(schulerTO);
		

		
		if(anmeldungfactory.getAnmeldungDAO().benutzerAnmelden(schulerTO)==true) {
		
		System.out.println("\nwas möchten Sie ändern ");
		System.out.println("\n1-Benutzername"+"\n2-Passwort"+"\n3-Beides"+"\n4-Zurück");
		
	
		
		int auswahl1 = 0;
	
		
		try {
			
			System.out.println("Auswahl :");
			auswahl1 = 	Integer.parseInt(sc1.nextLine());
			
		}catch(InputMismatchException e) {
			
			auswahl1 = 0;
			sc2.next();
		}
		
		
		switch(auswahl1) {
		
		
		//Benutzername
		case 1 :
			
			SchuelerTO schulerTO2;
			SchuelerTO schulerTO1;
			
		do {
			
		Scanner sc3 = new Scanner(System.in);
			
	
		
		System.out.println("geben Sie den alten Benutzernamen ein : ");
		
		String schulerbenutzernamealt = sc3.nextLine();
		
		System.out.println("geben Sie den neuen Benutzernamen ein : ");
		
		String schulerbenutzernameneu  = sc3.nextLine();
		

		
		 schulerTO1 = new SchuelerTO(null,null,null,0,schulerbenutzernamealt,null);
		 schulerTO2 = new SchuelerTO(null,null,null,0,schulerbenutzernameneu,null);
		 
		 
		
		 
		 
		 if(schulerTO1.getBenutzername().equals(schulerTO2.getBenutzername())){
			 
			 System.out.println("der neue und alte Benutzername sind identisch, Sie müssen einen anderen Benutzernamen aussuchen ");
			 
		 }
		 else {
			 
				AnmeldungInfrastructurFactory anmeldungfactory1 = new AnmeldungInfrastructurFactory();
				anmeldungfactory1.getAnmeldungDAO().benutzerDatenAendernBenutzername(schulerTO1 , schulerTO2);
				
			 break;
		 }
		
		} while(schulerTO1.getBenutzername().equals(schulerTO2.getBenutzername())); 
		
		break;

		
		
		//Passwort			
		case 2:
			
			SchuelerTO schulerTO4;
			SchuelerTO schulerTO3;
			
		do {
			
		Scanner sc3 = new Scanner(System.in);
			
		
		System.out.println("geben Sie das alte Passwort ein : ");
		
		String schulerpasswortalt = sc3.nextLine();
		
		System.out.println("geben Sie das neue Passwort ein : ");
		
		String schulerpasswortneu  = sc3.nextLine();
		

		
		 schulerTO3 = new SchuelerTO(null,null,null,0,null,schulerpasswortalt);
		 schulerTO4 = new SchuelerTO(null,null,null,0,null,schulerpasswortneu);
		 
		 
		
		 if(schulerTO3.getPasswort().equals(schulerTO4.getPasswort())){
			 
			 System.out.println("das neue und alte Passwort sind identisch, Sie müssen ein anderes Passwort aussuchen ");
			 
		 }
		 else {
			 
				AnmeldungInfrastructurFactory anmeldungfactory1 = new AnmeldungInfrastructurFactory();
				anmeldungfactory1.getAnmeldungDAO().benutzerDatenAendernPasswort(schulerTO3 , schulerTO4);
				
			 break;
		 }
		
		} while(schulerTO3.getPasswort().equals(schulerTO4.getPasswort())); 
		
		break;


		//Beides		
		case 3:
			
			SchuelerTO schulerTO6;
			SchuelerTO schulerTO5;
			
		do {
			
			
			Scanner sc8 = new Scanner(System.in);
				
		
			System.out.println("geben Sie den alten Benutzernamen ein : ");
			
			String schulerbenutzernamealt = sc8.nextLine();
			
			System.out.println("geben Sie den neuen Benutzernamen ein : ");
			
			String schulerbenutzernameneu  = sc8.nextLine();
			
			System.out.println("geben Sie das alte Passwort ein : ");
			
			String schulerpasswortalt = sc8.nextLine();
			
			System.out.println("geben Sie das neue Passwort ein : ");
			
			String schulerpasswortneu  = sc8.nextLine();
			
			 schulerTO5 = new SchuelerTO(null,null,null,0,schulerbenutzernamealt,schulerpasswortalt);
			 schulerTO6 = new SchuelerTO(null,null,null,0,schulerbenutzernameneu,schulerpasswortneu);
			 
		 
		
		 if(schulerTO5.getBenutzername().equals(schulerTO6.getBenutzername()) || schulerTO5.getPasswort().equals(schulerTO6.getPasswort())){
			 
			 System.out.println("der neue und alte Benutzername oder Passwort sind identisch, Sie müssen einen anderen Benutzernamen bzw. Passwort aussuchen. ");
			 
		 }
		 else {
			 
				AnmeldungInfrastructurFactory anmeldungfactory1 = new AnmeldungInfrastructurFactory();
				anmeldungfactory1.getAnmeldungDAO().benutzerDatenAendernBenutzernameUndPasswort(schulerTO5 , schulerTO6);
				
			 break;
		 }
		
		} while(schulerTO5.getPasswort().equals(schulerTO6.getPasswort())); 
		
		break;
	
		case 4:break;

		}
		
		}
		
		
		
///////////////////////////////////////////////////		
	
		break;
	
// LEHRER		
		
	case 2 :
		 
		String lehrerbenutzername,lehrerpasswort;
		
		System.out.println("Sie müssen sich erst anmelden, um Ihre Daten ändern zu können.");
		System.out.println("geben Sie daher Ihren Benutzernamen ein : ");
		
		lehrerbenutzername = sc1.nextLine();
		
		System.out.println("geben Sie Ihr Passwort ein : ");
		
		lehrerpasswort = sc1.nextLine();
		
		
		LehrerTO lehrerTO = new LehrerTO(null,null,0,lehrerbenutzername,lehrerpasswort);
        AnmeldungInfrastructurFactory anmeldungfactory1 = new AnmeldungInfrastructurFactory();
		anmeldungfactory1.getAnmeldungDAO().benutzerAnmelden(lehrerTO);
		
		System.out.println("\nwas möchten Sie ändern ");
		System.out.println("\n1-Benutzername"+"\n2-Passwort"+"\n3-Beides"+"\n4-Zurück");
		
		int auswahl2 = Integer.parseInt(sc1.nextLine());
		
		switch(auswahl2) {
		
		
		//Benutzername
				case 1 :
					
					
					LehrerTO lehrerTO1;
					LehrerTO lehrerTO2;
					
					
				do {
					
				Scanner sc3 = new Scanner(System.in);
					
			
				
				System.out.println("geben Sie den alten Benutzernamen ein : ");
				
				String lehrerbenutzernamealt = sc3.nextLine();
				
				System.out.println("geben Sie den neuen Benutzernamen ein : ");
				
				String lehrerbenutzernameneu  = sc3.nextLine();
				

				
				lehrerTO1 = new LehrerTO(null,null,0,lehrerbenutzernamealt,null);
				lehrerTO2 = new LehrerTO(null,null,0,lehrerbenutzernameneu,null);
				 
				 
	
				 if(lehrerTO1.getBenutzername().equals(lehrerTO2.getBenutzername())){
					 
					 System.out.println("der neue und alte Benutzername sind identisch, Sie müssen einen anderen Benutzernamen aussuchen ");
					 
				 }
				 else {
					 
						AnmeldungInfrastructurFactory anmeldungfactory2 = new AnmeldungInfrastructurFactory();
						anmeldungfactory2.getAnmeldungDAO().benutzerDatenAendernBenutzername(lehrerTO1 , lehrerTO2);
						
					 break;
				 }
				
				} while(lehrerTO1.getBenutzername().equals(lehrerTO2.getBenutzername())); 
				
				break;

				
				
	//Passwort			
				case 2:
					
					LehrerTO lehrerTO3;
					LehrerTO lehrerTO4;
					
				do {
					
				Scanner sc3 = new Scanner(System.in);
					
				
				System.out.println("geben Sie das alte Passwort ein : ");
				
				String lehrerpasswortalt = sc3.nextLine();
				
				System.out.println("geben Sie das neue Passwort ein : ");
				
				String lehrerpasswortneu  = sc3.nextLine();
				

				
				lehrerTO3 = new LehrerTO(null,null,0,null,lehrerpasswortalt);
				lehrerTO4 = new LehrerTO(null,null,0,null,lehrerpasswortneu);
				 
				 
				
				 if(lehrerTO3.getPasswort().equals(lehrerTO4.getPasswort())){
					 
					 System.out.println("das neue und alte Passwort sind identisch, Sie müssen ein anderes Passwort aussuchen ");
					 
				 }
				 else {
					 
						AnmeldungInfrastructurFactory anmeldungfactory2 = new AnmeldungInfrastructurFactory();
						anmeldungfactory2.getAnmeldungDAO().benutzerDatenAendernPasswort(lehrerTO3 , lehrerTO4);
						
					 break;
				 }
				
				} while(lehrerTO3.getPasswort().equals(lehrerTO4.getPasswort())); 
				
				break;


				//Beides		
				case 3:
					
					LehrerTO lehrerTO5;
					LehrerTO lehrerTO6;
					
				do {
					
					
					Scanner sc8 = new Scanner(System.in);
						
				
					System.out.println("geben Sie den alten Benutzernamen ein : ");
					
					String lehrerbenutzernamealt = sc8.nextLine();
					
					System.out.println("geben Sie den neuen Benutzernamen ein : ");
					
					String lehrerbenutzernameneu  = sc8.nextLine();
					
					System.out.println("geben Sie das alte Passwort ein : ");
					
					String lehrerpasswortalt = sc8.nextLine();
					
					System.out.println("geben Sie das neue Passwort ein : ");
					
					String lehrerpasswortneu  = sc8.nextLine();
					
					lehrerTO5 = new LehrerTO(null,null,0,lehrerbenutzernamealt,lehrerpasswortalt);
					lehrerTO6 = new LehrerTO(null,null,0,lehrerbenutzernameneu,lehrerpasswortneu);
					 
				 
				
				 if(lehrerTO5.getBenutzername().equals(lehrerTO6.getBenutzername()) || lehrerTO5.getPasswort().equals(lehrerTO6.getPasswort())){
					 
					 System.out.println("der neue und alte Benutzername oder Passwort sind identisch, Sie müssen einen anderen Benutzernamen bzw. Passwort aussuchen. ");
					 
				 }
				 else {
					 
						AnmeldungInfrastructurFactory anmeldungfactory2 = new AnmeldungInfrastructurFactory();
						anmeldungfactory2.getAnmeldungDAO().benutzerDatenAendernBenutzernameUndPasswort(lehrerTO5 , lehrerTO6);
						
					 break;
				 }
				
				} while(lehrerTO5.getPasswort().equals(lehrerTO6.getPasswort())); 
				
				break;
			
				
		case 4:
			
			break;
		
	
		}
		
		
		
	case 3 : 
		
		break;
	
	}


}





///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public void dialogBenutzernameAendern() {
	
	
	
	
	
}

}



