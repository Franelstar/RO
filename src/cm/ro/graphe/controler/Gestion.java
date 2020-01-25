/**
 * 
 */
package cm.ro.graphe.controler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import cm.ro.graphe.model.Graphe;
import cm.ro.graphe.model.Noeud;

/**
 * @author franel
 *
 */
public class Gestion {
	private Scanner sc = new Scanner(System.in);
	private ArrayList<Graphe> graphe = new ArrayList<Graphe>();
	
	public Gestion(){
		graphe.add(new Graphe("toto"));
	}
	
	protected boolean contentNom(String nom) {
		for(Graphe g : graphe) {
			if(g.getNom().equals(nom))
				return true;
		}
		return false;
	}
	
	protected boolean contentIndex(int index) {
		for(int i = 0; i < graphe.size(); i++) {
			if(i == index)
				return true;
		}
		return false;
	}
		
	public void play() {
		int reponse = 10;
		
		while(reponse != 9) {
			clearConsole();
			System.out.println("********** - Projet de Recherche Opérationnelle - **********");
			System.out.println("1. Créer un graphe");
			System.out.println("2. Ouvrir un graphe");
			System.out.println("3. Modifier un graphe");
			System.out.println("4. Voir un graphe");
			System.out.println("5. Sauvegarder un graphe");
			System.out.println("6. Exporter un graphe");
			System.out.println("7. Supprimer un graphe");
			System.out.println("9. Quitter");
			System.out.print("Veillez faire un choix : ");
			
			reponse = sc.nextInt();
			
			if(reponse == 9) {
				clearConsole();
				System.out.println("Aurevoir !!!");
			}
			
			if(reponse == 1) {
				creerGraphe();
			}
			
			if(reponse == 2) {
				
			}
			
			if(reponse == 3) {
				modifierGraphe();
			}
			
			if(reponse == 4) {
				voirGraphe();
			}
			
			if(reponse == 6) {
				exporterGraphe();
			}
			
			if(reponse == 7) {
				supprimergraphe();
			}
		}
	}
	
	public void creerGraphe() {
		clearConsole();
		String nom = "";
		
		while(nom.isEmpty() || this.contentNom(nom)) {
			System.out.print("Entrez le nom du nouveau graphe : ");
			nom = sc.next();
			if(this.contentNom(nom)) {
				clearConsole();
				System.out.println("Ce nom n'est plus disponible !");
			}
		}
		Graphe g = new Graphe(nom);
		graphe.add(g);
		
		int rep = 9;
		while(rep != 99) {
			clearConsole();
			System.out.println("le graphe " + nom + " a été créé");
			System.out.println("2. Modifier ce graphe");
			System.out.println("99. Retour");
			System.out.print("Veillez faire un choix : ");
			
			rep = sc.nextInt();
			
			if(rep == 2) {
				modifGraphe(graphe.indexOf(g));
			}
		}
	}
	
	protected void modifierGraphe() {
		int rep = 0;
		while(rep != 99) {
			clearConsole();
			if(graphe.size() == 0) {
				System.out.println("Vous n'avez créé aucun graphe");
				System.out.println("99. Sortir");
			}else {
				System.out.println("Liste des graphes :");
				for(int i = 0; i < graphe.size(); i++) {
					System.out.println(i+1+". "+graphe.get(i).getNom()+" - "+graphe.get(i).getNbNoeuds()+" Noeuds");
				}
				System.out.println("99. Sortir");
				System.out.print("Veillez selectionner le graphe que vous voulez modifier :");
			}
			rep = sc.nextInt();
			if(rep <= graphe.size() && rep > 0) {
				modifGraphe(rep-1);
			}
		}
	}
	
	protected void modifGraphe(int i) {
		int reponse = 0;
		
		while(reponse != 99) {
			clearConsole();
			System.out.println("---Modification du graphe " + graphe.get(i).getNom() + "---");
			System.out.println("");
			System.out.println("1. Créer un noeud");
			System.out.println("2. Modifier un noeud");
			System.out.println("3. Supprimer un noeud");
			System.out.println("99. Sortir");
			System.out.print("Veillez selectionner : ");
			
			reponse = sc.nextInt();
			
			if(reponse == 1) {
				graphe.get(i).creerNoeud(creerNoeud(i));
			}
			
			if(reponse == 2) {
				modifierNoeud(i);
			}
			
			if(reponse == 3) {
				supprimerNoeud(i);
			}
		}
		
	}
	
	protected Noeud creerNoeud(int i) {
		clearConsole();
		String label = "";
		int nbre = 0;
		System.out.println("--- Création d'un nouveau noeud dans le graphe " + graphe.get(i).getNom() + "---");
		System.out.println("");
		
		while(label.isEmpty() || graphe.get(i).contentNoeud(label)) {
			System.out.print("Entrez le label du noeud : ");
			label = sc.next();
			if(graphe.get(i).contentNoeud(label)) {
				clearConsole();
				System.out.println("Le label que vous avez utilisé existe déjà ! ");
			}
		}
		System.out.print("Entrez le nombre de voisin : ");
		nbre = sc.nextInt();
		Noeud n = new Noeud(label);
		
		if(nbre > 0) {
			for(int i1 = 1; i1 <= nbre; i1++) {
				clearConsole();
				System.out.println("Selection/Création des noeuds voisins de "+label);
				System.out.println("Création du noeud "+i1+" sur "+nbre);
				System.out.println("");
				if(graphe.get(i).getNbNoeuds() > 0) {
					System.out.println("1. Choisir dans la liste des noeuds");
				}else {
					System.out.println("Aucun noeud disponible");
				}
				
				int nbre2 = 0;
				while(nbre2 != 899) {
					System.out.println("2. Créer un noeud");
					System.out.print("Veillez faire un choix : ");
					nbre2 = sc.nextInt();
					String noe = "";
					
					if(nbre2 == 1 && graphe.get(i).getNbNoeuds() > 0) {
						clearConsole();
						System.out.println("Selection/Création des noeuds voisins de "+label);
						System.out.println("Création du noeud "+i1+" sur "+nbre);
						System.out.println("");
						while(!graphe.get(i).contentNoeud(noe)) {
							System.out.print("Liste des noeuds disponibles : ");
							System.out.println(graphe.get(i).getNoeuds());
							System.out.print("Selectionnez un noeud : ");
							noe = sc.next();
							if(graphe.get(i).contentNoeud(noe)) {
								n.ajouteVoisin(graphe.get(i).getNoeud(noe), 1);
							}
							nbre2 = 899;
						}
					}else if(nbre2 == 2) {
						Noeud neunc;
						neunc = creerNoeud(i);
						graphe.get(i).creerNoeud(neunc);
						n.ajouteVoisin(neunc, 1);
						nbre2 = 899;
					}
				}
			}
		}
		return n;
	}
	
	public void modifierNoeud(int i) {
		clearConsole();
		int reponse2 = 1;
		while(reponse2 != 99) {
			if(graphe.get(i).getListeNoeud().size() == 0) {
				System.out.println("---Modifier un noeud du graphe " + graphe.get(i).getNom() + "---");
				System.out.println("Liste des Noeuds :");
				System.out.println("La liste des noeuds est vide");
				System.out.println("99. Sortir");
				System.out.print("veuillez faire un choix :");
				reponse2 = sc.nextInt();
				clearConsole();
			}
			else {
				reponse2 = -1;
				clearConsole();
				System.out.println("---Modifier un noeud du graphe " + graphe.get(i).getNom() + "---");
				while(reponse2 != 99) {
					System.out.println("Liste des Noeuds : ");
		
					for(int i1 = 0; i1 < graphe.get(i).getListeNoeud().size(); i1++) {
						System.out.println(i1 + ". " + graphe.get(i).getListeNoeud().get(i1).getLabel());
					}
					System.out.println("99. Sortir");
					System.out.print("veuillez faire un choix : ");
					reponse2 = sc.nextInt();
					try {
						String label = graphe.get(i).getListeNoeud().get(reponse2).getLabel();
						int reponse3 = -1;
						while(reponse3 != 99) {
							clearConsole();
							System.out.println("---Modifier le noeud " + label + " du graphe " + graphe.get(i).getNom() + "---");
							System.out.println("1. Modifier le label");
							System.out.println("2. Créer un voisin");
							System.out.println("3. Supprimer un voisin");
							System.out.println("99. Sortir");
							System.out.print("veuillez faire un choix : ");
							reponse3 = sc.nextInt();
							clearConsole();
							
							if(reponse3 == 1) {
								while(graphe.get(i).contentNoeud(label)) {
									System.out.println("---Modifier le label " + graphe.get(i).getListeNoeud().get(reponse2).getLabel() + "---");
									System.out.print("veuillez écrire le nouveau label : ");
									label = sc.next();
									if(graphe.get(i).contentNoeud(label)) {
										clearConsole();
										System.out.print("Ce label existe déjà dans le graphe " + graphe.get(i).getNom());
									}
								}
								graphe.get(i).getListeNoeud().get(reponse2).setLabel(label);
							}
							
							if(reponse3 == 2) {
								System.out.println("---Selection/Création d'un noeud voisins de " + label + "---");
								System.out.println("");
								if(graphe.get(i).getNbNoeuds() > 0) {
									System.out.println("1. Choisir dans la liste des noeuds");
								}else {
									System.out.println("Aucun noeud disponible");
								}
								
								int nbre2 = 0;
								while(nbre2 != 99) {
									System.out.println("2. Créer un noeud");
									System.out.println("99. Retour");
									System.out.print("Veillez faire un choix : ");
									nbre2 = sc.nextInt();
									String noe = "";
									
									if(nbre2 == 1 && graphe.get(i).getNbNoeuds() > 0) {
										clearConsole();
										System.out.println("---Selection d'un noeud voisins de " + label + "---");
										System.out.println("");
										while(!graphe.get(i).contentNoeud(noe)) {
											System.out.print("Liste des noeuds disponibles : ");
											System.out.println(graphe.get(i).getNoeuds());
											System.out.print("Selectionnez un noeud : ");
											noe = sc.next();
											if(graphe.get(i).contentNoeud(noe)) {
												graphe.get(i).getListeNoeud().get(reponse2).ajouteVoisin(graphe.get(i).getNoeud(noe), 1);
											}
											nbre2 = 99;
										}
									}else if(nbre2 == 2) {
										Noeud neunc;
										neunc = creerNoeud(i);
										graphe.get(i).creerNoeud(neunc);
										graphe.get(i).getListeNoeud().get(reponse2).ajouteVoisin(neunc, 1);
										nbre2 = 99;
									}
								}	
							}
							
							if(reponse3 == 3) {
								String reponse4 = "";
								while(!reponse4.equals("99")) {
									System.out.println("---Supprimer voisin de " + graphe.get(i).getListeNoeud().get(reponse2).getLabel() + "---");
									if(graphe.get(i).getListeNoeud().get(reponse2).getNbVoisins() > 0) {
										System.out.println("Liste des voisins de " + graphe.get(i).getListeNoeud().get(reponse2).getLabel() + " : ");
										for(Noeud n : graphe.get(i).getListeNoeud().get(reponse2).getSuccesseurs()) {
											System.out.println(n.getLabel());
										}
										System.out.println("99. Retour");
										System.out.print("Veillez faire un choix : ");
										reponse4 = sc.next();
										graphe.get(i).getListeNoeud().get(reponse2).enleveVoisin(graphe.get(i).getNoeud(reponse4));
										clearConsole();
									}
									else {
										System.out.println("Aucun voisin trouvé");
										System.out.println("99. Retour");
										System.out.print("Veillez faire un choix : ");
										reponse4 = sc.next();
									}
								}
							}
						}
					}
					catch (Exception e) {
						clearConsole();
						System.out.println("Choix invalide !");  
					}
				}
			}
		}
	}
	
	public void supprimerNoeud(int i){
		int reponse = -1;
		while(reponse != 99) {
			clearConsole();
			System.out.println("---Supprimer un noeuds du graphe " + graphe.get(i).getNom() + "---");
			if(graphe.get(i).getListeNoeud().size() > 0) {
				System.out.println("Liste des noeuds : ");
				for(int l = 0; l < graphe.get(i).getListeNoeud().size(); l++) {
					System.out.println(l+1 + " ." + graphe.get(i).getListeNoeud().get(l).getLabel());
				}
				System.out.println("99. Retour");
				System.out.print("Veillez faire un choix : ");
				reponse = sc.nextInt();
				if(graphe.get(i).contentNoeudIndex(reponse-1)) {
					graphe.get(i).deleteNoeud(graphe.get(i).getNoeud(graphe.get(i).getListeNoeud().get(reponse-1).getLabel()));
				}
			}
			else {
				System.out.println("La liste des noeuds est vide");
				System.out.println("99. Retour");
				System.out.print("Veillez faire un choix : ");
				reponse = sc.nextInt();
			}
		}
	}
	
	public void voirGraphe(){
		int cont = 0;
		while(cont != 99) {
			clearConsole();
			if(graphe.size() > 0) {
				System.out.println("Liste des graphes : ");
				String unG;
				for(Graphe g : graphe) {
					System.out.print(g.getNom()+" |");
				}
				System.out.println("");
				System.out.print("Saisissez le nom du graphe à afficher : ");
				unG = sc.next();
				for(Graphe g : graphe) {
					if(g.getNom().equals(unG)) {
						while(cont != 99) {
							clearConsole();
							System.out.println("Nom : " + g.getNom());
							System.out.println("Nombre de noeuds : " + g.getNbNoeuds());
							if(g.getListeNoeud().size() > 0) {
								for(Noeud n : g.getListeNoeud()) {
									System.out.print("." + n.getLabel() + " {");
									if(n.getSuccesseurs().size() > 0) {
										for(int i = 0; i < n.getSuccesseurs().size(); i++) {
											if(i+1 == n.getSuccesseurs().size())
												System.out.print(n.getSuccesseurs().get(i).getLabel());
											else
												System.out.print(n.getSuccesseurs().get(i).getLabel() + ", ");
										}
									}
									System.out.println("}");
								}
							}
							System.out.println("");
							System.out.println("99. Retour");
							System.out.print("Veillez faire un choix : ");
							cont = sc.nextInt();
							clearConsole();
						}
					}
				}
			}
			else {
				System.out.println("Aucun graphe à afficher");
				System.out.println("99. Retour");
				System.out.print("Veillez faire un choix : ");
				cont = sc.nextInt();
			}
		}
	}
	
	protected void supprimergraphe() {
		int reponse = -1;
		while(reponse != 99) {
			clearConsole();
			System.out.println("---Supprimer un graphe---");
			System.out.println("Liste des graphes : ");
			if(graphe.size() == 0) {
				System.out.println("La liste des graphes est vide");
			}
			for(int i = 0; i < graphe.size(); i++) {
				System.out.println(i+1 + " ." + graphe.get(i).getNom());
			}
			System.out.println("99. Retour");
			System.out.print("Veillez faire un choix : ");
			reponse = sc.nextInt();
			if(contentIndex(reponse-1))  {
				graphe.remove(reponse-1);
			}
		}
		
	}
	
	protected void exporterGraphe() {
		int reponse = -1;
		while(reponse != 99) {
			clearConsole();
			System.out.println("---Exporter un graphe---");
			System.out.println("Liste des graphes : ");
			if(graphe.size() == 0) {
				System.out.println("La liste des graphes est vide");
			}
			for(int i = 0; i < graphe.size(); i++) {
				System.out.println(i+1 + " ." + graphe.get(i).getNom());
			}
			System.out.println("99. Retour");
			System.out.print("Veillez faire un choix : ");
			reponse = sc.nextInt();
			if(contentIndex(reponse-1)) {
				System.out.print("Entrez le nom du fichier : ");
				String nom = sc.next();
				toPNG(graphe.get(reponse-1), nom);
			}
		}
	}
	
	protected static File createFile(String fPath) {
		try {
			File f = new File(fPath);
			if ( f.exists() ) {
				String renamePath = fPath + "." + getDate() + getTime();
				boolean rename = f.renameTo( new File ( renamePath ) );
				if ( rename ) {
					System.out.println("File \n\t" + 
							fPath + "\nexists. Renamed to:\n\t" 
							+ renamePath);
				}
				else {
					System.out.println("File \n\t" + 
							fPath + "\nexists and cannot be renamed.");
					return null;
				}
			}
			//System.out.println("Ole Ole Ole " + f.createNewFile());
			f.createNewFile();
			
			//System.out.println("1.00001");
			//System.out.println("f null? " + (f == null));
			
			return f;
		}
		catch(Exception e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			return null;
		}
	}
	
	// Get today's date in YYYYMMDD format, to be used as file prefix
	protected static String getDate() {
		ZonedDateTime t = ZonedDateTime.now();
		
		String str = "" + t.getYear() + twoDigits(t.getMonthValue()) + twoDigits(t.getDayOfMonth());
		return str;
	}
	
	protected static String getTime() {
		ZonedDateTime t = ZonedDateTime.now();
		String str;
		str = "" + t.getHour() + t.getMinute() + t.getSecond();
		return str;
	}
	
	// FILE MANIPULATION 
	private static String twoDigits(int n) {
		String str;
		if ( n < 10 ) {
			str = "0" + n;
		}
		else {
			str = "" + n;
		}
		return str;
	}
	
	// dessiner un png avec dot
	public void toPNG ( Graphe graphe, String fichier ) {
		try {
			File sortie = createFile(fichier);
			BufferedWriter buf = new BufferedWriter( 
					new OutputStreamWriter(
							new FileOutputStream( sortie ), Charset.forName("UTF-8").newEncoder()
							)
					);
			
			String line;
			
			buf.write("graph " + graphe.getNom() + " {\n");
			
			for ( Noeud v : graphe.getListeNoeud() ) {
				line = "\t" + v.getLabel() + ";\n";
				buf.write(line);
			}
			for ( Noeud v : graphe.getListeNoeud() ) {
				if ( v.getNbVoisins() > 0 ) {
					for ( Noeud u : v.getSuccesseurs() ) {
						line = "\t" + v.getLabel() + " -- " + u.getLabel() + ";\n";
						buf.write(line);
					}
				}
			}
			
			buf.write("}");
			
			buf.close();
 
			String commande = "neato -Tpng " + fichier + " -o " + fichier + ".png";
			Process process = Runtime.getRuntime().exec(commande);
			process.waitFor();
			commande = "eog" + fichier + ".png &";
			process = Runtime.getRuntime().exec(commande);
			process.waitFor();
		}
		catch ( Exception e ) {			
			e.printStackTrace();
		}
	}
	
	public final static void clearConsole()
	{
		try {
			String commande = "clea";
			Process process = Runtime.getRuntime().exec(commande);
			process.waitFor();
		}
		catch ( Exception e ) {			
			for(int i = 0; i < 100; i++)
			    System.out.println();
		}
	}
}
