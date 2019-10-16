import java.util.Scanner;

public class yams {
    static Scanner in = new Scanner (System.in) ;
    static Scanner sc = new Scanner (System.in) ;
    
    
    
    public static int NombreJoueur() {                          // Sous programme qui demande le nombre de joueur
	System.out.println ("Entrer le nombre de joueurs :");   // On demande le nombre de joueur,
	int nbj;
        nbj = in.nextInt();
	return nbj;                                             // et on retourne cet entier.
    }
    
    public static String [] NomJoueur(String [] tabj, int nbj) { //Sous programme qui demande le nom des joueurs
	
	for (int i = 0; i < nbj ; ++i){                                 // Pour chaque joueur,
	    System.out.println("Entrer nom du joueur" + (i+1) + ":");	// On demande d'entrer un nom,	    
	    String nomjoueur=sc.nextLine();                             
	    tabj[i] = nomjoueur;                                        // qui est rentré dans un tableau de caractère,
	    
	    
	    
	}
	return tabj;                                                    // et on retourne ce tableau de caractère.
	
    }
    
    
    
    
    public static int [] LancerDes(int [] t){         // Sous programme qui réalise le lancer de dés.
	
	for(int i = 0; i <t.length; i++){             // Pour chaque dés,
	    int ValeurDes = (int)(Math.random()*6+1); // on appelle la fonction qui donne une valeure aléatoire entre 0 et 6 inclus
	    t[i] = ValeurDes;                         // on rentre cette  valeure dans la case (du tableau) qui corresspond au des 
	}
	Affichage(t);                                 // On appelle le sous programme qui affiche les dés triés,
	return t;                                     // et on retourne le tableau.                         
    }
    
    
    public static void Tri (int [] t){               // Sous programme qui réalise un tri par sélection du tableau de dés.
	for (int i=0 ; i<=t.length-2 ; i++){
	    int min = i;
	    for (int j=i+1 ; j<t.length ; j++){
		if (t[j]<t[min])
		    min = j;
	    }
	    int aux=t[i];
	    t[i]=t[min];
	    t[min]=aux;
	}
    }
    
    
    
    public static void Affichage (int[]t){          // Sous programme qui affiche les dés triés.
	
	Tri(t);	                                    // On appelle le sous programme de tri.
	
	// boucle ligne 1                                   // Ensuite, pour chaque ligne de la représentation du dés,
	for (int i=0; i<5;i++)                              // on affiche 5 fois cote à cote la ligne qui represente chaque dés, 
	    System.out.print(" _____________ ");            // en fonction de la valeur du dés.
	
	System.out.println("");              // Entre chaque ligne de la représentation on va a la ligne pour afficher en dessous.
	
	// boucle ligne 2
	for (int i=0; i<5;i++)
	    System.out.print("|             |");
	
	System.out.println("");
	
	//boucle ligne 3
	for(int i=0; i<5;i++){
	    
	    if (t[i]==1)		     
		System.out.print("|             |");
	    
	    else if (t[i]==2 || t[i]==3)
		System.out.print("|          o  |");
	    
	    else if (t[i]==4 || t[i]==5 || t[i]==6)
		System.out.print("|  o       o  |");
	}
	
	System.out.println("");
	
	//ligne 4
	for(int i=0; i<5;i++)
	    System.out.print("|             |");
	
	System.out.println("");
	
	//Boucle ligne 5
	for (int i=0 ; i<5;i++){
	    if(t[i]==1 || t[i]==3 || t[i]==5)
		System.out.print("|      o      |");
	    else if (t[i]==2 || t[i]==4)
		System.out.print("|             |");
	    else if (t[i]==6)
		System.out.print("|  o       o  |");
	}
	
	System.out.println("");
	
	//Boucle ligne 6
	for(int i=0; i<5;i++)
	    System.out.print("|             |");
	
	System.out.println("");
	
	//Boucle ligne 7
	for (int i=0 ; i<5;i++){
	    if (t[i]==1)
		System.out.print("|             |");
	    
	    else if (t[i]==2 || t[i]==3)
		System.out.print("|  o          |");
	    
	    else if (t[i]==4 || t[i]==5 || t[i]==6)
		System.out.print("|  o       o  |");
	}
	
	System.out.println("");
	
	//Boucle ligne 8
	for(int i=0; i<5;i++)
	    System.out.print("|_____________|");
	
	System.out.println("");
	
	
	
	
    }
    
    
    public static int [] Relance(int [] t){ // Sous programme pour effectuer les relances
	
	int relance;
	int nbd;
	int deschoisi;
	int numlance=1;
	do {
	    do{
		System.out.println ("Voulez vous relancer ? Si oui tapez 1,sinon tapez 0");  // On demande a l'utilisateur si il
		relance = sc.nextInt();                                                      // veut relancer ou garder ses dés,
	    }while(relance!=1 && relance!=0);                             // tant qu'il ne rentre pas une valeur correcte (1 ou 0).
	    
	    if (relance==1){                                                      // Si il rentre 1,
		do{
		    System.out.println("Combien de dés voulez vous relancer ?"); // Demande combien de dés il veut relancer, 
		    nbd = in.nextInt();
		}while(nbd<1 || nbd>5);                         // tant que le nombre rentré n'est pas compris entre 1 et 5 inclus.
		for (int i = 0; i < nbd; i++){                                     // Pour le nombre de dés à relancer,
		    do{
			System.out.println (" Quel dés voulez vous relancer ?");   // on demande quel dé relancer,
			deschoisi = in.nextInt();
		    }while(deschoisi<1 || deschoisi>5);           // tant que le dés choisi n'est pas compris en 1 et 5 inclus,
		    int ValeurDes = (int)(Math.random()*6+1);     // on rapelle la fonction aleatoire pour changer la valeur du dés
		    t[deschoisi-1]= ValeurDes;                    // le dés choisi prend la nouvelle valeur dans le tableau.
		    
		}                                                
		numlance = numlance+1;                    // On incrémente le numero du lancé a chaque relance.
		Affichage(t);                             // Puis on appelle le sous programme pour afficher les nouveau dés triés.
	    }
	    else if (relance==0){                       // Sinon si il rentre 0, on ne fait rien.
	    }
	    
	}while (relance==1 && numlance<3); // Faire tout ça tant que l'utilisateur veut relancer et n'a pas déja relancer 2 fois.
	
	return t;                          // Quand on ne relance plus alors on retourne le tableau t
    }
    
    
    
    
    // Sous Programmes pour définir tous les contrats :
    
    
    public static int Contrat16 (int [] t, int n){       // Sous programme pour les contrats de 1 à 6 
	
	int somme=0;
	for (int i = 0; i<t.length; i++){                // Pour chaques dés,           
	    if (t[i]==n)                                 // Si la valeur du dé est égale à la valeur n choisi (1 à 6),
		somme=somme+n;                           // On incrémente la somme pour avoir le nombre de points gagnés.
	}
	return somme;
    }
    
    
    
    public static int Brelan (int [] t){                 // Sous programme pour le contrat Brelan
	int somme=0;
	for (int i = 0 ; i<3 ; i++){                     // Il y a 3 possibilités de positionnment du brelan, pour les 3 positions,
	    if (t[i] == t[i+1] &&  t[i+1] == t[i+2]){    // si 3 dés minimum sont égaux,
		for(int j = 0; j<t.length; j++){         // pour chaques dés (sauf le dernier),
		    somme=somme+t[j];}                   // on incrémente la somme en ajoutant la valeur du dé.
		return somme;
	    }
	} return -1; // Sinon on ne retourne pas la somme mais -1 qui correspond à un contrat non réalisable avec ces dés.
	
	
    }
    
    
    
    public static int Full (int [] t){                                        // Sous programme pour le contrat Full
	if(t[0]==t[1] && (t[2]==t[3] && t[3]==t[4]) && t[1]!=t[2] ){          // Il y a 2 possibilités pour réaliser un full;
	    return 25;}                                                       // Si les conditions du full  sont réspectées;
	else if ((t[0]==t[1] && t[1]==t[2]) && t[3]==t[4] && t[2]!=t[3]){     // alors on retourne 25.
	    return 25;
	}
	else return -1;                                                       // Sinon on retourne -1.
    }
    
    
    
    
    public static int Carré (int [] t){                        // Sous programme pour le contrat Carré
	int somme=0;
	for (int i = 0 ; i<2 ; i++){                           // Il y a 2 possibilités, 
	    if (t[i]==t[i+1] &&  t[i+1]==t[i+2] && t[i+2]==t[i+3] || t[i]==t[i+1] && t[i+1]==t[i+2] && t[i+2]==t[i+3] && t[i+3]==t[i+4]){                                                         // Si les conditions du carré sont respectées,             
		for(int j = 0; j<t.length; j++){               // Pour chaques dés (sauf le dernier),
		    somme=somme+t[j];}                         // on incrémente la somme avec la valeur du dé, que le retourne.
		return somme;
	    }}
	return -1;                                             // Sinon on retourne -1.
	
    }
    
    
    
    
    public static int PetiteSuite (int [] t){                        // Sous programme pour le contrat PetiteSuite (5 ou 6 cas)
	                                  // On vérifie que c'est une petite suite en vérifiant toute les configurations possible.
	
	// Petite suite sans égalité
	if ( t[0]==t[1]-1 && t[1]==t[2]-1 && t[2]==t[3]-1)                     //12346
	    return 30;
	else if ( t[1]==t[2]-1 && t[2]==t[3]-1 && t[3]==t[4]-1)                //13456
	    return 30;
	
	// Petite suite avec égalité
	else if (t[0]==t[1] && t[1]==t[2]-1 && t[2]==t[3]-1 && t[3] == t[4]-1) //11234
	    return 30;
	else if (t[0]==t[1]-1 && t[1]==t[2] && t[2]==t[3]-1 && t[3]==t[4]-1)  // 12234
	    return 30;
	else if (t[0]==t[1]-1 && t[1]==t[2]-1 && t[2]==t[3] && t[3]==t[4]-1)  // 12334
	    return 30;
	else if (t[0]==t[1]-1 && t[1]==t[2]-1 && t[2]==t[3]-1 && t[3]==t[4])  // 12344
	    return 30;                                                        // Si on a bien une petite suite on retourne 30.
	else{
	    return -1;}                                                        // Sinon on retourne -1.
    }
    
    
    
    
    public static int GrandeSuite (int [] t){                      // Sous programme pour le contrat GrandeSuite

	if(t[0]==t[1]-1 && t[1]==t[2]-1 && t[2]==t[3]-1 && t[3]==t[4]-1)
	    /*for (int i = 0 ; i<t.length ; i++){                        // Pour chaques dés (sauf le dernier),
	      if ( t[i]==i+1 ) */  //probleme ?                          // Si la valeur du dé est égale au numéro du dé suivant,
	    return 40;                                         // alors on retourne 40.
	else {
	    return -1; }                                                // Sinon on retourne -1.
    } 
    
    
    
    public static int Yams (int [] t){                             // Sous programme pour le contrat Yams
	int cpt = 1;
	for (int i = 0 ; i<=t.length-2 ; i++){                     // Pour chaques dés (sauf le dernier),
	    if(t[i]==t[i+1])                                       // Si la valeur du dé est égale au dé suivant,
		cpt++;                                             // Alors on incrémente un entier défini à 1 de base,
	    
	}
        if (cpt==5)                                                // Si cet entier apres la boucle pour, est égal à 5,
	    return 50;                                             // Les conditions sont valides, on retourne 50.
	else{
	    return-1;                                              // Sinon on retourne -1
	}
	
    }
    
    public static int Chance (int [] t) {                          // Sous programme pour le contrat Chance
	int somme=0;                                               
	for (int i = 0; i<t.length; i++){                          // Pour chaques dés sauf le dernier,
	    somme=somme+t[i];                                      // on incrémente la somme avec la valeur du dé
	}
	return somme;                                              // Puis on retourne la somme.
    }
         
				     
   
    public static String [][][] Contrats (String[][][] c,int p) {      //Sous programme qui crée le tableau avec les 13 contrats
	c[p][0][0]="sacrifier";                                        // On ajoute une ligne pour le sacrifice de contrat
	c[p][1][0]="Somme des  1";                                     // On rentre un contrat pour chaque ligne de la colonne qui
	c[p][2][0]="Somme des 2";                                      // correspond aux contrats.
	c[p][3][0]="Somme des 3";
	c[p][4][0]="Somme des 4";
	c[p][5][0]="Somme des 5";
	c[p][6][0]="Somme des 6";
	c[p][7][0]="Brelan";
	c[p][8][0]="Full";
	c[p][9][0]="Carré";
	c[p][10][0]="Petite Suite";
	c[p][11][0]="Grande Suite";
	c[p][12][0]="Yams";
	c[p][13][0]="Chance";
	for (int i=0 ; i<c[0].length ; i++)                           // Et chaque contrat est défini comme disponible.
	    c[p][i][1]="Disponible";
	return c;                                                     // On retourne le tableau.
    }
    
    
    public static int []  Points(int [] t,int [] p){     //Sous-programme pour calculer les points pour chaque joueur (p)
	t[0]=0;                                                
	t[1]=Contrat16(p,1);                      // Dans chaque case du tableau des points on définit le calcul d'un contrat
	t[2]=Contrat16(p,2);	     
	t[3]=Contrat16(p,3);
	t[4]=Contrat16(p,4);
	t[5]=Contrat16(p,5);
	t[6]=Contrat16(p,6);
	t[7]=Brelan(p);
	t[8]=Full(p);
	t[9]=Carré(p);
	t[10]=PetiteSuite(p);
	t[11]=GrandeSuite(p);
	t[12]=Yams(p);
	t[13]=Chance(p);
	return t;                         // On retourne le tableau
    }
		
    
    
    
    public static void main (String [] args){
                                                             	/*
		                                         	// test
		                                              	int des[] = {2,3,4,5,6};
		                                            	int res = GrandeSuite(des);
 		                                             	System.out.println(res);
                                                               	*/
	
	int nbj=NombreJoueur();            
	String [] tabj=new String[nbj];    // On crée le tableau qu'on remplira avec le nom des joueurs
	NomJoueur(tabj,nbj);               // On appelle le sous programme pour remplir le tableau avec les noms des joueurs
	
	int [] t = new int [5];           // On crée le tableau qui correspond aux dés
	int [] score = new int[nbj];      // On crée le tableau de score pour le nombre de joueurs
	int [] points = new int[14];      // On crée le tableau qui correspond aux points des contrats
	
	String [][][] contrats = new String [nbj][14][2];   // On crée le tableau avec l'etat de chaque contrat pour chaque joueur

	/*Tableau avec le nombre de parties gagné de chaque joueur */
	int [] partiegagnées = new int [nbj];
	
	int partieencours=0; //afficher le nombre des parties jouées
	int parties=1; // compte le nombre de parties jouées
	int rejouer=1;
	while(rejouer==1){                    // Au début de chaque partie,
	    for( int i=0; i<nbj ; i++){       // pour chaque joueur,
		Contrats(contrats,i);         // on reset tous les contrats,
		score[i]=0;                   // ainsi que leur score.
	    }
	    
	    for(int tour=0; tour<13 ; tour++){ // Pour chaque tour jusqu'au 13éme inclus,
		for (int j=0 ; j<nbj ; j++) {  // Pour chaque joueur,
		    LancerDes(t);              // Lance sous programme qui permet de faire un lancer de dés et l'affichage inclus,
		    System.out.println("C'est le tour de " + tabj[j]);
		    // probleme ça affiche 2 points=Points(points,t);
		    
		    Relance(t);                    // Lance sous programme pour la relance et l'affichage.
		    
		    
		    
		    int contratchoisi=1;
		    int contratsacrifié=1;
		    points=Points(points,t);                                  // On défini les points grâce au sous programme.
		    System.out.println("Les contrats encore disponible sont :");
		    for (int c=1; c<14; c++){                                     // Pour tous les contrats de 1 à 13,
			if (contrats[j][c][1].equals("Disponible"))               // Parcours le tableau, si le contrat est disponible,
			    System.out.println((c)+"= "+ contrats[j][c][0]);      // Alors affiche le contrat.
		    }
		    
		    do{		    
			do{
			    System.out.println("Choisissez un contrat réalisable, ou tapez 0 pour sacrifier un contrat");		
			    contratchoisi=in.nextInt();                             // L'utilisateur doit choisir un contrat,
			}while((contratchoisi<0) || (contratchoisi>13));		// Tant qu'il choisit un contrat inexistant,
		    }while (!contrats[j][contratchoisi][1].equals("Disponible") || points[contratchoisi]==-1); // Ou tant qu'il  n'est plus disponible ou qu'il n'est pas réalisable avec ces dés (retour -1 lors de la vérif)
		    
		    if (contratchoisi!=0){                                          // Si le contrat choisi est différent de 0,
			contrats[j][contratchoisi][1]="pas disponible";             // Le contrat devient indisponible dans le tableau,
			System.out.println("Vous obtenez "+points[contratchoisi]+" points !");
			// On affiche les points gagnés(avec les points défini plus haut),
			score[j] = points[contratchoisi] + score[j]; // On incrémente le score du joueur avec les points du contrat.
		    }
		    else {                                                          // Sinon, si (contrat choisi = 0),
			do {
			    do{
				System.out.println("Quel contrat voulez vous sacrifier ?"); // Demande quel contrat doit etre sacrifié,
				contratsacrifié=in.nextInt();                     
			    }while((contratsacrifié<1) || (contratsacrifié>13));           // tant qu'on choisit un contrat inexistant,
			}while (!contrats[j][contratsacrifié][1].equals("Disponible"));    // ou que le contrat a déja été sacrifié.
			contrats[j][contratsacrifié][1]="pas disponible";                  // Le contrat choisi devient indisponible.
			
		    }
		    
		}
		// On incrémente la valeur du tour a la fin de chaque tour.
	    }

	    
	    // Bonus qui crée des erreurs Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 1
	                                             //at yams.main(yams.java:448) (sommecontrat16=sommecontrat...) ?
	    
	    /*
	      int bonus=0;
	    for(int i=0; i<nbj; i++){
		int sommecontrat16=0;
		for(int contrat=0 ; contrat<6; contrat++){
		    sommecontrat16=sommecontrat16+score[contrat+1];}
		    if (sommecontrat16>=63){
			bonus=35;
		    }
		    else{
			bonus=0;}}
		score[i]=score[i]+bonus;
		System.out.println(tabj[i]+ "Vous gagnez un bonus de :"+ bonus+ "points");
	    
	   
	    System.out.println(tabj[i] +" a" + score[i]+"points au total");
	    } */
	    

	    for (int i=0 ; i<nbj; i++){                                             // Pour chaque joueur on affiche le score total
		System.out.println(tabj[i] +" a " + score[i]+"points au total");		
	    }
	    
	    // /!\  Calcul du gagnant qui ne fonctionne seulement avec 2 joueurs...
	    
	    if (nbj>1){                                 // Si il y a plus d'un joueur,
		int jgagnant=0;
		for( int j=0; j <nbj-1; j++){        // pour chaque joueur
		    if (score[j]>score[j+1]){        // on compare le score d'un joueur au suivant, si le joueur suivant a plus de points
			jgagnant=j;                  // le joueur qui gagne et le joueur j
		    }                                // tant qu'on est inférieur au nombre de joueurs	                       
		    
		    else {                                    // Sinon le gagnant
			jgagnant=j+1;}                        // est le joueur suivant
	}
		System.out.println(tabj[jgagnant]+" gagne cette partie avec un score de "+score[jgagnant]+" points !");  // Affiche qui a gagné la partie et avec combien son nombre de points
		
	    partiegagnées[jgagnant]=partiegagnées[jgagnant]+1; //on incrémente le nombre de partie gagné pour le gagnant
	    }
	    

	    
	    
	    System.out.println();
	    parties++;                   //on incrémente le nombre de parties
	    partieencours=parties-1;
	    
	    do{
		System.out.println("Voulez-vous rejouer ? Si oui tapez 1, sinon tapez 0 : "); // demande si l'on rejoue une partie
		rejouer=in.nextInt(); 
	    }while(rejouer!=1 && rejouer!=0);
	    if(rejouer==0)
		parties=-1 ; //  Donc on ne rejoue pas et on ne relance pas la boucle
	    
	}
	
	System.out.println("Vous avez joués "+partieencours+" partie(s) "); // affiche le nombre de parties jouées
	if (nbj!=1){
	    for(int i=0; i<nbj; i++){
		System.out.println(tabj[i]+" a gagné "+partiegagnées[i]+" parties "); // affiche le nombre de parties gagnées par chaque utilisateur
		
	    }
	}           
    }  
}
