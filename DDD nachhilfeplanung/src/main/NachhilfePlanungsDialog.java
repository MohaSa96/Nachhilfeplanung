package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import infrastructure.datastore.anmeldung.AnmeldungInfrastructurFactory;
import infrastructure.datastore.matching.MatchingDAO;
import infrastructure.datastore.matching.MatchingInfrastructurFactory;
import services.matching.ports.primary.LehrerTO;
import services.matching.ports.primary.NachhilfeangebotTO;
import services.matching.ports.primary.NachhilfegesuchTO;
import services.matching.ports.primary.SchuelerTO;

public class NachhilfePlanungsDialog {
	
	
public void startDialog() {
	
	
	int auswahl;
	

	
	do {
	
System.out.println("wählen Sie aus, was Sie tun möchten : \n");
System.out.println("1-Nachhilfeangebot machen."+"\n"+"2-Nachhilfegesuch aufegeben."
+"\n"+"3-Nachhileangebote sehen"+"\n"+"4-Nachhilegesuche "
+ "sehen."+"\n"+"5-Nachhilfeangebot-zu gesuch matchen."+"\n"+"6-Matchings sehen"+"\n"+ "7-Ende"+"\n"+"\nAuswahl :");
	
Scanner sc = new Scanner(System.in);	

	try {
	
		 auswahl = Integer.parseInt(sc.nextLine());
		
		
	}catch(InputMismatchException e) {
		
		auswahl = 0;
		sc.next();
	}
 

switch(auswahl) {

case 1: startNachhilfeangebotMachen(); break;

case 2: startNachhilfegeuschAufegeben();break;

case 3: MatchingDAO mdao1 = new MatchingDAO(); mdao1.nachhilfeangebotSehen(); break;

case 4: MatchingDAO mdao = new MatchingDAO();  mdao.nachhilfegesuchSehen(); break;

case 5: startNachhilfeangebotzuNachhilfegesuchMatchenDialog(); break;

case 6 :MatchingDAO mdao3 = new MatchingDAO();  mdao3.gematchteAngebotUndGesucheSehen(); break;

case 7: System.out.println("das Programm wurde beendet.");


}

	} while(auswahl != 7);


}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



public void startNachhilfeangebotMachen() {
	
	Scanner sc = new Scanner(System.in);
	
	String name , vorname , emailadresse , fach , jahrgangstufe , fachbeherrschung ;
	
do {	
	
System.out.println("geben Sie bitte Ihren Namen ein :");

name = sc.nextLine();
 
 if(name.equals("a")) {
	 
	 break;
 }
	
System.out.println("geben Sie bitte Ihren Vornamen ein :");
vorname = sc.nextLine();

if(vorname.equals("a")) {
	 
	 break;
}
	

System.out.println("geben Sie bitte Ihre Emailadresse ein :");
 emailadresse = sc.nextLine();
	
 if(emailadresse.equals("a")) {
	 
	 break;
 }
	
 
System.out.println("geben Sie bitte das Fach ein :");
fach = sc.nextLine();	
	
if(fach.equals("a")) {
	 
	 break;
}
	

System.out.println("es sind nur folgende Stufen erlaubt (5-10, EF, Q1 und Q2) geben Sie bitte die gewünschte Jahrgangstufe  ein :");
 jahrgangstufe = sc.nextLine();	

 if(jahrgangstufe.equals("a")) {
	 
	 break;
 }
	

System.out.println("wie beherrschen Sie das Fach (befriedigend , gut , sehr gut) :");
fachbeherrschung  = sc.nextLine();	

if(fachbeherrschung.equals("a")) {
	 
	 break;
}
	

SchuelerTO schulerTO = new SchuelerTO(name,vorname,emailadresse);

NachhilfeangebotTO nachhilfeangebotTO = new NachhilfeangebotTO(fach,jahrgangstufe,fachbeherrschung,schulerTO);

MatchingInfrastructurFactory machtingfactory = new MatchingInfrastructurFactory();
machtingfactory.getMatchinggDAO().nachhilfeangebotMachen(nachhilfeangebotTO);


break;


}

while(!name.equals("a")|| !vorname.equals("a")|| !emailadresse.equals("a")|| !fach.equals("a")|| !jahrgangstufe.equals("a") || !fachbeherrschung.equals("a"));

}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


public void startNachhilfegeuschAufegeben() {
	
	Scanner sc = new Scanner(System.in);
	
	String name , vorname , emailadresse , fach , jahrgangstufe ;
	
	do {
	
	
System.out.println("geben Sie bitte Ihren Namen ein :");
 name = sc.nextLine();
 
if(name.equals("a")) {
	 
	 break;
 }
	
	
System.out.println("geben Sie bitte Ihren Vornamen ein :");
 vorname = sc.nextLine();
 
if(vorname.equals("a")) {
	 
	 break;
 }
	
	
System.out.println("geben Sie bitte Ihre Emailadresse ein :");
 emailadresse = sc.nextLine();
 
if(emailadresse.equals("a")) {
	 
	 break;
 }
	
	
System.out.println("geben Sie bitte das Fach ein :");
 fach = sc.nextLine();	
 
if(fach.equals("a")) {
	 
	 break;
 }
	
	
System.out.println("es sind nur folgende Stufen erlaubt (5-10, EF, Q1 und Q2) geben Sie bitte die gewünschte Jahrgangstufe  ein :");
jahrgangstufe = sc.nextLine();	

if(jahrgangstufe.equals("a")) {
	 
	 break;
}
	
SchuelerTO schulerTO = new SchuelerTO(name,vorname,emailadresse);
NachhilfegesuchTO nachhilfegesuchTO = new NachhilfegesuchTO(fach,jahrgangstufe,schulerTO);

MatchingInfrastructurFactory machtingfactory = new MatchingInfrastructurFactory();
machtingfactory.getMatchinggDAO().nachhilfegesuchAufgeben(nachhilfegesuchTO);

break;

} while(!name.equals("a")|| !vorname.equals("a")|| !emailadresse.equals("a")|| !fach.equals("a")|| !jahrgangstufe.equals("a"));

}	
	


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


public void startNachhilfeangebotzuNachhilfegesuchMatchenDialog(){
	
	
	Scanner sc = new Scanner(System.in);
	
	int angebotID , gesuchID;
	
	String name ,vorname ;
	
do {	
	
	
System.out.println("geben Sie Ihren Namen ein :");
 name = sc.nextLine();
 
if(name.equals("a")) {
	 
	 break;
 }
 

System.out.println("geben Sie Ihren Vornamen ein :");
 vorname = sc.nextLine();
 
if(vorname.equals("a")) {
	 
	 break;
 }
 

System.out.println("geben Sie den AngebotID ein :");

angebotID= Integer.parseInt(sc.nextLine());

if(vorname.equals("0")) {
	 
	 break;
}

System.out.println("geben Sie den GesuchID ein :");

gesuchID= Integer.parseInt(sc.nextLine());

if(vorname.equals("0")) {
	 
	 break;
}



LehrerTO  lehrerTO = new LehrerTO(name,vorname);

MatchingDAO mdao = new MatchingDAO();
mdao.nachhilfeangebotzuNachhilfegesuchMatchen(lehrerTO, angebotID, gesuchID);
break;


} while(!name.equals("a")|| !vorname.equals("a")|| angebotID !=0 || gesuchID !=0);


}


}